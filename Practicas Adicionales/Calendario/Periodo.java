package calendario;

import java.time.LocalDate;

public class Periodo {
    private LocalDate start;
    private LocalDate end;
    public Periodo(LocalDate feriadoStart, LocalDate feriadoEnd) {
        start = feriadoStart;
        end = feriadoEnd;
    }

    public boolean esFeriado(LocalDate unaFecha) {
        return start.isBefore(unaFecha) && end.isAfter(unaFecha);
    }
}
