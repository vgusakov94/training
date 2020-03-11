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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GetAllTransactionsOfCertainTypeInAPeriod implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl userService = serviceFactory.getUserService();
        TransactionServiceImpl transactionService = serviceFactory.getTransactionService();

        String login = Separation.getValueParam(request,"login");
        StringBuilder str = new StringBuilder();

        try {
            Date startPeriod = simpleDateFormat.parse(Separation.getValueParam(request, "startPeriod"));
            Date endPeriod = simpleDateFormat.parse(Separation.getValueParam(request, "endPeriod"));
            User user = userService.get(login);
            TransactionType transactionType =
                    TransactionType.valueOf(Separation.getValueParam(request,"transactionType"));
            ArrayList<Transaction> transactions =
                    transactionService.getAllUsersTransactionsOfCertainTypeInAPeriod(user,startPeriod,transactionType,endPeriod);
            if(transactions.size() == 0){
                str.append("You haven't got transactions of such tye in this period");
            }else{
                for(Transaction transaction : transactions){
                    str.append(TransactionConverter.convertTransactionToPrintableString(transaction)).append("\n");
                }
            }
        } catch (ParseException | ServiceException | InvalidParameterDAOException | InvalidFieldDAOException e) {
            String mes = "Getting transactions of type in a period error";
            //write log
            throw new ControllerException(mes,e);
        }



        return str.toString();


    }
}
