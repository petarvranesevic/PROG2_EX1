import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordCheckTest  {

    @Test
    @DisplayName("Is too short")
    public void testPwLength1(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("abcdafg"));
    }


    @Test
    @DisplayName("Is too long")
    public void testPwLength2(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("ajkwposkindqiewoisunfiheaslkjh"));
    }


    @Test
    @DisplayName("Is too short")
    public void testPwUpperLower1(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("PASSWORD"));
    }
    @Test
    @DisplayName("Is too short")
    public void testPwUpperLower2(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("password"));
    }

    @Test
    @DisplayName("Is too short")
    public void testPwLength3(){
        PasswordCheck pw = new PasswordCheck();
        assertFalse(pw.checkPassword("abcdafg"));
    }
}
