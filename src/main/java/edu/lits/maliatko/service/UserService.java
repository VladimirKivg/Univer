package edu.lits.maliatko.service;

import edu.lits.maliatko.model.test.UserModel;

public interface UserService {
    UserModel findUserById(Integer id);
}
