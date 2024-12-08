package portfolio6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PortfolioTest {

    @Test void testNewAccountHasNoBalance() {
        assertEquals( 0, new Account().balance() );
    }
    @Test void test02() {
        assertEquals( 10, new Account().deposit( 10 ).balance() );
    }
    @Test void test03() {
        assertEquals( 5, new Account()
                                .deposit( 10 )
                                .withdraw( 5 ).balance() );
    }
    @Test void test04() {
        assertEquals( Account.HayQueIrATrabajar,
                      assertThrows( RuntimeException.class, () -> new Account().withdraw( 5 ).balance() ).getMessage() );
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
//
//    @Test void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyInOtherBranchPlus() {
//        Account anAccount = accountWith10();
//        Portfolio a = new Portfolio().addAccount( anAccount );
//        Portfolio c = new Portfolio();
//        a.addAccount( c );
//        Portfolio b = new Portfolio().addAccount( anAccount );
//
//        assertThrows( RuntimeException.class, () -> c.addAccount( b ) );
//
//        assertEquals( 10, a.balance() );
//    }
  // reportes:

  private Account accountWith10() {
    return new Account().deposit( 10 );
  }

}
