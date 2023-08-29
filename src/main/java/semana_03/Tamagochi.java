package semana_03;

enum EstadoTamagochi{
    MUERTO,
    DESPIERTO,
    VIVO

}

public class Tamagochi {

    public String nombre;
    public boolean estaVivo = true;
    public boolean estaDormido = false;
    public int energia = 50; // valor entre 0 y 100
    public int humor = 3; // valor entre 1 y 5

    private EstadoTamagochi estado;

    private int cantidadIngestas= 0;
    public Tamagochi(String unNombre){
        nombre = unNombre;
    }

    // comportamientos de ingesta
    public void comer(){
        ingerir(10);
    }
    public void beber(){
        ingerir(5);
    }

    private void ingerir(int porcentaje) {
        // control de vida del bicho
        if (estado == EstadoTamagochi.MUERTO) return;

        // calcula la nueva energia a setear
        int nuevaEnergia = porcentaje * energia / 100;

        // se suma la cantidad de ingestas
        cantidadIngestas += 1;


        if(cantidadIngestas > 3){
            decrementarHumor();
            if(cantidadIngestas > 5){
                cambioEstado(EstadoTamagochi.MUERTO);
                return;
            }
            return;
        }
        incrementarHumor();
    }
    private void incrementarHumor(){
        humor++;
    }
    private void decrementarHumor(){
        humor--;
    }

    private void setEnergia(int nuevaEnergia){
        if(energia < 100){
            energia += nuevaEnergia;
        }
    }
    private void setHumor(int nuevoHumor){
        if(0 < humor && humor <= 5 ){
            humor += nuevoHumor;
        }
    }

    // comportamientos de actividades
    public void correr(){

    }
    public void saltar(){ }

    // otros comportamientos
    public void dormir(){

    }
    public void despertar(){

    }

    private void cambioEstado(EstadoTamagochi nuevoEstado ){
        estado = nuevoEstado;
    };

    private String getHumor(){
        switch (humor){
            case 1:
                return "muy enojado";
            case 2:
                return "enojado";
            case 3:
                return "neutral";
            case 4:
                return "contento";
            case 5:
                return "chocho";
            default:
                return "no capo hay un error";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Hola mi nombre es: ");
        sb.append(nombre);
        sb.append(" tengo el nivel de energia: ");
        sb.append(energia);
        sb.append(" tengo un humor: ");
        sb.append(getHumor());
        sb.append(" estoy durmiendo: ");
        sb.append(estaDormido);
        sb.append(" estoy vivo: ");
        sb.append(estaVivo);
        return sb.toString();
    }
}
