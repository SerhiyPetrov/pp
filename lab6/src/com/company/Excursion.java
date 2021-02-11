package Passes;

public class Excursion extends Passes.PassBase {
    public Excursion(int passType, String passLocation, int passDuration, int passPrice, String passDates) {
        super(1, passLocation, passDuration, passPrice, passDates);
    }

    @Override
    public String toString() {
        return "PassType='" + "Excursion" + '\'' + ", PassLocation='" + PassLocation + '\'' + ", PassDuration='" + PassDuration + '\'' + ", PassPrice='" + PassPrice + '\'' + ", PassDates='" + PassDates + '\'';
    }
}