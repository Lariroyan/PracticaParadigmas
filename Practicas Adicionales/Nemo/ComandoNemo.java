package nemo;

public abstract class ComandoNemo {
    protected char comando;

    public abstract boolean buscarComando(char c);
    public abstract void ejecutar(Nemo nemo);

}