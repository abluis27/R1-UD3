package main.control;

import jakarta.persistence.*;
import main.model.Autor;

import java.util.List;

public class GestorEntidadAutor {
   private EntityManager gestorEntidades;
   private final String UNIDAD = "UnidadAutor";

   public GestorEntidadAutor() {
       EntityManagerFactory entityManagerFactory =
               Persistence.createEntityManagerFactory(UNIDAD);
      this.gestorEntidades = entityManagerFactory.createEntityManager();
   }

    public void registrarAutor(Autor nuevoAutor) {
        gestorEntidades.getTransaction().begin();
        gestorEntidades.persist(nuevoAutor);
        gestorEntidades.getTransaction().commit();
    }

    public List<Autor> obtenerAutores() {
       return gestorEntidades.createQuery(
               " SELECT autor FROM Autor autor", Autor.class).getResultList();
    }

   public Autor buscarAutorPorNombreCompleto(String nombre, String apellidos)
           throws NoResultException {
       String sql = "SELECT autor FROM Autor autor" +
               " WHERE autor.nombre =:nombre AND autor.apellido = :apellidos";
       TypedQuery<Autor> query = gestorEntidades.createQuery(sql, Autor.class);
       query.setParameter("nombre", nombre);
       query.setParameter("apellidos", apellidos);
       return query.getSingleResult();
   };

    public void actualizarAutor(Autor autorModificado) {
        gestorEntidades.getTransaction().begin();
        gestorEntidades.merge(autorModificado);
        gestorEntidades.getTransaction().commit();
    }

    public void eliminarAutor(Autor autor) {
       gestorEntidades.getTransaction().begin();
       gestorEntidades.remove(autor);
       gestorEntidades.getTransaction().commit();
    }

}
