package encapsulation;

public class Avenger {

    protected String name;
    private int power;
    private double roi = 7.5;

    private void fight() {
        System.out.println("Avenger is fighting with power"+ power);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {

    }

    public String getName() {
        return this.name;
    }
}
