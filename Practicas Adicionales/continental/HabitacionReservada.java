package continental;

public class HabitacionReservada extends Habitacion {
    private final String huespedReservado;

    public HabitacionReservada(int numero, String huespedReservado) {
        super(numero);
        this.huespedReservado = huespedReservado;
    }

    @Override
    public void ocupar(String huesped) {
        if (!huespedReservado.equals(huesped)) {
            throw new IllegalStateException("La habitación está reservada para otro cliente.");
        }
        Hotel.cambiarEstado(numero, new HabitacionOcupada(numero, huesped));
    }

    public void reservar(String huesped) {
        throw new IllegalStateException("La habitación ya está reservada.");
    }

    public void liberar() {
        Hotel.cambiarEstado(numero, new HabitacionDisponible(numero));
    }

    public String getHuespedActual() {
        throw new IllegalStateException("La habitación está desocupada.");
    }


}
