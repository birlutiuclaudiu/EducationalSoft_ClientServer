package database.businesslogic;

import database.businesslogic.validators.PasswordValidator;
import database.businesslogic.validators.UsernameValidator;
import database.dao.UserDao;
import model.entities.User;

public class UserBll {

    private UserDao userDao;
    public UserBll(){
        this.userDao = new UserDao();
    }

    public User findById(Integer id){
        return userDao.findById(id);
    }

    public Boolean saveUser(User user){
        return userDao.save(user);
    }

    public User exists(String username, String password){
        return userDao.findByUsernameAndPassword(username, password);
    }

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }
    public User createNewUser(String username, String password) throws IllegalArgumentException{
        new UsernameValidator().validate(username);
        new PasswordValidator().validate(password);
        if(findByUsername(username)!=null){
             throw new IllegalArgumentException("User already exists!");
        }
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        saveUser(user);
        return exists(username,password);
    }
}
