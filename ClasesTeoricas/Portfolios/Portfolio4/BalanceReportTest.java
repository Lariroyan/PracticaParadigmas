package portfolio7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BalanceReportTest {
  
  @Test void testReportOnEmptyAccount() {
    assertEquals( "Account:\n" +
                  "Balance: 0",
                  BalanceReport.report( new Account() ) );
  }

  @Test void testReportOnAccountWithDeposit() {
    assertEquals( "Account:\n" +
                  "Balance: 10",
                  BalanceReport.report( accountWith10()) );
  }

  @Test void testReportOnAccountWithDepositAndWithdraw() {
    assertEquals( "Account:\n" +
                  "Balance: 5",
                  BalanceReport.report( new Account().deposit( 10 )
                          .withdraw( 5 )
                          ) );
  }
  @Test void testReportPortfolioAfterADeposit() {
    assertEquals( "Portfolio:\n" +
                  "  Account:\n" +
                  "  Balance: 10\n" +
                  "Balance: 10", BalanceReport.report( new Portfolio().addAccount( accountWith10() )) );
  }

  @Test void testReportPortfolioComplex() {
    assertEquals( "Portfolio:\n" +
                  "  Portfolio:\n" +
                  "    Account:\n" +
                  "    Balance: 10\n" +
                  "  Balance: 10\n" +
                  "  Account:\n" +
                  "  Balance: 10\n" +
                  "  Portfolio:\n" +
                  "    Account:\n" +
                  "    Balance: 10\n" +
                  "  Balance: 10\n" +
                  "Balance: 30",
                  BalanceReport.report( new Portfolio().addAccount( new Portfolio().addAccount( accountWith10() ) )
                          .addAccount( accountWith10() )
                          .addAccount( new Portfolio().addAccount( accountWith10() ) )) );
  }

  @Test void testReportAfterATransferenceWithdraw() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();

    transferRegister( 10, anAccount, anotherAccount );
    assertEquals( "Account:\n" +
                  "Balance: 0", BalanceReport.report( anAccount ) );
  }

  @Test void testReportAfterATransferenceDeposit() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();

    transferRegister( 10, anAccount, anotherAccount );
    assertEquals( "Account:\n" +
                  "Balance: 20", BalanceReport.report( anotherAccount ) );
  }

  private Transfer transferRegister( int anAmmount, Account originAccount, Account destinationAccount ) {
    return Transfer.register( anAmmount, originAccount, destinationAccount );
  }

  private Account accountWith10() {
    return new Account().deposit( 10 );
  }
  
}
