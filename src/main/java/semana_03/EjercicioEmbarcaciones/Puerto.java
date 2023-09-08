package semana_03.EjercicioEmbarcaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Clase que contiene todos los barcos que necesitan ser procesados para generar
 * la informacion del sistema pedido
 */
public class Puerto {

    List<Barco> barcos;

    private String pathFile = "C:\\Users\\Alito\\repos\\JavaBAPP\\BackendAplicaciones\\src\\main\\java\\semana_03\\EjercicioEmbarcaciones\\barcos.csv";

    public Puerto(){ }

    public boolean cargarDatosDeBarcos(){
        boolean headers = true;
        barcos = new ArrayList<>();
        try{

            File f = new File(pathFile);

            Scanner sc = new Scanner(f);

            while(sc.hasNext()){
                String line = sc.nextLine();

                if(headers) {
                    headers = false;
                    continue;
                }

                // trabajo con la linea
                Barco b = new Barco(line);
                barcos.add(b);

            }

            sc.close();

        }catch (Exception e){
            return false;
        }

        return true;
    }

    public int cantidadBarcos(){
        return barcos.size();
    }

    public double calcularTotalCarga(){
        if(barcos.isEmpty()) return 0D;

        double total = 0;

        for(Barco b: barcos){
            total +=  b.costoAlquiler *15;
        }

        return total;
    }


    public List<Barco>  obtenerBarcosConExp(){
        List<Barco> resultados = new ArrayList<>();

        for(Barco b : barcos){
            if(b.comandante.age > 18){
                resultados.add(b);
            }
        }

        return resultados;
    }

    public double calcularCargaPromedio(){

        List<Barco> barcosPares = new ArrayList<>();
        for (Barco barco : barcos) {
            if (barco.nroMuelle % 2 == 0) {
                barcosPares.add(barco);
            }
        }

        double totalCargaBarcosPares = 0;
        for(Barco b : barcosPares){
            totalCargaBarcosPares += b.capacidadDeCarga;
        }

        return totalCargaBarcosPares / barcosPares.size();

    }

}
