package calendario;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FeriadoSemanal extends TipoFeriado{
    private DayOfWeek diaSemanal;
    public FeriadoSemanal(DayOfWeek dia) {
        this.diaSemanal = dia;
    }


    @Override
    public boolean esFeriado(LocalDate unaFecha) {
        return unaFecha.getDayOfWeek().equals(diaSemanal);
    }
}
