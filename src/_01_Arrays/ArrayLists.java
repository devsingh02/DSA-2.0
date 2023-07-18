package _01_Arrays;/* ArrayList -> Array + dynamic size (indexed✔)
 Internal working -> there is actually a fixed size, but when that size is reached, a new array is
                       created of size [n+n/2+1] and all elements are copied in it. Previous array is deleted.

   Advantages over Array :-
   Dynamic Size  ✔✔✔
   list.add(value) : O(1)  ✔✔✔
   list.get(index) : O(1)   ✔✔✔   *** MAIN ADVANTAGE
   list.add(index,value) : O(n)
   list.indexOf(value) : O(n)
   list.contains(value) : O(n) **
   list.set(index,value) : O(1)
   list.remove(index) : O(n) for beginning ir middle  ||  O(1) if last index is removed ***
   list.remove(Integer.valueOf(value)) : O(n)   [without index]
   Collections.sort(list) : O(nlogn)
*/
// Arrays are FASTER than ArrayLists : so prefer them when possible

// table.add(0, x) -> X         //shifts all else, put x at 0
// table.set(0, x) -> Correct   //replaces 0

import java.util.*;

public class ArrayLists {
    public static void main(String[] args) {
        // ANY OTHER DATATYPE OTHER THAN INT :- DIRECT
        String[] s = {"a", "b", "c"};
        List<String> list1 = new ArrayList<>(Arrays.asList(s)); //O(n) //List or ArrayList

        // FOR INT :- LOOP
        int[] a = {7, 8, 9};
        ArrayList<Integer> list2 = new ArrayList<>();  

        for (int I : a) list2.add(I);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.addAll(list2); //adding list2 to list

        System.out.println(list); // proper display

        System.out.println(list.get(1));

        System.out.println(list.contains(2));

        list.add(0, 10);
        System.out.println(list);

        list.set(1, 20);  //index,element
        System.out.println(list);

        list.remove(3);
        list.remove(Integer.valueOf(5));
        System.out.println(list);

        Collections.sort(list); // O(nlogn)
        System.out.println(list);

        // ITERATION
        // METHOD 1
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        // METHOD 2
        for (Integer I : list) {
            System.out.print(I + " ");
        }
        System.out.println();
        // METHOD 3
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        list.clear(); // clears list
        System.out.println(list);
    }
}

/*
IMPORTANT NOTES :-

1.   List<Integer> curr = new ArrayList<>(table.get(i)); // call by value
     List<Integer> upd = new ArrayList<>(table.get(i + num)); // call by reference

2.   List<Integer> list = new ArrayList<>( SIZE / LIST );

3.   List<Integer> list = new ArrayList<>(null); -> ERROR

4.   for (List<String> subArray : table.get(i)) {
        List<String> newArray = new ArrayList<>(subArray);
        newArray.add(word);
        newCombinations.add(newArray);
     }

5.   FASTER than Stack
 */
