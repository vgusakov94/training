package by.training.gusakov.service.impl;

import by.training.gusakov.bean.Transaction;
import by.training.gusakov.bean.TransactionType;
import by.training.gusakov.bean.User;
import by.training.gusakov.dao.DataAccessTransaction;
import by.training.gusakov.dao.exception.DAOException;
import by.training.gusakov.dao.factory.DAOFactory;
import by.training.gusakov.service.exception.ServiceException;
import by.training.gusakov.validation.Validation;

import java.util.ArrayList;
import java.util.Date;

public class TransactionServiceImplImpl implements by.training.gusakov.service.TransactionServiceImpl {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private DataAccessTransaction transactionDAO = daoFactory.getTransactionDAO();


    @Override
    public void add(Transaction transaction) throws ServiceException {
        if(Validation.isEqualsNull(transaction)){
            String mes = "Transaction is null";
            throw new ServiceException(mes);
        }
        try {

            transactionDAO.add(transaction);
        }catch (DAOException e){
            String mes = "Transaction adding error";
            throw new ServiceException(mes,e);
        }

    }

    @Override
    public ArrayList<Transaction> getAllUsersTransactions(User user) throws ServiceException {
        if(Validation.isEqualsNull(user)){
            String mes = "User has null value";
            throw new ServiceException(mes);
        }

        ArrayList<Transaction> allTransactions ;
        try {
            allTransactions = transactionDAO.getAll();
        }catch (DAOException e){
            String mes = "Getting all transactions error";
            throw new ServiceException(mes,e);
        }

        ArrayList<Transaction> usersTransactions = new ArrayList<>();

        for(Transaction transaction : allTransactions){
            if(user.getId() == transaction.getUsersId()){
                usersTransactions.add(transaction);
            }
        }

        return usersTransactions;
    }

    @Override
    public ArrayList<Transaction> getAllUsersTransactionsInAPeriod(User user, Date startPeriod, Date endPeriod)
            throws ServiceException {
        if(Validation.isEqualsNull(user)){
            String mes = "User has null value";
            throw new ServiceException(mes);
        }
        if(Validation.isEqualsNull(startPeriod) || Validation.isEqualsNull(endPeriod)){
            String mes = "Date has null value";
            throw new ServiceException(mes);
        }
        if(!Validation.datePeriodIsCorrect(startPeriod,endPeriod)){
            String mes = "Incorrect date period";
            throw new ServiceException(mes);
        }

        ArrayList<Transaction> allUsersTransactions = getAllUsersTransactions(user);
        ArrayList<Transaction> usersTransactionsInAPeriod = new ArrayList<>();
        for(Transaction transaction : allUsersTransactions){
            if(transaction.getDate().after(startPeriod) && transaction.getDate().before(endPeriod)){
                usersTransactionsInAPeriod.add(transaction);
            }
        }

        return usersTransactionsInAPeriod;
    }

    @Override
    public ArrayList<Transaction> getAllUsersTransactionsOfCertainType(User user, TransactionType transactionType) throws ServiceException {
        if(Validation.isEqualsNull(user)){
            String mes = "User has null value";
            throw new ServiceException(mes);
        }
        if(Validation.isEqualsNull(transactionType)){
            String mes = "Transaction type is null";
            throw new ServiceException(mes);
        }

        ArrayList<Transaction> allUsersTransactions = getAllUsersTransactions(user);

        ArrayList<Transaction> usersTransactionsOfType = new ArrayList<>();

        for(Transaction transaction : allUsersTransactions){
            if(transaction.getTransactionType().equals(transactionType)){
                usersTransactionsOfType.add(transaction);
            }
        }

        return usersTransactionsOfType;
    }
    @Override
    public ArrayList<Transaction> getAllUsersTransactionsOfCertainTypeInAPeriod
            (User user, Date startPeriod, TransactionType transactionType,Date endPeriod) throws ServiceException {
        if(Validation.isEqualsNull(user)){
            String mes = "User has null value";
            throw new ServiceException(mes);
        }
        if(Validation.isEqualsNull(transactionType)){
            String mes = "User has null value";
            throw new ServiceException(mes);
        }
        if(Validation.isEqualsNull(startPeriod) || Validation.isEqualsNull(endPeriod)){
            String mes = "Date has null value";
            throw new ServiceException(mes);
        }
        if(!Validation.datePeriodIsCorrect(startPeriod,endPeriod)){
            String mes = "Incorrect date period";
            throw new ServiceException(mes);
        }


        ArrayList<Transaction> usersTransactionsInAPeriod = getAllUsersTransactionsInAPeriod(user,startPeriod,endPeriod);
        ArrayList<Transaction> usersTransactionsOfCertainTypeInAPeriod  = new ArrayList<>();
        for(Transaction transaction : usersTransactionsInAPeriod){
            if(transaction.getTransactionType().equals(transactionType)){
                usersTransactionsOfCertainTypeInAPeriod.add(transaction);
            }
        }

        return usersTransactionsOfCertainTypeInAPeriod;
    }


}
