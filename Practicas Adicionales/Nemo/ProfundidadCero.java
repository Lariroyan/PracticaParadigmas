package nemo;

import java.util.List;

public class ProfundidadCero extends Profundidad{
	
	public List<Profundidad> subirNemo(List<Profundidad> profundidades) {
		return profundidades;
	}

	public List<Profundidad> bajarNemo(List<Profundidad> profundidades) {
		profundidades.add(new ProfundidadUno());
		return profundidades;
	}

	public void liberarCapsula() {}
	
}
