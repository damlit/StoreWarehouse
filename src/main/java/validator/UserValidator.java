package validator;

import entity.User;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

public class UserValidator {

    private final int MIN_PASSWORD_LENGTH = 6;
    private final int MIN_LOGIN_LENGTH = 4;

    private static UserValidator instance = null;

    private UserValidator() {

    }

    public static UserValidator getInstance() {
        if(instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLengthLoginException {
        if(isPasswordNotLengthEnough(user.getPassword())) {
            throw new UserShortLengthPasswordException("Password is too short.");
        }
        if(isLoginNotLengthEnough(user.getLogin())) {
            throw new UserShortLengthLoginException("Login is too short.");
        }
        return true;
    }

    private boolean isPasswordNotLengthEnough(String password) {
        return password.length() <= MIN_PASSWORD_LENGTH;
    }

    private boolean isLoginNotLengthEnough(String login) {
        return login.length() <= MIN_LOGIN_LENGTH;
    }
}
