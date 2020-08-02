import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Liutianyou
 * @date 2020/8/1 11:05 下午
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      //移除开始的单词
      wordList = new ArrayList<>(wordList);
      wordList.remove(beginWord);
      //将单词列表的单词转换为通用状态
      Map<String, List<String>> words = new HashMap();
      for(String tem:wordList){
        for(int i = 0; i<tem.length(); i++){
          String word = tem.substring(0,i)+"*"+tem.substring(i+1);
          List<String> list = words.getOrDefault(word,new ArrayList<String>());
          list.add(tem);
          words.put(word,list);
        }
      }
      int count = 0;
      Queue<String> queue = new LinkedList();
      Set<String> visited = new HashSet<>();
      queue.offer(beginWord);
      while(queue.peek()!=null){
        count++;
        int  size = queue.size();
        for (int m = 0; m <size ; m++) {
          String s = queue.poll();
          for(int i=0;i<s.length();i++){
            String word = s.substring(0,i)+"*"+s.substring(i+1);
            if(words.get(word)!=null){
              for(String temp :words.get(word)){
                if(temp.equals(endWord)){
                  return count+1;
                }else{
                  if(!visited.contains(temp)){
                    queue.offer(temp);
                    visited.add(temp);
                  }
                }
              }
            }


          }

        }


      }
      return 0;
    }

  public static void main(String[] args) {
//     List<String> strings = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
     List<String> strings = Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot");
//     List<String> strings = Arrays.asList("hot","dog","dot");
//     String beginWords="hit";
     String beginWords="hot";
//    String endWords="cog";
    String endWords="dog";
    LadderLength ladderLength = new LadderLength();
    System.out.println(ladderLength.ladderLength(beginWords,endWords,strings));

  }


}
