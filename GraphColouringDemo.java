import java.util.*;

public class GraphColouringDemo {
    int graph[][]; 
    int n; 
    int m; // Number of colors
    int color[];

    public GraphColouringDemo(int g[][], int v, int numColors) {
        graph = g;
        n = v;
        m = numColors;
        color = new int[n]; // Correcting array size
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int numOfVertices = sc.nextInt();

        System.out.print("Enter the number of colors: ");
        int numOfColors = sc.nextInt();

        int graph[][] = new int[numOfVertices][numOfVertices];

        System.out.println("Enter the adjacency matrix: ");
        for (int i = 0; i < numOfVertices; i++) {
            for (int j = 0; j < numOfVertices; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        sc.close();

        GraphColouringDemo g = new GraphColouringDemo(graph, numOfVertices, numOfColors);
        g.solveGCP();
    }

    public void solveGCP() {
        if (!solutionGC(0)) {
            System.out.println("No solution exists.");
            return;
        }
        printSolution();
    }

    public boolean solutionGC(int v) {
        if (v == n) return true;

        for (int c = 1; c <= m; c++) {  // Corrected loop
            if (isSafe(v, c)) {
                color[v] = c;
                if (solutionGC(v + 1)) return true;
                color[v] = 0; // Backtrack
            }
        }
        return false;
    }

    public boolean isSafe(int v, int c) {
        for (int i = 0; i < n; i++) {
            if (graph[v][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    public void printSolution() {
        System.out.println("The solution is:");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + (i + 1) + ": " + color[i]);
        }
    }
}
