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
public class practice {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[]args){
        int n = scn.nextInt();
        int m = scn.nextInt();
         divideNinMparts(n,m);
        List<String>[][]dp = new ArrayList[n+1][m+1];
        for(int i=0;i<(n+1);i++)
            for(int j=0;j<(m+1);j++)
                dp[i][j]=new ArrayList<>();
        
        combinationSum3(m,n,1,dp);
        display(dp[n][m]);
        System.out.println();
        display(dp);
    }
    public static void combinationSum3(int k,int n,int idx,List<String>[][]dp){
        if(dp[n][k].size()!=0) return;
        if(k==1){
            dp[n][k].add(Integer.toString(n));
            return ;
        }
      

        List<String>myList = new ArrayList<>();
        for(int i=idx;i<=n/k;i++){
            if(n-i>=0){
                combinationSum3(k-1,n-i,i,dp);
                List<String> got = dp[n-i][k-1];
                for(String e : got)
                    if(e!="")
                        myList.add(i+" "+e);
            }
        }

        dp[n][k]=myList;   
        return;
    }
    
    public static void display(List<String>arr){
        System.out.println();
                for(String e : arr)
            System.out.println(e);
    }

    public static void display(List<String>[][]dp){
        for(List<String>[] d : dp){
            for(List<String> e : d)
            System.out.print(e);
        System.out.println();
        }
    }

    public static void divideNinMparts(int n, int m, int prev, StringBuilder ans){
        if(m == 1){
            ans.append(n);
            System.out.println(ans.toString());
            ans.delete(ans.length()-1, ans.length());
            return;
        }

        for(int i = prev; i <= n/m; i++){
            if(n-i>=0)
                divideNinMparts(n - i, m - 1, i, ans.append(i + " "));
                ans.delete(ans.length()-2,ans.length());
        }
    }
    
    

    public static void divideNinMparts(int n, int m){
        if(n == 0 || m == 0 || m > n)
            return;
        StringBuilder ans = new StringBuilder();
        divideNinMparts(n, m, 1, ans);
    }
}
