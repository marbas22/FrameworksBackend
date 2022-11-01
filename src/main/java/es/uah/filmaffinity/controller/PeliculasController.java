package es.uah.filmaffinity.controller;

import es.uah.filmaffinity.model.Pelicula;
import es.uah.filmaffinity.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class PeliculasController {
    @Autowired
    IPeliculasService peliculasService;

    @GetMapping("/peliculas")
    public List<Pelicula> buscarTodos(){
        return peliculasService.buscarTodos();
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Pelicula> buscarPeliculaPorContainingTitulo(@PathVariable("titulo") String titulo) {
        return peliculasService.buscarPeliculasPorContainingTitulo(titulo);
    }

//    @GetMapping("/peliculas/genero/{genero}")
//    public List<Pelicula> buscarPeliculaPorGenero(@PathVariable("genero") String genero){
//        return peliculasService
//    }
}
