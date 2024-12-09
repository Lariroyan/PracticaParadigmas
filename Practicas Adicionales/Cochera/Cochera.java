package cochera;
import java.time.LocalDate;
import java.util.*;
public class Cochera {
    private Map<LocalDate, Reserva> reservas = new HashMap<>();

    private void decidir( LocalDate bookingDate, Reserva booking ) {
        reservas.put( bookingDate, reservaEn( bookingDate ).mejorDe( booking ) );
    }

    private Reserva reservaEn(LocalDate bookingDate) {
        return reservas.getOrDefault( bookingDate, new ReservaAbierta() );
    }

    public void reservaPorReunion(String empleado, LocalDate diaReservado) {
        decidir(diaReservado, new ReservaNominada(empleado, 1));
    }
    public void reservaPorClase(String empleado, LocalDate diaReservado) {
        decidir(diaReservado, new ReservaNominada(empleado, 2));
    }

    public void reservaPorUsoPersonal(String empleado, LocalDate diaReservado) {
        decidir(diaReservado, new ReservaNominada(empleado, 3));
    }

    public String consultar(LocalDate fecha) {
       return reservaEn(fecha).consultar();
    }


    public void cerrarFecha(LocalDate fecha) {
        reservas.put( fecha, reservaEn( fecha ).cerrar() );
    }



}

