package cajero;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CajeroTest {

    public static final String JUAN = "Juan";
    public static final String ROMI = "Romi";
    public static final String CARLOS = "Carlos";
    public static final String LUCIA = "Lucia";
    public static final String MONI = "Moni";

    @Test void test01ElPozoEsCeroSiNoHayApuestas(){
        assertEquals(0, new Quiniela().getPozo());
    }
    @Test void test02ApuestaUnNumeroALaCabeza(){
        Quiniela quiniela = QuinielaConApuestaALaCabeza();
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertPozoAndPremio(100, quiniela, 2000, JUAN);
    }

    @Test void tes03ApuestaALosPrimerosCinco(){
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaALosPrimerosCinco(ROMI,  9012, 100);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertPozoAndPremio(100, quiniela, 1400, ROMI);
    }
    @Test void test04ApuestaALosPrimerosDiez(){
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaLosPrimerosDiez(CARLOS,  1212, 20);

        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890, 2345, 6789, 1010, 1212, 3434));
        assertPozoAndPremio(20, quiniela, 200, CARLOS);
    }
    @Test void test05ApuestaALaCentena(){
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaALaCentena(LUCIA, 234 , 100);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890)); // 5678 tiene centena 678
        assertPozoAndPremio(100, quiniela, 900, LUCIA);

    }
    @Test void test06ApuestaALaDecena(){
        Quiniela quiniela = QuinielaConApuestaALaDecena();
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertEquals(20, quiniela.consultarPremio(MONI));
    }
    @Test void test07ApuestasCombinadasALaDecenaYALaCabeza(){
        Quiniela quiniela = QuinielaConApuestaALaDecena();
        quiniela.registrarApuestaCabeza(JUAN, 1234, 100);
        quiniela.cerrarApuesta(Arrays.asList(1234, 5678, 9012, 3456, 7890));
        assertPozoAndPremio(110, quiniela, 20, MONI);
        assertEquals(2000, quiniela.consultarPremio(JUAN));
    }

    private static Quiniela QuinielaConApuestaALaDecena() {
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaALaDecena(MONI, 34, 10);
        return quiniela;
    }

    private static Quiniela QuinielaConApuestaALaCabeza() {
        Quiniela quiniela = new Quiniela();
        quiniela.registrarApuestaCabeza(JUAN, 1234, 100);
        return quiniela;
    }
    private static void assertPozoAndPremio(int monto, Quiniela quiniela, int premio, String nombre) {
        assertEquals(monto, quiniela.getPozo());
        assertEquals(premio, quiniela.consultarPremio(nombre));
    }

}
