package abstraction;

public class Hdfc implements Bank{
    @Override
    public int getRateOfInterest() {
        return 5;
    }

    @Override
    public String getDetails() {
        return "This is HDFC bank";
    }
}
