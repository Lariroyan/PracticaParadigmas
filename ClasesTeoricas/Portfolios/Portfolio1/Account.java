package portfolio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account implements Accountable {
  private List<Transaction> transactions = new ArrayList();
  
  public int balance() {
    return transactions.stream()
        .map( (transaction) -> transaction.valueForBalance() )
        .reduce(0, (a, b) -> a + b);
  }

  public Account deposit( int anAmount ) {
    return register( new Deposit( anAmount ) );

  }

  public Account withdraw( int anAmount ) {
    if ( balance() < anAmount ) {
      throw new RuntimeException( "No hay plata" );
    }
    
    return register( new Withdraw( anAmount ) );
  }
  public Account register(Transaction aTransaction) {
    transactions.add(aTransaction);
    return this;

  }
  public String report() { return report( "" ); }
  public String report( String prefix ) {

    List<String> report = new ArrayList();

    report.add( prefix + "Account:" );

    reportBody( prefix, report );

    report.add( prefix + "Balance: " + balance() );

    return String.join("\n", report);
  }

  private void reportBody( String prefix,  List<String> report ) {
    transactions.forEach( (transaction) -> {
      report.add( prefix + "  " + transaction.reportDetail() );
    });
  }

  public List<Account> accounts() {
    return Arrays.asList( this );
  }


}
