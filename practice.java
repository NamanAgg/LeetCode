// Split the number into M parts such that sum of all parts is equal to number and print them
// if N=10 , M=4   
// then output must be
// 1 1 1 7
// 1 1 2 6
// 1 1 3 5
// 1 1 4 4
// 1 2 2 5
// 1 2 3 4
// 1 3 3 3
// 2 2 2 4
// 2 2 3 3
// (Total 9 sequences)
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class practice {
    static Scanner scn = new Scanner(System.in);
    // // public static void main(String[]args){
    // //     int n = scn.nextInt();
    // //     int m = scn.nextInt();
    // //      divideNinMparts(n,m);
    // //     List<String>[][]dp = new ArrayList[n+1][m+1];
    // //     for(int i=0;i<(n+1);i++)
    // //         for(int j=0;j<(m+1);j++)
    // //             dp[i][j]=new ArrayList<>();
        
    // //     combinationSum3(m,n,1,dp);
    // //     display(dp[n][m]);
    // //     System.out.println();
    // //     display(dp);
    // // }
    // // public static void combinationSum3(int k,int n,int idx,List<String>[][]dp){
    // //     if(dp[n][k].size()!=0) return;
    // //     if(k==1){
    // //         dp[n][k].add(Integer.toString(n));
    // //         return ;
    // //     }
      

    // //     List<String>myList = new ArrayList<>();
    // //     for(int i=idx;i<=n/k;i++){
    // //         if(n-i>=0){
    // //             combinationSum3(k-1,n-i,i,dp);
    // //             List<String> got = dp[n-i][k-1];
    // //             for(String e : got)
    // //                 if(e!="")
    // //                     myList.add(i+" "+e);
    // //         }
    // //     }

    // //     dp[n][k]=myList;   
    // //     return;
    // // }
    
    // // public static void display(List<String>arr){
    // //     System.out.println();
    // //             for(String e : arr)
    // //         System.out.println(e);
    // // }

    // // public static void display(List<String>[][]dp){
    // //     for(List<String>[] d : dp){
    // //         for(List<String> e : d)
    // //         System.out.print(e);
    // //     System.out.println();
    // //     }
    // // }

    // // public static void divideNinMparts(int n, int m, int prev, StringBuilder ans){
    // //     if(m == 1){
    // //         ans.append(n);
    // //         System.out.println(ans.toString());
    // //         ans.delete(ans.length()-1, ans.length());
    // //         return;
    // //     }

    // //     for(int i = prev; i <= n/m; i++){
    // //         if(n-i>=0)
    // //             divideNinMparts(n - i, m - 1, i, ans.append(i + " "));
    // //             ans.delete(ans.length()-2,ans.length());
    // //     }
    // // }
    
    

    // // public static void divideNinMparts(int n, int m){
    // //     if(n == 0 || m == 0 || m > n)
    // //         return;
    // //     StringBuilder ans = new StringBuilder();
    // //     divideNinMparts(n, m, 1, ans);
    // // }

    // // public int probability

    // static int count = 0;

    // static int[][]dis,low;
    // static boolean[][]vis;
    // static int time=0, calls=0;
    // public static void main(String[]args){
    //     int m = scn.nextInt();
    //     int n = scn.nextInt();
    //     char[][]arr = new char[m][n];
    //     for(int i=0;i<m;i++){
    //         String str = scn.next();
    //         for(int j=0;j<n;j++)
    //             arr[i][j] = str.charAt(j);
    //     }

    //     ArrayList<int[]>[] graph = makeGraph(arr);
    //     vis = new boolean[m][n];
    //     dis = new int[m][n];
    //     low = new int[m][n];

    //     dfs(graph,0,0);
    // }

    // public void dfs(ArrayList<int[]>[]graph,int i,int j,int parI,int parJ){
    //     vis[i][j] = true;
    //     dis[i][j] = time;
    //     low[i][j] = time;

    //     for(int[] vtx : graph[i][j]){
    //         int r = vtx[0];
    //         int c = vtx[1];
    //         if(!vis[r][c]){
    //             dfs(graph,r,c,i,j);
    //             if(dis[i][j]<low[r][c]){
    //                 count++; //articulation point;
    //             }
    //             low[i][j] = Math.min(low[i][j],dis[r][c]);
    //         }
    //         else if(vis[])
    //     }
    // }
    
    // // public int probability(char[][]arr,int i,int j,int[][]dp){
    // //     if(dp[i][j]!=-1) return dp[i][j];

    // //     if(i==arr.length-1 && j==arr[0].length-1){
    // //         return dp[i][j] = 1;
    // //     }

        

    // //     int res1=0, res2=0;
    // //     if(i+1<arr.length && arr[i+1][j]!='#'){
    // //         res1 = probability(arr,i+1,j);
    // //     }
    // //     if(j+1<arr[0].length && arr[i][j+1]!='#'){
    // //         res1 = probability(arr,i,j+1);
    // //     }

    // //     if(res1==1 && res2==0 || res2==1 && res1==0){
    // //         count++;
    // //         return 1;
    // //     }
    // //     else if(res1==1 && res2==1)
    // //         return 1;
        
    // //         return 0;

    // // }

    // public static ArrayList<int[]>[] makeGraph(char[][]arr){
    //     int m = arr.length;
    //     int n = arr[0].length;
    //     ArrayList<int[]>[][] graph = new ArrayList[m][n];
    //     for(ArrayList<int[]>[] list : graph)
    //         for(ArrayList<int[]> e : list)
    //             e = new ArrayList<>();
        
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(i+1<m && arr[i+1][j]!='#')
    //              graph[i][j].add(new int[]{i+1,j});
    //              if(j+1<n && arr[i][j+1]!='#')
    //              graph[i][j].add(new int[]{i,j+1});
    //         }
    //     }

    //     return graph;
    // }

    public static double polygonArea(double X[], double Y[], 
                                                       int n)
    {
        // Initialize area
        double area = 0.0;
      
        // Calculate value of shoelace formula
        int j = n - 1;
        for (int i = 0; i < n; i++)
        {
            area += (X[j] + X[i]) * (Y[j] - Y[i]);
              
            // j is previous vertex to i
            j = i; 
        }
      
        // Return absolute value
        return Math.abs(area / 2.0);
    }

    public int takeInput(){
        int n = scn.nextInt();
        int m = scn.nextInt();
        double[][]points = new int[2][n];
        double[][]cutPoints = new int[2][m];
        for(int i=0;i<n;i++){

        }
    }
//  
}
