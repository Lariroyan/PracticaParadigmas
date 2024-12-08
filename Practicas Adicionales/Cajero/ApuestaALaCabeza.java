package cajero;

import java.util.List;

public class ApuestaALaCabeza extends Apuesta{
    public ApuestaALaCabeza(String nombre, int numero, int monto) {
        super(nombre, numero, monto);
    }

    @Override
    public int calcularPremio(List<Integer> resultados) {
        return resultados.get(0) == getNumero() ? getMonto() * 20 : 0;
    }

}
