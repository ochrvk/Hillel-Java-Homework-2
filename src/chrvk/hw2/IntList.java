package chrvk.hw2;

public interface IntList {

    boolean add(int element);

    boolean add(int index, int element);

    void clear();

    int get(int index);

    boolean isEmpty();

    boolean remove(int index);

    boolean removeByValue(int value);

    boolean set(int index, int element);

    int size();

    IntList subList(int fromIndex, int toIndex);

    int[] toArray();
}