package ownPractice;
//**************81345. Jump Game IV
// Given an array of integers arr, you are initially positioned at the first index of the array.
// In one step you can jump from index i to index:
// i + 1 where: i + 1 < arr.length.
// i - 1 where: i - 1 >= 0.
// j where: arr[i] == arr[j] and i != j.
// Return the minimum number of steps to reach the last index of the array.
// Notice that you can not jump outside of the array at any time.

// Example 1:
// Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
// Output: 3
// Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

// Example 2:
// Input: arr = [7]
// Output: 0
// Explanation: Start index is the last index. You do not need to jump.

// Example 3:
// Input: arr = [7,6,9,6,9,6,9,7]
// Output: 1
// Explanation: You can jump directly from index 0 to index 7 which is last index of the array.

// Constraints:
// 1 <= arr.length <= 5 * 104
// -108 <= arr[i] <= 108
public class JumpGameIV {
    public int minJumps(int[] arr) {
        if(arr.length<=1) return 0;
        int n = arr.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        LinkedList<Integer>que = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            int val = arr[i];
            map.putIfAbsent(val,new ArrayList<>());
            ArrayList<Integer> list = map.get(val);
            list.add(i);
        }
       
        que.addLast(0);   
        int steps = 0;
        
        while(!que.isEmpty()){
            int size = que.size();
            while(size-->0){
                int rm = que.removeFirst();
                if(rm==n-1) 
                    return steps;
                
                if(rm-1>=0 && map.containsKey(arr[rm-1])) 
                    que.addLast(rm-1);
                if(rm+1<arr.length && map.containsKey(arr[rm+1]))
                    que.addLast(rm+1);
                
                if(map.containsKey(arr[rm])){
                    ArrayList<Integer>list = map.get(arr[rm]);
                    for(Integer e : list){
                        if(e!=rm && e!=(rm-1) && e!=(rm+1))
                            que.addLast(e);
                    }
                    map.remove(arr[rm]);
                }
            }
            steps++;
        }
        
        return steps;
    }
}