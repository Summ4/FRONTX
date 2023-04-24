package selenideWebTesting.dataObjects.Enums;

import java.util.Arrays;
import java.util.List;

public enum PeriodEnums {

    ONCE("ერთჯერადი"),
    WEEKLY("ერთი კვირა"),
    MONTHLY("ერთი თვე"),
    YEARLY("ერთი წელი");
//    INDEFINITELY("უსასრულოდ");

    private final String period;

    PeriodEnums(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }



}
