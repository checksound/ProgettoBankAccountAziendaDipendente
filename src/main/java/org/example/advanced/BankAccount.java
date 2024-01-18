package org.example.advanced;

public class BankAccount {
    private int livelloConto;

    public BankAccount() {}

    public BankAccount(int startLivelloConto) {
        deposita(startLivelloConto);
    }

    public synchronized void deposita(int quantita) {
        this.livelloConto += quantita;
        notify();
    }

    public synchronized int prelava(int quantita) {
        while(this.livelloConto<quantita) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.livelloConto -= quantita;
        return this.livelloConto;
    }

    public synchronized int getLivelloConto() {
        return livelloConto;
    }

}
