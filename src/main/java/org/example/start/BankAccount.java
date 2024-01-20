package org.example.start;

public class BankAccount {
    private int livelloConto;

    public BankAccount() {}

    public BankAccount(int startLivelloConto) {
        deposita(startLivelloConto);
    }

    public void deposita(int quantita) {
        this.livelloConto += quantita;
    }

    public int prelava(int quantita) {
        this.livelloConto -= quantita;
        return this.livelloConto;
    }

    public synchronized int getLivelloConto() {
        return livelloConto;
    }

}
