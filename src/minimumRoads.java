import java.util.*;
import java.io.*;
public class minimumRoads {
    public static int minimumRoadsAns(int n,int[][]queries){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int diff1 = a[1]-a[0];
            int diff2 = b[1]-b[0];
            if(diff1==diff2) return a[0]-b[0];
            return diff1-diff2;
        });
        
        for(int[] q : queries)
            pq.add(q);
        
        boolean[]vis = new boolean[n];
        int count = 0;
        while(pq.size()!=0){
            int[]arr = pq.remove();
            if(arr[1]-arr[0]==0){
                count++;
                continue;
            }
            boolean flag = false;
            for(int i=arr[0];i<arr[1];i++){
                if(vis[i]){
                    flag = true;
                    break;
                }
            }
    
            if(!flag){
                vis[arr[1]-1] = true;
                count++;
            }
        }
    
        return count;
    }


    public static void main(String[]args){
        // Scanner scn = new Scanner(System.in);

        int n = 9;
        int[][]queries = new int[][]{{7,9},{1,8},{3,5},{2,7},{4,6}};
        // int[][]queries = new int[][]{{1,4},{2,5}};
    
    }

}
