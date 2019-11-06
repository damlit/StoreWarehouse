package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import service.UserServiceImpl;

import java.io.IOException;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {

    private UserService userService = UserServiceImpl.getInstance();
    private static UserRegisterLoginFacade instance = null;

    private UserRegisterLoginFacadeImpl() {

    }

    public static UserRegisterLoginFacade getInstance() {
        if(instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    public String registerUser(User user) {
        try {
            userService.addUser(user);
            return "Register successfully";
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public boolean loginUser(String login, String password) throws IOException {
        if(userService.isCorrectLoginAndPassword(login, password)) {
            return true;
        }
        return false;
    }
}
