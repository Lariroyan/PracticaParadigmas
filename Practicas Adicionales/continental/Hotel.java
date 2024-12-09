package continental;

import java.util.HashMap;
import java.util.Map;

public class Hotel {

    private static Map<Integer, Habitacion> habitaciones;

    public Hotel () {
        this.habitaciones = new HashMap<>();
    }
    public void checkIn (String huesped, int numero ){
        Habitacion habitacion = getOrCreateHabitacion(numero);
        habitacion.ocupar(huesped);
    }

    public void checkOut(int numero) {
        Habitacion habitacion = getOrCreateHabitacion(numero);
        habitacion.liberar();
    }

    public void reservar(String huesped, int numero) {
        Habitacion habitacion = getOrCreateHabitacion(numero);
        habitacion.reservar(huesped);
    }

    private Habitacion getOrCreateHabitacion(int numero) {
        return habitaciones.computeIfAbsent(numero, HabitacionDisponible::new);
    }

    public String getHuesped(int numero) {
        return getOrCreateHabitacion(numero).getHuespedActual();
    }

    public static void cambiarEstado(int numero, Habitacion newHabitacion) {
        habitaciones.put(numero, newHabitacion);
    }


}
