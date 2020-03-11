package by.training.gusakov.dao.factory;

import by.training.gusakov.dao.DataAccessTransaction;
import by.training.gusakov.dao.DataAccessUser;
import by.training.gusakov.dao.impl.FileDataAccessTransaction;
import by.training.gusakov.dao.impl.FileDataAccessUser;

public class DAOFactory {
    private final static DAOFactory instance = new DAOFactory();

    private final DataAccessUser userDAO = new FileDataAccessUser();
    private final DataAccessTransaction transactionDAO = new FileDataAccessTransaction();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public DataAccessUser getUserDAO() {
        return userDAO;
    }

    public DataAccessTransaction getTransactionDAO() {
        return transactionDAO;
    }
}
