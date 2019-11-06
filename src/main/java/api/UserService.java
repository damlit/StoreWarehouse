package api;

import entity.User;
import exception.UserLoginAlreadyExistException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean addUser(User user) throws UserLoginAlreadyExistException;

    List<User> getAllUsers() throws IOException;
    Optional<User> getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password) throws IOException;
}
