package mx.utng.ultima.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Deporte {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String nombreLista;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String equiposDeportivos;


    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEquiposDeportivos() {
        return equiposDeportivos;
    }
    public void setEquiposDeportivos(String equiposDeportivos) {
        this.equiposDeportivos = equiposDeportivos;
    }
    public String getNombreLista() {
        return nombreLista;
    }
    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }
}

