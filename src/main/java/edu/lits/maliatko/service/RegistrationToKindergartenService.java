package edu.lits.maliatko.service;

import edu.lits.maliatko.model.KidReg;
import edu.lits.maliatko.model.KindergartenModel;


import java.util.List;

public interface RegistrationToKindergartenService {

    void saveKidAddress(KidReg kidReg);

    void saveUserAddress(KidReg kidReg);

    void saveUserParentOne(KidReg kidReg);

    void saveChild(KidReg kidReg);

    List<KindergartenModel> findAllKindergarten();

    void saveQueue(KidReg kidReg);
}
