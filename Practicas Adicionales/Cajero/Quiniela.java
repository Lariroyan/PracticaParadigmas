package cajero;
import java.util.ArrayList;
import java.util.List;

public class Quiniela {
    private List<Apuesta> apuestas;
    private List<Integer> resultados;
    private boolean apuestasCerradas;

    public Quiniela() {
        this.apuestas = new ArrayList<>();
        this.apuestasCerradas = false;
    }

    public void registarApuesta(String nombre, String tipo, int monto, int numero) {
        if (apuestasCerradas) {
            throw new IllegalStateException("No se pueden registrar apuestas después de cerrar.");
        }
        // Aquí asumo que el número se genera o recibe externamente

        apuestas.add(new Apuesta(nombre, tipo, numero, monto));
    }

    public void cerrarApuesta(List<Integer> resultados) {
        if (apuestasCerradas) {
            throw new IllegalStateException("Las apuestas ya están cerradas.");
        }
        this.resultados = resultados;
        this.apuestasCerradas = true;
    }

    public int getPozo() {
        return apuestas.stream().mapToInt(Apuesta::getMonto).sum();
    }

    public int consultarPremio(String nombre) {
        if (!apuestasCerradas) {
            throw new IllegalStateException("No se pueden consultar premios antes de cerrar las apuestas.");
        }

        return apuestas.stream()
                .filter(apuesta -> apuesta.getNombre().equals(nombre))
                .mapToInt(apuesta -> apuesta.calcularPremio(resultados))
                .sum();
    }
}
