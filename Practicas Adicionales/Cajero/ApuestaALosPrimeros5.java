package cajero;

import java.util.List;

public class ApuestaALosPrimeros5 extends Apuesta{
    public ApuestaALosPrimeros5(String nombre, int numero, int monto) {
        super(nombre, numero, monto);
    }

    @Override
    public int calcularPremio(List<Integer> resultados) {
        return resultados.subList(0, 5).contains(getNumero()) ? getMonto() * 14 : 0;
    }
}
