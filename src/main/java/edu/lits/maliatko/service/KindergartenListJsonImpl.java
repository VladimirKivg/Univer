package edu.lits.maliatko.service;

import edu.lits.maliatko.model.KindergartenModel;
import edu.lits.maliatko.pojo.Kindergarten;
import edu.lits.maliatko.repository.KindergartenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class KindergartenListJsonImpl implements KindergartenListJsonService{

    @Autowired
   private KindergartenRepository kindergartenRepository;

    @Override
    public List<KindergartenModel> findAll() {

        Iterable<Kindergarten> all = kindergartenRepository.findAll();
        List<KindergartenModel>kindergartenModelList=new ArrayList<>();
        for (Kindergarten kindergarten :all){
            KindergartenModel kindergartenModel=new KindergartenModel(kindergarten.getNumber(), kindergarten.getName(), kindergarten.getAddress());
            kindergartenModel.setId(kindergarten.getId());
            kindergartenModelList.add(kindergartenModel);
        }

        return kindergartenModelList;
    }
}
