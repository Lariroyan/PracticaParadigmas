package continental;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ContinentalTest {
    private Hotel hotel;

    @BeforeEach
    void setUp() {
        hotel = new Hotel();
    }

    @Test void test00checkInAHabitaionDisponible (){
        hotel.checkIn("Rocio", 24);
        assertEquals("Rocio", hotel.getHuesped(24));
    }

    @Test void test01ReservarHabitacion(){
        hotel.reservar("Rocio", 24);
        hotel.checkIn("Rocio", 24);
        assertEquals("Rocio", hotel.getHuesped(24));
    }

    @Test void test02SoloReservarSinCheckIn (){
        hotel.reservar("Rocio", 24);
        assertThrowsLike("La habitación está desocupada.", () -> hotel.getHuesped(24));
        assertThrowsLike("La habitación está reservada para otro cliente.", () -> hotel.checkIn("Juan", 24));

    }

    @Test void test03CheckOutHabitacion(){
        hotel.checkIn("Mila", 27);
        hotel.checkOut(27);
        assertThrowsLike("La habitación está desocupada.",
                () -> hotel.getHuesped(27));
    }

    @Test void test04CheckOutHabitacionNoOcupada(){
        assertThrowsLike("La habitación ya está desocupada.",
                ()-> hotel.checkOut(27));
    }

    @Test void test05ReasignacionHabitacionLiberada(){
        hotel.checkIn("Mila", 27);
        hotel.checkOut(27);
        hotel.reservar("Juan", 27);
        hotel.checkIn("Juan", 27);
        assertEquals("Juan", hotel.getHuesped(27));
    }
    @Test public void test06heckOutYVerificarHabitacionDesocupada() {
        hotel.reservar("Rocio", 24);
        hotel.checkIn("Rocio", 24);
        hotel.checkOut(24);
        assertThrowsLike("La habitación está desocupada.", () -> hotel.getHuesped(24));
    }

    private static void assertThrowsLike(String expectedMessage, Executable executable) {
        assertEquals(expectedMessage,
                assertThrows(Exception.class, executable)
                        .getMessage());
    }




}
