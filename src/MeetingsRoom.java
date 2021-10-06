//*************920 · Meeting Rooms
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
// determine if a person could attend all meetings.
// (0,8),(8,10) is not conflict at 8

// Example1
// Input: intervals = [(0,30),(5,10),(15,20)]
// Output: false
// Explanation: 
// (0,30), (5,10) and (0,30),(15,20) will conflict

// Example2
// Input: intervals = [(5,8),(9,15)]
// Output: true
// Explanation: 
// Two times will not conflict 
public class MeetingsRoom {
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if(intervals.size()==0) return true;
        Collections.sort(intervals,(a,b)->{
            return a.start-b.start;
        });
        Interval inter = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval val = intervals.get(i);
            if(inter.end>val.start) return false;
            inter= val;
        }

        return true;
    }
}
