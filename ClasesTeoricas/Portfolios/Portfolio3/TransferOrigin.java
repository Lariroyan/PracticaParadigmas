package portfolio6;


public class TransferOrigin extends TransferTransaction   {

  public TransferOrigin( Transfer transfer ) {
    super( transfer );
  }
  
  public TransferDestination destination() {
    return transfer.destination();
  }

  public int affectBalance() {
    return - value();
  }

  public String reportDetail() {
    return "Débito por transferencia de: " + value();
  }


}
