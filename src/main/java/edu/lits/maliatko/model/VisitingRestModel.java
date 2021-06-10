package edu.lits.maliatko.model;

import java.util.List;

public class VisitingRestModel {

    private Integer educatorId;

    private String educatorName;

    private String educatorSurname;

    private String educatorFatherName;

    private List<ClusterModel> clusterList;

    private Integer selectedCluster;

    private String visitingDate;

    private List<VisitingModel> visitingList;

    public Integer getEducatorId() {
        return educatorId;
    }

    public void setEducatorId(Integer educatorId) {
        this.educatorId = educatorId;
    }

    public String getEducatorName() {
        return educatorName;
    }

    public void setEducatorName(String educatorName) {
        this.educatorName = educatorName;
    }

    public String getEducatorSurname() {
        return educatorSurname;
    }

    public void setEducatorSurname(String educatorSurname) {
        this.educatorSurname = educatorSurname;
    }

    public String getEducatorFatherName() {
        return educatorFatherName;
    }

    public void setEducatorFatherName(String educatorFatherName) {
        this.educatorFatherName = educatorFatherName;
    }

    public List<ClusterModel> getClusterList() {
        return clusterList;
    }

    public void setClusterList(List<ClusterModel> clusterList) {
        this.clusterList = clusterList;
    }

    public String getVisitingDate() {
        return visitingDate;
    }

    public void setVisitingDate(String visitingDate) {
        this.visitingDate = visitingDate;
    }

    public Integer getSelectedCluster() {
        return selectedCluster;
    }

    public void setSelectedCluster(Integer selectedCluster) {
        this.selectedCluster = selectedCluster;
    }

    public List<VisitingModel> getVisitingList() {
        return visitingList;
    }

    public void setVisitingList(List<VisitingModel> visitingList) {
        this.visitingList = visitingList;
    }
}
