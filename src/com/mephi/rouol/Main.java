package com.mephi.rouol;

public class Main {

    /** returns merged sorted list of two given sorted lists **/
    public static List mergeSortedLists(List A, List B){

        if (A.size() == 0) return B;
        if (B.size() == 0) return A;

        int newlen = A.size() + B.size();
        List mergedList = new List(newlen);
        int headA = 0;
        int headB = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < newlen; i++) {
            if (headA >= A.size()) {
                mergedList.set(b, i);
                headB++;
                continue;
            }
            if (headB >= B.size()) {
                mergedList.set(a, i);
                headA++;
                continue;
            }
            a = (int) A.get(headA);
            b = (int) B.get(headB);
            if (a <= b) {
                mergedList.set(a, i);
                headA++;
            } else {
                mergedList.set(b, i);
                headB++;
            }
        }

        return mergedList;
    }

    public static void main(String[] args) {

        // checking the List
        System.out.println("\n        checking the List\n");
        {
            List list = new List();

            System.out.println(list.isEmpty());

            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);

            System.out.println(list.get(0));

            System.out.println(list.contains(8));
            list.add(8, 1);
            System.out.println(list.contains(8));
            System.out.println(list.indexOf(8));

            System.out.println(list.size());

            System.out.println(list.isEmpty());

            System.out.println(list);
            System.out.println(list.remove(1));
            System.out.println(list);

            list.add(10, 4);
            System.out.println(list);

            System.out.println(list.set(100, 4));
            System.out.println(list);

            List newlist = new List(10, "sdjfhjshdfkjsh");
            System.out.println(newlist);
        }

        // checking the Map
        {
            System.out.println("\n        checking the Map\n");

            Map map = new Map();

            System.out.println(map.isEmpty());

            map.put(0, 10);
            map.put(1, "ааа");
            map.put(17, new List(3, "ыыы"));
            map.put(2, 228);
            map.put(3, "java");
            map.put("dsjfkl", "sdfsdfsdf");
            System.out.println(map);
            System.out.println(map.get("dsjfkl"));
            System.out.println(map.remove(1));
            System.out.println(map.keyContains(100));
            System.out.println(map.get(100, "100"));
            System.out.println(map.keyContains(100));
            System.out.println(map);
            System.out.println(map.getKeys().toString());
            System.out.println(map.getValues().toString());
            System.out.println(map.getEntries().toString());
            System.out.println(map.size());

            System.out.println(map.isEmpty());
        }

        // checking mergeSortedLists
        {
            List a = new List(new Object[]{0, 1, 2, 7, 9});
            List b = new List(new Object[]{-1, 2, 3, 4, 5, 8, 11});
            List merged = mergeSortedLists(a, b);
            System.out.println(merged);
        }

    }
}
