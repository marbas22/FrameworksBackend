package es.uah.filmaffinity.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "peliculas", schema = "filmaffinitydb")
public class Pelicula {
    @Id
    @Column(name = "id_pelicula", nullable = false)
    private Integer id_pelicula;

    @Column(name = "titulo", nullable = false, length = 45)
    private String titulo;

    @Column(name = "anio")
    private LocalDate anio;

    @Column(name = "duracion", columnDefinition = "TINYINT UNSIGNED")
    private Short duracion;

    @Column(name = "pais", length = 120)
    private String pais;

    @Lob
    @Column(name = "direccion")
    private String direccion;

    @Lob
    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "imagen")
    private byte[] imagen;

    @Column(name = "genero")
    private String genero;

    @ManyToMany(mappedBy = "peliculas")
    private List<Actor> actores = new ArrayList<>();

    public List<Actor> getActores() {
        return actores;
    }
    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public void addActor(Actor actor) {
        if (actor != null) {
            getActores().add(actor);
        }
    }
    public void removeActor(Actor actor) {
        if (actor != null) {
        getActores().remove(actor);
    }
    }

    public Pelicula(){
    }

    public Integer getId() {
        return id_pelicula;
    }

    public void setId(Integer id) {
        this.id_pelicula = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getAnio() {
        return anio;
    }

    public void setAnio(LocalDate anio) {
        this.anio = anio;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(id_pelicula, pelicula.id_pelicula);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id_pelicula);
    }

}