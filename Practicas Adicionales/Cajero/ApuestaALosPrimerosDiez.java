package cajero;

import java.util.List;

public class ApuestaALosPrimerosDiez extends Apuesta{
    public ApuestaALosPrimerosDiez(String nombre, int numero, int monto) {
        super(nombre, numero, monto);
    }

    @Override
    public int calcularPremio(List<Integer> resultados) {
        return resultados.subList(0, 10).contains(getNumero()) ? getMonto()*10:0;
    }
}
