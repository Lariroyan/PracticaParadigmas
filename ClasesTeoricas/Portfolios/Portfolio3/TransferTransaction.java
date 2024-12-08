package portfolio6;

public abstract class TransferTransaction extends Transaction {
  protected Transfer transfer;

  public TransferTransaction( Transfer transfer ) {
    super( transfer.value() );
    this.transfer = transfer;
  }

  public int value() {
    return transfer.value();
  }

}
