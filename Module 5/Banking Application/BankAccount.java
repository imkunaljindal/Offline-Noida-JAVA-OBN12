public interface BankAccount {

    int checkBalance(String password);

    int deposit(int amount);

    void withdraw(int amount, String password);

    void changePassword(String oldPassword, String newPassword);

    double calculateInterest(int years);
}
