package nemo;

import java.util.List;

public abstract class Direccion {
	public abstract Direccion left ();
	public abstract Direccion right ();
	public abstract List<Integer> moveForward ();
	public abstract String getDireccion ();
}