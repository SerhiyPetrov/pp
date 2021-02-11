package Passes;

public class PassBase {
    public int PassType;
    public String PassLocation;
    public Integer PassDuration;
    public Integer PassPrice;
    public String PassDates;

    public PassBase(int passType, String passLocation, int passDuration, int passPrice, String passDates) {
        PassType = passType;
        PassLocation = passLocation;
        PassDuration = passDuration;
        PassPrice = passPrice;
        PassDates = passDates;
    }

    @Override
    public String toString() {
        return "PassBase{" + "PassType='" + PassType + '\'' + ", PassLocation='" + PassLocation + '\'' + ", PassDuration='" + PassDuration + '\'' + ", PassPrice='" + PassPrice + '\'' + ", PassDates='" + PassDates + '\'' + '}';
    }

    public int getPassType() {
        return PassType;
    }

    public void setPassType(int passType) {
        PassType = passType;
    }

    public String getPassLocation() {
        return PassLocation;
    }

    public void setPassLocation(String passLocation) {
        PassLocation = passLocation;
    }

    public int getPassDuration() {
        return PassDuration;
    }

    public void setPassDuration(int passDuration) {
        PassDuration = passDuration;
    }

    public int getPassPrice() {
        return PassPrice;
    }

    public void setPassPrice(int passPrice) {
        PassPrice = passPrice;
    }

    public String getPassDates() {
        return PassDates;
    }

    public void setPassDates(String passDates) {
        PassDates = passDates;
    }
}