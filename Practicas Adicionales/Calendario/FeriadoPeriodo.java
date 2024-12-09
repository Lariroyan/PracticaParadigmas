package calendario;

import java.time.LocalDate;

public class FeriadoPeriodo extends TipoFeriado{
    private LocalDate inicio;
    private LocalDate fin;

    public FeriadoPeriodo(LocalDate inicio, LocalDate fin){
        this.inicio = inicio;
        this.fin = fin;
    }
    @Override
    public boolean esFeriado(LocalDate unaFecha) {
        return (unaFecha.isEqual(inicio) || unaFecha.isEqual(fin) || (unaFecha.isAfter(inicio) && unaFecha.isBefore(fin)));
    }
}
