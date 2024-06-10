import org.example.models.Account;
import org.example.models.CheckingAccount;
import org.example.models.SavingAccount;
import org.junit.jupiter.api.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestAccount {

//    private int count;
    private Account a1;
    private CheckingAccount a2;
    private SavingAccount a3;


    @BeforeAll
    public static void init() {
        Account.annualRate = 0.12;
        System.out.println("init before all");
    }

    @AfterAll
    public static void clean() {
        Account.annualRate = 0.04;
        System.out.println("cleaning after all");
    }

    @BeforeEach
    public void createObjects() {
        a1 = new Account("Ahmed", 10000);
        a2 = new CheckingAccount("Ahmed", 10000);
        a3 = new SavingAccount("Ahmed", 10000, 2500);
        System.out.println("creating before each");
    }


    @Test
    public void testMonthlyRate() {

        double actual = Account.getMonthlyRate();
        double expected = 0.01;

//        count += 10;
//        System.out.println(count);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMonthlyInt() {
//        count += 10;
//        System.out.println(count);

        double actual = a1.getMonthlyInt();
        double expected = 10000 * 0.01;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWithdraw() {
//        count += 10;
//        System.out.println(count);

        Assertions.assertThrows(IllegalArgumentException.class, () -> a2.withdraw(11000));
        Assertions.assertThrows(IllegalArgumentException.class, () -> a3.withdraw(9000));
        Assertions.assertDoesNotThrow(() -> a1.withdraw(11000));
        Assertions.assertEquals(-1000, a1.getBalance());
    }

    @RepeatedTest(3)
    public void doMultipleTimes(RepetitionInfo repInfo) {

        System.out.println(repInfo.getCurrentRepetition());
        Assertions.assertTrue(true);
    }

}
