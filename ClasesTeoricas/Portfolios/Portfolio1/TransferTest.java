package portfolio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransferTest {
    @Test void testValueOfTransfer(){
        assertEquals(10, new Transferencia(10).value());
    }

    @Test void testValueOfTransferShouldBePositive(){
        assertThrows(RuntimeException. class, ()-> new Transferencia(0));
    }

    @Test void testValueOfOrigin(){
        assertEquals(10, new Transferencia(10).origin().value());
        assertEquals(10, new Transferencia(10).destination().value());
        Transferencia transferencia = new Transferencia(10);
        assertEquals(transferencia.destination(), new );
    }
    @Test void testX(){
        Transferencia transferencia = new Transferencia(10);
        assertEquals( 20 , new Account().deposit(10).register( transferencia.destination()).balance());
        assertEquals( 10, new Transferencia(10).origin().value());
        assertEquals( 10, new Transferencia(10).destination().value());


    }

    @Test void testReportOnAccountWithDeposit() {
        Account accountDestino = new Account().deposit(10);
        Account accountOrigen = new Account().deposit(10);
        Transferencia.nuevaTransPorConDestinoEnYOrigenEn(10, accountDestino, accountOrigen);
        Transferencia transferencia = new Transferencia(10);
        assertEquals( "Account:\n" +
                        "  Deposit: 10\n" +
                        "  Deposit from Transfer: 10\n" +
                        "Balance: 20",
                accountDestino.report());
    }



}
