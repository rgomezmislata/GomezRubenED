package ud6.exam;

import org.junit.jupiter.api.BeforeEach;
import ud5.practices.bank.BankAccount;

import static org.junit.jupiter.api.Assertions.*;

class LampTest {


    private Lamp lamp;
    @BeforeEach
    void setUp() {
    lamp = new Lamp(250);

    }
}