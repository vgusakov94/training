package by.training.gusakov.service;

import by.training.gusakov.bean.TransactionType;
import by.training.gusakov.bean.User;
import by.training.gusakov.service.exception.ServiceException;

import java.math.BigDecimal;
import java.util.Date;


public interface UserServiceImpl {
    boolean registration(String login, String password) throws ServiceException;
    boolean signIn(String login, String password) throws ServiceException;
    void logOut() throws ServiceException;
    User get(String login) throws ServiceException;
    BigDecimal getBalance(String login) throws ServiceException;
    BigDecimal getSumOfAllUsersTransactionsInAPeriod
            (User user, Date startPeriod, Date endPeriod, TransactionType transactionType) throws ServiceException;
    BigDecimal getSumOfAllUsersTransactionsOfCertainType(User user, TransactionType transactionType)
            throws ServiceException;

}
