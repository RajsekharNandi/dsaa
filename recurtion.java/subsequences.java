public class subsequences {
    public static void subseq(String str, int idx, String newString){
        if(idx == str.length()){
            System.out.println(newString);
            return;
        }
        char currentchar = str.charAt(idx);
        // to be
        subseq(str, idx+1, newString + currentchar);
        // not to be
        subseq(str, idx+1, newString);
    }
    public static void main(String args[]){
        String str = "abc";
        subseq(str, 0, "");
    }
}
