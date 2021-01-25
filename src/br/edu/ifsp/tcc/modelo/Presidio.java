package br.edu.ifsp.tcc.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author macelan
 */
@Entity
@Table(name = "presidio")
public class Presidio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "presidio_id",nullable = false)
    private Integer id;
    @Column(name = "nome", length = 170, nullable = false)
    private String nome;
    @Column(name = "sigla", length = 7, nullable = false)
    private String sigla;
    @Column(name = "regime", length = 15, nullable = false)
    private String regime;
    @Column(name = "cidade", length = 30, nullable = false)
    private String cidade;
    
    @OneToOne
    @JoinColumn(name="coordenadoria_id")
    private Coordenadoria coordenadoria;
   
    //Coleção
    private List<Funcionario> funcionarios = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "coordenadoria_id")
//    private Coordenadoria coordenadoria;
//    @OneToMany(mappedBy = "preCod")
//    private List<Funcionario> funcionarioList;
    
public Presidio() {
    }

    public Presidio(Integer id, String nome, String sigla, String regime, String cidade, Coordenadoria cordenadoria) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.regime = regime;
        this.cidade = cidade;
        this.coordenadoria = coordenadoria;
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

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Coordenadoria getCordenadoria() {
        return coordenadoria;
    }

    public void setCordenadoria(Coordenadoria cordenadoria) {
        this.coordenadoria = cordenadoria;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    

//    @Override
//    public String toString() {
//        return "Presidio{" + "id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", regime=" + regime + ", cidade=" + cidade + ", cordenadoria=" + cordenadoria + ", funcionarios=" + funcionarios + '}';
//    }

    @Override
    public String toString() {
        return this.getSigla();
    } 
    
}
