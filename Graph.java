import java.util.*;

class Graph {
    int vertices;
    int[][] matrix;
    Graph(int v) {
        vertices = v;
        matrix = new int[v][v];
    }
    void addPath(int from, int to) {
        matrix[from][to] = 1;
    }
    void printPath() {
        for(int i = 0;i < vertices;i++) {
            System.out.print(i+"->");
            for(int j = 0;j < vertices;j++) {
                if(matrix[i][j] == 1) {
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Graph g = new Graph(4);
        g.addPath(0,1);
        g.addPath(0,2);
        g.addPath(0,3);
        g.addPath(1,3);
        g.addPath(2,3);
        g.printPath();
    }
}
