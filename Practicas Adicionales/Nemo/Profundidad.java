package nemo;

import java.util.List;

public abstract class Profundidad {
	public static String errorMessage_Explota = "BOOM";
	
	public abstract List<Profundidad> subirNemo (List<Profundidad> profundidades);
	public abstract List<Profundidad> bajarNemo (List<Profundidad> profundidades);
	public abstract void liberarCapsula ();
}