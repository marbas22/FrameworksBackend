package es.uah.filmaffinity.dao;
import es.uah.filmaffinity.model.Actor;
import java.util.List;

public interface IActoresDao {
    List<Actor> buscarTodos();
    Actor buscarActorPorId(Integer idActor);
    List<Actor> buscarActorPorNombre(String nombre);
    List<Actor> buscarActorPorSexo(String sexo);
    List<Actor> buscarActorPorPais(String pais);
    void guardarActor(Actor actor);
    void eliminarActor(Integer idActor);
    void actualizarActor(Actor actor);
    void introducirActor(Integer idPelicula, Integer idActor);
}
