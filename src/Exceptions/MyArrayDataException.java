package Exceptions;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int x, int y) {
        super(x + " " + y);
    }
}
