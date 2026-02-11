import java.util.*;

class Dfs {
    static boolean[] visited;

    boolean[] search(int start, int[][] graph) {
        Stack<Integer> stk = new Stack<>();

        visited = new boolean[graph[0].length];

        int current = start;
        stk.push(current);

        while(!stk.isEmpty()) {
            boolean isSearchAvailabe = false;
            if(!visited[current]) {
                visited[current] = true;
                stk.push(current);
            }
            for(int i = 0; i < graph.length; i++) {
                if(graph[current][i] == 1) {
                    if (visited[i]) {
                        continue;
                    }
                    current = i;
                    isSearchAvailabe = true;
                    break;
                }
            }
            if(!isSearchAvailabe) {
                stk.pop();
                if(stk.isEmpty()) {
                    break;
                } else
                    current = stk.peek();
            }
        }

        return visited;
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        Dfs dfs = new Dfs();
        
        boolean[] visited = new boolean[computers.length];
        boolean[] tempVisited;
        for(int i = 0; i < computers.length; i++) {
            if(visited[i]) {
                continue;
            }
            tempVisited = dfs.search(i, computers);
            for(int j = 0 ; j < tempVisited.length; j++) {
                if(tempVisited[j])
                    visited[j] = true;
            }
            count++;
        }
        
        return count;
    }
}