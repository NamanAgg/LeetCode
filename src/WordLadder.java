//***************127. Word Ladder
// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
// beginWord -> s1 -> s2 -> ... -> sk such that:
// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation
// sequence from beginWord to endWord, or 0 if no such sequence exists.

// Example 1:
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

// Example 2:
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

// Constraints:
// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.
import java.util.*;
import java.io.*;
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int idx = find(wordList,beginWord);
        int idx1 = find(wordList,endWord);
        
        if(idx1==-1) return 0;
        
        if(idx==-1) wordList.add(beginWord);
        
        ArrayList<Integer>[]graph = new ArrayList[wordList.size()];
        
        makeGraph(graph,wordList);
        
        LinkedList<Integer>que = new LinkedList<>();
        boolean[] vis = new boolean[wordList.size()];
        que.add((idx!=-1)?idx:(wordList.size()-1));
        
        int level=0;
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                int i = que.removeFirst();
            
                if(i==idx1) return level+1;
                if(vis[i]) continue;
                
                for(Integer e : graph[i])
                    que.addLast(e);
                
                vis[i]=true;
            }
            level++;
        }
        return 0;
    }
    
    public void makeGraph(ArrayList<Integer>[]graph,List<String>wordList){
        for(int i=0;i<graph.length;i++)
            graph[i]=new ArrayList<>();
        
        for(int i=0;i<wordList.size();i++){
            String word1 = wordList.get(i);
            for(int j=i+1;j<wordList.size();j++)
                String word2=wordList.get(j);
                if(diff(word1,word2)==1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
        }
        
        // displayGraph(graph,wordList);
    }
    
    public int find(List<String> dict,String word){
        for(int i = 0;i<dict.size();i++){
            String tmp = dict.get(i);
            if(tmp.equals(word)) return i;
        }
        
        return -1;
    }
    
    public int diff(String tmp,String word){
        int count=0;
        for(int j=0;j<word.length();j++)
            if(word.charAt(j)!=tmp.charAt(j))
                count++;
        
        return count; 
    }
    
    public void displayGraph(ArrayList<Integer>[]graph,List<String>wordList){
        int count=0;
        for(ArrayList<Integer> e : graph){
            System.out.print(wordList.get(count++)+"=>");
            for(Integer i : e){
                System.out.print(wordList.get(i)+" ");
            }
            System.out.println();
        }
    }
}
