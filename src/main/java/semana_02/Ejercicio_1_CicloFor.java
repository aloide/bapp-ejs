package semana_02;

public class Ejercicio_1_CicloFor {
    public static char c = '*';
    public static void main(String[] args) {
        // Figura1();
        // Figura2();
        // Figura3();
        Figura4();
    }

    private static  void Figura1(){

        String pattern = c + " ";
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {
                System.out.print(pattern);
            }

            System.out.println();

        }
    }

    private static void Figura2(){
        String pattern1 = c + " ";
        String pattern2 = " " + c;
        for (int i = 0; i < 4; i++) {
            if(i %2 != 0){ // si i no es par
                for (int j = 0; j < 5; j++) {
                    System.out.print(pattern2);
                }
            }
            else{ // si i es par
                for (int j = 0; j < 5; j++) {
                    System.out.print(pattern1);
                }
            }
            System.out.println();
        }
    }

    private static void Figura3(){
        int index = 1;
        String pattern = c + " ";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < index; j++) {
                System.out.print(pattern);
            }
            index++;
            System.out.println();
        }
    }

    private static void Figura4(){
        String p = c + " ";
        int index = 1;
        while(index <=4 ){
            System.out.println(multiplyString(p, index));
            index++;
        }

        while (index != 0){
            System.out.println(multiplyString(p, index));
            index--;
        }

    }

    public static String multiplyString(String s, int n){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            sb.append(s);
            sb.append(" ");
        }
        return  sb.toString();
    }

}
