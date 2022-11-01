package es.uah.filmaffinity.dao;

import es.uah.filmaffinity.model.Pelicula;
import java.util.List;

public interface IPeliculasDAO {
    List<Pelicula> buscarTodos();
    List<Pelicula> buscarPeliculasPorContainingTitulo(String titulo);
    void guardarPelicula(Pelicula pelicula);
    void eliminarPelicula(Integer idPelicula);
    void actualizarPelicula(Pelicula pelicula);
    void introducirActor(Integer idPelicula, Integer idActor);
}
