package estacionamiento;

public class InvitedCar extends ParkedCar{
    public static int InvitedFeeCar = 50;
    public static int InvitedFeePassenger = 60;

    public InvitedCar(Car car){
        super(car);
    }

    @Override
    public int fee() {
        return InvitedFeeCar +  InvitedFeePassenger*passengers();
    }
}
