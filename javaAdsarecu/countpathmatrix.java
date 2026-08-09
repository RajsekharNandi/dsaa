public class countpathmatrix {
    public static int countpaths(int i, int j, int n, int m){
        if(i == n || j == m){
            return 1;
        }
        if(i == n-1 && j == m-1){
            return 1;
        }
        int downPaths = countpaths(i+1, j, n, m);
        int rightPath = countpaths(i, j+1, n, m);
        return downPaths + rightPath;
    }
    public static void main(String args[]){
        int n = 3;
        int m = 3;
        int totalpath = countpaths(0,0,n,m);
        System.out.println(totalpath);
     }
    }

