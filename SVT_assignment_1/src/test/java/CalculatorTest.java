import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;


                        //Question 1

    @BeforeEach
    void setUp() {
        System.out.println("Setting up before each test");
        this.calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleaning up after each test");
    }

    @BeforeAll
    static void setBeforeAll(){
        System.out.println("Executed once before all tests");
    }

    @AfterAll
    static void setAfterAll(){
        System.out.println("Executed once after all tests");
    }

    @Test
    void add() {
        assertEquals(10,calculator.add(5,5));
    }

                        //Question 2

    @Test
    void addition() {
        assertEquals(20,calculator.add(15,5));
        assertNotEquals(30,calculator.add(10,10));
    }

    @Test
    void divide() {
        assertEquals(10,calculator.divide(20,2));
        assertNotEquals(20,calculator.divide(10,5));
    }
    @Test
    void CheckNull() {
        Calculator calculator1 = null;
        Calculator calculator2 = new Calculator();

        assertNull(calculator1);
        assertNotNull(calculator2);
    }
    @Test
    void checkCondition(){
        assertTrue(calculator.checkCondition(80,8));
        assertFalse(calculator.checkCondition(20,100));
    }

                            //Question 3

    @Test
    void division(){
        assertThrows(ArithmeticException.class, ()->calculator.divide(10,0));
        assertDoesNotThrow(()->calculator.divide(30,2));
    }

                            //Question 4

   @Test
   void getArray(){
        assertArrayEquals(new int[]{1,2,3},calculator.getArray());

       List<String> str1 = Arrays.asList("1","2","3");
       List<String> str2 = Arrays.asList("1","2","3");

       assertLinesMatch(str1,str2);
   }
   @Test
   void sameInstance(){
        Calculator calculator1 = calculator;

        assertSame(calculator,calculator1);
   }

                             //Question 5
   @Test
   void timeLimit(){
       assertTimeout(Duration.ofMillis(1), () -> {
           calculator.add(2,3);
       });
   }

                           //Question 6

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "5,2,7",
            "3,0,3"
    })
    void add_CsvSourse(int a,int b,int expected){
        assertEquals(expected,calculator.add(a,b));

    }

                        //Question 7

    @RepeatedTest(5)
    void generateRandomNumber() {
        int result = calculator.generateRandomNumber(5,15);
        assertTrue( result<=15);

    }
}