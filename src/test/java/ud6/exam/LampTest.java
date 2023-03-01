package ud6.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

class LampTest {


    private Lamp lamp;
    private Lamp lamp2;
    private Lamp lamp3;
    private Lamp lamp4;
    @BeforeEach
    void setUp() {
    lamp = new Lamp(120);
        lamp2 = new Lamp(60);
        lamp3 = new Lamp(240);
        lamp4 = new Lamp(100);

    }

    @Nested
    public class provesEstatLampara{
        @Test
        @DisplayName("Comprueba si la lampara se enciende")
        void turnOnTest() {
           lamp.turnOn();
           assertTrue(lamp.isOn(),"La Lampara no esta encendida");
            lamp.turnOn();
            assertTrue(lamp.isOn(),"La Lampara no se mantiene encendida");

        }

        @Test
        @DisplayName("Comprueba si la lampara se apaga")
        void turnOffTest() {
            lamp.turnOn();
            lamp.turnOff();
            assertFalse(lamp.isOn(),"La Lampara esta encendida");
            lamp.turnOff();
            assertFalse(lamp.isOn(),"La Lampara no se mantiene apagada");
        }

        @Test
        @DisplayName("Comprueba si la lampara se enciende apagada")
        void toggleTest() {
            lamp.toggle();
            assertTrue(lamp.isOn(),"La Lampara no cambia de estado,no se enciende");
            lamp.toggle();
            assertFalse(lamp.isOn(),"La Lampara esta encendida, no se apaga");
        }


    }

    @ParameterizedTest
    @ValueSource(doubles = {7200, 60, 6, 8, 10})
    @DisplayName("Prueba del consumo ")
    public void computeConsumption(double seconds) {
        lamp.toggle();
        lamp2.toggle();
        lamp3.toggle();
        lamp4.toggle();

        assertEquals(240.0,lamp.computeConsumption(seconds),0.1);
        assertEquals(2.0, lamp2.computeConsumption(seconds),0.1);
        assertEquals(240.0, lamp3.computeConsumption(seconds),0.1);
        assertEquals(240.0, lamp4.computeConsumption(seconds),0.1);
    }

}