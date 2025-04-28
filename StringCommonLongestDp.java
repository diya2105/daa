public class StringCommonLongestDp {
    public static void main(String args[]) {
        String x = "acdaed";
        String y = "abcadf";
        int result = maxEditDist(x, y);
        System.out.println("Longest Common Subsequence: " + result);
    }

    public static int maxEditDist(String p, String q) {
        int m = p.length();
        int n = q.length();
        int table[][] = new int[m + 1][n + 1];

    
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    table[i][j] = 0;
                else if (p.charAt(i - 1) == q.charAt(j - 1))
                    table[i][j] = table[i - 1][j - 1] + 1;
                else
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
            }
        }


        
        return table[m][n];
    }
}
