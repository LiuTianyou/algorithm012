
import java.util.*;

/**
 * @author Liutianyou
 * @date 2020/8/18 11:23 下午
 */
public class SimpleTrie{
  public Map<Character, Trie> nodes;
  public static Character endFlag='#';
  public String show(){
    List<String> res = new ArrayList<String>();
    showAllFunc("",nodes,res);
    System.out.println(res);
    return "";
  }


  /**
   * 深度进入Trie
   * @param s
   * @param nodes
   * @param res
   */
  public void showAllFunc(String s,Map<Character, Trie> nodes,List<String> res){
    if(nodes.isEmpty()){
      res.add(s);
    }
    for (Character character : nodes.keySet()) {
      showAllFunc(s+character,nodes.get(character).nodes,res);
    }
  }
  public SimpleTrie(){
    nodes = new HashMap<Character, Trie>();
  }
  public void insert(String s){
    Map<Character, Trie> temNodes = nodes;
    for(Character c:s.toCharArray()){
      if(!temNodes.containsKey(c)){
        temNodes.put(c,new Trie());
      }
      temNodes = temNodes.get(c).nodes;
    }
    //插入 endFlag
    temNodes.put(endFlag,new Trie());
  }
  public boolean  searchPrev(String s){
    Map<Character, Trie> temNodes = nodes;
    for(Character c :s.toCharArray()){
      if(!temNodes.containsKey(c)){
        return false;
      }else{
        temNodes=temNodes.get(c).nodes;
      }
    }
    return true;
  }

  public boolean search(String s){
    Map<Character, Trie> temNodes = nodes;
    for(Character c :s.toCharArray()){
      if(!temNodes.containsKey(c)){
        return false;
      }else{
        temNodes=temNodes.get(c).nodes;
      }
    }
    return temNodes.containsKey(endFlag);
  }




}