package cajero;

import java.util.List;

public class ApuestaALaCentena extends Apuesta{
    public ApuestaALaCentena(String nombre, int numero, int monto) {
        super(nombre, numero, monto);
    }

    @Override
    public int calcularPremio(List<Integer> resultados) {
        return (resultados.get(0) % 1000) == (getNumero() % 1000) ? getMonto() *9:0;
    }
}
