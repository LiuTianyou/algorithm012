/**
 * @author Liutianyou
 * @date 2020/8/16 11:34 下午
 */

import java.util.*;

public class LeastInterval {

  public int leastInterval(char[] tasks, int n) {
    int[] map = new int[26];
    for (char c : tasks) {
      map[c - 'A']++;
    }
    Arrays.sort(map);
    int time = 0;
    while (map[25] > 0) {
      int i = 0;
      while (i <= n) {
        if (map[25] == 0) {
          break;
        }
        if (i < 26 && map[25 - i] > 0) {
          map[25 - i]--;
        }
        time++;
        i++;
      }
      Arrays.sort(map);
    }
    return time;
  }

}
