package by.training.gusakov.dao.impl;

import by.training.gusakov.bean.Transaction;
import by.training.gusakov.dao.DataAccessTransaction;
import by.training.gusakov.dao.exception.DAOException;
import by.training.gusakov.dao.exception.InvalidFieldDAOException;
import by.training.gusakov.dao.exception.InvalidParameterDAOException;
import by.training.gusakov.util.convertor.TransactionConverter;
import by.training.gusakov.dao.datasource.FileUtilDAO;
import by.training.gusakov.util.exception.UtilException;
import by.training.gusakov.validation.Validation;



import java.text.ParseException;
import java.util.ArrayList;


import static by.training.gusakov.dao.datasource.ConstantsDAO.LINK_TRANSACTIONS;

public class FileDataAccessTransaction implements DataAccessTransaction {
    @Override
    public void add(Transaction transaction) throws DAOException {
        if(Validation.isEqualsNull(transaction)){
            String mes = "Transaction is null";
            throw new DAOException(mes);
        }

        try {
            String trans = TransactionConverter.convertTransactionToString(transaction).trim();
            FileUtilDAO.writeToFile(LINK_TRANSACTIONS, trans);
        } catch (InvalidParameterDAOException e) {
            String mes = "Transaction is null";
            throw new DAOException(mes, e);
        } catch (InvalidFieldDAOException e) {
            String mes = "Transaction has incorrect fields";
            throw new DAOException(mes, e);
        } catch (UtilException e) {
            String mes = "File problems happened";
            throw new DAOException(mes,e);
        }


    }



    @Override
    public Transaction get(long id) throws DAOException {

        ArrayList<Transaction> transactions = getAll();
        for(Transaction transaction : transactions){
                if(transaction.getTransactionId() == id){
                    return transaction;
                }
            }


        throw new DAOException("Transaction with such id is not found");

    }

    @Override
    public ArrayList<Transaction> getAll() throws DAOException {

        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            String allTrans = FileUtilDAO.readFile(LINK_TRANSACTIONS).trim();
            String[] separatedTrans = allTrans.split("\n");
            for (int i = 0; i < separatedTrans.length; i++) {
                transactions.add(TransactionConverter.parseTransactionToObject(separatedTrans[i]));
            }
        } catch (InvalidParameterDAOException e) {
            String mes = "Data is null or empty";
            throw new DAOException(mes,e);
        } catch (InvalidFieldDAOException e) {
            String mes = "Invalid values of fields in data";
            throw new DAOException(mes,e);
        } catch (UtilException e) {
            String mes = "File problems happened";
            throw new DAOException(mes,e);
        } catch (ParseException e) {
            String mes = "Incorrect value to parse";
            throw new DAOException(mes,e);
        }
        return transactions;
    }

    @Override
    public void update(long id, Transaction transaction) throws DAOException {

        ArrayList<Transaction> transactions = getAll();
        try {

            FileUtilDAO.cleanFile(LINK_TRANSACTIONS);


            for (Transaction transaction1 : transactions) {
                if (transaction1.getTransactionId() != id) {
                    FileUtilDAO.writeToFile(LINK_TRANSACTIONS,TransactionConverter.convertTransactionToString(transaction1));
                } else {
                    FileUtilDAO.writeToFile(LINK_TRANSACTIONS,TransactionConverter.convertTransactionToString(transaction));
                }
            }
        } catch (InvalidParameterDAOException e) {
            String mes = "Data is null or empty";
            throw new DAOException(mes,e);
        } catch (InvalidFieldDAOException e) {
            String mes = "Invalid values of fields in data";
            throw new DAOException(mes,e);
        } catch (UtilException e) {
            String mes = "File problems happened";
            throw new DAOException(mes,e);
        }
    }

    @Override
    public void delete(long id) throws DAOException {
        ArrayList<Transaction> transactions = getAll();
        try {

            FileUtilDAO.cleanFile(LINK_TRANSACTIONS);
            for (Transaction transaction1 : transactions) {
                if (transaction1.getTransactionId() != id) {
                    FileUtilDAO.writeToFile(LINK_TRANSACTIONS,TransactionConverter.convertTransactionToString(transaction1));
                }
            }
        } catch (InvalidParameterDAOException e) {
            String mes = "Data is null or empty";
            throw new DAOException(mes,e);
        } catch (InvalidFieldDAOException e) {
            String mes = "Invalid values of fields in data";
            throw new DAOException(mes,e);
        } catch (UtilException e) {
            String mes = "File problems happened";
            throw new DAOException(mes,e);
        }
    }


}
