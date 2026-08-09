public class removeduplicate {
    public static boolean[] map = new boolean[26];

    public static void removeno (String str, int idx, String newString){
        if(idx == str.length()){
            System.out.println(newString);
              return;
        }
        char currchar = str.charAt(idx);
        if(map[currchar - 'a']){
            removeno(str, idx + 1, newString);
        }
        else{
            newString += currchar;
            map[currchar - 'a'] = true;
            removeno(str,idx+1, newString);
        }
    }
    public static void main(String arg[]){
        String str = "abbccda";
        removeno(str, 0, "");
    }

}