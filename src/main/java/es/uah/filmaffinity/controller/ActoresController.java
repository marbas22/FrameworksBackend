package es.uah.filmaffinity.controller;

import es.uah.filmaffinity.model.Actor;
import es.uah.filmaffinity.model.Pelicula;
import es.uah.filmaffinity.service.IActoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActoresController {

    @Autowired
    IActoresService actoresService;

    @GetMapping("/actores")
    public List<Actor> buscarTodos(){
        return actoresService.buscarTodos();
    }

    @GetMapping("/actores/{id}")
    public Actor buscarActorPorId(@PathVariable("id") Integer id){
        return actoresService.buscarActorPorId(id);
    }

    @GetMapping("/actores/nombre/{nombre}")
    public List<Actor> buscarActoresPorNombre(@PathVariable("nombre") String nombre) {
        return actoresService.buscarActorPorNombre(nombre);
    }

    @GetMapping("/actores/sexo/{sexo}")
    public List<Actor> buscarActoresPorSexo(@PathVariable("sexo") String sexo) {
        return actoresService.buscarActorPorSexo(sexo);
    }

    @PostMapping("/actores")
    public void guardarActor(@RequestBody Actor actor){
        actoresService.guardarActor(actor);
    }

    @PutMapping("/actores")
    public void actualizarActor(@RequestBody Actor actor){
        actoresService.actualizarActor(actor);
    }

    @DeleteMapping("/actores/{id}")
    public void eliminarActor(@PathVariable("id") Integer id){
        actoresService.eliminarActor(id);
    }

    @GetMapping("/actores/anadir/{idp}/{ida}")
    public void anadirActorToPelicula(@PathVariable("idp") Integer idp, @PathVariable("ida") Integer ida){
        actoresService.introducirActor(idp,ida);
    }

}
