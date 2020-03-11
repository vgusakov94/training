package by.training.gusakov.controller.command.impl;

import by.training.gusakov.controller.command.Command;
import by.training.gusakov.controller.exception.ControllerException;
import by.training.gusakov.service.exception.ServiceException;
import by.training.gusakov.service.factory.ServiceFactory;
import by.training.gusakov.service.impl.UserServiceImplImpl;
import by.training.gusakov.util.Separation;

public class SignIn implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserServiceImplImpl userService = serviceFactory.getUserService();

        String login = Separation.getValueParam(request,"login");
        String password = Separation.getValueParam(request,"password");
        boolean result;
        try {

            result = (userService.signIn(login,password));


        } catch (ServiceException e) {
            //write log
            String mes = "Signing in error";
            throw new ControllerException(mes,e);
        }

        return result ? "You are entered! Welcome" : "Something went bad, please try again";

    }
}
