package genericTree;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentRemovalProblem {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<10;i++) li.add(i);
        li.add(3,22);

        for(int i=li.size()-1;i>=0;i--){
            if(li.get(i) % 2 == 0){
                li.remove(li.get(i));
            }
        }

        System.out.println(li);
    }
}
