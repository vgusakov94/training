package by.training.gusakov.validation;

import java.util.Date;

public class Validation {

    public static boolean isEqualsNull(Object o){
        return o == null;
    }

    public static boolean isMoreThanZero(int num){
        return num > 0;
    }

    public static boolean isMoreThanZero(long num){
        return num > 0;
    }

    public static boolean datePeriodIsCorrect(Date startPeriod, Date endPeriod){
        return startPeriod.before(endPeriod);
    }
}
