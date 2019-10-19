package lecture9a25;

import java.util.*;
public class AdjMatrix {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Graph gp = new Graph(7);
        gp.addEdge(1, 2, 6);
        gp.addEdge(1, 3, 1);
        gp.addEdge(3, 4, 5);
        gp.addEdge(2, 4, 2);
        gp.addEdge(2, 5, 3);
        gp.addEdge(5, 6, 2);
        gp.addEdge(6, 7, 5);
        gp.addEdge(5, 7, 4);
//      gp.removeEdge(6, 7);
//      gp.removeEdge(4, 6);
        System.out.println(gp);
        System.out.println(gp.hasPath(1, 6));
        System.out.println(gp.BFS(1, 6));
        gp.BFT();
        System.out.println(gp.DFS(1, 7));
        gp.DFT();
        System.out.println(gp.isConnected());
        System.out.println(gp.isCycle());
        System.out.println(gp.getConnectedComp());
        System.out.println(gp.isBipertite());
        gp.Dijkstra(1, 7);
    }
    static class Graph {
        int[][] matrix;
        int numV;
        public Graph() {
            this(5);
        }
        public Graph(int N) {
            numV = N;
            matrix = new int[N + 1][N + 1];
        }
        public Graph(int[][] paths) {
            numV = paths.length;
            for (int i = 0; i < paths.length; i++) {
                addEdge(paths[i][0], paths[i][1], paths[i][2]);
            }
        }
        public void addEdge(int u, int v, int cost) {
            matrix[u][v] = cost;
            matrix[v][u] = cost;
        }
        public boolean isEdge(int u, int v) {
            return (matrix[u][v] != 0);
        }
        public void removeEdge(int u, int v) {
            matrix[u][v] = 0;
            matrix[v][u] = 0;
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= numV; i++) {
                sb.append(i + ": ");
                for (int j = 0; j < matrix[0].length; j++) {
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
        public boolean hasPath(int src, int dst) {
            Set<Integer> visited = new HashSet<>();
            hasAllPath(src, dst, visited, "");
            visited = new HashSet<>();
            return hasPath(src, dst, visited);
        }
        public boolean hasPath(int src, int dst, Set<Integer> visited) {
            if (isEdge(src, dst)) {
                return true;
            }
            visited.add(src);
            int[] nbrs = matrix[src];
            for (int nbr = 1; nbr < nbrs.length; nbr++) {
                if (!visited.contains(nbr) && isEdge(src, nbr)) {
                    boolean ans = hasPath(nbr, dst, visited);
                    if (ans)
                        return true;
                }
            }
            return false;
        }
        public void hasAllPath(int src, int dst, Set<Integer> visited, String asf) {
            if (src == dst) {
                System.out.println(asf + dst + "!");
                return;
            }
            visited.add(src);
            int[] nbrs = matrix[src];
            for (int nbr = 1; nbr < nbrs.length; nbr++) {
                if (!visited.contains(nbr) && isEdge(src, nbr)) {
                    hasAllPath(nbr, dst, visited, asf + src + " - ");
                }
            }
            visited.remove(src);
        }
        class pair {
            int data;
            String psf;
            String color;
            public pair(int d, String p) {
                data = d;
                psf = p;
            }
            public pair(int d, String p, String c) {
                data = d;
                psf = p;
                color = c;
            }
        }
        public boolean BFS(int src, int dst) {
            LinkedList<pair> q = new LinkedList<>();
            q.add(new pair(src, src + ""));
            Set<Integer> visited = new HashSet<>();
            while (!q.isEmpty()) {
                pair rp = q.poll();
                if (visited.contains(rp.data)) {
                    continue;
                }
                if (isEdge(rp.data, dst)) {
                    System.out.println(rp.psf + dst);
                    return true;
                }
                visited.add(rp.data);
                int[] nbrs = matrix[rp.data];
                for (int nbr = 1; nbr < nbrs.length; nbr++) {
                    if (!visited.contains(nbr) && isEdge(rp.data, nbr)) {
                        q.addLast(new pair(nbr, rp.psf + nbr));
                    }
                }
            }
            return false;
        }
        public void BFT() {
            LinkedList<pair> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            for (int i = 1; i <= numV; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                pair np = new pair(i, i + "");
                q.add(np);
                while (!q.isEmpty()) {
                    pair rp = q.poll();
                    if (visited.contains(rp.data)) {
                        continue;
                    }
                    System.out.println(np.data + " coming via " + rp.psf);
                    visited.add(rp.data);
                    int[] nbrs = matrix[rp.data];
                    for (int nbr = 0; nbr < nbrs.length; nbr++) {
                        if (!visited.contains(nbr) && isEdge(rp.data, nbr)) {
                            q.addLast(new pair(nbr, rp.psf + nbr));
                        }
                    }
                }
            }
        }
        public boolean DFS(int src, int dst) {
            LinkedList<pair> stack = new LinkedList<>();
            stack.addFirst(new pair(src, src + ""));
            Set<Integer> visited = new HashSet<>();
            while (!stack.isEmpty()) {
                pair rp = stack.removeFirst();
                if (visited.contains(rp.data)) {
                    continue;
                }
                if (isEdge(rp.data, dst)) {
                    System.out.println(rp.psf + dst);
                    return true;
                }
                visited.add(rp.data);
                int[] nbrs = matrix[rp.data];
                for (int nbr = 1; nbr < nbrs.length; nbr++) {
                    if (!visited.contains(nbr) && isEdge(rp.data, nbr)) {
                        stack.addFirst(new pair(nbr, rp.psf + nbr));
                    }
                }
            }
            return false;
        }
        public void DFT() {
            LinkedList<pair> stack = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            for (int i = 1; i <= numV; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                pair np = new pair(i, i + "");
                stack.addFirst(np);
                while (!stack.isEmpty()) {
                    pair rp = stack.removeFirst();
                    if (visited.contains(rp.data)) {
                        continue;
                    }
                    System.out.println(np.data + " coming via " + rp.psf);
                    visited.add(rp.data);
                    int[] nbrs = matrix[rp.data];
                    for (int nbr = 0; nbr < nbrs.length; nbr++) {
                        if (!visited.contains(nbr) && isEdge(rp.data, nbr)) {
                            stack.addFirst(new pair(nbr, rp.psf + nbr));
                        }
                    }
                }
            }
        }
        public boolean isConnected() {
            LinkedList<pair> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            int cnt = 0;
            for (int i = 1; i <= numV; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                cnt++;
                pair np = new pair(i, i + "");
                q.add(np);
                while (!q.isEmpty()) {
                    pair rp = q.poll();
                    if (visited.contains(rp.data)) {
                        continue;
                    }
                    System.out.println(np.data + " coming via " + rp.psf);
                    visited.add(rp.data);
                    int[] nbrs = matrix[rp.data];
                    for (int nbr = 0; nbr < nbrs.length; nbr++) {
                        if (!visited.contains(nbr) && isEdge(rp.data, nbr)) {
                            q.addLast(new pair(nbr, rp.psf + nbr));
                        }
                    }
                }
            }
            return cnt <= 1;
        }
        public boolean isCycle() {
            LinkedList<pair> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            int cnt = 0;
            for (int i = 1; i <= numV; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                cnt++;
                pair np = new pair(i, i + "");
                q.add(np);
                while (!q.isEmpty()) {
                    pair rp = q.poll();
                    if (visited.contains(rp.data)) {
                        return true;
                    }
                    System.out.println(np.data + " coming via " + rp.psf);
                    visited.add(rp.data);
                    int[] nbrs = matrix[rp.data];
                    for (int nbr = 0; nbr < nbrs.length; nbr++) {
                        if (!visited.contains(nbr) && isEdge(rp.data, nbr)) {
                            q.addLast(new pair(nbr, rp.psf + nbr));
                        }
                    }
                }
            }
            return false;
        }
        public boolean isTree() {
            return isConnected() && !isCycle();
        }
        public ArrayList<ArrayList<Integer>> getConnectedComp() {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            LinkedList<pair> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            int cnt = 0;
            for (int i = 1; i <= numV; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                ArrayList<Integer> comp = new ArrayList<>();
                cnt++;
                pair np = new pair(i, i + "");
                q.add(np);
                while (!q.isEmpty()) {
                    pair rp = q.poll();
                    if (visited.contains(rp.data)) {
                        continue;
                    }
                    System.out.println(np.data + " coming via " + rp.psf);
                    visited.add(rp.data);
                    comp.add(rp.data);
                    int[] nbrs = matrix[rp.data];
                    for (int nbr = 0; nbr < nbrs.length; nbr++) {
                        if (!visited.contains(nbr) && isEdge(rp.data, nbr)) {
                            q.addLast(new pair(nbr, rp.psf + nbr));
                        }
                    }
                }
                res.add(comp);
            }
            return res;
        }
        public boolean isBipertite() {
            LinkedList<pair> q = new LinkedList<>();
            HashMap<Integer, String> visited = new HashMap<>();
            for (int i = 1; i <= numV; i++) {
                if (visited.containsKey(i)) {
                    continue;
                }
                pair np = new pair(i, i + "", "r");
                q.add(np);
                while (!q.isEmpty()) {
                    pair rp = q.poll();
                    if (visited.containsKey(rp.data)) {
                        String oc = visited.get(rp.data);
                        String nc = rp.color;
                        if (!nc.equals(oc))
                            return false;
                        continue;
                    }
                    visited.put(rp.data, rp.color);
                    int[] nbrs = matrix[rp.data];
                    for (int nbr = 0; nbr < nbrs.length; nbr++) {
                        if (!visited.containsKey(nbr) && isEdge(rp.data, nbr)) {
                            q.addLast(new pair(nbr, rp.psf + nbr, rp.color.equals("g") ? "r" : "g"));
                        }
                    }
                }
            }
            return true;
        }
        class Dpair {
            int vname;
            int cost;
            String psf;
            public Dpair(int name, int c, String ans) {
                vname = name;
                cost = c;
                psf = ans;
            }
        }
        public void Dijkstra(int src, int dst) {
            PriorityQueue<Dpair> pq = new PriorityQueue<>(new Comparator<Dpair>() {
                @Override
                public int compare(Dpair o1, Dpair o2) {
                    return o1.cost - o2.cost;
                }
            });
            for (int key = 1; key <= numV; key++) {
                pq.add(new Dpair(src, 0, src + ""));
                while (!pq.isEmpty()) {
                    Dpair rp = pq.poll();
                    if (rp.vname == key) {
                        System.out.println(rp.psf + ":" + rp.cost);
                        break;
                    }
                    int[] nbrs = matrix[rp.vname];
                    for (int nbr = 1; nbr < nbrs.length; nbr++) {
                        if (isEdge(nbr, rp.vname))
                            pq.offer(new Dpair(nbr, rp.cost + matrix[rp.vname][nbr], rp.psf + nbr));
                    }
                }
            }
        }
    }
}