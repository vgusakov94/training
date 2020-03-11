package by.training.gusakov.controller.command.impl;

import by.training.gusakov.controller.command.Command;
import by.training.gusakov.controller.exception.ControllerException;
import by.training.gusakov.service.UserServiceImpl;
import by.training.gusakov.service.exception.ServiceException;
import by.training.gusakov.service.factory.ServiceFactory;
import by.training.gusakov.util.Separation;

public class Registration implements Command {

    @Override
    public String execute(String request) throws ControllerException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImpl userService = serviceFactory.getUserService();

        String login = Separation.getValueParam(request, "login");
        String password = Separation.getValueParam(request, "password");

        boolean result;
        try {
            result = userService.registration(login, password);
        } catch (ServiceException e) {
            String mes = "Registration error";
            throw new ControllerException(mes, e);
        }

        return result ? "You are registered!" : "User with such login is already registered!";
    }

}
