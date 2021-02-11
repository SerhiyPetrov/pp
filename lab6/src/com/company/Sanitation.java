package Passes;

public class Sanitation extends Passes.PassBase {
    public Sanitation(int passType, String passLocation, int passDuration, int passPrice, String passDates) {
        super(passType, passLocation, passDuration, passPrice, passDates);
    }

    @Override
    public String toString() {
        return "PassType='" + "Sanitation" + '\'' + ", PassLocation='" + PassLocation + '\'' + ", PassDuration='" + PassDuration + '\'' + ", PassPrice='" + PassPrice + '\'' + ", PassDates='" + PassDates + '\'';
    }
}