package estacionamiento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstacionamientoTest {
    @Test void test01NewParkingHasNoMoney(){
        assertEquals(0, new Garage().futureFees());
    }
    @Test void test02MemberCarParks(){
        Garage garage = new Garage();
        garage.parkMemberCar(new Car(2));
        assertEquals(2, garage.guests());
        assertEquals(100, garage.futureFees());


    }
    @Test void test03TwoMemberCarPark(){
        Garage garage = new Garage();
        garage.parkMemberCar(new Car(2));
        garage.parkMemberCar(new Car(3));
        assertEquals(5, garage.guests());
        assertEquals(200, garage.futureFees());
    }
    @Test  void test04ParkTwoMemberCarsAndThenOneLeave() {
        Garage garage = new Garage();
        Car earlyCar = new Car( 3 ) ;
        garage.parkMemberCar( earlyCar );
        garage.parkMemberCar( new Car( 4 ) );
        garage.unpark( earlyCar );

        assertEquals( 4, garage.guests() );

        assertEquals( 200, garage.futureFees() );
    }

    @Test void test05ParkVisitorCar(){
        Garage garage = new Garage();
        garage.parkVisitorCar(new Car(2) );
        assertEquals(2, garage.guests());
        assertEquals(50 + (2 * 60), garage.futureFees());

    }
    @Test public void test06ParkTwoInvitedCars() {
        Garage garage = new Garage();
        garage.parkVisitorCar(new Car(3));
        garage.parkVisitorCar(new Car(2));
        assertEquals(5, garage.guests());
        assertEquals(2*50 + 60*5, garage.futureFees());
    }

    @Test public void test07ParkOneInvitedCars() {
        Garage garage = new Garage();
        garage.parkInvitedCar( new Car( 3 ) );
        assertEquals(3, garage.guests());

        assertEquals( 150, garage.futureFees() );
    }
    @Test public void test08ParkTwoInvitedCars() {
        Garage garage = new Garage();
        garage.parkInvitedCar( new Car( 3 ) );
        garage.parkInvitedCar( new Car( 3 ) );
        assertEquals(6, garage.guests());

        assertEquals( 300, garage.futureFees() );
    }






}
