package Lab5;

import MyCollections.*;

public class MyHashtable <T> {
    public int capacity;

    private MyHashtableItem<T>[] items;

    public MyHashtable(int capacity) {
        items = new MyHashtableItem[capacity];
        this.capacity = capacity;
    }

    public void add(String key, T value) {
        items[findItem(key, true)] = new MyHashtableItem<>(key, value);
    }

    public T get(String key) {
        return items[findItem(key, false)].value;
    }

    public void remove(String key) {
        items[findItem(key, false)] = null;
    }

    private int findItem(String key, boolean findEmpty) {
        int startIdx = getHashCode(key);

        for (int i = 0; i < capacity * 64; i++) {
            int curIdx = (startIdx + i * i) % capacity;
            MyHashtableItem<T> item = items[curIdx];

            if (item == null)
                if (findEmpty)
                    return curIdx;
                else
                    continue;

            if (key.equals(item.key))
                return curIdx;
        }

        if (findEmpty)
            throw new TableFullException();

        else
            throw new KeyNotFoundException(key);
    }

    private int getHashCode(String from) {
        int returnValue = from.length() * 256;

        for (char i: from.toCharArray()) {
            returnValue += i;
        }

        return returnValue % capacity;
    }

    public String toString() {
        StringBuilder returnValue = new StringBuilder();

        for (MyHashtableItem<T> i : items)
            if (i != null)
                returnValue.append("(" + i.key + ", " + i.value.toString() + ") \n");
            else
                returnValue.append("() \n");

        return returnValue.toString();
    }
}

class MyHashtableItem <T> {
    public String key;
    public T value;

    public MyHashtableItem(String key, T value) {
        this.key = key;
        this.value = value;
    }
}
