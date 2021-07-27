import java.util.*;
public class MaxNumberOfKSumPairTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int [] arr= new int[n];
		for(int i=0;i<arr.length;i++) 
			arr[i]=scn.nextInt();
		int k=scn.nextInt();
		System.out.println(maxOperations2(arr,k));
		
	}
	public static int maxOperations(int[]nums,int k) {
		int op=0;
		int i=0;
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(i=0;i<nums.length;i++) {
			if(hmap.containsKey(k-nums[i]))
        	{
				hmap.remove(k-nums[i]);
				op++;
				continue;
        	}
        	hmap.put(nums[i], i);
		}
		return op;
	}

	public static int maxOperations2(int[]nums,int k) {
		int op=0;
		int i=0;
		Arrays.parallelSort(nums);
		//System.out.println(Arrays.toString(nums));
		for(i=0;i<nums.length;i++) {
			if((k-nums[i])>0) {
				int[] temp= Arrays.copyOfRange(nums,i+1,nums.length);	
				int res= Arrays.binarySearch(temp,k-nums[i]);
				if(res>=0)
				{
					op++;;
					nums[res+1+i]=Integer.MAX_VALUE;
					//System.out.println(Arrays.toString(nums));
				}
			}
				
		}
		return op;
	}

}
