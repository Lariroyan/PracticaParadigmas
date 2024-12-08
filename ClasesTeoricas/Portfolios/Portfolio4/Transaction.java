package portfolio7;

public abstract class Transaction {
  protected int value;

  public Transaction() {
  }
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
