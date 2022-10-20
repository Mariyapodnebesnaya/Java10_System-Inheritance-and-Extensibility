package ru.netology.domane;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public boolean matches(String search) {
        boolean matches = super.matches(search);
        if (matches) {
            return true;
        } else {
            if (getAuthor().contains(search)) {
                return true;
            } else {
                return false;
            }
        }
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
