import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap();

        for(int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            if(M != 0) {
                heap.add(M);
            } else
                heap.delete();
        }
    }
}

class Heap {
    ArrayList<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
        heap.add(0);
    }

    void add(int N) {
        heap.add(N);

        int currentIdx = heap.size()-1;

        while(currentIdx / 2 >= 1) {
            int parentIdx = currentIdx / 2;

            if(heap.get(parentIdx) > heap.get(currentIdx)) {
                Collections.swap(heap, currentIdx, parentIdx);
                currentIdx = parentIdx;
            } else break;
        }
    }

    void delete() {
        if(heap.size() == 1) {
            System.out.println(0);
            return;
        } else if (heap.size() == 2) {
            System.out.println(heap.get(1));
            heap.remove(1);
            return;
        }

        System.out.println(heap.get(1));
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int currentIdx = 1;

        while(currentIdx * 2 <= heap.size()-1) {
            int leftIdx = currentIdx * 2;
            int rightIdx = currentIdx * 2 + 1;
            int minIdx = leftIdx;

            if(rightIdx <= heap.size()-1 && heap.get(rightIdx) < heap.get(leftIdx)) {
                minIdx = rightIdx;
            }

            if(heap.get(currentIdx) > heap.get(minIdx)) {
                Collections.swap(heap, currentIdx, minIdx);
                currentIdx = minIdx;
            } else break;
        }
    }
}
