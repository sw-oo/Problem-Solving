import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MaxHeap heap = new MaxHeap();

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            if(M != 0) {
                heap.add(M);
            } else {
                sb.append(heap.delete()).append("\n");
            }
        }
        System.out.println(sb);
    }
}

class MaxHeap {
    List<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        heap.add(0);
    }

    void add(int N) {
        heap.add(N);
        int current = heap.size()-1;

        while(current / 2 >= 1) {
            int parent = current / 2;
            if(heap.get(parent) < heap.get(current)) {
                Collections.swap(heap, parent, current);
                current = parent;
            } else
                break;
        }
    }

    int delete() {
        if(heap.size() == 1) return 0;

        if(heap.size() == 2) {
            int rv = heap.get(1);
            heap.remove(1);
            return rv;
        }

        int rv = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int current = 1;
        while(current * 2 < heap.size()) {
            int left = current * 2;
            int right = current * 2 + 1;
            int max = left;

            if(right < heap.size() && heap.get(right) > heap.get(left)) {
                max = right;
            }

            if(heap.get(current) < heap.get(max)) {
                Collections.swap(heap, current, max);
                current = max;
            } else
                break;
        }
        return rv;
    }
}
