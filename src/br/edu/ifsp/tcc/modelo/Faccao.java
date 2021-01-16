package br.edu.ifsp.tcc.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author macelan
 */
@Entity
@Table(name = "faccao")
public class Faccao implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faccao_id",nullable = false)
    private Integer id;
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @Column(name = "sigla_faccao", length = 10, nullable = false)
    private String siglaFaccao;
    
//    @OneToMany (mappedBy = "faccao")
//    @JoinColumn (name = "faccao_id")
    private List<Sentenciado> sentenciados = new ArrayList<>();
    

//    @ManyToOne
//    @JoinColumn(name = "coordenadoria_id")
//    private Coordenadoria coordenadoria;
//    @OneToMany(mappedBy = "preCod")
//    private List<Funcionario> funcionarioList;
    
public Faccao() {
    }

    public Faccao(Integer id, String nome, String siglaFaccao) {
        this.id = id;
        this.nome = nome;
        this.siglaFaccao = siglaFaccao;
    }

    public PropertyChangeSupport getChangeSupport() {
        return changeSupport;
    }

    public void setChangeSupport(PropertyChangeSupport changeSupport) {
        this.changeSupport = changeSupport;
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

    public String getSiglaFaccao() {
        return siglaFaccao;
    }

    public void setSiglaFaccao(String siglaFaccao) {
        this.siglaFaccao = siglaFaccao;
    }

    public List<Sentenciado> getSentenciados() {
        return sentenciados;
    }

    public void setSentenciados(List<Sentenciado> sentenciados) {
        this.sentenciados = sentenciados;
    }

    
 //    public List<Funcionario> getFuncionarioList() {
//        return funcionarioList;
//    }
//
//    public void setFuncionarioList(List<Funcionario> funcionarioList) {
//        this.funcionarioList = funcionarioList;
//    }
   @Override
    public String toString() {
        return this.getSiglaFaccao();
    }

}
