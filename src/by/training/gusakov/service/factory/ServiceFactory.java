package by.training.gusakov.service.factory;

import by.training.gusakov.service.impl.TransactionServiceImplImpl;
import by.training.gusakov.service.impl.UserServiceImplImpl;

public class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final TransactionServiceImplImpl transactionService = new TransactionServiceImplImpl();
    private final UserServiceImplImpl userService = new UserServiceImplImpl();

    private ServiceFactory(){

    }

    public static ServiceFactory getInstance(){
        return INSTANCE;
    }

    public TransactionServiceImplImpl getTransactionService(){
        return transactionService;
    }

    public UserServiceImplImpl getUserService(){
        return userService;
    }


}
