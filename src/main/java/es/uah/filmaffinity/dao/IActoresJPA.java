package es.uah.filmaffinity.dao;

import es.uah.filmaffinity.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IActoresJPA extends JpaRepository<Actor, Integer> {

    List<Actor> findByNombreContainingIgnoreCase(String nombre);
    List<Actor> findBySexoContainingIgnoreCase(String sexo);
    List<Actor> findByPaisNacimiento(String paisNacimiento);
}
