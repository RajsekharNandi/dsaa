class stonegame9 {
    public static void main(String[] args) {
        int n = 10; // Number of stones
        boolean[] dp = new boolean[n + 1];

       
        dp[0] = false;

        for (int i = 1; i <= n; i++) {
            
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        if (dp[n]) {
            System.out.println("First player can win with " + n + " stones.");
        } else {
            System.out.println("Second player can win with " + n + " stones.");
        }
    }
}