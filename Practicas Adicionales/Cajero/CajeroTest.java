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
        quiniela.registarApuesta("Romi", "a los primeros cinco", 30, 4500);
        assertEquals(30, quiniela.getPozo());
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));

    }

}
