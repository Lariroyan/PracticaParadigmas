package cochera;

public class ReservaCerrada extends Reserva {
    protected String ganador;
    public ReservaCerrada(String nombre) { ganador = nombre;}
    public String consultar() {               return ganador;               }

    }

