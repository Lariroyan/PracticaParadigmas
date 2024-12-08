package calendario;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgendaTest {
    @Test public void test01agendaVaciaNoTieneFeriados(){
        assertFalse(new Agenda().esFeriado(LocalDate.of(2024, 12, 25)));
    }
    @Test public void test02AgendaConUnFeriadoPuntual() {
        LocalDate navidad = LocalDate.of(2024, 12, 25);
        assertTrue(new Agenda().agregarFeriadoPuntual(navidad).esFeriado(navidad));
    }
    @Test public  void test03AgendaConUnFeriadoSemanal(){
        assertTrue(new Agenda().agregarFeriadoSemanal(DayOfWeek.FRIDAY).esFeriado(LocalDate.of(2024, 9, 20)));
    }
    @Test public void test04gendaConUnPeriodoFeriado(){
        assertTrue(new Agenda().agregarFeriadosEntre(LocalDate.of(2024, 9, 10), LocalDate.of(2024, 9, 15)).esFeriado(LocalDate.of(2024, 9, 20)));


    }


}
