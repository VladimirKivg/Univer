package edu.lits.maliatko.service;

import edu.lits.maliatko.model.ChildModel;
import edu.lits.maliatko.model.ClusterModel;
import edu.lits.maliatko.model.VisitingList;
import edu.lits.maliatko.model.VisitingModel;
import edu.lits.maliatko.pojo.*;
import edu.lits.maliatko.repository.ChildRepository;
import edu.lits.maliatko.repository.UserRepository;
import edu.lits.maliatko.repository.UserToGroupRepository;
import edu.lits.maliatko.repository.VisitingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class VisitingService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VisitingRepository visitingRepository;

    @Autowired
    private UserToGroupRepository userToGroupRepository;

    public List<ChildModel> getChildList (Integer clusterId) {
        Iterable<Child> childIterable = childRepository.findByClusterId(clusterId);
        List<ChildModel> childList = new ArrayList<>();
        for (Child c :
                childIterable) {
            childList.add(new ChildModel(c.getId(),c.getName(),c.getSurname(),c.getFatherName()));
        }
        return childList;
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

    public List<ClusterModel> getClusterList(Integer educatorId) {
        Iterable<UserToGroup> userToGroup = userToGroupRepository.findByUserId(educatorId);
        List<ClusterModel> clusterModelList = new ArrayList<>();

        for (UserToGroup u :
                userToGroup) {
            clusterModelList.add(new ClusterModel(u.getGroupId().getId(), u.getGroupId().getName(), u.getGroupId().getKindergarten()));
        }

        return clusterModelList;
    }

    public String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("EET"));
        return formatter.format(new Date());
    }

}
