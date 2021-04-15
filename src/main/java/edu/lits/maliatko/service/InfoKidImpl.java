package edu.lits.maliatko.service;

import edu.lits.maliatko.model.test.InfoKidModel;
import edu.lits.maliatko.pojo.Child;
import edu.lits.maliatko.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfoKidImpl implements InfoKidService{

    @Autowired
private ChildRepository childRepository;



    @Override
    public  InfoKidModel findById(Integer id)  {
        Child child = childRepository.findById(id).get();
        InfoKidModel infoKidModel=new InfoKidModel(child.getId(),child.getSurname(),child.getName(),child.getFatherName(),child.getBirthDate(),child.getAddress(),child.getUserParentOne(),child.getBenefits(),child.getStatus(), child.getUserParentTwo(), child.getCluster());
        return infoKidModel;
    }
}
