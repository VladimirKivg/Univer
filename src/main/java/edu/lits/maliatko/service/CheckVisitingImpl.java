package edu.lits.maliatko.service;

import edu.lits.maliatko.model.test.CheckVisitingModel;
import edu.lits.maliatko.pojo.Visiting;
import edu.lits.maliatko.repository.VisitingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CheckVisitingImpl implements CheckVisitingService{

    @Autowired
    VisitingRepository visitingRepository;


    @Override
    public List<CheckVisitingModel> findAllByPresence(Integer presence) {
        Iterable<Visiting> allByPresence = visitingRepository.findAllByPresence(presence);
        List<CheckVisitingModel>modelList=new ArrayList<>();
        for (Visiting visiting:allByPresence){
            CheckVisitingModel checkVisitingModel=new CheckVisitingModel(visiting.getId(), visiting.getChild(), visiting.getVisitingDate(), visiting.getPresence(), visiting.getUserLogger());
            modelList.add(checkVisitingModel);
        }

        return modelList;
    }
}
