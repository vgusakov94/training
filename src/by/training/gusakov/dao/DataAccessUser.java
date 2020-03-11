package by.training.gusakov.dao;

import by.training.gusakov.bean.User;
import by.training.gusakov.dao.exception.DAOException;
import java.util.ArrayList;


public interface DataAccessUser {
    void add(User user) throws DAOException;
    User get(int id) throws DAOException;
    User get(String login) throws DAOException;
    ArrayList<User> getAll() throws DAOException;
    void update (int id, User updatedUser) throws DAOException;
    void delete(int id) throws DAOException;
}
