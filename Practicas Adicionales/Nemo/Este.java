package nemo;

import java.util.ArrayList;
import java.util.List;

public class Este extends Direccion {

	public Este () {}
	
	public Direccion left () {
		return new Norte (); 
	}
	
	public Direccion right () {
		return new Sur (); 
	}
	
	public List<Integer> moveForward (){
		List<Integer> coordenadas = new ArrayList();
		coordenadas.add(0, 1);
		coordenadas.add(1, 0);
		return coordenadas;
	}
	
	public String getDireccion () {
		return "Este";
	}

}
