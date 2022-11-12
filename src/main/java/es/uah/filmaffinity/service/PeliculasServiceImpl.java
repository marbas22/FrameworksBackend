package es.uah.filmaffinity.service;

import es.uah.filmaffinity.dao.IPeliculasDAO;
import es.uah.filmaffinity.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeliculasServiceImpl implements IPeliculasService {

    @Autowired
    IPeliculasDAO peliculasDAO;

    @Override
    public List<Pelicula> buscarTodos() {
        return peliculasDAO.buscarTodos();
    }

    @Override
    public List<Pelicula> buscarPeliculasPorContainingTitulo(String titulo) {
        return peliculasDAO.buscarPeliculasPorContainingTitulo(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorGenero(String genero) {
        return peliculasDAO.buscarPeliculaPorGenero(genero);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorNombreActor(String actorName) {
        return peliculasDAO.buscarPeliculaPorNombreActor(actorName);
    }

    @Override
    public Pelicula buscarPorId(Integer id) {
        return peliculasDAO.buscarPeliculaPorId(id);
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculasDAO.guardarPelicula(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        if (peliculasDAO.buscarPeliculaPorId(idPelicula)!=null) {
            peliculasDAO.eliminarPelicula(idPelicula);
        }
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        if (peliculasDAO.buscarPeliculaPorId(pelicula.getId())!=null) {
            peliculasDAO.actualizarPelicula(pelicula);
        }
    }
}
