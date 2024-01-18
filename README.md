# Progetto BankAccount Azianda Dipendente

Creare un progetto Java con 3 classi:  
**Account** : rappresenta il conto corrente di un utente dove è possibile effettuare 3 operazioni:
- versare del denaro
- prelevarlo
- avere il saldo

**Company** : è una classe Thread che rappresenta l'azienda per la quale l'utente lavora.  
  All'interno di run() creare un ciclo di 100 iterazioni nel quale per ogni iterazione
  viene aggiunta una somma di 1000€ sul conto passando al thread l'oggetto di tipo Account.  
**Bancomat** : è una classe Thread che rappresenta il bancomat dell'utente che ha bisogno di prelevare 
denaro.
  All'interno di run() creare un ciclo di 100 iterazioni nel quale per ogni iterazione
  viene sottratta una somma di 1000€ dal conto passando al thread l'oggetto di tipo Account

Partire con un bilancio iniziale di 1000€ e stampare il saldo del conto al termine del lavoro
dei due thread.
Quale sarà il risultato?

## Versione base

Classe applicazione, [org.example.base.Applicazione](./src/main/java/org/example/base/Application.java),
i thread [org.example.base.Azienda](./src/main/java/org/example/base/Azienda.java) e
[org.example.base.Bancomat](./src/main/java/org/example/base/Bancomat.java), 
e la classe dell'account, 
[org.example.base.BankAccount](./src/main/java/org/example/base/BankAccount.java), condiviso tra i due thread.

```java
package org.example.base;

public class BankAccount {

    private int livelloConto;

    public BankAccount() {}

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
```

Eseguendo l'esempio si può vedere che può seccedere che venda prelevato da BankAccount anche se 
sul conto non c'è disponibilità mandando il conto in negativo. Come fare per evitare questo, cioè che il thread Bancomat aspetti a prelevare 
finchè sul conto c'è disponibilità?

La versione sotto utilizza wait() e notify() per sincronizzare l'accesso al BanckAccount.

## Versione avanzata

La nuova applicazione 
[org.example.advanced.Applicazione](./src/main/java/org/example/advanced/Application.java) con la versione
nuova di [org.example.advanced.BankAccount](./src/main/java/org/example/advanced/BankAccount.java).

```java
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
```

