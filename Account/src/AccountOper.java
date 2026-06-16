public class AccountOper implements Runnable {
    private Account account;
    private int amount;

    public AccountOper(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.deposit(amount);
    }

    public static void main(String[] args) {
        Account account = new Account();
        int threadCount = 10;
        int depositAmount = 1000;
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new AccountOper(account, depositAmount), "客户" + (i + 1));
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("最终余额：" + account.getBalance() + " 元");
    }
}