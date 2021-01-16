package br.edu.ifsp.tcc.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author macelan
 */
@Entity
@Table(name = "coordenadoria")
public class Coordenadoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coordenadoria_id", nullable = false)
    private int id;
    @Column(name = "nome", length = 170, nullable = false)
    private String nome;
    @Column(name = "sigla", length = 10, nullable = false)
    private String sigla;
  
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presidio")
//    @JoinColumn(name="coordenadoria_id")
    private List<Presidio> Presidio = new ArrayList<>();
        
    public Coordenadoria() {
    }


//    public String incluirCoordenadoria() {
//        return null;
//    }

    public Coordenadoria(int id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Presidio> getPresidio() {
        return Presidio;
    }

    public void setPresidio(List<Presidio> Presidio) {
        this.Presidio = Presidio;
    }

//    @Override
//    public String toString() {
//        return "Coordenadoria{" + "id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", Presidio=" + Presidio + '}';
//    }

    @Override
    public String toString() {
    return this.getSigla();
    }
    
}
