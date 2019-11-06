package api;

import entity.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void removeUserById(Long id);

    List<User> getAllUsers();
}
