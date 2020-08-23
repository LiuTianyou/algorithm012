/**
 * @author Liutianyou
 * @date 2020/8/20 10:48 下午
 */
import java.util.*;

public class FindWords {

    public List<String> findWords(char[][] board, String[] words){
      Trie t = new Trie();
      for(String s:words){
        t.insert(s);
      }
      t.show();
      Set<String> ans = new HashSet();
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board[i].length;j++){
          dp(ans,"",i,j,board.length,board[0].length,board,t);
        }
      }
      ArrayList<String> arrayList = new ArrayList(ans);
      arrayList.sort(String::compareTo);
      return arrayList;
    }
    public void dp (Set<String> ans , String s,int x,int y,int m,int n,char[][] board, Trie t){
      System.out.println(s);
      if(!ans.contains(s) && t.search(s)){
        ans.add(s);
        return;
      }
      int[][] step ={{0,-1},{0,1},{1,0},{-1,0}};
      if(x<0||x>=m||y<0||y>=n||board[x][y]=='@'||!t.searchPrev(s)){
        return ;
      }
      char tem = board[x][y];

      for (int[] ints : step) {
        board[x][y] = '@';
        dp(ans, s + tem, x + ints[0], y + ints[1], m, n, board, t);
        board[x][y] = tem;
      }
    }


  public static void main(String[] args) {
    FindWords findWords = new FindWords();
    char[][] board = new char[][]{{'s','e','e','n','e','w'},{'t','m','r','i','v','a'},{'o','b','s','i','b','d'},{'w','m','y','s','e','n'},{'l','t','s','n','s','a'},{'i','e','z','l','g','n'}};
    String[] words = new  String[]{};
    System.out.println( findWords.findWords(board,words));
  }
  }
  class Trie{
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
    public Trie(){
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
