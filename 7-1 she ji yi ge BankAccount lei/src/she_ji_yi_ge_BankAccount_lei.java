import java.util.Scanner;
class BankAccount{
    private int balance;
    public BankAccount() {
        this.balance = 0;
    }
    public BankAccount(int balance) {
        this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }
    public void withdraw(int amount) {
        balance -= amount;
    }
    public void deposit(int amount) {
        balance += amount;
    }
}
public class she_ji_yi_ge_BankAccount_lei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int initial = sc.nextInt();
        int withdrawAmount = sc.nextInt();
        int depositAmount = sc.nextInt();
        BankAccount account = new BankAccount(initial);
        System.out.println(account.getBalance());
        account.withdraw(withdrawAmount);
        System.out.println(account.getBalance());
        account.deposit(depositAmount);
        System.out.println(account.getBalance());
        sc.close();
    }
}
