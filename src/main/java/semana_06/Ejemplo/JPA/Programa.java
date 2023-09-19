package semana_06.Ejemplo.JPA;

import semana_06.Ejemplo.JPA.Model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Programa {

    public static void main(String[] args) {
        // Creamos un Factory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BLYAT");

        // creamos el usuario
        crearUsuario(emf);
    }


    private static void crearUsuario(EntityManagerFactory emf){

        // creamos un objeto a partir del factory
        var em = emf.createEntityManager();

        em.getTransaction().begin();
        // Creamos el usuario dentro de la transaccion para
        Usuario u = new Usuario("alito", "alito@email.com");
        em.persist(u);
        em.getTransaction().commit();

        em.close();
    }

}
