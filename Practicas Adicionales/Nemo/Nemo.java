package nemo;

import java.util.ArrayList;
import java.util.List;


public class Nemo {
	
	private Posicion coordenada;
	private Direccion direccion;
	private List<Profundidad> profundidades = new ArrayList();
	private ComandoNemo comandoActual;
	private List<ComandoNemo> comandos = new ArrayList<>(); 

	
	
	public Nemo (int posInicialX, int posInicialY, Direccion direcInicial) {
		coordenada = new Posicion (posInicialX, posInicialY);
		direccion = direcInicial;
		profundidades.add(new ProfundidadCero());
        comandos.add(new ComandoDescender());
        comandos.add(new ComandoAscender());
        comandos.add(new ComandoGirarIzquierda());
        comandos.add(new ComandoGirarDerecha());
        comandos.add(new ComandoAvanzar());
        comandos.add(new ComandoCapsulaLiberada());
	}

	public Nemo doThis(String comandos) {
		comandos.chars()
				.forEach(c -> this.comandos.stream()
						.filter(comando -> comando.buscarComando((char) c))
						.findFirst()
						.ifPresent(commandFound -> commandFound.ejecutar(this)));
		return this;
	}
	
	public void hacer(Character comando) { 
		comandoActual.ejecutar(this); 
	}
		
	public void ascender() {
		profundidades = profundidades.get(profundidades.size() - 1).subirNemo(profundidades);
	}

	public void descender() {
		profundidades = profundidades.get(profundidades.size() - 1).bajarNemo(profundidades);
	}

	public void girarIzquierda() {
		direccion = direccion.left();
	}

	public void girarDerecha() {
		direccion = direccion.right();
	}

	public void avanzar() {
		coordenada = coordenada.add(direccion.moveForward());
	}

	public void liberarCapsula() {
		profundidades.get(profundidades.size() - 1).liberarCapsula();
	}
	
	//getters
	public int getProfundidad () {return profundidades.size() - 1;}
	public int getCoordenadaX () {return coordenada.coordenadaX();}
	public int getCoordenadaY () {return coordenada.coordenadaY();}
	public String getDireccion () {return direccion.getDireccion();}
	
}
