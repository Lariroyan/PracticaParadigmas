package portfolio6;

public abstract class Transaction {
    protected int value;

    protected Transaction( int anAmount ) {
        value = anAmount;
    }
//    public abstract boolean isDeposit();
    public abstract String reportDetail();
    public abstract int affectBalance();

    public int value() { return value; }
}

class Deposit extends Transaction {
    public Deposit( int anAmount ) {
        super( anAmount );
    }
    public String reportDetail() {     return "Deposit: " + value();     }
    public int affectBalance() {       return value();    }
    public boolean isDeposit() {       return true;   }
}

class Withdraw extends Transaction {
    public Withdraw( int anAmount ) {
        super( anAmount );
    }
    public String reportDetail() {     return "Withdraw: " + value();     }
    public int affectBalance() {       return - value();    }
    public boolean isDeposit() {       return false;   }
}
