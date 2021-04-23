package edu.lits.maliatko.service;

import edu.lits.maliatko.model.KindergartenModel;
import edu.lits.maliatko.model.QueueModel;
import edu.lits.maliatko.pojo.Kindergarten;
import edu.lits.maliatko.pojo.Queue;
import edu.lits.maliatko.repository.KindergartenRepository;
import edu.lits.maliatko.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueueImpl implements QueueService{

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private KindergartenRepository kindergartenRepository;

    @Override
    public List<KindergartenModel> findByName(String kindergartenName) {
        Iterable<Kindergarten> byName = kindergartenRepository.findByName(kindergartenName);
        List<KindergartenModel>kindergartenModelList=new ArrayList<>();
        for (Kindergarten kindergarten:byName){
            KindergartenModel kindergartenModel=new KindergartenModel( kindergarten.getNumber(), kindergarten.getName(), kindergarten.getAddress());
        kindergartenModelList.add(kindergartenModel);
        }
        return kindergartenModelList;
    }

    @Override
    public List<QueueModel> findByKindergarten_Name(String kindergartenName) {
        List<QueueModel>queueModelList=new ArrayList<>();
        Iterable<Queue> byKindergarten = queueRepository.findByKindergarten_Name(kindergartenName);
        for (Queue queue:byKindergarten){
            QueueModel queueModel=new QueueModel(queue.getId(), queue.getChild(), queue.getKindergarten(), queue.getApplyDate());
            queueModelList.add(queueModel);
        }
        return queueModelList;
    }
}
