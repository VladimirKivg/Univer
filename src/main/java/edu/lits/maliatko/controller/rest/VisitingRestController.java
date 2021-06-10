package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.configuration.JwtTokenUtil;
import edu.lits.maliatko.model.TokenModel;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest")
public class VisitingRestController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/visiting")
    public void visitingChecking(@RequestHeader Map<String, String> header) {

        String t = header.get("Authorization");

    }
}
