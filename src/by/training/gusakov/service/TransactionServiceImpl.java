package by.training.gusakov.service;

import by.training.gusakov.bean.Transaction;
import by.training.gusakov.bean.TransactionType;
import by.training.gusakov.bean.User;
import by.training.gusakov.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.Date;

public interface TransactionServiceImpl {
    void add(Transaction transaction) throws ServiceException;
    ArrayList<Transaction> getAllUsersTransactions (User user) throws ServiceException;
    ArrayList<Transaction> getAllUsersTransactionsInAPeriod(User user, Date startPeriod, Date endPeriod)
            throws ServiceException;
    ArrayList<Transaction> getAllUsersTransactionsOfCertainType(User user, TransactionType transactionType)
            throws ServiceException;
    ArrayList<Transaction> getAllUsersTransactionsOfCertainTypeInAPeriod
            (User user, Date startPeriod, TransactionType transactionType,Date endPeriod) throws ServiceException;

}
