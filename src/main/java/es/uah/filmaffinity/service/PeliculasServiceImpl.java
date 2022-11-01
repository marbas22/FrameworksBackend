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
    public void guardarPelicula(Pelicula pelicula) {
        peliculasDAO.guardarPelicula(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        peliculasDAO.eliminarPelicula(idPelicula);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculasDAO.actualizarPelicula(pelicula);
    }

    @Override
    public void introducirActor(Integer idPelicula, Integer idActor) {
        peliculasDAO.introducirActor(idPelicula,idActor);
    }
}
