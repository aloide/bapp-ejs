import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio_2_ISBN {


    public static void main(String[] args) {
        String entrada = "1-55615-507-7";

        char[] cs = entrada.toCharArray();
        List<Integer> isbnNumbers = new ArrayList<>();

        for (char c : cs) {
            if(c != '-'){
                int charToInt = c -'0';
                isbnNumbers.add(charToInt);
            }
        }

        if(isbnMultiplier(isbnNumbers) % 11 == 0){
            System.out.println("ISBN Valid");
        }
        else
            System.out.println("ISBN No valid");

    }

    private static int isbnMultiplier(List<Integer> isbnNumbers){
        int index = 10;
        int total = 0;
        for (int n : isbnNumbers) {
            total += n * index;
            index--;
        }
        return total;
    }

}
