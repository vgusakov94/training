package by.training.gusakov.controller.command.impl;

import by.training.gusakov.controller.command.Command;
import by.training.gusakov.controller.exception.ControllerException;
import by.training.gusakov.service.UserServiceImpl;
import by.training.gusakov.service.exception.ServiceException;
import by.training.gusakov.service.factory.ServiceFactory;
import by.training.gusakov.util.Separation;
import java.math.BigDecimal;

public class GetBalance implements Command {
    @Override
    public String execute(String request) throws ControllerException{
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl userService = serviceFactory.getUserService();

        String login = Separation.getValueParam(request,"login");
        BigDecimal balance;
        try {
            balance = userService.getBalance(login);
        } catch (ServiceException e) {
            String mes = "Getting balance error";
            throw new ControllerException(mes,e);
        }
        return balance.toString();
    }
}
