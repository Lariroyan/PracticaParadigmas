package portfolio7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReportTest {
  
  @Test void testReportOnEmptyAccount() {
    assertEquals( "Account:\n" +
                  "Balance: 0",
                  SummaryTreeReport.report( new Account() ) );
  }

  @Test void testReportOnAccountWithDeposit() {
    assertEquals( "Account:\n" +
                  "Deposit: 10\n" +
                  "Balance: 10",
                  SummaryTreeReport.report( accountWith10()) );
  }

  @Test void testReportOnAccountWithDepositAndWithdraw() {
    assertEquals( "Account:\n" +
                  "Deposit: 10\n" +
                  "Withdraw: 5\n" +
                  "Balance: 5",
                  SummaryTreeReport.report( new Account().deposit( 10 )
                          .withdraw( 5 )
                          ) );
  }
  @Test void testReportPortfolioAfterADeposit() {
    assertEquals( "Portfolio:\n" +
            "  Account:\n" +
            "  Deposit: 10\n" +
            "  Balance: 10\n" +
            "Balance: 10", SummaryTreeReport.report( new Portfolio().addAccount( accountWith10() )) );
  }

  @Test void testReportPortfolioComplex() {
    assertEquals( "Portfolio:\n" +
                  "  Portfolio:\n" +
                  "    Account:\n" +
                  "    Deposit: 10\n" +
                  "    Balance: 10\n" +
                  "  Balance: 10\n" +
                  "  Account:\n" +
                  "  Deposit: 10\n" +
                  "  Balance: 10\n" +
                  "  Portfolio:\n" +
                  "    Account:\n" +
                  "    Deposit: 10\n" +
                  "    Balance: 10\n" +
                  "  Balance: 10\n" +
                  "Balance: 30",
                  SummaryTreeReport.report( new Portfolio().addAccount( new Portfolio().addAccount( accountWith10() ) )
                          .addAccount( accountWith10() )
                          .addAccount( new Portfolio().addAccount( accountWith10() ) )) );
  }



  private Account accountWith10() {
    return new Account().deposit( 10 );
  }
  
}
