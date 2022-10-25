package ru.netology;

import ru.netology.domane.Product;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String s) {
        super(s);
    }


}
