package cochera;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
public class CocheraTest {
    LocalDate hoy = LocalDate.of(2024, 12, 10 );
    LocalDate mañana= LocalDate.of(2024, 12, 11 );
    @Test void test01PrimeraReservaPorReunion(){
        Cochera cochera = new Cochera();
        cochera.reservaPorReunion("Carla",  hoy );
        cochera.cerrarFecha(hoy);
        assertEquals("Carla", cochera.consultar(hoy));
    }

    @Test void test02ReservaUnaFcehaPorClase(){
        Cochera cochera = new Cochera();
        cochera.reservaPorClase("Ramon", hoy);
        cochera.cerrarFecha(hoy);
        assertEquals("Ramon", cochera.consultar(hoy));

    }

    @Test void test03ReservaFechaPorUsoPersonal(){
        Cochera cochera = new Cochera();
        cochera.reservaPorUsoPersonal("Roxana", hoy);
        cochera.cerrarFecha(hoy);
        assertEquals("Roxana", cochera.consultar(hoy));
    }

    @Test void test04ReservoUnaFechaPorReunionYPersonal(){
        Cochera cochera = new Cochera();
        cochera.reservaPorUsoPersonal("Roxana", hoy);
        cochera.reservaPorReunion("Carla",  hoy );
        cochera.cerrarFecha(hoy);
        assertEquals("Carla", cochera.consultar(hoy));

    }

    @Test void test05ReservoUnaFechaPorReunionyReunion(){
        Cochera cochera = new Cochera();
        cochera.reservaPorReunion("Carla",  hoy );
        cochera.reservaPorReunion("Mora",  hoy );
        cochera.cerrarFecha(hoy);
        assertEquals("Carla", cochera.consultar(hoy));
    }

    @Test void test06ReservaDosFechasPorPersonalYReunion(){
        Cochera cochera = new Cochera();
        cochera.reservaPorReunion("Carla",  hoy );
        cochera.reservaPorUsoPersonal("Majo", mañana);
        cochera.cerrarFecha(hoy);
        assertEquals("Carla", cochera.consultar(hoy));
        cochera.cerrarFecha(mañana);
        assertEquals("Majo", cochera.consultar(mañana));

    }

    @Test void test07ReservoUnaFechaSinCerrar(){
        Cochera cochera = new Cochera();
        cochera.reservaPorReunion( "Bob", hoy);
        assertThrows( Error.class, () -> cochera.consultar( hoy) );
    }

    @Test void test08CierroSinReservar(){
        Cochera cochera = new Cochera();
        cochera.cerrarFecha(hoy);
        assertThrows( Error.class, () -> cochera.consultar( hoy ) );

    }

    @Test void test09ReservoDespuesDeCerrar(){
        Cochera cochera = new Cochera();
        cochera.cerrarFecha(hoy);
        assertThrows( Error.class, () -> cochera.reservaPorReunion( "Bob", hoy ) );

    }

}
