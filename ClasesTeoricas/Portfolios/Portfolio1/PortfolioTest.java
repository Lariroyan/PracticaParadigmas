package portfolio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PortfolioTest {

  @Test void testNewAccountHasNoValue() {
    assertEquals( 0, new Account().balance() );
  }

  @Test void testAccountWithADepositHasBalance() {
    assertEquals( 10, accountWith10().balance() );
  }

  @Test void testAccountCanWithdraw() {
    assertEquals( 5, new Account().deposit( 10 )
            .withdraw( 5 )
            .balance() );
  }

  @Test void testAccountCantUseNegativeValues() {
    assertEquals( "Volve a la primaria",
                  assertThrows( RuntimeException.class,
                                () -> new Account().deposit( -10 ) ).getMessage() );
    assertEquals( "Volve a la primaria",
                  assertThrows( RuntimeException.class,
                                () -> new Account().deposit( 10 ).withdraw( -5 ) ).getMessage() );
  }

  @Test void testAccountCantWithdraw() {
    assertEquals( "No hay plata",
                  assertThrows( RuntimeException.class,
                                () -> new Account().withdraw( 15 ) ).getMessage() );
  }

  @Test void testAccountCanWithdrawAndEmptyBalance() {
    assertEquals( 0, new Account().deposit( 10 )
            .withdraw( 10 )
            .balance() );
  }

  @Test void testReportOnEmptyAccount() {
    assertEquals( "Account:\n" +
                  "Balance: 0",
                  new Account().report() );
  }

  @Test void testReportOnAccountWithDeposit() {
    assertEquals( "Account:\n" +
                  "  Deposit: 10\n" +
                  "Balance: 10",
                  accountWith10().report() );
  }

  @Test void testReportOnAccountWithDepositAndWithdraw() {
    assertEquals( "Account:\n" +
                  "  Deposit: 10\n" +
                  "  Withdraw: 5\n" +
                  "Balance: 5",
                  new Account().deposit( 10 )
                          .withdraw( 5 )
                          .report() );
  }

  // Portfolios
  @Test void testBalanceOnNewPortfolio() {
    assertEquals( 0, new Portfolio().balance() );
  }

  @Test void testBalanceAfterAddingAnAccount() {
    Portfolio p = new Portfolio();
    p.addAccount( accountWith10() );
    
    assertEquals( 10, p.balance() );
  }

  @Test void testPortfolioFailsAfterAddingAnAccountTwice() {
    Portfolio p = new Portfolio();
    Account anAccount = accountWith10();
    p.addAccount( anAccount);
    
    assertThrows( RuntimeException.class, () -> p.addAccount( anAccount ) );

    assertEquals( 10, p.balance() );
  }


  @Test void testPortfolioAfterAddingAPortfolio() {
    Portfolio a = new Portfolio();
    a.addAccount( new Portfolio() );
    
    assertEquals( 0, a.balance() );
  }

  @Test void testPortfolioBalanceAddsWell() {
    Portfolio p = new Portfolio();
    p.addAccount( accountWith10() );
    p.addAccount( new Portfolio().addAccount( accountWith10() ) );

    assertEquals( 20, p.balance() );
  }

  // cuentas sin repetir
  @Test void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyAlone() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().addAccount( anAccount );
    Portfolio b = new Portfolio().addAccount( a );
    
    assertThrows( RuntimeException.class, () -> b.addAccount( anAccount ) );

    assertEquals( 10, a.balance() );
  }

  @Test void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyInPortfolio() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().addAccount( anAccount );
    Portfolio b = new Portfolio().addAccount( anAccount );
    
    assertThrows( RuntimeException.class, () -> b.addAccount( a ) );

    assertEquals( 10, a.balance() );
  }

  @Test void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyInOtherBranch() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().addAccount( anAccount );
    Portfolio b = new Portfolio().addAccount( anAccount );
    
    assertThrows( RuntimeException.class, () -> new Portfolio().addAccount( a ).addAccount( b ) );

    assertEquals( 10, a.balance() );
  }
  
  // reportes:
  @Test void testReportPortfolioAfterADeposit() {
    assertEquals( "Portfolio:\n" +  
                  "  Account:\n" +
                  "    Deposit: 10\n" +
                  "  Balance: 10", new Portfolio().addAccount( accountWith10() ).report() );
  }
 
  @Test void testReportPortfolioComplex() {
    assertEquals( "Portfolio:\n" +  
                  "  Portfolio:\n" +  
                  "    Account:\n" +
                  "      Deposit: 10\n" +
                  "    Balance: 10\n" +
                  "  Account:\n" +
                  "    Deposit: 10\n" +
                  "  Balance: 10\n" +
                  "  Portfolio:\n" +  
                  "    Account:\n" +
                  "      Deposit: 10\n" +
                  "    Balance: 10", 
                  new Portfolio().addAccount( new Portfolio().addAccount( accountWith10() ) )
                                 .addAccount( accountWith10() )
                                 .addAccount( new Portfolio().addAccount( accountWith10() ) ).report() );
  }


   
 
  private Account accountWith10() {
    return new Account().deposit( 10 );
  }


  
}
