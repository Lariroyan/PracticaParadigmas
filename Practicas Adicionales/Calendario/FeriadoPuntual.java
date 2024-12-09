package calendario;

import java.time.LocalDate;

public class FeriadoPuntual extends TipoFeriado {
    private LocalDate feriado;

    public FeriadoPuntual(LocalDate feriado){
        this.feriado=feriado;
    }

    @Override
    public boolean esFeriado(LocalDate unaFecha) {
        return this.feriado.equals(unaFecha);
    }
}
