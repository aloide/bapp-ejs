package semana_03;

enum EstadoTamagochi{
    MUERTO,
    DESPIERTO,

}

public class Tamagochi {

    public String nombre;
    public boolean estaVivo = true;
    public boolean estaDormido = false;
    public int energia = 50; // valor entre 0 y 100
    public int humor = 3; // valor entre 1 y 5

    private int cantidadIngestas= 0;
    public Tamagochi(String unNombre){
        nombre = unNombre;
    }

    // comportamientos de ingesta

    /**
     * incrementa la energía (que es un número entre 0 y 100 unidades) en 10% de la energía que tiene la mascota y incrementa el humor en 1 nivel.
     */
    public void comer(){
        ingerir(10);

    }
    public void beber(){
        ingerir(5);
    }

    private void ingerir(int porcentaje) {
        int nuevaEnergia = porcentaje * energia / 100;

        cantidadIngestas++;
        if(cantidadIngestas == 5){
            estaVivo = false;
            return;
        }

        if (cantidadIngestas<= 3) {
            setHumor(-1);
            return;
        }
        if (energia < 100) {
            setHumor(1);
        }
        setEnergia(nuevaEnergia);


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

    private boolean cambioEstado(){
        return true;
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
