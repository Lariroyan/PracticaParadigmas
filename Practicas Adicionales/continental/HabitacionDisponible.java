package continental;

public class HabitacionDisponible extends Habitacion {

    public HabitacionDisponible(int numero) {
        super(numero);
    }

    public void ocupar(String huesped) {
        Hotel.cambiarEstado(numero, new HabitacionOcupada(numero, huesped));
    }

    public void reservar(String huesped) {
        Hotel.cambiarEstado(numero, new HabitacionReservada(numero, huesped));
    }

    public void liberar() {
        throw new IllegalStateException("La habitación ya está desocupada.");
    }

    public String getHuespedActual() {
        throw new IllegalStateException("La habitación está desocupada.");
    }
}
