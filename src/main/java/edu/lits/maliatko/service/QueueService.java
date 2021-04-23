package edu.lits.maliatko.service;

import edu.lits.maliatko.model.KindergartenModel;
import edu.lits.maliatko.model.QueueModel;


import java.util.List;

public interface QueueService {
    List<KindergartenModel> findByName(String kindergartenName);

    List<QueueModel> findByKindergarten_Name(String kindergartenName);

}
