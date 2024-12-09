package continental;

public abstract class Habitacion {
//    private String huespedActual;
//    private String reserva;
    protected final int numero;


    public Habitacion(int numero) {
        this.numero = numero;
    }
    public abstract String getHuespedActual();
    public abstract void ocupar(String huesped);

    public abstract void reservar(String huesped);

    public abstract void liberar();
}

