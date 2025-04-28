import java.util.Scanner;
public class NQueenDemo {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queens : ");
        int n = sc.nextInt();
        sc.close();
        int board[][] = new int[n][n];
        if(n==1)
        {
            System.out.println("The board is : ");
            System.out.println("Q");
        }
        else if(n==2 || n==3)
            System.out.println("No solution exists for " + n + " queens.");
        else
            solveNQueen(board, n, 0);
    }
    public static void solveNQueen(int board[][], int n, int row)
    {
        if(row>=n)
        {
            printSolution(board, n);
            return;
        }
        for(int i=0; i<n; i++)
        {
            if(isSafe(board, n, row, i))
            {
                board[row][i] = 1;
                solveNQueen(board, n, row+1);
                board[row][i] = 0;
            }
        }
    }
    public static boolean isSafe(int board[][], int n, int row, int col)
    {
        for(int i=0; i<row; i++)
            if(board[i][col]==1)
                return false;
        for(int i=row, j=col; i>=0 && j>=0; i--, j--)
            if(board[i][j]==1)
                return false;
        for(int i=row, j=col; i>=0 && j<n; i--, j++)
            if(board[i][j]==1)
                return false;
        return true;
    }
    public static void printSolution(int board[][], int n)
    {
        System.out.println("The board is : ");
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                if(board[i][j]==1)
                    System.out.print("Q ");
                else
                    System.out.print("_ ");
            System.out.println();
        }
    }
}
