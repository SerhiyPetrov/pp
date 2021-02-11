package Passes;

public class Holiday extends Passes.PassBase {
    public Holiday(int passType, String passLocation, int passDuration, int passPrice, String passDates) {
        super(2, passLocation, passDuration, passPrice, passDates);
    }

    @Override
    public String toString() {
        return "PassType='" + "Holiday" + '\'' + ", PassLocation='" + PassLocation + '\'' + ", PassDuration='" + PassDuration + '\'' + ", PassPrice='" + PassPrice + '\'' + ", PassDates='" + PassDates + '\'';
    }
} 