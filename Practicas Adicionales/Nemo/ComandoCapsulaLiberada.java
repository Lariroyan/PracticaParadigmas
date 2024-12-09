package nemo;

public class ComandoCapsulaLiberada extends ComandoNemo{

    public ComandoCapsulaLiberada() {
        this.comando = 'm';
    }

    @Override
    public boolean buscarComando(char c) {
        return c == this.comando;
    }

    @Override
    public void ejecutar(Nemo nemo) {
        nemo.liberarCapsula();

    
}
}
