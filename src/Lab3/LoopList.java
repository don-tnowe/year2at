package Lab3;

public class LoopList <T>{
    public int size = 0;
    public LoopListItem <T> head;
    public LoopListItem <T> tail;
    public LoopListItem <T> cur;

    public LoopList () { }

    public LoopList (T[] from) {
        add(from);
    }

    public void add(T value)
    {
        LoopListItem <T> newItem = new LoopListItem<T>(value, head);
        if (head == null)
            head = newItem;
        if (tail != null)
            tail.next = newItem;
        tail = newItem;
        if (cur == null)
            cur = newItem;
        size++;
    }

    public void add(T[] value)
    {
        for (int i = 0; i < value.length; i++)
            add(value[i]);
    }

    public T get(int idx)
    {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("size " + idx + " is bigger than " + size);
        if (idx == 0)
            return head.value;
        if (idx == size - 1)
            return tail.value;
        LoopListItem<T> curItem = head;
        for (int i = 0; i < idx - 1; i++)
        {
            curItem = curItem.next;
        }
        return curItem.value;
    }

    public T get()
    {
        return cur.value;
    }

    public void resetCur()
    {
        cur = null;
    }

    public T next()
    {
        if (cur == null)
            cur = head;
        else
            cur = cur.next;
        return cur.value;
    }

    public void insert(T value, int before)
    {
        if (before < 0 || before >= size)
            throw new IndexOutOfBoundsException("size " + before + " is bigger than " + size);
        LoopListItem<T> newItem = new LoopListItem<T>(value, null);
        if (before == 0)
        {
            newItem.next = head;
            head = newItem;
            tail.next = newItem;
            return;
        }
        LoopListItem<T> curItem = head;
        for (int i = 0; i < before - 1; i++)
        {
            curItem = curItem.next;
        }
        newItem.next = curItem.next;
        curItem.next = newItem;
        size++;
    }

    public void insert(T value)
    {
        if (cur == null)
            cur = head;
        LoopListItem<T> newItem = new LoopListItem<T>(value, cur.next);
        cur.next = newItem;
        cur = newItem;
        size++;
    }

    public void remove(int idx)
    {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("size " + idx + " is bigger than " + size);
        if (idx == 0)
        {
            head = head.next;
            tail.next = head;
            return;
        }
        LoopListItem<T> curItem = head;
        for (int i = 0; i < idx - 1; i++)
        {
            curItem = curItem.next;
        }
        curItem.next = curItem.next.next;
        size--;
        if (size == 0)
        {
            head = null;
            tail = null;
            cur = null;
        }
    }

    public int removeAll(T value, int count)
    {
        int removed = 0;
        LoopListItem<T> curItem = head;
        for (int i = 0; i <= size || removed == count; i++)
        {
            if (curItem.next.value.equals(value))
            {
                curItem.next = curItem.next.next;
                size--;
                removed++;
            }
            curItem = curItem.next;
        }
        if (size == 0)
        {
            head = null;
            tail = null;
            cur = null;
        }
        return removed;
    }

    public int removeAll(T value)
    {
        return removeAll(value, -1);
    }

    public int find(T value)
    {
        LoopListItem<T> curItem = head;
        for (int i = 0; i < size; i++)
        {
            if (curItem.value.equals(value))
                return i;
            curItem = curItem.next;
        }
        return -1;
    }
}

class LoopListItem <T>{
    public T value;
    public LoopListItem<T> next;

    public LoopListItem (T value, LoopListItem<T> next) {
        this.value = value;
        this.next = next;
    }
}
