public class Xendofstring {
    public static void moveallX(String str,int idx, int count,String newString){
        // base case: reached end of string -> append all 'x' and print
        if (idx == str.length()){
            for (int i = 0; i < count; i++) newString += 'x';
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        // treat lowercase 'x' (input uses 'x') and also accept 'X'
        if (currChar == 'x' || currChar == 'X'){
            moveallX(str, idx+1, count+1, newString);
        } else {
            newString += currChar;
            moveallX(str, idx+1, count, newString);
        }
        }
        public static void main (String args[]){
        String str = "axxbcxxd";
        moveallX(str,0, 0,"");
        }
    }

