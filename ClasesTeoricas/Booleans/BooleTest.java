package booleans;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BooleTest {

	@Test void testDeMorganAndOnVF() {
		assertEquals( Booleanos.True().yy( Booleanos.False() ),
					  ( Booleanos.True().not().oo( Booleanos.False().not() ) ).not() );
	}

	@Test void testDeMorganAndOnFV() {
		assertEquals( Booleanos.False().yy( Booleanos.True() ),
					  ( Booleanos.False().not().oo( Booleanos.True().not() ) ).not() );
	}

	@Test void testDeMorganOrOnVF() {
		assertEquals( Booleanos.True().oo( Booleanos.False() ),                         //    v | f    -> v
					  ( Booleanos.True().not().yy( Booleanos.False().not() ) ).not() );	// -(-v & -f ) -> ?
	}                                                                                   // -( f &  v ) -> v
 
	@Test void testDeMorganOrOnFV() {
		assertEquals( Booleanos.False().oo( Booleanos.True() ),
					  ( Booleanos.False().not().yy( Booleanos.True().not() ) ).not() );
	}

}
