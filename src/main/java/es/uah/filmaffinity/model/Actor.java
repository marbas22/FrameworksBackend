package es.uah.filmaffinity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "actores", schema = "filmaffinitydb")
public class Actor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id_actor;
    private String nombre;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String paisNacimiento;
    @ManyToMany
    @JoinTable(name = "peliculas_has_actores",
            joinColumns = {@JoinColumn(name = "Actores_id_actor", referencedColumnName = "id_actor")},
            inverseJoinColumns = {@JoinColumn(name = "Peliculas_id_pelicula", referencedColumnName = "id_pelicula")})
    @JsonIgnoreProperties("actores")
    private List<Pelicula> peliculas = new ArrayList<>();

    public Actor() {
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public Integer getId() {
        return id_actor;
    }

    public void setId(Integer id_actor) {
        this.id_actor = id_actor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public void addPelicula(Pelicula pelicula) {
        if (pelicula != null) {
            getPeliculas().add(pelicula);
            pelicula.addActor(this);
        }
    }
    public void removePelicula(Pelicula pelicula) {
        if (pelicula != null) {
            pelicula.removeActor(this);
            getPeliculas().remove(pelicula);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(id_actor, actor.id_actor);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_actor);
    }
}