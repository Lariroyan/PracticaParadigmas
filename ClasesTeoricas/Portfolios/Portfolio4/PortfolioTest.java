package portfolio7;

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
    Portfolio b = new Portfolio();
    a.addAccount( b );
    
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

  private Account accountWith10() {
    return new Account().deposit( 10 );
  }


  
}
