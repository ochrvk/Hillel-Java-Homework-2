package chrvk.javaelementary.hw2;

import java.util.Arrays;

public class IntArrayList implements IntList {

    private int size = 0;
    private int[] elementData = new int[10];

    public IntArrayList(int[] array) {
        elementData = array;
        size = array.length;
    }

    public IntArrayList() {
    }

    @Override
    public int get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be in 0.." + size);
        }
        return elementData[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        elementData = new int[10];
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        System.arraycopy(elementData, 0, result, 0, size);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    @Override
    public boolean add(int element) {
        if (elementData.length <= size + 1) {
            int[] tmpArray = new int[elementData.length * 3 / 2 + 1];
            System.arraycopy(elementData, 0, tmpArray, 0, size);
            elementData = tmpArray;
        }
        elementData[size] = element;
        size++;
        return true;
    }

    @Override
    public boolean set(int index, int element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be in 0.." + size);
        }
        elementData[index] = element;
        return true;
    }


    @Override
    public boolean add(int index, int element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be in 0.." + size);
        }
        int[] tmpArray = new int[elementData.length * 3 / 2 + 1];
        System.arraycopy(elementData, 0, tmpArray, 0, index);
        tmpArray[index] = element;
        System.arraycopy(elementData, index, tmpArray, index + 1, size - index);
        elementData = tmpArray;
        size++;
        return true;
    }

    @Override
    public boolean remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index should be in 0.." + size);
        }
        System.arraycopy(elementData, index + 1, elementData, index, size - 2);
        size--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        int[] tmpArray = new int[elementData.length];
        int tmp = 0;

        for (int i = 0; i < elementData.length; i++) {
            if (i + 1 < elementData.length
                    && elementData[i] != value) {
                tmpArray[tmp] = elementData[i];
                tmp++;
            } else if (elementData[i] == value) {
                --size;
            }
        }
        System.arraycopy(tmpArray, 0, elementData, 0, size);
        return true;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index should be in 0.." + size);
        }
        int[] tmpArray = new int[toIndex - fromIndex];
        System.arraycopy(elementData, fromIndex, tmpArray, 0, tmpArray.length);
        return new IntArrayList(tmpArray);
    }
}
