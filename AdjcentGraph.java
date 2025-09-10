import java.util.*;

class AdjcentGraph {
    int[][] adjMatrix;
    int size;
    public AdjcentGraph(int n) {
        size = n;
        adjMatrix = new int[n][n];
    }
    public void addEdge(int i,int j,int weight) {
        adjMatrix[i][j] = adjMatrix[j][i] = weight;
    }
    public void addEdge(int i,int j) {
        adjMatrix[i][j] = adjMatrix[j][i] = 0;
    }
    public void addVertex() {
        int[][] newAdjMat = new int[size+1][size+1];
        for(int i = 0;i < size;i++) {
            for(int j = 0;j < size;j++) {
                newAdjMat[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newAdjMat;
        size++;
    }
    public void removeVertex(int v) {
        int[][] newAdjMat = new int[size-1][size-1];
        for(int i = 0;i < size;i++) {
            for(int j = 0;j < size;j++) {
                if(i != v && j != v)
                    newAdjMat[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newAdjMat;
        size--;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AdjcentGraph g = new AdjcentGraph(4);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 4, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(4, 3, 1);
        
    }
}
