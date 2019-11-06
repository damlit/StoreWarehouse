package api;

import entity.User;

import java.io.IOException;

public interface UserRegisterLoginFacade {

    String registerUser(User user);
    boolean loginUser(String login, String password) throws IOException;
}
