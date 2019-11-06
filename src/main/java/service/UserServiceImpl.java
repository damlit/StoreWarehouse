package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import validator.UserValidator;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if(instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public boolean addUser(User user) {
        try {
            if(isLoginAlreadyExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException();
            }
            if(userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean isLoginAlreadyExist(String login) {
        return getUserByLogin(login).isPresent();
    }

    public Optional<User> getUserByLogin(String login) {
        return getAllUsers().stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {
        return getUserByLogin(login)
                .filter(user -> hasCorrectLoginAndPassword(user, login, password))
                .isPresent();
    }

    private boolean hasCorrectLoginAndPassword(User user, String login, String password) {
        return login.equals(user.getLogin())
                && password.equals(user.getPassword());
    }
}