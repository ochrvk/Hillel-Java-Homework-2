package chrvk.JavaElementary.hw2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int min = 10;
        int max = 90;
        int diff = (max - min);

        IntList list = new IntArrayList();

        for (int i = 0; i < 20; i++) {
            list.add(i, random.nextInt((diff + 1) + min));
        }

        System.out.println("Original list: " + list);

        int tmp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j - 1) > list.get(j)) {
                    tmp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, tmp);
                }
            }
        }

        System.out.println("Sorted list:   " + list);
    }
}
