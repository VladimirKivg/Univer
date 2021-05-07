package edu.lits.maliatko.model;

import java.util.ArrayList;
import java.util.List;


public class ManagerGroupModel {

    public List<ClusterModel> groupList = new ArrayList<>();
    public List<ChildModel> childModelList = new ArrayList<>();
    public List<EducatorModel> educatorModelList = new ArrayList<>();



    public ManagerGroupModel() {
    }

    public List<ClusterModel> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<ClusterModel> groupList) {
        this.groupList = groupList;
    }

    public List<ChildModel> getChildModelList() {
        return childModelList;
    }

    public void setChildModelList(List<ChildModel> childModelList) {
        this.childModelList = childModelList;
    }

    public List<EducatorModel> getEducatorModelList() {
        return educatorModelList;
    }

    public void setEducatorModelList(List<EducatorModel> educatorModelList) {
        this.educatorModelList = educatorModelList;
    }
}
