package continental;

public class HabitacionOcupada extends Habitacion {

    private final String huespedActual;

    public HabitacionOcupada(int numero, String huespedActual) {
        super(numero);
        this.huespedActual = huespedActual;
    }

    public void ocupar(String huesped) {
        throw new IllegalStateException("La habitación ya está ocupada.");
    }

    public void reservar(String huesped) {
        throw new IllegalStateException("La habitación ya está ocupada.");
    }

    public void liberar() {
        Hotel.cambiarEstado(numero, new HabitacionDisponible(numero));
    }

    public String getHuespedActual() {
        return huespedActual;
    }
}
