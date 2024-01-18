package org.example.base;

public class Azienda extends Thread {
    private BankAccount bankAccount;

    public Azienda(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void run() {
        for(int i = 0; i < 100; i++) {
            bankAccount.deposita(1000);
            System.out.println("Depositato -->");
            try {
                sleep(RandomGen.getRandom());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
