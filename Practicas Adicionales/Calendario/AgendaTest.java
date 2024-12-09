package calendario;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgendaTest {
    @Test public void test01agendaVaciaNoTieneFeriados(){
        Agenda agenda = new Agenda();
        assertFalse(agenda.esFeriado(LocalDate.of(2024, 12, 25)));
    }
    @Test public void  test02AgregoFeriadoPuntual(){
        Agenda agenda = new Agenda();
        LocalDate añoNuevo = LocalDate.of(2025, 1,10);
        agenda.agregarFeriadoPuntual(añoNuevo);
        assertTrue(agenda.esFeriado(añoNuevo));

    }

    //test refactorizado
//    @Test public void test02AgendaConUnFeriadoPuntual() {
//        LocalDate navidad = LocalDate.of(2024, 12, 25);
//        assertTrue(new Agenda().agregarFeriadoPuntual(navidad).esFeriado(navidad));
//    }

    @Test public void test03agregarUnFeriadoSemanal(){
        Agenda agenda = new Agenda();
        DayOfWeek domingo =  DayOfWeek.SUNDAY;
        agenda.agregarFeriadoSemanal(domingo);
        assertTrue(agenda.esFeriado(LocalDate.of(2024, 12, 8)));
    }
    @Test void test04AgregarUnPeriodoFeriado(){
        Agenda agenda = new Agenda();
        agenda.agregarFeriadosEntre(LocalDate.of(2024, 9, 10), LocalDate.of(2024, 9, 15));
        assertTrue(agenda.esFeriado(LocalDate.of(2024, 9, 11)));

    }


}
