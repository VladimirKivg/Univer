package edu.lits.maliatko.service;

import edu.lits.maliatko.model.VisitingList;
import edu.lits.maliatko.model.VisitingModel;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.pojo.Visiting;
import edu.lits.maliatko.repository.ChildRepository;
import edu.lits.maliatko.repository.UserRepository;
import edu.lits.maliatko.repository.VisitingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VisitingService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VisitingRepository visitingRepository;

    public Iterable<Child> getChildList() {
        return childRepository.findAll();
    }

    public User getEducator(Integer educatorId) {
        return userRepository.findById(educatorId).get();
    }

    public void addVisiting(VisitingList visitingList) {
        for (VisitingModel visitingModel : visitingList.getVisitingList()) {
            Child visitingChild = childRepository.findById(visitingModel.getId()).get();
            Date visitingDate = visitingModel.getVisitingDate();
            Integer visitingPresence = visitingModel.getPresence();
            User visitingLogger = userRepository.findById(visitingModel.getLoggerId()).get();
            visitingRepository.save(new Visiting(visitingChild, visitingDate, visitingPresence, visitingLogger));
        }
    }

}
