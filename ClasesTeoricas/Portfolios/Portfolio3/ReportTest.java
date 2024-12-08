package portfolio6;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
public class ReportTest {
    @Test void test01reportAfterDeposit() {
        assertEquals( "Cuenta:\n" +
                "  Deposit: 10\n" +
                "Balance: 10", Report.report(accountWith10()) );
    }
    @Test void test02ReportAfterWithdraw() {
        assertEquals( "Cuenta:\n" +
                "  Deposit: 10\n" +
                "  Withdraw: 5\n" +
                "Balance: 5",
                Report.report(accountWith10().withdraw(5)));
    }


    @Test void testReportPortfolioAfterADeposit() {
        assertEquals( "Portfolio:\n" +
                "  Cuenta:\n" +
                "    Deposit: 10\n" +
                "  Balance: 10",
                Report.report(new Portfolio().addAccount( accountWith10() )));

    }

    @Test void testReportPortfolioComplex() {
        assertEquals( "Portfolio:\n" +
                        "  Portfolio:\n" +
                        "    Cuenta:\n" +
                        "      Deposit: 10\n" +
                        "    Balance: 10\n" +
                        "  Cuenta:\n" +
                        "    Deposit: 10\n" +
                        "  Balance: 10\n" +
                        "  Portfolio:\n" +
                        "    Cuenta:\n" +
                        "      Deposit: 10\n" +
                        "    Balance: 10",
                Report.report(new Portfolio().addAccount( new Portfolio().addAccount( accountWith10() ) )
                        .addAccount( accountWith10() )
                        .addAccount( new Portfolio().addAccount( accountWith10() ) )));
    }
//
    @Test void testReportAfterATransferenceWithdraw() {
        Account anAccount = accountWith10();
        Account anotherAccount = accountWith10();

        transferRegister( 10, anAccount, anotherAccount );
        assertEquals( "Cuenta:\n" +
                "  Deposit: 10\n" +
                "  Débito por transferencia de: 10\n" +
                "Balance: 0", Report.report(anAccount) );
    }
//
    @Test void testReportAfterATransferenceDeposit() {
        Account anAccount = accountWith10();
        Account anotherAccount = accountWith10();

        transferRegister( 10, anAccount, anotherAccount );
        assertEquals( "Cuenta:\n" +
                "  Deposit: 10\n" +
                "  Depósito por transferencia de: 10\n" +
                "Balance: 20", Report.report(anotherAccount) );
    }

    private Transfer transferRegister( int anAmmount, Account originAccount, Account destinationAccount ) {
        return Transfer.register( anAmmount, originAccount, destinationAccount );
    }

    private Transfer transferOf( int anAmmount ) {
        return new Transfer( anAmmount );
    }


    private Account accountWith10() {
        return new Account().deposit( 10 );
    }



}
