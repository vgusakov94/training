package by.training.gusakov.dao;

import by.training.gusakov.bean.Transaction;
import by.training.gusakov.dao.exception.DAOException;
import java.util.ArrayList;


public interface DataAccessTransaction {
    void add(Transaction transaction) throws DAOException;
    Transaction get(long id) throws DAOException;
    ArrayList<Transaction> getAll() throws DAOException;
    void update(long id, Transaction transaction) throws DAOException;
    void delete(long id) throws DAOException;



}
