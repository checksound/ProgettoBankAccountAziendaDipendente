package org.example.base;

public class Bancomat extends Thread {
    private BankAccount bankAccount;
    public Bancomat(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void run() {
        for(int i = 0; i < 100; i++) {
            int livelloConto = bankAccount.prelava(1000);

            System.out.println("<-- Prelevato - Livello conto: " + livelloConto);

            try {
                sleep(RandomGen.getRandom());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
