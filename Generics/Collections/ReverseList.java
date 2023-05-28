import java.util.*;

public class ReverseList {
  
  public static <T> List<T> reverseCopy(List<T> orgList) {
    List<T> revList = new ArrayList<>(orgList);
    int left = 0;
    int right = revList.size() - 1;
    
    while (left < right) {
      T temp = revList.get(left);
      revList.set(left, revList.get(right));
      revList.set(right, temp);
      left++;
      right--;
    }
    
    return revList;
  }
  
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    
    System.out.println("Original List: " + list);
    
    List<Integer> reversed = reverseCopy(list);
    System.out.println("Reversed Copy: " + reversed);
  }
}

