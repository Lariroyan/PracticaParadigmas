package cochera;

public class ReservaNominada extends Reserva {
    private int prioridad;
    protected String nombre;
    public ReservaNominada(String nombre, int prioridad){
        this.prioridad = prioridad;
        this.nombre = nombre;
    }

    public Reserva cerrar(){ return new ReservaCerrada(nombre);}
    @Override
    public int prioridad() {return prioridad;}
    public Reserva mejorDe( Reserva nueva ) {
        if ( prioridad > nueva.prioridad() ) {
            return this ;
        } else {
            return nueva;
        }
    }

}
