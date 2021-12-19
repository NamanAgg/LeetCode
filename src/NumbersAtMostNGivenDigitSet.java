public class NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int ans  = 0;
        boolean[]arr = new boolean[10];
        for(int i=0;i<digits.length;i++)
            arr[Integer.parseInt(digits[i])] = true;
        
        String s = Integer.toString(n);
        
        ans +=  calculateDefiniteNumbers(digits,n);
        ans+=backtracking(digits,arr,0,s);
        return ans;
    }
    
    public int backtracking(String[]digits,boolean[]arr,int idx,String s){
        int myCount = 0;
        int dig = s.charAt(idx)-'0';
        int cnt  = countNumbersBelowIt(arr,dig);
        int rem = s.length()-1-idx;
        if(idx==s.length()-1){
            return arr[dig]?cnt+1:cnt;
        }
        if(cnt==0 && !arr[dig]) return 0;
        myCount+= (cnt*(int)Math.pow(digits.length,rem));
        if(arr[dig]){
            int got = backtracking(digits,arr,idx+1,s);
            if(got!=0) myCount+=got;
        }
        
        return myCount;
    }
    
    public int countNumbersBelowIt(boolean[]arr,int dig){
        int count = 0;
        for(int i=0;i<dig;i++)
            if(arr[i]) count+=1;
        
        return count;
    }
    
    public int calculateDefiniteNumbers(String[]digits,int n){
        String s = Integer.toString(n);
        int size = s.length();
        int digitSize = digits.length;
        int ans = 0;
        --size;
        while(size>0){
            ans+=(int)(Math.pow(digitSize,size));
            size--;
        }
        
        return ans;
    }
}
