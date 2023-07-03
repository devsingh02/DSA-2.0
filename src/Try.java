import java.util.ArrayList;
import java.util.List;

public class Try {
    public static void main(String[] args) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i <= 10; i++) table.add(null);
        table.set(0, new ArrayList<>()); //[ [] , null , .....]
        System.out.println(table);
    }
}
