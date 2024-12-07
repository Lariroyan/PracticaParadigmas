package estacionamiento;

public class MemberCar extends ParkedCar {
    private int MemberFee = 100;
    public MemberCar(Car car){
        super(car);
    }

    public int fee() {
        return MemberFee;
    }
}
