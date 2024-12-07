package portfolio;

public abstract class Transaction {
  protected String origin;
  protected String destiny;
  protected int value;

  public Transaction( int value ) {
    if ( value <= 0 ) throw new RuntimeException( "Volve a la primaria" );
    this.value = value;
  }
  
  public abstract int valueForBalance();
  public abstract String reportDetail();
  
  public int value() {
    return value;
  }
  
}

public class TransferDeposit extends Transaction{
  public TransferDeposit(int value){
    super(value);
  }
  public int valueForBalance(){
    return value;

  }

  public String reportDetail(){
    return"Deposit from Transfer:" + value;
  }


}

class TransferWithdraw extends Transaction{
  public TransferWithdraw(int value){
    super(value);
  }
  public int valueForBalance(){
    return value * -1;
  }

  public String reportDetail(){
    return"Withdraw from Transfer:" + value;
  }
}
