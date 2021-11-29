package ownPractice;
//************721. Accounts Merge
// Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
// and the rest of the elements are emails representing emails of the account.
// Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both
// accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
// A person can have any number of accounts initially, but all of their accounts definitely have the same name.
// After merging the accounts, return the accounts in the following format: the first element of each account is the name,
// and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

// Example 1:
// Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],
// ["John","johnsmith@mail.com","john00@mail.com"],
// ["Mary","mary@mail.com"],
// ["John","johnnybravo@mail.com"]]
// Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],
// ["Mary","mary@mail.com"],
// ["John","johnnybravo@mail.com"]]
// Explanation:
// The first and second John's are the same person as they have the common email "johnsmith@mail.com".
// The third John and Mary are different people as none of their email addresses are used by other accounts.
// We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
// ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.

// Example 2:
// Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],
// ["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
// ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],
// ["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
// ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
// Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],
// ["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],
// ["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],
// ["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],
// ["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]

// Constraints:
// 1 <= accounts.length <= 1000
// 2 <= accounts[i].length <= 10
// 1 <= accounts[i][j] <= 30
// accounts[i][0] consists of English letters.
// accounts[i][j] (for j > 0) is a valid email.
public class AccountsMerge {
    public void union(int i,int j,int[]par,int[]size){
        int p1 = findPar(i,par);
        int p2 = findPar(j,par);
        
        if(p1!=p2){
            if(size[p1]>size[p2]){
                par[p2] = p1;
                size[p1] += size[p2];
            }
            else{
                par[p1] = p2;
                size[p2] += size[p1];
            }
        }
    }
    
    public int findPar(int u,int[]par){
        return ((u==par[u])?u:(par[u] = findPar(par[u],par)));
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> finalAns = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int[]par = new int[accounts.size()];
        int[]size = new int[accounts.size()];
        
        for(int i=0;i<par.length;i++){
            par[i] = i;
            size[i] = accounts.get(i).size()-1;
        }
        
        for(int i=0;i<accounts.size();i++)
            for(int j=1;j<accounts.get(i).size();j++){
                String str = accounts.get(i).get(j);
                if(!map.containsKey(str))
                    map.put(str,i);
                else
                    union(map.get(str),i,par,size);
            }
        
        List<String>[] li = new ArrayList[accounts.size()];      
        for(int i=0;i<li.length;i++)
            li[i] = new ArrayList<>();
        
        for(String key : map.keySet()){
            int val = map.get(key);
            int p1 = findPar(val,par);
            li[p1].add(key);
        }
        
        for(int i=0;i<accounts.size();i++)
            if(li[i].size()!=0){
                List<String> list = li[i];
                Collections.sort(list);
                list.add(0,accounts.get(i).get(0));
                finalAns.add(list);
            }
    
        return finalAns;
        
    }
}