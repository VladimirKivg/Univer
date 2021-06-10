package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.configuration.JwtTokenUtil;
import edu.lits.maliatko.model.LoginRequest;
import edu.lits.maliatko.model.LoginResponse;
import edu.lits.maliatko.model.TokenModel;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.pojo.UserToRole;
import edu.lits.maliatko.repository.UserRepository;
import edu.lits.maliatko.repository.UserToRoleRepository;
import edu.lits.maliatko.service.SecurityService;
import edu.lits.maliatko.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserToRoleRepository userToRoleRepository;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> registration(@RequestBody LoginRequest authenticationRequest) {

        edu.lits.maliatko.pojo.User userPojo = new edu.lits.maliatko.pojo.User();
        userPojo.setMail(authenticationRequest.getUsername());
        userPojo.setPassword(bCryptPasswordEncoder.encode(authenticationRequest.getPassword()));
        userRepository.save(userPojo);

        return ResponseEntity.ok(new LoginResponse("ok", authenticationRequest.getUsername()));

    }

    @RequestMapping(value = "/main-menu", method = RequestMethod.POST)
    public List <String> getMenu (@RequestBody TokenModel tokenModel){
        String userMail=jwtTokenUtil.getUsernameFromToken(tokenModel.getToken());
        User loggedUser= userRepository.findByMail(userMail);

       UserToRole role=userToRoleRepository.findByUserId(loggedUser.getId());
       List<String> menuItems=null;
       switch(role.getRole().getRole()) {
           case "ROLE_MANAGER":
               menuItems= Arrays.asList("url1","url2");
               break;
           case "ROLE_EDUCATOR":
               menuItems= Arrays.asList("url3","url4");
               break;
           case "ROLE_PARENTS":
               menuItems=Arrays.asList("url5","url6");
               break;
           case "ROLE_ACCOUNTANT":
               menuItems=Arrays.asList("url7","url8");
       }
    return menuItems;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody LoginRequest authenticationRequest) throws Exception {

        securityService.autoLogin(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponse(token, authenticationRequest.getUsername()));
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return ResponseEntity.ok("Success");
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
