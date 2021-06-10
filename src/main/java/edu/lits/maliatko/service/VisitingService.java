package edu.lits.maliatko.service;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public List<VisitingModel> getVisitingList(Integer clusterId, Date visitingDate) {
        Iterable<Child> childIterable = childRepository.findByClusterId(clusterId);
        List<Integer> childIdList = new ArrayList<>();
        for (Child c :
                childIterable) {
            childIdList.add(c.getId());
        }

        Iterable<Visiting> commonVisitingList = visitingRepository.findAllVisitingByDate(visitingDate);
        List<VisitingModel> visitingList = new ArrayList<>();
        for (Visiting v :
                commonVisitingList) {
            if (childIdList.contains(v.getChild().getId())) {
                visitingList.add(new VisitingModel(v.getId(), v.getChild().getId(), v.getChild().getSurname() + ' ' + v.getChild().getName(), v.getPresence(), convertDateTimeToString(v.getVisitingDate()), v.getUserLogger().getId()));
            }
        }

        childIdList = new ArrayList<>();
        for (VisitingModel v :
                visitingList) {
            childIdList.add(v.getChildId());
        }

        for (Child c :
                childIterable) {
            if (!childIdList.contains(c.getId()) && convertDateToString(getCurrentDateTime()).equals(convertDateToString(visitingDate))) {
                visitingList.add(new VisitingModel(null, c.getId(), c.getSurname() + ' ' + c.getName(), null, convertDateTimeToString(getCurrentDateTime()), null));
            }
        }
        return visitingList;
    }

    public User getEducator(Integer educatorId) {
        return userRepository.findById(educatorId).get();
    }

    public void addVisiting(VisitingList visitingList) {
        for (VisitingModel vm : visitingList.getVisitingList()) {
            Child visitingChild = childRepository.findById(vm.getChildId()).get();
            Date visitingDate = convertStringToDateTime(vm.getVisitingDate());
            Integer visitingPresence = vm.getPresence();
            User visitingLogger = userRepository.findById(vm.getLoggerId()).get();
            Visiting visiting = new Visiting(visitingChild, visitingDate, visitingPresence, visitingLogger);
            if (vm.getId() != null) {
                visiting.setId(vm.getId());
            }
            visitingRepository.save(visiting);
        }
    }

    public List<ClusterModel> getClusterList(Integer educatorId) {
        Iterable<UserToGroup> userToGroup = userToGroupRepository.findByUserId(educatorId);
        List<ClusterModel> clusterModelList = new ArrayList<>();

        for (UserToGroup u :
                userToGroup) {
            clusterModelList.add(new ClusterModel(u.getGroupId().getId(), u.getGroupId().getName(), null));
        }

        return clusterModelList;
    }

    public String convertDateTimeToString(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss");
        return df.format(date);
    }

    public String convertDateToString(Date date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);
    }

    public Date convertStringToDateTime(String stringDate) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public Date getCurrentDateTime() {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("EET"));
        return cal.getTime();
    }



}
