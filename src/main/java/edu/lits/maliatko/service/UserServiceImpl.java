package edu.lits.maliatko.service;

import edu.lits.maliatko.model.test.UserModel;
import edu.lits.maliatko.pojo.User;
import edu.lits.maliatko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
   private UserRepository userRepository;

    @Override
    public UserModel findUserById(Integer id) {
        User user = userRepository.findById(id).get();

        UserModel userModel= new UserModel(user.getId(), user.getName());

        return userModel;
    }
}
