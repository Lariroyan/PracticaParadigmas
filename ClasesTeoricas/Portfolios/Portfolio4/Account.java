package portfolio7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account extends Accountable {
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


  public Account register( Transaction trannsactionToRegister ) {
     transactions.add( trannsactionToRegister );
     return this;
  }
  
  public boolean contains( Accountable anAccountable ) {
    return equals( anAccountable );
  }

  public List<Account> accounts() {
    return Arrays.asList( this );
  }

  public List<Transaction> transactions() {
    return transactions;
  }

  public String title() {
    return "Account:";
  }

  public void reportOn( Report report ) {
    report.reportAsAccount( this );
  }

  public void reportTransactionsOn( Report report ) {
    transactions().forEach( (transaction) -> {
      report.reportAsTransaction( transaction );
    });
  }

}









