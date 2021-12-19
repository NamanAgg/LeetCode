public class DecodeStrings {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==']'){
                StringBuilder temp =new StringBuilder();
                while(!stack.peek().equals("[")){
                    String str = stack.pop();
                    temp.append(str);
                }
                stack.pop();
                String str = temp.toString();
                String num = "";
                while(!stack.isEmpty() && isNum(stack.peek())){
                    num = stack.pop() + num;
                }
                int n = Integer.parseInt(num);
                while(n-->1)
                    temp.append(str);
                stack.push(temp.toString());
            }
            else 
                stack.push(""+ch);
        }
        
        while(stack.size()!=0)
            sb.append(stack.pop());
        
        return sb.reverse().toString();
    }
    
    public boolean isNum(String s){
        for(int i=0;i<10;i++){
            if(s.equals(""+i)) return true;
        }
        return false;
    }
}
