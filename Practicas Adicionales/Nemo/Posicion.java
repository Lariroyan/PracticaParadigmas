package nemo;

import java.util.List;

public class Posicion {
	
	public int coordenadaX;
	public int coordenadaY;
	
	public Posicion (int coordX, int coordY) {
		coordenadaX = coordX;
		coordenadaY = coordY;
	}
	
	public Posicion add (List<Integer> diferenciales) {
		return new Posicion (coordenadaX + diferenciales.get(0), coordenadaY + diferenciales.get(1));
	}

	public int coordenadaX() {
		return coordenadaX;
	}

	public int coordenadaY() {
		return coordenadaY;
	}
}
