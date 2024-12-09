package nemo;

import java.util.ArrayList;
import java.util.List;

public class Norte extends Direccion {
	
	public Norte () {}
	
	public Direccion left () {
		return new Oeste ();
	}
	
	public Direccion right () {
		return new Este ();
	}
	
	public List<Integer> moveForward (){
		List<Integer> coordenadas = new ArrayList();
		coordenadas.add(0, 0);
		coordenadas.add(1, 1);
		return coordenadas;
	}
	
	public String getDireccion () {
		return "Norte";
	}
	
}
