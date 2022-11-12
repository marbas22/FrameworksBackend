package es.uah.filmaffinity.dao;
import es.uah.filmaffinity.model.Actor;
import es.uah.filmaffinity.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ActoresDAOImpl implements IActoresDao {

    @Autowired
    IActoresJPA actoresJPA;

    @Autowired
    IPeliculasJPA peliculasJPA;

    @Override
    public List<Actor> buscarTodos() {
        return actoresJPA.findAll();
    }

    @Override
    public Actor buscarActorPorId(Integer idActor) {
        Optional<Actor> optional = actoresJPA.findById(idActor);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Actor> buscarActorPorNombre(String nombre) {
        return actoresJPA.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Actor> buscarActorPorSexo(String sexo)
    {
        return actoresJPA.findBySexoContainingIgnoreCase(sexo);
    }
    @Override
    public void guardarActor(Actor actor) {
        actoresJPA.save(actor);
    }

    @Override
    public void eliminarActor(Integer idActor) {
        Optional<Actor> optional = actoresJPA.findById(idActor);
        if (optional.isPresent()) {
            Actor actor = optional.get();
            List<Pelicula> peliculas = actor.getPeliculas();
            for (Pelicula pelicula: peliculas) {
                peliculas.remove(actor);
            }
        }
        actoresJPA.deleteById(idActor);
    }

    @Override
    public void actualizarActor(Actor actor) {
        actoresJPA.save(actor);
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
