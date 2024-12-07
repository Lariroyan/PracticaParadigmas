package numeros;

public class Fraccion extends Numero{
    public Entero numerator;
    public Entero denominator;

    protected Fraccion( Entero aNumerator,Entero aDenominator ) {
        if (aNumerator.isZero()) {
            throw new IllegalArgumentException( "Una fraccion no puede ser cero" );
        }
        if (aDenominator.isOne()) {
            throw new IllegalArgumentException( "Una fraccion no puede tener denominador 1 porque sino es un entero" );
        }

        numerator = aNumerator;
        denominator = aDenominator;
    }
        public static Numero with(Entero aDividend, Entero aDivisor) {

        if (aDivisor.isZero()) {
            throw new IllegalArgumentException( CanNotDivideByZero );
        }

        if (aDividend.isZero()) {
            return with( 0 );
        }

        if (aDivisor.isNegative()) {
            return aDividend.negated().dividedBy(aDivisor.negated());
            //return with( -aDividend, -aDivisor );
        }

        int greatestCommonDivisor = Numero.greatestCommonDivisor( aDividend.value, aDivisor.value );
        Entero numerator = Entero.with(aDividend.value/greatestCommonDivisor); //aDividend / greatestCommonDivisor;
        Entero denominator = Entero.with(aDivisor.value/greatestCommonDivisor);//aDivisor / greatestCommonDivisor;

        if (denominator.isOne()) {
            return numerator ;
        }

        return new Fraccion( numerator, denominator );
    }



    public Numero dividedBy( Numero aDivisor ) { return aDivisor.divideMeAsFraccion(this);

//        if (aDivisor.type == Entero){
//            return Numero.with(numerator, denominator* aDivisor.value);
//        }
//        if (aDivisor.type == Fraccion){
//            return Numero.with( numerator* aDivisor.denominator, denominator* aDivisor.numerator );
//
//        }
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }
    public Numero multipliedBy( Numero aMultiplier ) {
        return aMultiplier.multiplyMeAsFraction(this);

    }

    public  Numero substractedBy( Numero aSubstrahend ){ return aSubstrahend.subtractMeAsFraccion(this);
//        if( aSubstrahend.type == Fraccion){
//            return with(numerator * aSubstrahend.denominator - denominator* aSubstrahend.numerator, denominator*aSubstrahend.denominator);
//
//        }
//        if ( aSubstrahend.type == Entero){
//            return with(numerator - denominator*aSubstrahend.value, denominator);
//        }
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }
    public  boolean isZero(){
        return false;

    }
    public  boolean isOne(){
        return false;
    }
    public  boolean isNegative(){
        return denominator.value < 0 ;
    }

    public  Numero negated(){
        return new Fraccion( numerator * -1, denominator );
    }

    public  String toString(){
        return "" + numerator + "/" + denominator;
    }


    public Numero addedTo( Numero anAdder ) { return anAdder.addMeAsFraccion(this);


//        if ( anAdder.type == Fraccion) {
//            int newNumerator = ( numerator * anAdder.denominator ) + ( denominator * anAdder.numerator );
//            int newDenominator = denominator * anAdder.denominator;
//            return with( newNumerator, newDenominator );
//        }
//        if ( anAdder.type == Entero) {
//            return new Fraccion(anAdder.value * denominator + numerator, denominator);
//        }
//
//        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public Numero multiplyMeAsFraction(Fraccion fraccion) {
        return fraccion.numerator.multipliedBy(numerator).dividedBy(fraccion.denominator.multipliedBy(denominator));
     //   return numeros.Fraccion.with(fraccion.numerator * this.numerator,
       //             fraccion.denominator * this.denominator);
    }
    public Numero multiplyMeAsEntero(Entero entero) {
        return numerator.multipliedBy(this).dividedBy(denominator);

        //return Numero.with(entero.value * numerator, denominator);
    }

    
    public Numero addMeAsEntero(Entero firstAdder) {
        return  firstAdder.multipliedBy(denominator).addedTo(numerator).dividedBy(denominator);
        //return new Fraccion( firstAdder.value * denominator + numerator , firstAdder.value * denominator);
    }

    
    public Numero divideMeAsEntero(Entero aDividend) {
        return aDividend.multipliedBy(denominator).dividedBy(numerator);
       // return Numero.with(aDividend.value * denominator, numerator);
    }

    
    public Numero substractMeAsEntero(numeros.Entero aSubstrahend) {
        return aSubstrahend.multipliedBy(denominator).substractedBy(numerator).dividedBy(denominator);
       // return with( aSubstrahend.value* denominator - numerator, denominator);
    }

    
    public Numero divideMeAsFraccion(numeros.Fraccion aDividend) {
        return aDividend.numerator.multipliedBy(denominator)
                .dividedBy(aDividend.denominator.multipliedBy(numerator));
       // return Numero.with( aDividend.numerator* denominator, aDividend.denominator* numerator );
    }

    
    public Numero subtractMeAsFraccion(numeros.Fraccion aMinuend) {
        return aMinuend.numerator.multipliedBy(denominator)
                .substractedBy(aMinuend.denominator.multipliedBy(numerator))
                .dividedBy(aMinuend.denominator.multipliedBy(denominator));
      //  return with(aMinuend.numerator * denominator - aMinuend.denominator* numerator, aMinuend.denominator*denominator);
    }

    
    public Numero addMeAsFraccion(Fraccion firstAdder) {
        return firstAdder.numerator.multipliedBy(denominator)
                .addedTo(firstAdder.denominator.multipliedBy(numerator))
                .dividedBy(firstAdder.denominator.multipliedBy(denominator));
//        int newNumerator = ( firstAdder.numerator * denominator ) + ( firstAdder.denominator * numerator );
//        int newDenominator = firstAdder.denominator * denominator;
//        return with( newNumerator, newDenominator );

    }

    public int hashCode(){
        return Double.hashCode( (double) numerator / (double) denominator );

    }
    public  Numero greatestCommonDivisorWith( int anEntero ){
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }
    public boolean equals( Object anObject ){
        return Fraccion.class.isInstance(anObject) && numerator.multipliedBy(Fraccion.class.cast(anObject).denominator)
                .equals(denominator.multipliedBy(Fraccion.class.cast(anObject).numerator));
                //numerator * Fraccion.class.cast(anObject).denominator() == denominator * Fraccion.class.cast(anObject).numerator();
    }

    public int denominator() {  return denominator; }
    public int numerator() {    return numerator;   }
}
