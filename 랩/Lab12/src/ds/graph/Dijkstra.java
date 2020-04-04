package ds.graph;

import ds.queue.DistanceQueue;

public class Dijkstra {
    private DistanceQueue distQueue;
    private int[] prev;
    private double[] D;
    private Graph G;

    public Dijkstra(Graph G) {
        this.G=G;
        distQueue = new DistanceQueue(G.n());
        prev = new int[G.n()];
        D = new double[G.n()];
    }

    public void calculateShortestPath(Graph G, int start) {
        D[start]=0;
        double alt;
        for(int i=0;i<G.n();i++) {
            if(i!=start) {
                D[i] = Integer.MAX_VALUE;
            }
            prev[i]= -1;
            distQueue.insert(i,D[i]);
        }
        while(!distQueue.isEmpty()) {
            int v = minVertex(G);
            for (int w = G.first(v); w < G.n(); w = G.next(v, w)) {
                alt = D[v] + G.weight(v, w);
                if (alt < D[w]) {
                    D[w] = alt;
                    prev[w] = v;
                    distQueue.decreaseDistance(w, alt);
                }
            }
        }
    }

    private void printPathToEnd(Graph G, int end) {
    }

    public void printAllPath(Graph G, int src) {
        int temp;
        int[] tempArr = new int[G.n()];
        int cnt = 0;
        for(int i=0;i<G.n();i++) {
            if(i!=src) {
                System.out.print("PATH " + src + " " + i + ": " + D[i]);
                temp = i;
                tempArr[cnt++] = temp;
                while(prev[temp]!=-1){
                    temp = prev[temp];
                    tempArr[cnt++]= temp;
                }
                for(int j=cnt; j>=0; j--) {
                    System.out.print(" "+tempArr[j]);
                }
                System.out.println();
                cnt = 0;
            }
        }
    }

    public int minVertex(Graph G) {
        return distQueue.removeMin();
    }


}