package es.uah.filmaffinity.dao;

import es.uah.filmaffinity.model.Pelicula;
import java.util.List;

public interface IPeliculasDAO {
    List<Pelicula> buscarTodos();
    List<Pelicula> buscarPeliculasPorContainingTitulo(String titulo);
    List<Pelicula> buscarPeliculaPorGenero(String genero);
    List<Pelicula> buscarPeliculaPorNombreActor(String actorName);
    Pelicula buscarPeliculaPorId(Integer idPelicula);
    void guardarPelicula(Pelicula pelicula);
    void eliminarPelicula(Integer idPelicula);
    void actualizarPelicula(Pelicula pelicula);
}
