package booleans;

import java.util.Objects;

public abstract class Booleanos {


    private boolean value;

    public static Booleanos True() {
        return new Verdadero();
    }

    public static Booleanos False() { return new Falso();}



    @Override
    public boolean equals(Object o) {
        return this == o || o == null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass().hashCode());
    }

    public abstract Booleanos yy(Booleanos aBoolean);

    public abstract Booleanos oo(Booleanos aBoolean);

    public abstract Booleanos not();


}
 class Verdadero extends Booleanos{

     public Booleanos yy(Booleanos aBoolean) {     return aBoolean;    }
     public Booleanos oo(Booleanos aBoolean) {     return True();      }
     public Booleanos not() {                      return False();     }


}
class Falso extends Booleanos{

    public Booleanos yy(Booleanos aBoolean) {     return this;         }
    public Booleanos oo(Booleanos aBoolean) {     return aBoolean;     }
    public Booleanos not() {                      return True();       }


}
