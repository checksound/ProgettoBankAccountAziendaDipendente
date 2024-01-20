package org.example.start;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccount(1000);

        Azienda azienda = new Azienda(bankAccount);
        Bancomat bancomat = new Bancomat(bankAccount);

        azienda.start();
        bancomat.start();

        azienda.join();
        bancomat.join();

        int livelloConto = bankAccount.getLivelloConto();

        System.out.println("Livello conto: " + livelloConto);

    }
}