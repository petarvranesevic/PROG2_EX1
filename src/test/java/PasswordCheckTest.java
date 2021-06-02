import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordCheckTest {
    /*
    Checking Correct Password length 8-25
     */

    @Test
    @DisplayName("Passwordlength")
    @Description("Password too short")
    public void testPwLength1() {
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkLength("passwo"));
    }

    @Test
    @DisplayName("Passwordlength")
    @Description("Password too long")
    public void testPwLength2() {
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkLength("ajkwposkindqiewoisunfiheaslkjh"));
    }

    @Test
    @DisplayName("Passwordlength")
    @Description("Password right size")
    public void testPwLength3() {
        PasswordCheck pw = new PasswordCheck();
        assertTrue(pw.checkLength("password"));
    }



    /*
    Checking if there is at least one upper and lowercase letter
     */

    @Test
    @DisplayName("Uppercase/Lowercase")
    public void testPwUpperLower1() {
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkUpper("PASSWORD"));
    }

    @Test
    @DisplayName("Uppercase/Lowercase")
    public void testPwUpperLower2() {
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkUpper("password"));
    }

    @Test
    @DisplayName("Uppercase/Lowercase")
    public void testPwUpperLower3() {
        PasswordCheck pw = new PasswordCheck();
        assertTrue(pw.checkUpper("PassWord"));
    }



    /*
    Checking if there is at least one number
     */

    @Test
    @DisplayName("At least one number 1")
    public void testContainsNumber1() {
        PasswordCheck pw = new PasswordCheck();
        assertTrue(pw.checkNum("Password1"));
    }

    @Test
    @DisplayName("At least one number 2")
    public void testContainsNumber2() {
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkNum("Password"));
    }



    /*
    Checking if there is at least one special char
     */

    @Test
    @DisplayName("At least one special char 1")
    public void testHasSpecialchar() {
        PasswordCheck pw = new PasswordCheck();
        assertTrue(pw.checkSpecial("Password12@"));
    }

    @Test
    @DisplayName("At least one special char 2")
    public void testHasSpecialchar2() {
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkSpecial("Password12"));
    }



    /*
    Checking if 3 numbers are not ascending
    e.g 123 = false 124 = true
     */

    @Test
    @DisplayName("Ascending numbers 1")
    public void testCountingNumbers() {
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkNext("Password123@"));
    }

    @Test
    @DisplayName("Ascending numbers 2")
    public void testCountingNumbers2() {
        PasswordCheck pw = new PasswordCheck();
        assertTrue(pw.checkNext("Password111@"));
    }



    /*
    Checking if more than 3 numbers are next to each other
    */

    @Test
    @DisplayName("Recurring Numbers 1")
    public void testRecurringNumbers1() {
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkRecurring("Password@1111"));
    }

    @Test
    @DisplayName("Recurring Numbers 2")
    public void testRecurringNumbers2() {
        PasswordCheck pw = new PasswordCheck();
        assertTrue(pw.checkRecurring("Password111@"));
    }

}
