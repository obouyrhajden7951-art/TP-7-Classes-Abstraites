package com.example2.tp;

public class FileSystem {
    private FsItem[] items;
    private int count;

    public FileSystem() {
        this.items = new FsItem[4];
        this.count = 0;
    }

    public void addRoot(FsItem item) {
        if (count == items.length) {
            FsItem[] tmp = new FsItem[items.length * 2];
            for (int i = 0; i < items.length; i++) {
                tmp[i] = items[i];
            }
            items = tmp;
        }
        items[count] = item;
        count++;
    }

    public void listAll() {
        System.out.println("=== Système de fichiers ===");
        for (int i = 0; i < count; i++) {
            if (items[i] instanceof Directory) {
                ((Directory) items[i]).list(0);
            } else {
                System.out.println("[F] " + items[i]);
            }
        }
    }

    public long totalSize() {
        long somme = 0;
        for (int i = 0; i < count; i++) {
            somme = somme + items[i].getSize();
        }
        return somme;
    }
}