package by.training.gusakov.controller.command;

import by.training.gusakov.controller.exception.ControllerException;

public interface Command {

    String execute (String request) throws ControllerException;

}
