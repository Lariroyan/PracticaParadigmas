package booleans;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BooleanosTest {

	@Test void testTrueAndOnTrue() {
		assertEquals( Booleanos.True().yy( Booleanos.True() ), Booleanos.True() );
	}

	@Test void testTrueAndOnFalse() {
		assertEquals( Booleanos.True().yy( Booleanos.False() ), Booleanos.False() );
	}

	@Test void testTrueOrOnTrue() {
		assertEquals( Booleanos.True().oo( Booleanos.True() ), Booleanos.True() );
	}

	@Test void testTrueOrOnFalse() {
		assertEquals( Booleanos.True().oo( Booleanos.False() ), Booleanos.True() );
	}

	@Test void testTrueNot() {
		assertEquals( Booleanos.True().not(), Booleanos.False() );
	}

  @Test void testFalseAndOnTrue() {
    assertEquals( Booleanos.False().yy( Booleanos.True() ), Booleanos.False() );
  }

  @Test void testFalseAndOnFalse() {
    assertEquals( Booleanos.False().yy( Booleanos.False() ), Booleanos.False() );
  }

  @Test void testFalseOrOnTrue() {
    assertEquals( Booleanos.False().oo( Booleanos.True() ), Booleanos.True() );
  }

  @Test void testFalseOrOnFalse() {
    assertEquals( Booleanos.False().oo( Booleanos.False() ), Booleanos.False() );
  }

  @Test void testFalseNot() {
    assertEquals( Booleanos.False().not(), Booleanos.True() );
  }


}
