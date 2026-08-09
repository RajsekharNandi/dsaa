public class placeTiles {
     public static int totalTiles(int n, int m){
        if(n == m){
            return 2;
        }
        if(n < m){
            return 1;
        }
        int vertPlacement = totalTiles(n-m, m);
        int horPlacement = totalTiles(n-1, m);
        return vertPlacement + horPlacement;

     }
     public static void main(String args[]){
        int n = 4, m = 2;
        System.out.println(totalTiles(n, m));
     }
}
