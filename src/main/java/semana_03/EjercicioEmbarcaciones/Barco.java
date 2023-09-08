package semana_03.EjercicioEmbarcaciones;

public class Barco {

    public String matricula;
    public int nroMuelle;
    public float capacidadDeCarga;
    public double costoAlquiler;
    public Capitan comandante;


    public Barco(String csvLine) {
        // X4R4I4,1,55137,4313.88, 41BA5DC0-CA64-9061-3BD9-562B67C3C815,Wylie,Calderon,27
        String[] col = csvLine.split(",");
        matricula = col[0];
        nroMuelle = Integer.parseInt(col[1]);
        capacidadDeCarga = Float.parseFloat(col[2]);
        costoAlquiler = Float.parseFloat(col[3]);

        comandante = new Capitan(
                col[4], // guid
                col[5], // nombre
                col[6], // apellido
                Integer.parseInt(col[7]) // edad
        );
    }

}
