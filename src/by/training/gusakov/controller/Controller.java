package by.training.gusakov.controller;

import by.training.gusakov.controller.command.Command;
import by.training.gusakov.controller.exception.ControllerException;
import by.training.gusakov.util.Separation;

public class Controller {

    private CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request) throws ControllerException {
        String commandName = request.substring(0, request.indexOf(Separation.DELIMITER));
        Command command = commandProvider.getCommand(commandName);
        String response = command.execute(request);

        return response;
    }
}
