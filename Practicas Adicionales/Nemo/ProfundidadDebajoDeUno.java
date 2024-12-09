package nemo;

import java.util.List;

public class ProfundidadDebajoDeUno extends Profundidad{
	
	public List<Profundidad> subirNemo(List<Profundidad> profundidades) {
		profundidades.remove(profundidades.size()-1);
		return profundidades;
	}

	public List<Profundidad> bajarNemo(List<Profundidad> profundidades) {
		profundidades.add(new ProfundidadDebajoDeUno());
		return profundidades;
	}

	public void liberarCapsula() {
		throw new Error (errorMessage_Explota);
	}

}