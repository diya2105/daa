public class StringEditDistanceDp {
    public static void main(String args[]) {
        String x = "acdaed";
        String y = "abcadf";
        int result = minEditDist(x, y);
        System.out.println("Min no  of operations: " + result);
    }

    public static int minEditDist(String p, String q) {
        int m = p.length();
        int n = q.length();
        int table[][] = new int[m + 1][n + 1];

        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    table[i][j] = j; 
                } else if (j == 0) {
                    table[i][j] = i; 
                } else if (p.charAt(i - 1) == q.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1]; 
                } else {
                    table[i][j] = 1 + Math.min(Math.min(table[i - 1][j], table[i][j - 1]), table[i - 1][j - 1]);
                }
            }
        }

        return table[m][n]; 
    }
}
