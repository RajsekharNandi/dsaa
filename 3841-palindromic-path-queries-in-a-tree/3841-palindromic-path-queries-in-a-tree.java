import java.util.*;

class Solution {
    int n, LOG;
    int[][] up;
    int[] depth, tin, tout, bit;

    void upd(int i, int val) {
        for (i++; i <= n + 1; i += i & -i) bit[i] ^= val;
    }

    void rangeXor(int l, int r, int val) {
        upd(l, val);
        upd(r + 1, val);
    }

    int query(int i) {
        int res = 0;
        for (i++; i > 0; i -= i & -i) res ^= bit[i];
        return res;
    }

    int lca(int a, int b) {
        if (depth[a] < depth[b]) { int t = a; a = b; b = t; }
        int diff = depth[a] - depth[b];
        for (int k = 0; k < LOG; k++) {
            if (((diff >> k) & 1) == 1) a = up[k][a];
        }
        if (a == b) return a;
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][a] != up[k][b]) {
                a = up[k][a];
                b = up[k][b];
            }
        }
        return up[0][a];
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = Math.max(1, 32 - Integer.numberOfLeadingZeros(n));
        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        bit = new int[n + 2];

        // Iterative DFS for Euler tour
        int timer = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, -1, 0});
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int node = top[0], par = top[1], done = top[2];
            if (done == 1) {
                tout[node] = timer - 1;
                continue;
            }
            tin[node] = timer++;
            up[0][node] = par == -1 ? node : par;
            stack.push(new int[]{node, par, 1});
            for (int nb : adj[node]) {
                if (nb != par) {
                    depth[nb] = depth[node] + 1;
                    stack.push(new int[]{nb, node, 0});
                }
            }
        }

        for (int k = 1; k < LOG; k++) {
            for (int v = 0; v < n; v++) {
                up[k][v] = up[k - 1][up[k - 1][v]];
            }
        }

        int[] cur = new int[n];
        for (int v = 0; v < n; v++) {
            cur[v] = 1 << (s.charAt(v) - 'a');
            rangeXor(tin[v], tout[v], cur[v]);
        }

        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                int nw = 1 << (p[2].charAt(0) - 'a');
                if (nw != cur[u]) {
                    rangeXor(tin[u], tout[u], cur[u] ^ nw);
                    cur[u] = nw;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);
                int l = lca(u, v);
                int m = query(tin[u]) ^ query(tin[v]) ^ cur[l];
                res.add((m & (m - 1)) == 0);
            }
        }

        return res;
    }
}