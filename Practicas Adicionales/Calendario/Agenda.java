package calendario;

import java.time.*;
import java.util.*;

public class Agenda {
    private List<LocalDate> feriados = new ArrayList<>();
    private List<DayOfWeek> dias = new ArrayList<>();
    private List<Periodo> periodos = new ArrayList<>();


    public boolean esFeriado(LocalDate unFeriado) {
        if ( dias.contains(unFeriado.getDayOfWeek())){
            return true;
        } else if(feriados.contains(unFeriado)){
            return true;
        }else if(periodos.stream().anyMatch(each -> each.esFeriado(unFeriado))){
            return true;
        }else{
            return false;
        }
    }

    public Agenda agregarFeriadoPuntual(LocalDate unFeriado) {
        feriados.add(unFeriado);
        return this;
    }

    public Agenda agregarFeriadoSemanal(DayOfWeek dayOfWeek) {
        dias.add(dayOfWeek);
        return this;
    }

    public Agenda agregarFeriadosEntre(LocalDate feriadoStart, LocalDate feriadoEnd) {
        periodos.add(new Periodo(feriadoStart, feriadoEnd));
        return this;

    }
}
