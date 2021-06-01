import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

public class PasswordCheck {


    public boolean checkPassword(String str) {
        int num = str.length();
        char[] list = new char[num];
        for (int i = 0; i < num; i++) {
            list[i] = str.charAt(i);
        }
        int duplicates = 0;
        int counting = 0;


        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[()#$?!%/@]).+$";
        Pattern p = Pattern.compile(regex);

        if (!(8 <= num && num <= 25)) {
            return false;
        }
        // Upper, Lower, Numbers, Special
        Matcher m = p.matcher(str);
        if (!m.matches()) {
            return false;
        }
/*
        //Counting
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (list[i] >= 48 && list[i] <= 57) {
                    if (list[i] + 1 == list[j]) {
                        counting++;
                        if (counting > 2) return false;
                    } else {
                        counting = 0;
                    }
                }
            }
        }
*/

        //Recurring
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (list[i] >= 48 && list[i] <= 57) {
                    if (list[i] == list[j]) {
                        duplicates++;
                        if (duplicates > 3) return false;
                    } else {
                        duplicates = 0;
                    }
                }
            }
        }

        return true;
    }
}
