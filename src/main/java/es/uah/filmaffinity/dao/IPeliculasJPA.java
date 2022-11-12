package es.uah.filmaffinity.dao;


import es.uah.filmaffinity.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface IPeliculasJPA extends JpaRepository<Pelicula, Integer>{
    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);
    List<Pelicula> findByGenero(String genero);
    List<Pelicula> findByActoresPeliculas_nombreContainingIgnoreCase(@Param("n") String n);
}
