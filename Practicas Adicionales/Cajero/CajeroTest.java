package cajero;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CajeroTest {
    @Test void test01ElPozoEsCeroSiNoHayApuestas(){
        Quiniela quiniela = new Quiniela();
        assertEquals(0, quiniela.getPozo());
    }
    @Test void test02ApuestaUnNumeroALaCabeza(){
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaCabeza("Juan", 1234, 100);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertEquals(100, quiniela.getPozo());
        assertEquals(2000, quiniela.consultarPremio("Juan"));
    }
    @Test void tes03ApuestaALosPrimerosCinco(){
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaALosPrimerosCinco("Romi",  9012, 100);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertEquals(100, quiniela.getPozo());
        assertEquals(1400, quiniela.consultarPremio("Romi"));
    }
    @Test void test04ApuestaALosPrimerosDiez(){
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaLosPrimerosDiez("Carlos",  1212, 20);

        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890, 2345, 6789, 1010, 1212, 3434));
        assertEquals(20, quiniela.getPozo());
        assertEquals(200, quiniela.consultarPremio("Carlos"));
    }
    @Test void test05ApuestaALaCentena(){
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaALaCentena("Lucia", 234 , 100);

        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890)); // 5678 tiene centena 678
        assertEquals(900, quiniela.consultarPremio("Lucia"));

    }
    @Test void test06ApuestaALaDecena(){
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaALaDecena("Moni", 34, 10);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertEquals(20, quiniela.consultarPremio("Moni"));
    }
    @Test void test07ApuestasCombinadasALaDecenaYALaCabeza(){
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaALaDecena("Moni", 34, 10);
        quiniela.registrarApuestaCabeza("Juan", 1234, 100);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertEquals(110, quiniela.getPozo());
        assertEquals(20, quiniela.consultarPremio("Moni"));
        assertEquals(2000, quiniela.consultarPremio("Juan"));
    }

}
