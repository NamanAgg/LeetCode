//************169. Majority Element
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.

// Example 1:
// Input: nums = [3,2,3]
// Output: 3

// Example 2:
// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
 
// Constraints:
// n == nums.length
// 1 <= n <= 5 * 104
// -231 <= nums[i] <= 231 - 1
// Follow-up: Could you solve the problem in linear time and in O(1) space? (Below solution is in linear time and in O(1) space).

// **VERY IMPORTANT QUESTION BASED ON  Boyer-Moore Majority Vote Algorithm and
// plz see the video ArraysAndStrings1LevelUp for more understanding**
// **DONE IN O(N) TIME AND O(1) SPACE**
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int maj=nums[0];
        int counter=1;
        for(int i=1;i<nums.length;i++){
            if(maj==nums[i]){
                counter++;
            }
            else if(counter==0){
                maj=nums[i];
                counter++;
            }
            else counter--;
        }
        //if outside of for loop, if counter is 0, it means that there is no such element exist where a 
        //majority element exist.
        return maj;
    }
}
