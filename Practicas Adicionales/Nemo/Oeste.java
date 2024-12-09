package nemo;

import java.util.ArrayList;
import java.util.List;

public class Oeste extends Direccion {
	
	public Oeste () {}
	
	public Direccion left () {
		return new Sur (); 
	}
	
	public Direccion right () {
		return new Norte (); 
	}
	
	public List<Integer> moveForward (){
		List<Integer> coordenadas = new ArrayList();
		coordenadas.add(0, -1);
		coordenadas.add(1, 0);
		return coordenadas;
	}
	
	public String getDireccion () {
		return "Oeste";
	}
	
}
