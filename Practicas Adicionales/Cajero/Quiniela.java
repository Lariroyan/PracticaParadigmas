package cajero;
import java.util.ArrayList;
import java.util.List;

public class Quiniela {
    private List<Apuesta> apuestas ;
    private List<Integer> resultados;
    private boolean apuestasCerradas;

    public Quiniela() {
        this.apuestas = new ArrayList<>();
        this.apuestasCerradas = false;
    }

    public void registrarApuestaCabeza(String nombre, int numero, int monto) {
        apuestas.add(new ApuestaALaCabeza(nombre, numero,monto));
    }
    public void registrarApuestaALosPrimerosCinco(String nombre, int numero, int monto) {
        apuestas.add(new ApuestaALosPrimeros5(nombre, numero,monto));
    }
    public void registrarApuestaLosPrimerosDiez(String nombre, int numero, int monto) {
        apuestas.add(new ApuestaALosPrimerosDiez(nombre, numero,monto));
    }
    public void registrarApuestaALaCentena(String nombre, int numero, int monto) {
        apuestas.add(new ApuestaALaCentena(nombre, numero,monto));
    }
    public void registrarApuestaALaDecena(String nombre, int numero, int monto) {
        apuestas.add(new ApuestaALaDecena(nombre, numero,monto));
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