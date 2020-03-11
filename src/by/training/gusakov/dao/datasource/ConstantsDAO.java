package by.training.gusakov.dao.datasource;

public class ConstantsDAO {

    public static final String LINK_USERS;

    static {
        StringBuilder link = new StringBuilder();
        link.append("resources\\Users.txt");
        LINK_USERS = link.toString();
    }

    public static final String LINK_TRANSACTIONS;

    static {
        StringBuilder link = new StringBuilder();
        link.append("resources\\Transactions.txt");
        LINK_TRANSACTIONS = link.toString();
    }

}
