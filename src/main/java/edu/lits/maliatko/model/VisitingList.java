package edu.lits.maliatko.model;

import java.util.List;

public class VisitingList {
    List<VisitingModel> visitingList;

    public VisitingList() {
    }

    public VisitingList(List<VisitingModel> visitingList) {
        this.visitingList = visitingList;
    }

    public List<VisitingModel> getVisitingList() {
        return visitingList;
    }

    public void setVisitingList(List<VisitingModel> visitingList) {
        this.visitingList = visitingList;
    }
}
