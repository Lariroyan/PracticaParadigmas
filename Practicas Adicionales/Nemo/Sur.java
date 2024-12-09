package nemo;

import java.util.ArrayList;
import java.util.List;

public class Sur extends Direccion {
	
	public Sur () {}
	
	public Direccion left () {
		return new Este (); 
	}
	
	public Direccion right () {
		return new Oeste (); 
	}
	
	public List<Integer> moveForward (){
		List<Integer> coordenadas = new ArrayList();
		coordenadas.add(0, 0);
		coordenadas.add(1, -1);
		return coordenadas;
	}
	
	public String getDireccion () {
		return "Sur";
	}
}
