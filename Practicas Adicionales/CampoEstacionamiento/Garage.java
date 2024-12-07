package estacionamiento;

public class Garage {
    private int totalGuests = 0;
    public int futureFees;

    public int futureFees() {
        return futureFees;
    }

    public void parkMemberCar(Car car) {
        totalGuests += car.getPassengers();
        futureFees += 100;
        
    }

    public int guests() {
        return totalGuests;
    }


    public void unpark(Car car) {
        totalGuests -= car.getPassengers();
    }

    public void parkVisitorCar(Car car) {
        totalGuests += car.getPassengers();
        futureFees += 50 + (car.getPassengers() * 60);

    }

    public void parkInvitedCar(Car car) {
        totalGuests += car.getPassengers();
        futureFees += 150;
    }
}
