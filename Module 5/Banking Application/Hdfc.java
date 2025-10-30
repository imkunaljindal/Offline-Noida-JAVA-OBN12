import java.util.UUID;

public class Hdfc implements BankAccount{

    private String accountNo;
    private String holderName;
    private String password;
    private int balance;
    private final double rateOfInterest;

    Hdfc(String holderName, String password, int balance) {
        this.accountNo = String.valueOf(UUID.randomUUID());
        this.holderName = holderName;
        this.password = password;
        this.balance = balance;
        this.rateOfInterest = 6.1;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public int checkBalance(String password) {
        if(this.password.equals(password)){
            return this.balance;
        }
        return -1;
    }

    @Override
    public int deposit(int amount) {
        this.balance += amount;
        return balance;
    }

    @Override
    public void withdraw(int amount, String password) {
        if(!this.password.equals(password)) {
            System.out.println("Wrong password");
            return;
        }
        if(amount > this.balance) {
            System.out.println("Insufficent balance");
            return;
        }
        this.balance -= amount;
        System.out.println("Your final balance = "+this.balance);
    }

    @Override
    public void changePassword(String currentPassword, String newPassword) {
        if(!this.password.equals(currentPassword)) {
            System.out.println("Current password is wrong");
            return;
        }

        this.password = newPassword;
        System.out.println("Password changed succesfully");
    }

    @Override
    public double calculateInterest(int years) {
        return (this.balance*this.rateOfInterest*years)/100.0;
    }
}
