package es.uah.filmaffinity.dao;


import es.uah.filmaffinity.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface IPeliculasJPA extends JpaRepository<Pelicula, Integer>{

    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
}
