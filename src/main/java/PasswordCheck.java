import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

public class PasswordCheck {
    //"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[()#$?!%/@]).+$";
    public String regexUL = "^(?=.*[A-Z])(?=.*[a-z]).+$";
    public Pattern upper = Pattern.compile(regexUL);
    public String regexNum = "^(?=.*\\d).+$";
    public Pattern regNum = Pattern.compile(regexNum);
    public String regexSpec = "^(?=.*[()#$?!%/@]).+$";
    public Pattern special = Pattern.compile(regexSpec);

public boolean checkPassword(String str){
    return checkLength(str) && checkUpper(str) && checkNum(str) && checkSpecial(str) && checkRecurring(str) && checkNext(str);
}


    public boolean checkLength(String str) {
        int num = str.length();

        if (!(8 <= num && num <= 25)) {
            return false;
        }
        return true;
//        char[] list = new char[num];
//        for (int i = 0; i < num; i++) {
//            list[i] = str.charAt(i);
//        }


    }

    public boolean checkUpper(String str) {
        // Upper, Lower
        Matcher m = upper.matcher(str);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
    public boolean checkNum(String str) {
        // Numbers
        Matcher m = regNum.matcher(str);
        if (!m.matches()) {
            return false;
        }
        return true;
    }
    public boolean checkSpecial(String str) {
        // Numbers
        Matcher m = special.matcher(str);
        if (!m.matches()) {
            return false;
        }
        return true;
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
public boolean checkNext(String str) {
    int first = 0, second = 0, third = 0;
    
    for (int i = 0; i <= str.length(); i++) {
        if (i < str.length()-2 && Character.isDigit(str.charAt(i)) && Character.isDigit(str.charAt(i+1)) && Character.isDigit(str.charAt(i+2))){
            first = str.charAt(i);
            second = str.charAt(i+1);
            third = str.charAt(i+2);
        }
    }
    if (first == second-1 && first == third-2) {
        return false;
    }

    return true;
}

    public boolean checkRecurring(String str) {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;


        for (int i = 0; i <= str.length(); i++) {
            if (i < str.length()-3 && Character.isDigit(str.charAt(i)) && Character.isDigit(str.charAt(i+1)) &&
                    Character.isDigit(str.charAt(i+2)) && Character.isDigit(str.charAt(i+3))){

                first = str.charAt(i);
                second = str.charAt(i+1);
                third = str.charAt(i+2);
                fourth = str.charAt(i+3);

                if (first == second && first == third && first == fourth) {
                    return false;
                }
            }
        }
        return true;

    }


}

