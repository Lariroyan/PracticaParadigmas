package cajero;
import java.util.List;

public class Apuesta {
    private String nombre;
    private String tipo;
    private int numero;
    private int monto;

    public Apuesta(String nombre, String tipo, int numero, int monto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.numero = numero;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public int calcularPremio(List<Integer> resultados) {
        int premio = 0;

        if ("a la cabeza".equals(tipo) && resultados.get(0) == numero) {
            premio = monto * 20;
        } else if ("a los primeros 5".equals(tipo) && resultados.subList(0, 5).contains(numero)) {
            premio = monto * 14;
        } else if ("a los primeros 10".equals(tipo) && resultados.subList(0, 10).contains(numero)) {
            premio = monto * 10;
        } else if ("a la centena".equals(tipo) && (resultados.get(0) % 1000) == (numero % 1000)) {
            premio = monto * 9;
        } else if ("a la decena".equals(tipo) && (resultados.get(0) % 100) == (numero % 100)) {
            premio = monto * 2;
        }

        return premio;
    }

    public int getMonto() {
        return monto;
    }
}
