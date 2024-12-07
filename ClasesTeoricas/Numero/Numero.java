package numeros;

public abstract class Numero {
    static public String CanNotDivideByZero = "No se puede dividir por cero!!!!!!";


    public static Numero with(int aValue){
        return new Entero( aValue );
    }

        public static Numero with( Entero aDividend, Entero aDivisor ) {
        if (aDivisor.isZero()) {
            throw new IllegalArgumentException( CanNotDivideByZero );
        }

        if (aDividend.isZero()) {
            return with( 0 );
        }

        if (aDivisor.isNegative()) {
            return aDividend.negated().dividedBy(aDivisor.negated());
        }

        int greatestCommonDivisor = Numero.greatestCommonDivisor( aDividend.value, aDivisor.value );
        Entero numerator =  Entero.with( aDividend.value / greatestCommonDivisor);
        Entero denominator = Entero.with( aDivisor.value / greatestCommonDivisor);

        if (denominator.isOne()) {
            return with( numerator.value );
        }

        return new Fraccion( numerator, denominator );
    }

    protected Numero() {}
//    protected Numero( int aValue ) {
//        type = Entero;
//        value = aValue;
//    }
//    protected Numero( int aNumerator, int aDenominator ) {
//        if (aNumerator == 0) {
//            throw new IllegalArgumentException( "Una fraccion no puede ser cero" );
//        }
//        if (aDenominator == 1) {
//            throw new IllegalArgumentException( "Una fraccion no puede tener denominador 1 porque sino es un entero" );
//        }
//        type = Fraccion;
//        numerator = aNumerator;
//        denominator = aDenominator;
//    }

    public abstract Numero substractedBy( Numero aSubstrahend );

    public abstract Numero multipliedBy( Numero aMultiplier );
//    {
//        if (type == Entero && aMultiplier.type == Entero) {
//            return new Entero( value * aMultiplier.value );
//        }
//
//        if (type == Fraccion && aMultiplier.type == Fraccion) {
//            return numeros.Fraccion.with( numerator * aMultiplier.numerator,
//                                denominator * aMultiplier.denominator );
//        }
//        if (type == Entero && aMultiplier.type == Fraccion) {
//            return Numero.with(value* aMultiplier.numerator, aMultiplier.denominator);
//        }
//        if (type == Fraccion && aMultiplier.type == Entero) {
//            return Numero.with(aMultiplier.value * numerator, denominator);
//        }
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
//    }

    public abstract Numero addedTo( Numero anAdder );
//    {
//        if (type == Entero && anAdder.type == Entero) {
//            return new Entero( value + anAdder.value );
//        }
//        if (type == Entero && anAdder.type == Fraccion) {
//            return new Fraccion( value * anAdder.denominator + anAdder.numerator , value * anAdder.denominator);
//        }
//
//        if (type == Fraccion && anAdder.type == Fraccion) {
//            int newNumerator = ( numerator * anAdder.denominator ) + ( denominator * anAdder.numerator );
//            int newDenominator = denominator * anAdder.denominator;
//            return with( newNumerator, newDenominator );
//        }
//        if (type == Fraccion && anAdder.type == Entero) {
//            return new Fraccion(anAdder.value * denominator + numerator, denominator);
//        }
//
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
//    }

    public abstract Numero dividedBy( Numero aDivisor ) ;
//        if (type == Entero) {
//            return new Entero( value / aDivisor.value );
//        }
//        if (type == Fraccion){
//            return new Fraccion( numerator * aDivisor.denominator, denominator * aDivisor.numerator  );
//        }
//
//
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
//    }

    public abstract Numero greatestCommonDivisorWith( int anEntero );
//    {
//        if (type == Entero) {
//            return new Entero( greatestCommonDivisor( value, anEntero ) );
//        }
//
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
//    }

    public abstract Numero negated();
//    {
//        if (type == Entero) {
//            return new Entero( value * -1 );
//        }
//        if (type == Fraccion) {
//            return new Fraccion( numerator * -1, denominator );
//        }
//
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
//    }

    public abstract boolean isNegative();
//    {
//        if (type == Entero) {
//            return value < 0;
//        }
//        if (type == Fraccion) {
//            return denominator < 0;
//        }
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
//    }

     public abstract boolean isOne();
//        if (type == Entero) {
//            return value == 1;
//        }
//        if (type == Fraccion) {
//            return false;
//        }
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
//    }

    public abstract boolean isZero() ;
//        if (type == Entero) {
//            return value == 0;
//        }
//        if (type == Fraccion) {
//            return false;
//        }
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
//    }

    public abstract String toString();
//    {
//        if (type == Entero) {
//            return "" + value;
//        }
//        if (type == Fraccion) {
//            return "" + numerator + "/" + denominator;
//        }
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
//    }

    public abstract boolean equals( Object anObject );
//    {
//        if (Numero.class.isInstance( anObject )) {
//            Numero other = Numero.class.cast( anObject );
//            if (type == other.type) {
//                if (type == Entero) {
//                    return value == other.value();
//                } else if (type == Fraccion) {
//                    return numerator * other.denominator() == denominator * other.numerator();
//                }
//            }
//        }
//        return false;
//    }

    public abstract int hashCode();
//    {
//        if (type == Entero) {
//            return Integer.hashCode( value );
//        }
//        if (type == Fraccion) {
//            return Double.hashCode( (double) numerator / (double) denominator );
//        }
//        return 0;
//    }

    // accessors


    public static int greatestCommonDivisor( int a, int b ) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public abstract Numero multiplyMeAsFraction(Fraccion fraccion);
//    {
//        if (this.type == Fraccion) {
//            return numeros.Fraccion.with(fraccion.numerator * this.numerator,
//                    fraccion.denominator * this.denominator);
//        }
//
//        if (type == Entero) {
//            return Numero.with(value * fraccion.numerator, fraccion.denominator);
//        }
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
//    }
//

    //ENTERO

    public abstract Numero multiplyMeAsEntero(Entero entero);

    public abstract Numero addMeAsEntero(Entero anAdder) ;

    public abstract Numero divideMeAsEntero(Entero aDivisor) ;

    public abstract Numero substractMeAsEntero(Entero aSubstrahend);



//    {
//        if (type == Entero) {
//            return new Entero(entero.value * value);
//        }
//
//        if (type == Fraccion) {
//            return Numero.with(entero.value * numerator, denominator);
//
//        }
//        throw new UnsupportedOperationException("Tipo de número no soportado");
//    }
//    }

    //FRACCIÓN

    public abstract Numero divideMeAsFraccion(Fraccion aDividend);

    public abstract Numero subtractMeAsFraccion(Fraccion aMinuend);

    public abstract Numero addMeAsFraccion(Fraccion firstAdder);
}
