//al destruirse no solo debe retornar un mensaje de error
//no se puede usar map
//si el submarino tiene problemas con la cápsula no hay nada más por hacer (si se destruye)
//
//Los comandos en sí son, en este caso, caracteres. La secuencia de comandos viene también en este caso en la forma de Strings. 
//Lo que les interesa modelar con polimorfismo, no son los caracteres sino el comportamiento de los comandos sobre el submarino. 
//Ustedes ya están en condiciones de distinguir el 'comando' del 'caracter' que lo representa en el 'medio' en el que se transmite. 
//Se ve que son tres conceptos distintos?
//Mientras piensan en esto, respondo la pregunta, el polimorfismo debe ser entre los las entidades que representan el comportamiento 
//del comando, y no entre Strings.

package nemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class NemoTest {
	
	@Test public void test00InitialCoordinates() {
		Nemo nemo = new Nemo(0, 0, new Norte());
		assertEquals (0, nemo.getCoordenadaX());
		assertEquals (0, nemo.getCoordenadaY());
		assertEquals (0, nemo.getProfundidad());
		assertEquals ("Norte", nemo.getDireccion());
	}
	
	@Test public void test01OtherInitialCoordinates() {
		Nemo nemo = new Nemo(5, -4, new Este());
		
		assertEquals (5, nemo.getCoordenadaX());
		assertEquals (-4, nemo.getCoordenadaY());
		assertEquals (0, nemo.getProfundidad());
		assertEquals ("Este", nemo.getDireccion());
	}
	
	@Test public void test02SendNothingDoNothing() {
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("");
		
		assertEquals (0, nemo.getCoordenadaX());
		assertEquals (0, nemo.getCoordenadaY());
		assertEquals (0, nemo.getProfundidad());
		assertEquals ("Norte", nemo.getDireccion());
	}
	
	@Test public void test03GoDown() {
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("d");
		
		assertEquals (1, nemo.getProfundidad());
	}
	
	@Test public void test04GoDownDown() {
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("dd");
		
		assertEquals (2, nemo.getProfundidad());
	}
	
	@Test public void test05GoDownThenUp() {
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("d");
		assertEquals (1, nemo.getProfundidad());
		
		nemo.doThis("u");
		assertEquals (0, nemo.getProfundidad());
	}
	
	@Test public void test06GoUpWhenNemoIsAtTheTop() {
		Nemo nemo = new Nemo(0, 0, new Norte());
		
		assertEquals (0, nemo.getProfundidad());
		assertEquals (0, nemo.doThis("u").getProfundidad());
	}

	@Test public void test07TurnLeftNorth(){
		Nemo nemo = new Nemo(0, 0, new Norte());
		assertEquals ("Norte", nemo.getDireccion());
		assertEquals ("Oeste", nemo.doThis("l").getDireccion());
	}
	
	@Test public void test08TurnRightNorth(){
		Nemo nemo = new Nemo(0, 0, new Norte());
		assertEquals ("Norte", nemo.getDireccion());
		assertEquals ("Este", nemo.doThis("r").getDireccion());
	}
	
	@Test public void test09TurnRightThenLeftNorth(){
		Nemo nemo = new Nemo(0, 0, new Norte());
		assertEquals ("Este", nemo.doThis("r").getDireccion());
		assertEquals ("Norte", nemo.doThis("l").getDireccion());
	}

	@Test public void test10MoveForwardToNorth(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("f");
		assertEquals (1, nemo.getCoordenadaY());
		assertEquals ("Norte", nemo.getDireccion());
	}
	
	@Test public void test11MoveForwardToEast(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("rf");
		assertEquals (1, nemo.getCoordenadaX());
		assertEquals ("Este", nemo.getDireccion());
	}
	
	@Test public void test12MoveForwardToWest(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("lf");
		assertEquals (-1, nemo.getCoordenadaX());
		assertEquals ("Oeste", nemo.getDireccion());
	}
	
	@Test public void test13MoveForwardToSouth(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("rrf");
		assertEquals (-1, nemo.getCoordenadaY());
		assertEquals ("Sur", nemo.getDireccion());
	}
	
	@Test public void test14ReleaseACapsuleOnTheSurface(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("m");
		assertEquals (0, nemo.getCoordenadaX());
		assertEquals (0, nemo.getCoordenadaY());
		assertEquals (0, nemo.getProfundidad());
	}
	
	@Test public void test15ReleaseACapsuleOnDepthOne(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("dm");
		assertEquals (0, nemo.getCoordenadaX());
		assertEquals (0, nemo.getCoordenadaY());
		assertEquals (1, nemo.getProfundidad());
	}
	
	@Test public void test16NemoExplodes(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("dd");
		assertThrowsLike (() -> nemo.doThis("m"), Profundidad.errorMessage_Explota);
	}
	
	@Test public void test17MoveAndReleaseACapsuleOnTheSurface(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("fflfrfrm");
		assertEquals (-1, nemo.getCoordenadaX());
		assertEquals (3, nemo.getCoordenadaY());
		assertEquals (0, nemo.getProfundidad());
		assertEquals ("Este", nemo.getDireccion());
	}
	
	@Test public void test18MoveAndReleaseACapsuleOnDepthOne(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("dfflfrfrm");
		assertEquals (-1, nemo.getCoordenadaX());
		assertEquals (3, nemo.getCoordenadaY());
		assertEquals (1, nemo.getProfundidad());
		assertEquals ("Este", nemo.getDireccion());
	}
	
	@Test public void test19MoveAndReleaseACapsuleBelowDepthOne(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("ddfflfrfr");
		assertEquals (-1, nemo.getCoordenadaX());
		assertEquals (3, nemo.getCoordenadaY());
		assertEquals (2, nemo.getProfundidad());
		assertEquals ("Este", nemo.getDireccion());
		assertThrowsLike (() -> nemo.doThis("m"), Profundidad.errorMessage_Explota);
	}
	
	@Test public void test20MoveNemoWithSpaces(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("f f l f"); //pruebo con espacios 
		assertEquals (-1, nemo.getCoordenadaX());
		assertEquals (2, nemo.getCoordenadaY());
		assertEquals (0, nemo.getProfundidad());
		assertEquals ("Oeste", nemo.getDireccion());
		
	}

	@Test public void test21MultipleRotationLeft(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("lll");
		assertEquals ("Este", nemo.getDireccion());

	}

	@Test public void test22MultipleRotationRight(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("rrr");
		assertEquals ("Oeste", nemo.getDireccion());
	}

	@Test public void test23RotationFromAllDirections(){
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("");
		assertEquals ("Norte", nemo.getDireccion());

		nemo.doThis("rr");
		assertEquals ("Sur", nemo.getDireccion());

		nemo.doThis("lll");
		assertEquals ("Oeste", nemo.getDireccion());

	}

	@Test public void test24DescendAndFreeCapsule(){

		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("rrdd");
		assertEquals ("Sur", nemo.getDireccion());
		assertThrowsLike (() -> nemo.doThis("m"), Profundidad.errorMessage_Explota);
		

	}
	
	@Test public void test25ComplexNemoOperations(){ 
		Nemo nemo = new Nemo(0, 0, new Norte()).doThis("fflmddrrf");
    	assertEquals (1, nemo.getCoordenadaX());
    	assertEquals (2, nemo.getCoordenadaY());
    	assertEquals (2, nemo.getProfundidad());
    	assertEquals ("Este", nemo.getDireccion());

	}

	@Test public void test26ComplexNemoOperations(){ 
		Nemo nemo = new Nemo(0, 0, new Este()).doThis("lrfrfmlfrrff");
    	assertEquals (0, nemo.getCoordenadaX());
    	assertEquals (-1, nemo.getCoordenadaY());
    	assertEquals (0, nemo.getProfundidad());
    	assertEquals ("Oeste", nemo.getDireccion());
}

@Test public void test27ComplexNemoOperatiobs(){
	Nemo nemo = new Nemo(0, 0, new Norte()).doThis("dmdfumrlfflmrmm");
    assertEquals (0, nemo.getCoordenadaX());
    assertEquals (3, nemo.getCoordenadaY());
    assertEquals (1, nemo.getProfundidad());
    assertEquals ("Norte", nemo.getDireccion());
}


	
	
	private void assertThrowsLike( Executable e, String message ) {
		  assertEquals( message, assertThrows( Error.class, e ).getMessage() );
	  }

}	