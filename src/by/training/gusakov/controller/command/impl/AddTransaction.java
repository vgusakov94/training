package by.training.gusakov.controller.command.impl;

import by.training.gusakov.bean.Transaction;
import by.training.gusakov.bean.TransactionType;
import by.training.gusakov.bean.User;
import by.training.gusakov.controller.command.Command;
import by.training.gusakov.controller.exception.ControllerException;
import by.training.gusakov.service.TransactionServiceImpl;
import by.training.gusakov.service.UserServiceImpl;
import by.training.gusakov.service.exception.ServiceException;
import by.training.gusakov.service.factory.ServiceFactory;
import by.training.gusakov.util.Separation;
import by.training.gusakov.validation.Validation;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTransaction implements Command {

    @Override
    public String execute(String request) throws ControllerException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionServiceImpl transactionService = serviceFactory.getTransactionService();
        UserServiceImpl userService = serviceFactory.getUserService();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yy");

        String login = Separation.getValueParam(request, "login");
        String type = Separation.getValueParam(request, "type");
        String amount = Separation.getValueParam(request, "amount");
        String comment = Separation.getValueParam(request, "comment");
        String date = Separation.getValueParam(request, "date");
        String response;
        TransactionType transactionType;
        transactionType = type.equalsIgnoreCase("income") ? TransactionType.INCOME : (
                type.equalsIgnoreCase("expense") ? TransactionType.EXPENSE : null);
        if (Validation.isEqualsNull(transactionType)) {
            return "Invalid transaction type";
        }
        try {
            Date date1 = dateFormat.parse(date);
            User user = userService.get(login);
            long usersId = user.getId();
            Transaction transaction = new Transaction(transactionType, new BigDecimal(amount), date1, usersId, comment);
            transactionService.add(transaction);
            response = "Transaction was added to your transaction list";
        } catch (ServiceException | ParseException e) {
            response = "Problems with adding, please retry";
            String mes = "Adding transaction error";
            throw new ControllerException(mes, e);
        }
        return response;
    }

}
