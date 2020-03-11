package by.training.gusakov.controller.command.impl;

import by.training.gusakov.controller.command.Command;
import by.training.gusakov.controller.exception.ControllerException;

public class LogOut implements Command {

    @Override
    public String execute(String request) throws ControllerException {
        String response = "You are left";
        return response;
    }
}
