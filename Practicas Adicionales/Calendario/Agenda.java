package calendario;



import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Agenda {

    private List<TipoFeriado> feriados = new ArrayList<>();

    public boolean esFeriado(LocalDate unFeriado) {
        return feriados.stream().anyMatch(feriado -> feriado.esFeriado(unFeriado));

    }

    public Agenda agregarFeriadoPuntual(LocalDate aFeriado) {
       feriados.add(new FeriadoPuntual(aFeriado));
       return this;
    }

    public Agenda agregarFeriadoSemanal(DayOfWeek diaFeriado) {
       feriados.add(new FeriadoSemanal(diaFeriado));
        return this;
    }

    public Agenda agregarFeriadosEntre(LocalDate startFeriado, LocalDate endOfFeriado) {
        feriados.add(new FeriadoPeriodo(startFeriado, endOfFeriado));
        return this;
    }
}
