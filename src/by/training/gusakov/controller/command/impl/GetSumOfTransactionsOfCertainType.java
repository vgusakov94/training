package by.training.gusakov.controller.command.impl;

import by.training.gusakov.bean.TransactionType;
import by.training.gusakov.bean.User;
import by.training.gusakov.controller.command.Command;
import by.training.gusakov.controller.exception.ControllerException;
import by.training.gusakov.service.UserServiceImpl;
import by.training.gusakov.service.exception.ServiceException;
import by.training.gusakov.service.factory.ServiceFactory;
import by.training.gusakov.util.Separation;

import java.math.BigDecimal;

public class GetSumOfTransactionsOfCertainType implements Command {
    @Override
    public String execute(String request) throws ControllerException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl userService = serviceFactory.getUserService();

        String login = Separation.getValueParam(request,"login");
        String type = Separation.getValueParam(request, "transactionType");
        StringBuilder st = new StringBuilder();
        try {
            User user = userService.get(login);
            BigDecimal sum = userService.getSumOfAllUsersTransactionsOfCertainType(user, TransactionType.valueOf(type));
            st.append(sum);
        } catch (ServiceException e) {
            //write log
           String mes = "GetSumOfTransactionsOfCertainType error";
           throw new ControllerException(mes,e);
        }

        return st.toString();
    }
}
