package portfolio6;

import java.util.ArrayList;
import java.util.List;

public class Account extends Accountable {
    public static String HayQueIrATrabajar = "hay que ir a trabajar";
    public List<Transaction> transactions = new ArrayList();

    public int balance() {
        return transactions.stream()
                .map( (transaction) -> transaction.affectBalance() )
                .reduce(0, (a, b) -> a + b);
    }

    public void register( Transaction aTransaction ) {
        transactions.add( aTransaction );
    }
    public Account deposit( int anAmount ) {
        register( new Deposit( anAmount ) );
        return this;
    }
    public Account withdraw( int anAmount ) {
        if ( anAmount > balance() ) {
            throw new RuntimeException( HayQueIrATrabajar );
        }
        register( new Withdraw( anAmount ) );
        return this;
    }

//    public String report( String prefix ) {
//        List<String> report = new ArrayList();
//
//        report.add( prefix + "Cuenta:" );
//        transactions.forEach( (transaction) -> {
//            report.add( prefix + "  " + transaction.reportDetail() );
//        });
//
//        report.add( prefix + "Balance: " + balance() );
//
//        return String.join("\n", report);
//    }

    public List<Account> accounts() {
        return List.of(this );
    }

    @Override
    public void reportOn(Report report) {
        report.reportAccount(this);
    }

}
