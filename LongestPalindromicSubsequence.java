import java.util.Scanner;

class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.nextLine();  // Use nextLine() to allow spaces

        if (s.isEmpty()) {  // Handle empty input case
            System.out.println("The length of the longest palindromic subsequence is: 0");
        } else {
            System.out.println("The length of the longest palindromic subsequence is: " + longestPalindromeSubseq(s));
        }

        sc.close();  // Close scanner to prevent resource leaks
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Single characters are palindromes of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the table
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1]; // Return the result from dp table
    }
}
