public class Customer {

    private String personName;
    private double meterBefore;
    private double meterNow;

    public Customer(String personName, double meterBefore, double meterNow) {
        this.personName = personName;
        this.meterBefore = meterBefore;
        this.meterNow = meterNow;
    }

    public String getPersonName() { return personName; }
    public double getMeterBefore() { return meterBefore; }
    public double getMeterNow() { return meterNow; }

    // subtract old unit from new unit  to get units consumption
    public double getTotalUnits() {
        return meterNow - meterBefore;
    }
}
