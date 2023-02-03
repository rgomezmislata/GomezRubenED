package ud5.examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

 @Nested
 @DisplayName("Drive Tests")
 class Drive{
   private Car car;

   @BeforeEach
   void setup(){

       car = new Car("0000 BBB",0);
   }
@DisplayName("Test con parametros")
    @Test
     void testDrive() {
       car.accelerate(100);
car.drive(3600);
       assertEquals(100,car.getKilometers(),"Metodo drive con parametro segundos");
    }
@DisplayName("Test sin Parametros")
    @Test
    void testDrive60() {
       car.accelerate(100);
       car.drive();
        assertEquals(1.66666666,car.getKilometers(),0.2,"Este es el metodo sin parametro");
    }
 }
}