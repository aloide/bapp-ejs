package semana_03.EjercicioEmbarcaciones;

public class Programa {

    public static void main(String[] args) {

        Puerto p = new Puerto();

        if(p.cargarDatosDeBarcos()){
            System.out.println("cantidad de barcos cargados: ");
            System.out.println(p.cantidadBarcos());

        }
        System.out.println("===");

        System.out.println("Total de carga recaudada: ");
        System.out.println(p.calcularTotalCarga());

        System.out.println("===");

        System.out.println("Cantidad de barcos con mucha experiencia");
        System.out.println(p.obtenerBarcosConExp().size());

        System.out.println("===");

        System.out.println("Carga promedio en toneladas de barcos en amarres pares");
        System.out.println(p.calcularCargaPromedio());
    }

}
