package portfolio6;

public class Transfer {

    private int value;
    private TransferOrigin origen;
    private TransferDestination destino;


    public static Transfer register( int anAmmount, Account originAccount, Account destinationAccount ) {
       Transfer t = new Transfer( anAmmount );
        originAccount.register( t.origin() );
        destinationAccount.register( t.destination() );
        return t;
    }

    public Transfer( int anAmmount ) {
        if ( anAmmount <= 0 ) throw new RuntimeException();

        value = anAmmount;
        origen = new TransferOrigin( this );
        destino = new TransferDestination( this );
    }


    public int value() {         return value;     }
    public TransferOrigin origin() {   return origen;     }
    public TransferDestination destination() {   return destino;     }

}
