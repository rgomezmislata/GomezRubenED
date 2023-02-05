package ud5.practices.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount;
    private BankAccount bankAccount1;
    @BeforeEach
    void setup() {
        bankAccount = new BankAccount("1234", "Pomma", 1000);
        bankAccount1 = new BankAccount("123", "Maduixa");
    }

    @Nested
class BankAccountConstructors{

    @Test
    @DisplayName("Comprova el constructor de la classe BankAccount amb parámetre Balance")
    void bankConstructorBalance10Test() {
        assertAll(
                () -> assertEquals("1234",bankAccount.getAccountNumber(),"El numero del compte no coincideix "),
                () -> assertEquals("Pomma", bankAccount.getAccountHolderName(),"El nom del compte no coincideix"),
                () -> assertEquals(1000, bankAccount.getBalance(),"El balanç no coincideix")
        );
    }
        @Test
        @DisplayName("Comprova el constructor de la classe BankAccount sense parámetre Balance")
        void bankConstructorTest() {
            assertAll(
                    () -> assertEquals("123",bankAccount1.getAccountNumber(),"El numero del compte no coincideix "),
                    () -> assertEquals("Maduixa", bankAccount1.getAccountHolderName(),"El nom del compte no coincideix"),
                    () -> assertEquals(0, bankAccount1.getBalance(),"El balanç no coincideix")
            );
        }
}
@Nested
class dipositTests{
    @Test
    @DisplayName("Ingrés de 100€")
    void deposit100Test(){
        boolean hasDeposited = bankAccount.deposit(100);
        Transaction lastTransaction = bankAccount.getLastTransaction();
        assertAll(
                () -> assertTrue(hasDeposited,"No s'ha efectuat la transacció"),
                () -> assertNotNull(lastTransaction,"No es troba l'ultima transacció"),
                () -> assertEquals(1100, bankAccount.getBalance(),"El balanç actual no es el esperat"),
                () -> assertEquals(100, lastTransaction.getAmount(),"L'import de l'ultima transacció no es l'esperat"),
                () -> assertEquals(TransactionType.DEPOSIT, lastTransaction.getTransactionType(),"No coincideix el tipus de l'ultima transacció")
        );
    }

    @Test
    @DisplayName("Ingrés de 0€")
    void deposit0Test(){
        boolean hasDeposited = bankAccount.deposit(0);
        Transaction lastTransaction = bankAccount.getLastTransaction();
        assertAll(
                () -> assertFalse(hasDeposited,"S'ha efectuat la transacció d'una manera incorrecta"),
                () -> assertNotNull(lastTransaction,"No es troba l'ultima transacció"),
                () -> assertEquals(1000, bankAccount.getBalance(),"El balanç actual no es el esperat")
        );
    }

    @Test
    @DisplayName("Ingrés de -5€")
    void depositNegativeTest(){
        boolean hasDeposited = bankAccount.deposit(-5);
        Transaction lastTransaction = bankAccount.getLastTransaction();
        assertAll(
                () -> assertFalse(hasDeposited,"S'ha efectuat la transacció d'una manera incorrecta"),
                () -> assertNotNull(lastTransaction,"No es troba l'ultima transacció"),
                () -> assertEquals(1000, bankAccount.getBalance(),"El balanç actual no es el esperat")
        );
    }


}

    @Nested
    class withdrawTests{
        @Test
        @DisplayName("Retirada de 100€")
        void withdraw100test(){
            boolean hasWithdrawed = bankAccount.withdraw(100);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertTrue(hasWithdrawed,"No s'ha efectuat la transacció"),
                    () -> assertNotNull(lastTransaction,"No es troba l'ultima transacció"),
                    () -> assertEquals(900, bankAccount.getBalance(),"El balanç actual no es el esperat"),
                    () -> assertEquals(100, lastTransaction.getAmount(),"L'import de l'ultima transacció no es l'esperat"),
                    () -> assertEquals(TransactionType.WITHDRAW, lastTransaction.getTransactionType(),"No coincideix el tipus de l'ultima transacció")
            );
        }

        @Test
        @DisplayName("Retirada de -5€")
        void withdrawNegativetest(){
            boolean hasWithdrawed = bankAccount.withdraw(-5);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertFalse(hasWithdrawed,"S'ha efectuat la transacció d'una manera incorrecta"),
                    () -> assertNotNull(lastTransaction,"No es troba l'ultima transacció"),
                    () -> assertEquals(1000, bankAccount.getBalance(),"El balanç actual no es el esperat")

            );
        }

        @Test
        @DisplayName("Retirada de 0€")
        void withdraw0test(){
            boolean hasWithdrawed = bankAccount.withdraw(0);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertFalse(hasWithdrawed,"S'ha efectuat la transacció d'una manera incorrecta"),
                    () -> assertNotNull(lastTransaction,"No es troba l'ultima transacció"),
                    () -> assertEquals(1000, bankAccount.getBalance(),"El balanç actual no es el esperat")

            );
        }

        @Test
        @DisplayName("Retirada de 1100€")
        void withdrawBiggerThanBalancetest(){
            boolean hasWithdrawed = bankAccount.withdraw(1100);
            Transaction lastTransaction = bankAccount.getLastTransaction();
            assertAll(
                    () -> assertFalse(hasWithdrawed,"S'ha efectuat la transacció d'una manera incorrecta"),
                    () -> assertNotNull(lastTransaction,"No es troba l'ultima transacció"),
                    () -> assertEquals(1000, bankAccount.getBalance(),"El balanç actual no es el esperat")

            );
        }


    }
}