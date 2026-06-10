import java.util.*;
import java.io.*;

class Solution {
    static long sum = 0;
    static long sumq1 = 0;
    public long solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        // get sum
        for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum += queue1[i] + queue2[i];
            sumq1 += queue1[i];
        }
        
        // check exception
        if(sum % 2 != 0)  return -1;
        if(sumq1 == sum / 2) return 0;
        for(int i = 0; i < queue1.length; i++) {
            if(isAnyOneOverHalf(queue1[i], queue2[i])) {
                return -1;
            }
        }
        
        long count = 0;
        long maxCount = queue1.length * 4;
        while(count <= maxCount) {
            if(sumq1 == sum / 2) {
                return count;
            }
            else if(sumq1 < sum / 2) {
                sumq1 += q2.peek();
                q1.offer(q2.poll());
                count++;
            } else {
                sumq1 -= q1.peek();
                q2.offer(q1.poll());
                count++;
            }
        }
        return -1;
    }
    
    public boolean isAnyOneOverHalf(long num1, long num2) {
        if(num1 > sum / 2 || num2 > sum / 2) {
            return true;
        } else 
            return false;
    }
}

