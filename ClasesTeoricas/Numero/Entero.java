package numeros;

public class Entero extends Numero{
    public int value;
    protected Entero( int aValue ) {

        value = aValue;
    }
    public static Entero with(int aValue ) {
        return new Entero( aValue );
    }

    public Numero dividedBy( Numero aDivisor ) { return aDivisor.divideMeAsEntero(this);
//        if(aDivisor.type == Entero){
//            return Numero.with( value , aDivisor.value );
//
//        }
//        if (aDivisor.type == Fraccion){
//            return Numero.with(value * aDivisor.denominator, aDivisor.numerator);
//        }
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );

    }
    public  Numero substractedBy( Numero aSubstrahend ){ return aSubstrahend.substractMeAsEntero(this);}
    public  boolean isZero(){
        return value == 0;

    }
    public  boolean isOne(){
        return value == 1;
    }
    public  boolean isNegative(){
        return value < 0;
    }
    public  Numero negated(){
        return new Entero( value * -1 );
    }
    public  String toString(){
        return "" + value;
    }

    public Numero multipliedBy( Numero aMultiplier ) {
        return aMultiplier.multiplyMeAsEntero(this);
//        if (aMultiplier.type == Entero) {
//            return new Entero(value * aMultiplier.value);
//        }
//
//        if (aMultiplier.type == Fraccion) {
//            return Numero.with(value * aMultiplier.numerator, aMultiplier.denominator);
//
//        }
//        throw new UnsupportedOperationException("Tipo de número no soportado");
    }
    public Numero multiplyMeAsEntero(Entero entero) {
        return new Entero(entero.value * value);

    }


    public Numero addMeAsEntero(Entero firstAdder) {
        return new Entero( value + firstAdder.value );
    }


    public Numero divideMeAsEntero(Entero aDivisor) {
        return Fraccion.with(aDivisor, this);
       // return Numero.with( aDivisor.value , value);
    }


    public Numero substractMeAsEntero(numeros.Entero aSubstrahend) {return new Entero(aSubstrahend.value - value);}
    public Numero divideMeAsFraccion(numeros.Fraccion aDividend) {

         return aDividend.numerator.dividedBy(aDividend.denominator.multipliedBy(this));
    }
        //return Numero.with(aDividend.numerator, aDividend.denominator* value);}
    public Numero subtractMeAsFraccion(numeros.Fraccion aMinuend) {
        return aMinuend.numerator.substractedBy(aMinuend.denominator.multipliedBy(this)).dividedBy(aMinuend.denominator);

       // return with(aMinuend.numerator - aMinuend.denominator*value, aMinuend.denominator);
    }
    public Numero addMeAsFraccion(numeros.Fraccion firstAdder) {
        return firstAdder.numerator.addedTo(firstAdder.denominator.multipliedBy(this)).dividedBy(firstAdder.denominator);
        //return new Fraccion(value * firstAdder.denominator + firstAdder.numerator, firstAdder.denominator);
    }
    public int hashCode(){return Integer.hashCode( value );}
    public Numero addedTo( Numero anAdder ) {
        return anAdder.addMeAsEntero(this);
//        if (type == Entero && anAdder.type == Entero) {
//            return new Entero( value + anAdder.value );
//        }
//        if (type == Entero && anAdder.type == Fraccion) {
//            return new Fraccion( value * anAdder.denominator + anAdder.numerator , value * anAdder.denominator);
//        }
//
//
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public Numero multiplyMeAsFraction(Fraccion fraccion) {
        return fraccion.numerator.multipliedBy(this).dividedBy(fraccion.denominator);
    }

        //return Numero.with(value * fraccion.numerator, fraccion.denominator);

    public Numero greatestCommonDivisorWith ( int anEntero ){return new Entero( greatestCommonDivisor( value, anEntero ) );}
    public boolean equals( Object anObject ){
      return Entero.class.isInstance(anObject) && value == Entero.class.cast(anObject).value;

    }
    public int value() {        return value;       }


}
