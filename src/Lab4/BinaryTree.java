package Lab4;

import MyCollections.*;

public class BinaryTree<T> {
    public BinaryTreeNode<T> root;

    public T get(int key){
        return findNode(key).value;
    }

    public BinaryTreeNode<T> findNode(int key) {
        BinaryTreeNode<T> cur = root;

        while (true) {
            if (cur == null)
                throw new KeyNotFoundException(Integer.toString(key));

            if (key == cur.key)
                return cur;

            cur = cur.getChild(key > cur.key);
        }
    }

    public void add(int key, T value) {
        if (root == null) {
            root = new BinaryTreeNode<>(key, value, null);
            return;
        }

        BinaryTreeNode<T> cur = root;

        while(true) {
            if (key == cur.key)
                throw new DuplicateKeyException(Integer.toString(key));

            boolean dir = key > cur.key;

            if (cur.hasChild(dir))
                cur = cur.getChild(dir);

            else {
                cur.setChild(dir, new BinaryTreeNode<>(key, value, cur));
                break;
            }
        }
    }

    public void remove(int key) {
        if (root == null)
            throw new KeyNotFoundException(Integer.toString(key));

        else if (key != root.key)
            findNode(key).remove();

        else
            root = root.remove();
    }

    public T getHighest() {
        BinaryTreeNode<T> cur = root;

        while (cur.hasChild(true))
            cur = cur.getChild(true);

        return cur.value;
    }

    public T getLowest() {
        BinaryTreeNode<T> cur = root;

        while (cur.hasChild(false))
            cur = cur.getChild(false);

        return cur.value;
    }

    public void printOrdered() {
        if (!root.hasChild(false))
        {
            System.out.print("\n");
            System.out.println("Tree empty.");
        }
        System.out.print("\n");
        root.PrintTree();
        System.out.print("\n");
    }
}


class BinaryTreeNode<T> {
    public int key;
    public T value;

    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> childHigher;
    private BinaryTreeNode<T> childLower;

    public BinaryTreeNode(int key, T value, BinaryTreeNode<T> parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }

    public BinaryTreeNode<T> getChild(boolean higher) {
        if (higher)
            return childHigher;
        else
            return childLower;
    }

    public void setChild(boolean higher, BinaryTreeNode<T> child) {
        if (higher) {
            childHigher = child;
            if (child != null)
                childHigher.parent = this;
        } else {
            childLower = child;
            if (child != null)
                childLower.parent = this;
        }
    }

    public boolean hasChild(boolean higher) {
        return getChild(higher) != null;
    }

    public BinaryTreeNode<T> getLowestChild() {
        BinaryTreeNode<T> cur = this;

        while (cur.childLower != null)
            cur = cur.childLower;

        return cur;
    }

    public BinaryTreeNode<T> getHighestChild() {
        BinaryTreeNode<T> cur = this;

        while (cur.childHigher != null)
            cur = cur.childHigher;

        return cur;
    }

    public BinaryTreeNode<T> remove() {
        if (parent != null) {
            boolean dir = parent.getChild(true) == this;

            if (childLower == null && childHigher == null)
                parent.setChild(dir, null);

            else if (childLower == null || childHigher == null)
                parent.setChild(dir, getChild(childLower == null));

            else {
                BinaryTreeNode<T> parentsNewChildNode;

                if (dir)
                    parentsNewChildNode = childLower.getHighestChild();

                else
                    parentsNewChildNode = childHigher.getLowestChild();

                parentsNewChildNode.remove();
                parent.setChild(dir, parentsNewChildNode);
                parentsNewChildNode.setChild(false, childLower);
                parentsNewChildNode.setChild(true, childHigher);
            }

            return this;
        }

        else {
            if (childLower == null && childHigher == null)
                return null;

            else if (childLower == null || childHigher == null)
                return getChild(childLower == null);

            else {
                BinaryTreeNode<T> newRoot = childLower.getHighestChild();

                newRoot.remove();
                newRoot.setChild(true, childHigher);
                newRoot.setChild(false, childLower);
                return newRoot;
            }
        }
    }

    public void PrintTree() {
        PrintTree(0, 0);
    }

    public void PrintTree(int currentDepth, int dir) {
        if (childLower != null)
            childLower.PrintTree(currentDepth + 1, -1);

        char dirChar = switch (dir) {
            case -1 -> '┍';
            case 1 -> '┗';
            default -> '━';
        };

        System.out.println("  ".repeat(currentDepth) + dirChar + " (" + key + ", " + value + ")");

        if (childHigher != null)
            childHigher.PrintTree(currentDepth + 1, 1);
    }
}


