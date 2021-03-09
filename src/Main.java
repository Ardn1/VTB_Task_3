import java.util.Random;
import Exceptions.MyArrayDataException;
import Exceptions.MyArraySizeException;

public class Main {
    public static void sumStringMatrix(String[][] matrix) throws MyArrayDataException, MyArraySizeException {
        if (matrix.length != 4 || matrix[0].length != 4)
            throw new MyArraySizeException();
        int intSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                try {
                    intSum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j); //Такое задание
                }
            }
        }
        System.out.println("Сумма чисел: " + Integer.toString(intSum));
    }

    public static void main(String[] args)  {
        String[][] matrix = new String[4][4];
        for (String[] arrayS : matrix) {
            for (int i = 0; i < arrayS.length; i++) {
                arrayS[i] = Long.toString(Math.round(Math.random()*100));
            }
        }
        try {
            sumStringMatrix(matrix);
        } catch (MyArraySizeException e) {
            System.out.println("Неправильный размер массива");
        } catch (MyArrayDataException e) {
            System.out.println("Неправильное содержимое массива");
        }
        matrix[1][3] = "dfsa";
        try {
            sumStringMatrix(matrix);
        } catch (MyArraySizeException e) {
            System.out.println("Неправильный размер массива");
        } catch (MyArrayDataException e) {
            System.out.println("Неправильное содержимое массива в ячейке " + e.getMessage());
        }
    }
}
