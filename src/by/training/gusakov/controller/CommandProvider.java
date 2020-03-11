package by.training.gusakov.controller;

import by.training.gusakov.controller.command.CommandName;
import by.training.gusakov.controller.command.Command;
import by.training.gusakov.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commands = new HashMap<>();

    CommandProvider() {
        commands.put(CommandName.REGISTRATION, new Registration());
        commands.put(CommandName.SIGN_IN, new SignIn());
        commands.put(CommandName.ADD_TRANSACTION, new AddTransaction());
        commands.put(CommandName.GET_ALL_TRANSACTIONS_OF_CERTAIN_TYPE,new GetAllTransactionsOfCertainType());
        commands.put(CommandName.GET_SUM_OF_TRANSACTIONS_OF_CERTAIN_TYPE, new GetSumOfTransactionsOfCertainType());
        commands.put(CommandName.GET_ALL_TRANSACTIONS, new GetAllTransactions());
        commands.put(CommandName.GET_ALL_TRANSACTIONS_IN_A_PERIOD, new GetAllTransactionsInAPeriod());
        commands.put(CommandName.GET_ALL_TRANSACTIONS_OF_CERTAIN_TYPE_IN_A_PERIOD,
                new GetAllTransactionsOfCertainTypeInAPeriod());
        commands.put(CommandName.LOG_OUT,new LogOut());
        commands.put(CommandName.GET_BALANCE, new GetBalance());
    }

    public Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commands.get(commandName);
        } catch (Exception e) {
            String mes = "Getting command error";

        }
        return command;
    }
}
