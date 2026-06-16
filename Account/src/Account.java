class Account {  // 非 public，可以放在同一包下
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " 存入 " + amount + " 元，当前余额：" + balance);
    }

    public int getBalance() {
        return balance;
    }
}