package com.example2.tp;

public abstract class FsItem {
    protected String name;

    public FsItem(String name) {
        this.name = name;
    }


    public abstract long getSize();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + getSize() + ")";
    }
}
