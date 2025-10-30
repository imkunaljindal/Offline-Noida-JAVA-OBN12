public class Main {

    public static void main(String[] args) {

        Hdfc kunalAccount = new Hdfc("Kunal Jindal","abc",1000);
        System.out.println(kunalAccount.getAccountNo());

        kunalAccount.deposit(2000);
        System.out.println(kunalAccount.checkBalance("xyz"));
        System.out.println(kunalAccount.checkBalance("abc"));

        kunalAccount.withdraw(1000,"skf");
        kunalAccount.withdraw(5000,"abc");
        kunalAccount.withdraw(2000,"abc");

        kunalAccount.changePassword("xyz","kunal123");
        kunalAccount.changePassword("abc","kunal123");

        System.out.println(kunalAccount.calculateInterest(2));
    }
}
