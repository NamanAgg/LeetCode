package ownPractice;
//***************71. Simplify Path
// Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system,
// convert it to the simplified canonical path.
// In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level,
// and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem,
// any other format of periods such as '...' are treated as file/directory names.
// The canonical path should have the following format:
// The path starts with a single slash '/'.
// Any two directories are separated by a single slash '/'.
// The path does not end with a trailing '/'.
// The path only contains the directories on the path from the root directory to the target file or directory
// (i.e., no period '.' or double period '..')
// Return the simplified canonical path.

// Example 1:
// Input: path = "/home/"
// Output: "/home"
// Explanation: Note that there is no trailing slash after the last directory name.

// Example 2:
// Input: path = "/../"
// Output: "/"
// Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

// Example 3:
// Input: path = "/home//foo/"
// Output: "/home/foo"
// Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

// Example 4:
// Input: path = "/a/./b/../../c/"
// Output: "/c"

// Constraints:
// 1 <= path.length <= 3000
// path consists of English letters, digits, period '.', slash '/' or '_'.
// path is a valid absolute Unix path.
public class SimpifyPath {
    public String simplifyPath(String path) {
        if(path.length()<=1) return path;
        
        // String str = path.substring(1);
        String str = path;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='/'){
                if(stack.isEmpty() || stack.peek()!='/'){
                    stack.push(ch);
                }
            }
            else if(ch=='.' && (i+1<str.length() && str.charAt(i+1)=='/' || i+1==str.length())){
            }
            else if(ch=='.' && ((i+2<str.length() && str.charAt(i+1)=='.' && str.charAt(i+2)=='/') ||(i+2==str.length() && str.charAt(i+1)=='.'))){
                if(!stack.isEmpty() && stack.peek()=='/') stack.pop();
                while(!stack.isEmpty() && stack.peek()!='/')
                    stack.pop();
                i+=1;
            }
            
            else{
                while(i<str.length()&&str.charAt(i)!='/'){
                    stack.push(str.charAt(i));
                    i++;
                }
                
                if(i<str.length()) i-=1;
            }
            // System.out.println(stack);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty() && stack.peek()=='/') stack.pop();
        if(stack.size()==0) return "/";
        while(stack.size()!=0)
            sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
}
