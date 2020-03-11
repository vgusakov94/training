package by.training.gusakov.controller.command.impl;

import by.training.gusakov.bean.Transaction;
import by.training.gusakov.bean.User;
import by.training.gusakov.controller.command.Command;
import by.training.gusakov.controller.exception.ControllerException;
import by.training.gusakov.dao.exception.InvalidFieldDAOException;
import by.training.gusakov.dao.exception.InvalidParameterDAOException;
import by.training.gusakov.service.TransactionServiceImpl;
import by.training.gusakov.service.UserServiceImpl;
import by.training.gusakov.service.exception.ServiceException;
import by.training.gusakov.service.factory.ServiceFactory;
import by.training.gusakov.util.Separation;
import by.training.gusakov.util.convertor.TransactionConverter;

import java.util.ArrayList;

public class GetAllTransactions implements Command {
    @Override
    public String execute(String request) throws ControllerException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionServiceImpl transactionService = serviceFactory.getTransactionService();
        UserServiceImpl userService = serviceFactory.getUserService();

        String login = Separation.getValueParam(request,"login");

        StringBuilder str = new StringBuilder();

        User user = null;
        try {
            user = userService.get(login);
            ArrayList<Transaction> allTransactions = transactionService.getAllUsersTransactions(user);
            if(allTransactions.size() == 0){
                str.append("You have't got any transactions");
            }else {
                for (Transaction transaction : allTransactions) {
                    str.append(TransactionConverter.convertTransactionToPrintableString(transaction)).append("\n");
                }
            }
        } catch (ServiceException | InvalidFieldDAOException | InvalidParameterDAOException e) {
            String mes = "Getting all transactions error";
            throw new ControllerException(mes,e);
        }

        return str.toString();
    }
}
