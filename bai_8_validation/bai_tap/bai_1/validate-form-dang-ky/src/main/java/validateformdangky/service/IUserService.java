package validateformdangky.service;

import validateformdangky.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void saveUser(User user);

    void deleteUser(int id);

    User findUserById(int id);
}
