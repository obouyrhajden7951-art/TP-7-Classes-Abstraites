package com.example2.tp;

public class Directory extends FsItem {
    private FsItem[] children;
    private int count;

    public Directory(String name) {
        super(name);
        this.children = new FsItem[4];
        this.count = 0;
    }

    public void add(FsItem item) {
        if (count == children.length) {
            FsItem[] tmp = new FsItem[children.length * 2];
            for (int i = 0; i < children.length; i++) {
                tmp[i] = children[i];
            }
            children = tmp;
        }
        children[count] = item;
        count++;
    }

    @Override
    public long getSize() {
        long total = 0;
        for (int i = 0; i < count; i++) {
            total = total + children[i].getSize();
        }
        return total;
    }

    // affiche l'arbre de façon récursive
    public void list(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.println("[D] " + this);

        for (int i = 0; i < count; i++) {
            if (children[i] instanceof Directory) {
                ((Directory) children[i]).list(indent + 1);
            } else {
                for (int j = 0; j < indent + 1; j++) {
                    System.out.print("  ");
                }
                System.out.println("[F] " + children[i]);
            }
        }
    }
}