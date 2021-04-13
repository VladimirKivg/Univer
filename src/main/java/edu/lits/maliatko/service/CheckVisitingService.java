package edu.lits.maliatko.service;

import edu.lits.maliatko.model.test.CheckVisitingModel;
import edu.lits.maliatko.pojo.Visiting;

import java.util.List;

public interface CheckVisitingService {

    List<CheckVisitingModel> findAllByPresence(Integer presence);
}
