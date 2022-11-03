package es.uah.filmaffinity.dao;
import es.uah.filmaffinity.model.Actor;
import es.uah.filmaffinity.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class PeliculasDAOImpl implements  IPeliculasDAO{

    @Autowired
    IPeliculasJPA peliculasJPA;

    @Autowired
    IActoresJPA actoresJPA;

    @Override
    public List<Pelicula> buscarTodos() {
        return peliculasJPA.findAll();
    }

    @Override
    public List<Pelicula> buscarPeliculasPorContainingTitulo(String titulo) {
        return peliculasJPA.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorGenero(String genero) {
        return peliculasJPA.findByGenero(genero);
    }

    @Override
    public List<Pelicula> buscarPeliculaPorNombreActor(String actorName) {
        return peliculasJPA.findByActoresPeliculas_nombreContainingIgnoreCase(actorName);
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        Optional<Pelicula> optional = peliculasJPA.findById(idPelicula);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void guardarPelicula(Pelicula pelicula) {
        peliculasJPA.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        Optional<Pelicula> optional = peliculasJPA.findById(idPelicula);
        if (optional.isPresent()) {
            Pelicula pelicula = optional.get();
            List<Actor> actores = pelicula.getActores();
            for (Actor actor : actores) {
                System.out.println(actor.getNombre());
                actores.remove(pelicula);
            }
        }
        peliculasJPA.deleteById(idPelicula);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculasJPA.save(pelicula);
    }
}
