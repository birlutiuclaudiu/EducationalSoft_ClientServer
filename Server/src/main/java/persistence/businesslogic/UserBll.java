package persistence.businesslogic;


import persistence.businesslogic.validators.PasswordValidator;
import persistence.businesslogic.validators.UsernameValidator;
import persistence.dao.UserDao;
import persistence.entities.User;

public class UserBll {

    private final UserDao userDao;

    public UserBll() {
        this.userDao = new UserDao();
    }

    public User findById(Integer id) {
        return userDao.findById(id);
    }

    public Boolean saveUser(User user) {
        return userDao.save(user);
    }

    public User exists(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public User createNewUser(String username, String password) throws IllegalArgumentException {
        new UsernameValidator().validate(username);
        new PasswordValidator().validate(password);
        if (findByUsername(username) != null) {
            throw new IllegalArgumentException("User already exists!");
        }
        User user = User.builder().username(username).password(password).build();
        saveUser(user);
        return exists(username, password);
    }
}
