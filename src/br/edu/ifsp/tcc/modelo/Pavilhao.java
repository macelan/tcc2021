package br.edu.ifsp.tcc.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author macelan
 */
@Entity
@Table(name = "pavilhao")
public class Pavilhao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pavilhao_id",nullable = false)
    private Integer id;
    @Column(name = "nome", length = 23, nullable = false)
    private String nome;
    @Column(name = "sigla_pavilhao", length = 15, nullable = false)
    private String sigla;
    
    private List<EventoColetivo> eventoColetivos = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pavilhao")
    private Collection<Cela> celas;

       

////        
////  @JoinColumn(name = "eve_cod", referencedColumnName = "eve_cod")
//    @ManyToOne
//    private EventoColetivo eveCod;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pavilhao")
//    private List<Cela> celaList;

    public Pavilhao() {
    }

    public Pavilhao(Integer id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<EventoColetivo> getEventoColetivos() {
        return eventoColetivos;
    }

    public void setEventoColetivos(List<EventoColetivo> eventoColetivos) {
        this.eventoColetivos = eventoColetivos;
    }

    public Collection<Cela> getCelas() {
        return celas;
    }

    public void setCelas(List<Cela> celas) {
        this.celas = celas;
    }

//    @Override
//    public String toString() {
//        return "Pavilhao{" + "id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", eventoColetivos=" + eventoColetivos + ", celas=" + celas + '}';
//    }
    
    @Override
    public String toString() {
    return this.getSigla();
    }
    public void addCela(Cela c){
        celas.add(c);
    }
    
 
}
