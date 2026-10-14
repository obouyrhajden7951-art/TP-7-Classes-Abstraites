package com.example2.tp;

public class Main {
    public static void main(String[] args) {

        FileItem f1 = new FileItem("notes.txt", 120);
        FileItem f2 = new FileItem("photo.jpg", 2048);
        FileItem f3 = new FileItem("cv.pdf", 512);
        FileItem f4 = new FileItem("Main.java", 300);
        FileItem f5 = new FileItem("readme.md", 80);


        Directory documents = new Directory("Documents");
        documents.add(f1);
        documents.add(f3);

        Directory images = new Directory("Images");
        images.add(f2);

        Directory src = new Directory("src");
        src.add(f4);

        Directory projet = new Directory("Projet");
        projet.add(src);
        projet.add(f5);

        Directory home = new Directory("Home");
        home.add(documents);
        home.add(images);
        home.add(projet);


        FileSystem fs = new FileSystem();
        fs.addRoot(home);
        fs.addRoot(new FileItem("autoexec.bat", 10));

        fs.listAll();
        System.out.println();
        System.out.println("Taille totale : " + fs.totalSize());
    }
}