package edu.lits.maliatko.controller.rest;

import edu.lits.maliatko.configuration.JwtTokenUtil;
import edu.lits.maliatko.model.VisitingRestModel;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.pojo.UserToRole;
import edu.lits.maliatko.repository.UserRepository;
import edu.lits.maliatko.repository.UserToRoleRepository;
import edu.lits.maliatko.service.VisitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class VisitingRestController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserToRoleRepository userToRoleRepository;

    @Autowired
    private VisitingService visitingService;

    @RequestMapping(method = RequestMethod.POST, value = "/visiting")
    public VisitingRestModel visitingChecking(@RequestHeader Map<String, String> header) {

        String token = header.get("authorization").substring(7);

        String userMail = jwtTokenUtil.getUsernameFromToken(token);

        User loggedUser = userRepository.findByMail(userMail);

        UserToRole role = userToRoleRepository.findByUserId(loggedUser.getId());

        VisitingRestModel visitingRestModel = null;

        Date currentVisitingDate = visitingService.getCurrentDateTime();

        if ("ROLE_EDUCATOR".equals(role.getRole().getRole())) {
            visitingRestModel = new VisitingRestModel();
            visitingRestModel.setEducatorId(loggedUser.getId());
            visitingRestModel.setEducatorName(loggedUser.getName());
            visitingRestModel.setEducatorSurname(loggedUser.getSurname());
            visitingRestModel.setEducatorFatherName(loggedUser.getFatherName());
            visitingRestModel.setClusterList(visitingService.getClusterList(loggedUser.getId()));
            visitingRestModel.setVisitingDate(visitingService.convertDateToString(currentVisitingDate));

            if (!visitingRestModel.getClusterList().isEmpty()) {
                visitingRestModel.setSelectedCluster(visitingRestModel.getClusterList().get(0).getId());
                visitingRestModel.setVisitingList(visitingService.getVisitingList(visitingRestModel.getSelectedCluster(),currentVisitingDate));
            }
        }

        return visitingRestModel;
    }
}
