import java.util.HashSet;
public class subseqhashset {
    public static void subsequence (String str, int idx, String newString, HashSet<String> set){
        if (idx == str.length()){
            if(set.contains(newString)){
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return; 
            }
        }
        char currentchar = str.charAt(idx);
        subsequence(str, idx+1, newString+currentchar, set);
        subsequence(str, idx+1, newString, set);
    }
    public static void main (String args[]){
        String str = "fff";
        HashSet<String> set = new HashSet<>();
        subsequence(str, 0, "", set);
    }
        
}
