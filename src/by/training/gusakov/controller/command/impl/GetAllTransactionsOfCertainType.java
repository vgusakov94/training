package by.training.gusakov.controller.command.impl;

import by.training.gusakov.bean.Transaction;
import by.training.gusakov.bean.TransactionType;
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

public class GetAllTransactionsOfCertainType implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl userService = serviceFactory.getUserService();
        TransactionServiceImpl transactionService = serviceFactory.getTransactionService();

        String login = Separation.getValueParam(request,"login");
        String type = Separation.getValueParam(request,"transactionType");
        StringBuilder st = new StringBuilder();
        try {
            User user = userService.get(login);
            ArrayList<Transaction> transactions =
                    transactionService.getAllUsersTransactionsOfCertainType(user, TransactionType.valueOf(type));
            if(transactions.size() == 0){
                st.append("You haven't got any transactions of this type");
            }else {
                for (Transaction transaction : transactions) {
                    st.append(TransactionConverter.convertTransactionToPrintableString(transaction) + "\n");

                }
            }
        } catch (ServiceException | InvalidParameterDAOException | InvalidFieldDAOException e) {
            //write log
            String mes = "Getting users transactions of certain type error";
            throw new ControllerException(mes,e);
        }

        return st.toString();
    }
}
