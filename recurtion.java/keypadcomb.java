import java.util.HashMap;

public class keypadcomb {
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "prst", "uvw", "xyz"};
     public static void keypadcomb(String str, int idx, String combination){
        if(idx == str.length()){
            System.out.println(combination);
            return;
        }
        char currentchar = str.charAt(idx);
        String mapping = keypad[currentchar - '0'];

        for(int i=0; i<mapping.length(); i++){
            keypadcomb(str, idx + 1, combination + mapping.charAt(i));
        }
     }
     public static void main (String agrs[]){
        String str = "23";
        keypadcomb(str,0,"");
    
     }
    }

