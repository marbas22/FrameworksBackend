package es.uah.filmaffinity.service;

import es.uah.filmaffinity.dao.IActoresDao;
import es.uah.filmaffinity.dao.IActoresJPA;
import es.uah.filmaffinity.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActoresServiceImpl implements IActoresService{

    @Autowired
    IActoresDao actoresDao;

    @Override
    public List<Actor> buscarTodos() {
        return actoresDao.buscarTodos();
    }

    @Override
    public Actor buscarActorPorId(Integer idActor) {
        return actoresDao.buscarActorPorId(idActor);
    }

    @Override
    public List<Actor> buscarActorPorNombre(String nombre) {
        return actoresDao.buscarActorPorNombre(nombre);
    }

    @Override
    public List<Actor> buscarActorPorSexo(String sexo) {
        return actoresDao.buscarActorPorSexo(sexo);
    }

    @Override
    public List<Actor> buscarActorPorPais(String pais) {
        return actoresDao.buscarActorPorPais(pais);
    }

    @Override
    public void guardarActor(Actor actor) {
        if (actoresDao.buscarActorPorId(actor.getId())== null){
            actoresDao.guardarActor(actor);
        }
    }

    @Override
    public void eliminarActor(Integer idActor) {
        if (actoresDao.buscarActorPorId(idActor)!= null){
            actoresDao.eliminarActor(idActor);
        }
    }

    @Override
    public void actualizarActor(Actor actor) {
        if (actoresDao.buscarActorPorId(actor.getId())!= null){
            actoresDao.actualizarActor(actor);
        }
    }
}
