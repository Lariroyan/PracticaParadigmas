package cajero;

import java.util.List;

public class ApuestaALaDecena extends Apuesta{
    public ApuestaALaDecena(String nombre, int numero, int monto) {
        super(nombre, numero, monto);
    }

    @Override
    public int calcularPremio(List<Integer> resultados) {
        return (resultados.get(0) % 100) == (getNumero() % 100) ? getMonto()*2:0;
    }
}
