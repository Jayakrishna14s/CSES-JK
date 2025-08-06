import java.io.*;
import java.lang.*;
import java.util.*;
 
class DistinctValuesQueries {
    
    static class SegmentTree {
        class Node {
            int[] indices;
            Node left, right;
        }
        
        int[] arr, next_right;
        int n;
        Node tree;
        
        SegmentTree(int[] arr, int n) {
            this.n = n;
            this.arr = arr;
            next_right = new int[n];
            
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for(int i = n - 1; i >= 0; i--) {
                map.putIfAbsent(arr[i], n);
                next_right[i] = map.get(arr[i]);
                map.put(arr[i], i);
            }
            
            build();
        }
        
        
        void merge(Node node) {
            int[] left = node.left.indices;
            int[] right = node.right.indices;
            int[] curr = node.indices;
            
            int p1 = 0, p2 = 0, p3 = 0;
            
            while(p1 < left.length && p2 < right.length) {
                if(left[p1] <= right[p2]) {
                    curr[p3++] = left[p1++];
                } else {
                    curr[p3++] = right[p2++];
                }
            }
            
            while(p1 < left.length) {
                curr[p3++] = left[p1++];
            }
            
            while(p2 < right.length) {
                curr[p3++] = right[p2++];
            }
        }
        
        Node build(int low, int high) {
            if(low == high) {
                Node node = new Node();
                
                node.indices = new int[high - low + 1];
                node.indices[0] = next_right[low];
                return node;
            }
            
            int mid = (low + high) / 2;
            Node node = new Node();
            node.left = build(low, mid);
            node.right = build(mid + 1, high);
            
            node.indices = new int[high - low + 1];
            merge(node);
            
            return node;
        }
        
        void build() {
            tree = build(0, n - 1);
        }
        
        int bs(int[] arr, int k) {
            int n = arr.length;
            int i = 0, j = n - 1; 
            
            int res = -1;
            
            while(i <= j) {
                int mid = (i + j) / 2;
                if(arr[mid] <= k) {
                    res = mid;
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            
            return n - 1 - res;
        }
        
        int query(int l, int r, int s, int e, Node tree) {
            if(r < s || l > e) return 0;
            if(l <= s && e <= r) {
                return bs(tree.indices, r);
            }
            int mid = (s + e) / 2;
            return query(l, r, s, mid, tree.left) + query(l, r, mid + 1, e, tree.right); 
        }
        
        int query(int l, int r) {
            return query(l, r, 0, n - 1, tree);
        }
    } 
    
	public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        SegmentTree tree = new SegmentTree(arr, n);
        
        while(m-- > 0) {
            int[] lr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.write((tree.query(lr[0] - 1, lr[1] - 1)) + "\n");
        }
        
        bw.flush();
	}
}
