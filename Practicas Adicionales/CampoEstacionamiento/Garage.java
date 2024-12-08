package estacionamiento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {
    private List<ParkedCar> cars = new ArrayList();

    public Garage() {
    }

    public int futureFees() {
        return (Integer)this.cars.stream().reduce(0, (total, car) -> {
            return total + car.fee();
        }, Integer::sum);
    }

    public void parkMemberCar(Car car) {
        this.cars.add(new MemberCar(car));
    }

    public int guests() {
        return (Integer)this.cars.stream().reduce(0, (total, car) -> {
            return total + car.passengers();
        }, Integer::sum);
    }

    public void unpark(Car earlyCar) {
        this.cars.removeAll((Collection)this.cars.stream().filter((parked) -> {
            return parked.holds(earlyCar);
        }).collect(Collectors.toList()));
    }

    public void parkVisitorCar(Car car) {
        this.cars.add(new VisitorCar(car));
    }

    public void parkInvitedCar(Car car) {
        this.cars.add(new InvitedCar(car));
    }
}
