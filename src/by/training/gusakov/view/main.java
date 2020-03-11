package by.training.gusakov.view;

import by.training.gusakov.controller.Controller;
import by.training.gusakov.controller.exception.ControllerException;
import by.training.gusakov.util.scanner.DataScanner;


public class main {
    public static void main(String[] args)  {

        Controller controller = new Controller();
        int viewCommand;
        String login = null;

        do{
            while(login == null){
                System.out.println("We are glad to welcome you in your personal money manager\n" +
                        "Enter 1 to register \nEnter 2 to sign in\nEnter 0 to exit");
                int command = DataScanner.getIntFromConsole();
                switch(command){
                    case 1: {
                        System.out.println("Enter login");
                        String loginRegistration = DataScanner.getStringFromConsole();
                        System.out.println("Enter password");
                        String passwordRegistration = DataScanner.getStringFromConsole();

                        String request = "registration login=" + loginRegistration + " password=" + passwordRegistration;

                        String response = null;
                        try {
                            response = controller.executeTask(request);
                        } catch (ControllerException e) {
                            System.out.println("Problems with registration, please, try again, a little bit later");
                        }
                        if (response.equals("You are registered!")) {
                            System.out.println(response);
                            login = loginRegistration;
                        } else {
                            System.out.println(response);
                        }

                        break;
                    }
                    case 2: {
                        System.out.println("Enter login");
                        String loginSigningIn = DataScanner.getStringFromConsole();
                        System.out.println("Enter password");
                        String passwordSigningIn = DataScanner.getStringFromConsole();

                        String requestSigningIn = "sign_in login=" + loginSigningIn + " password=" + passwordSigningIn;

                        String responseSingIn = null;
                        try {
                            responseSingIn = controller.executeTask(requestSigningIn);
                        } catch (ControllerException e) {
                            System.out.println("Problems with entering, please, try a little bit later");
                        }
                        if (responseSingIn.equals("You are entered! Welcome")) {
                            System.out.println("\n" + responseSingIn + "\n");
                            login = loginSigningIn;
                        } else {
                            System.out.println(responseSingIn);
                        }

                        break;
                    }
                }
            }
            if(login != null){
                System.out.println("Enter 1 to add transaction\nEnter 2 to show balance\n" +
                        "Enter 3 to show all expenses\nEnter 4 to show all incomes" +
                        "\nEnter 5 to show sum of all expenses\nEnter 6 to show sum of all incomes" +
                        "\nEnter 7 to show all transactions in a period\n" +
                        "Enter 8 to show transactions of certain type in a period\nEnter 9 to logOut\n" +
                        "Enter 10 to show all transactions");
            }

            viewCommand = DataScanner.getIntFromConsole();
            switch (viewCommand){

                case 1: {
                    System.out.println("Enter type of transaction: income or expense");
                    String type = DataScanner.getStringFromConsole();
                    System.out.println("Enter amount");
                    String amount = DataScanner.getStringFromConsole();
                    System.out.println("Enter the date of your transaction in format: dd-mm-yyyy");
                    String date = DataScanner.getStringFromConsole();
                    System.out.println("Enter the comment");
                    String comment = DataScanner.getStringFromConsole();

                    String requestAddTrans = "add_transaction login=" + login + " type=" + type + " amount=" +
                            amount + " date=" + date + " comment=" + comment;

                    try {
                        System.out.println("\n" + controller.executeTask(requestAddTrans) + "\n");
                    } catch (ControllerException e) {
                        System.out.println("Problems happened, please, try again, a little bit later");
                    }

                    break;
                }
                case 2: {
                    String balanceRequest = "get_balance login=" + login;
                    try {
                        System.out.println("\n" + controller.executeTask(balanceRequest) + "\n");
                    } catch (ControllerException e) {
                        System.out.println("Problems happened, please, try again, a little bit later");
                    }
                }
                case 3: {
                    String requestExpense = "get_all_transactions_of_certain_type login=" + login +
                            " transactionType=EXPENSE";
                    try {
                        System.out.println("\n" + controller.executeTask(requestExpense) + "\n");
                    } catch (ControllerException e) {
                        System.out.println("Problems happened, please, try again, a little bit later");
                    }
                    break;
                }
                case 4: {
                    String requestIncomes = "get_all_transactions_of_certain_type login=" + login +
                            " transactionType=INCOME";
                    try {
                        System.out.println("\n" + controller.executeTask(requestIncomes) + "\n");
                    } catch (ControllerException e) {
                        System.out.println("Problems happened, please, try again, a little bit later");
                    }
                    break;
                }
                case 5: {
                    String requestSumExpenses = "get_sum_of_transactions_of_certain_type login=" + login +
                            " transactionType=EXPENSE";
                    try {
                        System.out.println("\n" + controller.executeTask(requestSumExpenses) + "\n");
                    } catch (ControllerException e) {
                        System.out.println("Problems happened, please, try again, a little bit later");
                    }
                    break;
                }
                case 6: {
                    String requestSumIncomes = "get_sum_of_transactions_of_certain_type login=" + login +
                            " transactionType=INCOME";
                    try {
                        System.out.println("\n" + controller.executeTask(requestSumIncomes) + "\n");
                    } catch (ControllerException e) {
                        System.out.println("Problems happened, please, try again, a little bit later");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Enter the beginning of the period in format dd-mm-yyyy ");
                    String startPeriod = DataScanner.getStringFromConsole();
                    System.out.println("Enter the ending of the period in format dd-mm-yyyy ");
                    String endPeriod = DataScanner.getStringFromConsole();
                    String requestTransactionsInPeriod = "get_all_transactions_in_a_period login=" + login +
                            " startPeriod=" + startPeriod + " endPeriod=" + endPeriod;
                    try {
                        System.out.println("\n" + controller.executeTask(requestTransactionsInPeriod) + "\n");
                    } catch (ControllerException e) {
                        System.out.println("Problems happened, please, try again, a little bit later");
                    }
                    break;
                }
                case 8: {
                    System.out.println("Enter the type of transaction: income or expense");
                    String transType = DataScanner.getStringFromConsole();
                    System.out.println("Enter the beginning of the period in format dd-mm-yyyy ");
                    String transStartPeriod = DataScanner.getStringFromConsole();
                    System.out.println("Enter the ending of the period in format dd-mm-yyyy ");
                    String transEndPeriod = DataScanner.getStringFromConsole();

                    String transRequestInAPeriod = "get_all_transactions_of_certain_type_in_a_period login=" + login
                            + " transactionType=" + transType.toUpperCase() + " startPeriod=" + transStartPeriod +
                            " endPeriod=" + transEndPeriod;
                    try {
                        System.out.println("\n" + controller.executeTask(transRequestInAPeriod) + "\n");
                    } catch (ControllerException e) {
                        System.out.println("Problems happened, please, try again, a little bit later");
                    }
                    break;
                }
                case 9: {
                    String logOutRequest = "log_out ";
                    login = null;
                    try {
                        System.out.println(controller.executeTask(logOutRequest));
                    } catch (ControllerException e) {
                        System.out.println("Problems happened, please, try again, a little bit later");
                    }
                    break;
                }
                case  10: {
                    String requestTransactions = "get_all_transactions login=" + login;
                    try {
                        System.out.println("\n" + controller.executeTask(requestTransactions) + "\n");
                    } catch (ControllerException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default:{
                    System.out.println("Incorrect number! Try again.");
                }
            }

        }while(viewCommand !=0);






    }



}

