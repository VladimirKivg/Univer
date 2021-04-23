package edu.lits.maliatko.service;

import edu.lits.maliatko.model.KidReg;
import edu.lits.maliatko.model.KindergartenModel;
import edu.lits.maliatko.pojo.*;
import edu.lits.maliatko.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegistrationToKindergartenImpl implements RegistrationToKindergartenService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private KindergartenRepository kindergartenRepository;

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private ClusterRepository clusterRepository;

  private  Address userAddress;
    private Address kidAddress;
    private User userParentOne;
    private Child child;
    private Date date;
    @Override
    public void saveKidAddress(KidReg kidReg) {
         kidAddress = new Address(kidReg.getKidRegion(), kidReg.getKidCity(), kidReg.getKidStreet(),
                kidReg.getKidBuildingNumber(), kidReg.getKidApartment());
        addressRepository.save(kidAddress);

    }

    @Override
    public void saveUserAddress(KidReg kidReg) {
        userAddress = new Address(kidReg.getParentRegion(), kidReg.getParentCity(), kidReg.getParentStreet(), kidReg.getParentBuildingNumber(), kidReg.getParentApartment());
        addressRepository.save(userAddress);
    }

    @Override
    public void saveUserParentOne(KidReg kidReg) {
        userParentOne = new User(kidReg.getParentSurname(), kidReg.getParentName(), kidReg.getParentFatherName(), kidReg.getParentBirthDate(), kidReg.getParentPhone(), kidReg.getParentMail(), userAddress);
        userRepository.save(userParentOne);
    }

    @Override
    public void saveChild(KidReg kidReg) {
        date = new Date();

        child = new Child(kidReg.getKidSurname(), kidReg.getKidName(), kidReg.getKidFatherName(), kidReg.getKidBirthDate(), kidReg.getKidGender(), kidReg.getKidBirthDocument(), kidAddress, userParentOne, kidReg.getKidBenefits(), "в черзі", null, 0, date, null);
        childRepository.save(child);
    }

    @Override
    public List<KindergartenModel> findAllKindergarten() {
        return null;
    }

    @Override
    public void saveQueue(KidReg kidReg) {
        Kindergarten kindergarten = new Kindergarten();
        Iterable<Kindergarten> all = kindergartenRepository.findAll();


        for (Kindergarten kid : all) {
            if (Integer.parseInt(kidReg.getKindergartenName()) == kid.getNumber()) {
                kindergarten = kid;
            }
        }
        Queue queue = new Queue(child, kindergarten, date);
        queueRepository.save(queue);
    }
}
