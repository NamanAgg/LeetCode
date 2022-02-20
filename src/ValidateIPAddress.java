//************468. Validate IP Address
// Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither"
// if IP is not a correct IP of any type.
// A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros.
// For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168@1.1"
// are invalid IPv4 addresses.
// A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
// 1 <= xi.length <= 4
// xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f')
// and upper-case English letters ('A' to 'F').
// Leading zeros are allowed in xi.
// For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses,
// while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.

// Example 1:
// Input: queryIP = "172.16.254.1"
// Output: "IPv4"
// Explanation: This is a valid IPv4 address, return "IPv4".

// Example 2:
// Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
// Output: "IPv6"
// Explanation: This is a valid IPv6 address, return "IPv6".

// Example 3:
// Input: queryIP = "256.256.256.256"
// Output: "Neither"
// Explanation: This is neither a IPv4 address nor a IPv6 address.

// Constraints:
// queryIP consists only of English letters, digits and the characters '.' and ':'.
public class ValidateIPAddress {
    public String validIPAddress(String queryIP) {
        String fls = "Neither";
        String ipv4 = "IPv4";
        String ipv6 = "IPv6";
        if(isIpv4(queryIP)) return ipv4;
        if(isIpv6(queryIP)) return ipv6;
        return fls;
    }
    
    public boolean isIpv4(String str){
        int count = 0;
        int start = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='.'){
                count++;
                if(start==0) return false;
                start = 0;
            }
            else
                start++;
        }
        if(count!=3 || start==0) return false;
        
        String[]arr = str.split("[.]+");
        for(String s : arr){
            if(!validString(s)) return false;
            int num = Integer.parseInt(s);
            if(!(num>=0 && num<256)) return false;
        }
        return true;
    }
    
    public boolean validString(String str){
        if(str.length()>3 || str.length()==0) 
            return false;

        if(str.charAt(0)=='0' && str.length()>1) 
            return false;

        for(Character ch : str.toCharArray()){
            if(!((ch-'0')>=0 && (ch-'0')<=9)) 
                return false;
        }
        return true;
            
    }
    
    public boolean isIpv6(String str){
        int count = 0;
        int start = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch==':'){
                count++;
                if(start==0) return false;
                start = 0;
            }
            else start++;
        }
        if(count!=7 || start==0) return false;
        
        String[]arr = str.split(":");
        for(String s : arr){
            if(s.length()>4 || s.length()==0) return false;
            if(!isValidStringForv6(s)) return false;
        }
        return true;
        
    }
    
    public boolean isValidStringForv6(String str){
        for(Character ch : str.toCharArray()){
            if(ch>='a' && ch<='f' || ch>='A' && ch<='F' || ch>='0' && ch<='9'){
                
            }
            else 
                return false;
        }
        
        return true;
    }    
}
