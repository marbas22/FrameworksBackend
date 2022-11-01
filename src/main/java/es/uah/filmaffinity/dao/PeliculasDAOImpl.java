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
    public void guardarPelicula(Pelicula pelicula) {
        peliculasJPA.save(pelicula);
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        peliculasJPA.deleteById(idPelicula);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculasJPA.save(pelicula);
    }

    @Override
    public void introducirActor(Integer idPelicula, Integer idActor) {
        Optional<Actor> optionalActor = actoresJPA.findById(idActor);
        if(optionalActor.isPresent()){
            Actor actor = optionalActor.get();
            Optional<Pelicula> optionalPelicula = peliculasJPA.findById(idPelicula);
            if(optionalPelicula.isPresent()){
                actor.addPelicula(optionalPelicula.get());
                actoresJPA.save(actor);
            }
        }
    }
}
