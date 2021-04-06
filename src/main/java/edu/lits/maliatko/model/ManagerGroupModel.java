package edu.lits.maliatko.model;

import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.pojo.Cluster;
import edu.lits.maliatko.repository.ChildRepository;
import edu.lits.maliatko.repository.ClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;


public class ManagerGroupModel {

    public List<ClusterModel> groupList = new ArrayList<>();
    public List<ChildModel> childModelList = new ArrayList<>();
    public List<EducatorModel> educatorModelList = new ArrayList<>();



    public ManagerGroupModel() {
    }

}
