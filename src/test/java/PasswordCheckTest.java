import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordCheckTest  {

    @Test
    @DisplayName("Passwordlength")
    @Description("Password too short")
    public void testPwLength1(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("passwo"));
    }


    @Test
    @DisplayName("Passwordlength")
    @Description("Password too long")
    public void testPwLength2(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("ajkwposkindqiewoisunfiheaslkjh"));
    }

    @Test
    @DisplayName("All upper")
    public void testPwUpperLower1(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("PASSWORD"));
    }
    @Test
    @DisplayName("All lower")
    public void testPwUpperLower2(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("password"));
    }

    @Test
    @DisplayName("At least one upper/lower")
    public void testPwUpperLower3(){
        PasswordCheck pw = new PasswordCheck();
        assertTrue(pw.checkPassword("Password"));
    }
    @Test
    @DisplayName("At least one number")
    public void testContainsNumber1(){
        PasswordCheck pw = new PasswordCheck();
        assertTrue(pw.checkPassword("Password1"));
    }
    @Test
    @DisplayName("At least one number2")
    public void testContainsNumber2(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("Password"));
    }

    @Test
    @DisplayName("Has special char")
    public void testHasSpecialchar(){
        PasswordCheck pw = new PasswordCheck();
        assertTrue(pw.checkPassword("Password12@"));
    }
    @Test
    @DisplayName("Has special char2")
    public void testHasSpecialchar2(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("Password12"));
    }
    @Test
    @DisplayName("Recurring Numbers")
    public void testRecurringNumbers1(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("Password@1111"));
    }
    @Test
    @DisplayName("Recurring Numbers2")
    public void testRecurringNumbers2(){
        PasswordCheck pw = new PasswordCheck();
        assertTrue(pw.checkPassword("Password111@"));
    }

}
