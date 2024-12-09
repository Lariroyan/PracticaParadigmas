package nemo;

public class ComandoGirarDerecha extends ComandoNemo {

   
    public ComandoGirarDerecha() {
        this.comando = 'r';
    }

    @Override
    public boolean buscarComando(char c) {
        return c == this.comando;
    }

    @Override
    public void ejecutar(Nemo nemo) {
        nemo.girarDerecha();
}
}