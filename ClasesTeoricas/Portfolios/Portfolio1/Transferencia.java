package portfolio;

public class Transferencia {
    private int value;
    public Transferencia(int anAmount){
        if (anAmount <= 0) throw new RuntimeException();
        value = anAmount;
    }

    public static Transferencia nuevaTransPorConDestinoEnYOrigenEn(int anAmount, Account accountDestino, Account accountOrigen) {
        Transferencia t = new Transferencia(anAmount);
        accountDestino.register(t.destination());
        accountOrigen.register(t.origin());
        return t;
    }

    public int value() {return value;}

    public Withdraw origin() {
        return new Withdraw(value);

    }
    public Deposit destination() {
        return new Deposit(value) ;
    }
}
