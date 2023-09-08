package semana_03.EjercicioTamagotchi;


public class Tamagochi {

    public String nombre;
    public int energia = 50; // valor entre 0 y 100
    public int humor = 3; // valor entre 1 y 5

    public boolean estaDormido = false;
    public boolean estaVivo = true;


    private int cantidadIngestas= 0;
    public Tamagochi(String unNombre){
        nombre = unNombre;
    }

    // comportamientos de ingesta
    public void comer(){
        realizarIngesta(10);
    }
    public void beber(){
        realizarIngesta(5);
    }

    private void realizarIngesta(int porcentaje) {
        int nuevaEnergia = calcularPorcentajeEnergia(porcentaje);
        cantidadIngestas++;

        if(!estaVivo) return;
        switch (cantidadIngestas) {
            case 5 -> morir();

            case 3, 4 -> {
                setEnergia(nuevaEnergia);
                decrementarHumor();
            }

            case 0, 1, 2 -> {
                setEnergia(nuevaEnergia);
                incrementarHumor();
            }
        }
    }

    private int calcularPorcentajeEnergia(int porcentaje){
        return porcentaje * energia / 100;
    }

    private void morir(){
        estaVivo = false;
    }

    private void incrementarHumor(){
        if( 0 <= humor && humor < 5 )
            humor++;
    }
    private void decrementarHumor(){
        if(humor != 0)
            humor--;
    }

    private void setEnergia(int nuevaEnergia){
        if(energia < 100){
            energia += nuevaEnergia;
        }
    }

    // #region comportamientos de actividades
    public void correr(){
        //TODO:
        if(!estaVivo) return;
        realizarEjercicio(35);

        //decrementarEnergia(35);
        decrementarHumor();
        decrementarHumor();
    }
    public void saltar(){
        //TODO:
    }

    // #endregion
    private void realizarEjercicio(int porcEnergiaQuemada){


    }

    // otros comportamientos
    public void dormir(){
        //TODO:
    }
    public void despertar() {
        //TODO:
    }



    private String getHumor(){
        return switch (humor) {
            case 1 -> "muy enojado";
            case 2 -> "enojado";
            case 3 -> "neutral";
            case 4 -> "contento";
            case 5 -> "chocho";
            default -> "no capo hay un error";
        };
    }

    @Override
    public String toString() {
        String sb = "Hola mi nombre es: " + nombre +
                " tengo el nivel de energia: " +
                energia +
                " tengo un humor: " +
                getHumor() +
                " estoy durmiendo: " +
                estaDormido +
                " estoy vivo: " +
                estaVivo;
        return sb;
    }
}
