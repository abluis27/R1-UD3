package main.control;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import main.model.Autor;

public class GestorBBDD {
   private EntityManager gestorEntidades;
   private final String UNIDAD = "UnidadAutor";

   public GestorBBDD() {
       EntityManagerFactory entityManagerFactory =
               Persistence.createEntityManagerFactory(UNIDAD);
      this.gestorEntidades = entityManagerFactory.createEntityManager();
   }

   // TODO: CREATE
    public void registrarAutor(Autor nuevoAutor) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("UnidadAutor");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(nuevoAutor);
        entityManager.getTransaction().commit();
    }

    // TODO: READ
    // READ ALL
    // FIND
    // TODO: UPDATE
    // TODO: DELETE
}
