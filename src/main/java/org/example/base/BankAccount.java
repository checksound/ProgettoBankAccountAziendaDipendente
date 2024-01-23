package org.example.base;

public class BankAccount {
    private int livelloConto;

    public BankAccount() {
    }

    public BankAccount(int startLivelloConto) {
        deposita(startLivelloConto);
    }

    public synchronized void deposita(int quantita) {
        this.livelloConto += quantita;
    }

    public synchronized int prelava(int quantita) {
        this.livelloConto -= quantita;
        return this.livelloConto;
    }

    public synchronized int getLivelloConto() {
        return livelloConto;
    }

}
