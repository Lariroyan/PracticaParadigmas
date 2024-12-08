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
        quiniela.registarApuesta("Juan", "a la cabeza", 100, 1234);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertEquals(100, quiniela.getPozo());
        assertEquals(2000, quiniela.consultarPremio("Juan"));
    }
    @Test void tes03ApuestaALosPrimerosCinco(){
        Quiniela quiniela = new Quiniela();
        quiniela.registarApuesta("Romi", "a los primeros 5", 100, 9012);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertEquals(100, quiniela.getPozo());
        assertEquals(1400, quiniela.consultarPremio("Romi"));
    }
    @Test void test04ApuestaALosPrimerosDiez(){
        Quiniela quiniela = new Quiniela();
        quiniela.registarApuesta("Carlos", "a los primeros 10", 20, 1212);

        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890, 2345, 6789, 1010, 1212, 3434));
        assertEquals(20, quiniela.getPozo());
        assertEquals(200, quiniela.consultarPremio("Carlos"));
    }
    @Test void test05ApuestaALaCentena(){
        Quiniela quiniela = new Quiniela();
        quiniela.registarApuesta("Lucia", "a la centena", 100, 234);

        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890)); // 5678 tiene centena 678
        assertEquals(900, quiniela.consultarPremio("Lucia"));

    }
    @Test void test06ApuestaALaDecena(){
        Quiniela quiniela = new Quiniela();
        quiniela.registarApuesta("Moni", "a la decena", 10, 34);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertEquals(20, quiniela.consultarPremio("Moni"));
    }
    @Test void test07ApuestasCombinadasALaCentenaYALaCabeza(){
        Quiniela quiniela = new Quiniela();
        quiniela.registarApuesta("Moni", "a la decena", 10, 34);
        quiniela.registarApuesta("Juan", "a la cabeza", 100, 1234);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertEquals(20, quiniela.consultarPremio("Moni"));
        assertEquals(2000, quiniela.consultarPremio("Juan"));
    }

}
