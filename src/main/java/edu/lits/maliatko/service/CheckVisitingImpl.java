package edu.lits.maliatko.service;

import edu.lits.maliatko.pojo.Visiting;
import edu.lits.maliatko.repository.VisitingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CheckVisitingService {

    @Autowired
    VisitingRepository visitingRepository;

    public  List<Visiting> visiting(){
        Iterable<Visiting> all = visitingRepository.findAll();
        List<Visiting>visitingList=new ArrayList<>();
        all.forEach(visitingList::add);
        return visitingList; }
}
