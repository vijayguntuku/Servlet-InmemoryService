package service;

import model.User;

import java.util.List;

public interface Userservice {

    List<User> insert(User user);

    List<User> listUsers() ;

    void update(User user);

    void delete(int id);

    User search(int id);
}
