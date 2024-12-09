package cochera;

public class Reserva {
    public Reserva() {}
    public Reserva cerrar() {                 throw new Error();          }
    public String consultar() {               throw new Error();          }
    public int prioridad() {                  return 0;                   }
    public Reserva mejorDe( Reserva turno ) { throw new Error();          }
}
