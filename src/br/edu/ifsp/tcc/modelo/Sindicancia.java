/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author macel
 */
@Entity
@Table(name = "sindicancia")
public class Sindicancia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sindicancia_id", nullable = false) 
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_ocorrido", nullable = false)
    private Date dataOcorrencia;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_registro", nullable = false)
    private Date dataRegisto;
    @Column(name = "relato", length = 500, nullable = false)
    private String relato;
     
    
//    @ManyToMany
//    @JoinTable(name= "sindicancia_funcionario",joinColumns = {
//    @JoinColumn(name="funcionario_id")
//    },
//    inverseJoinColumns = {@JoinColumn(name = "sindicancia_id")})
//    private List<Funcionario> funcionarios = new ArrayList<>();
//    
//    
//    @ManyToMany
//    @JoinTable(name= "sindicancia_sentenciado",joinColumns = {
//    @JoinColumn(name="sentenciado_id")
//    },
//    inverseJoinColumns = {@JoinColumn(name = "sindicancia_id")})
//    private List<Sentenciado> sentenciados = new ArrayList<>();
    
    /*  retirado do JPA-MIni-Livro */
    @ManyToMany
    @JoinTable(name= "sindicancia_funcionario", joinColumns = @JoinColumn(name="sindicancia_id"),
    inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
    private List<Funcionario> funcionarios = new ArrayList<>();
        
    @ManyToMany
    @JoinTable(name= "sindicancia_sentenciado", joinColumns = @JoinColumn(name="sindicancia_id"),
    inverseJoinColumns = @JoinColumn(name = "sentenciado_id"))
    private List<Sentenciado> sentenciados = new ArrayList<>();
    

    public Sindicancia() {
    }

    public Sindicancia(Integer id, Date dataOcorrencia, Date dataRegisto, String relato) {
        this.id = id;
        this.dataOcorrencia = dataOcorrencia;
        this.dataRegisto = dataRegisto;
        this.relato = relato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public Date getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(Date dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Sentenciado> getSentenciados() {
        return sentenciados;
    }

    public void setSentenciados(List<Sentenciado> sentenciados) {
        this.sentenciados = sentenciados;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sindicancia other = (Sindicancia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sindicancia{" + "id=" + id + ", dataOcorrencia=" + dataOcorrencia + ", dataRegisto=" + dataRegisto + ", relato=" + relato + ", funcionarios=" + funcionarios + ", sentenciados=" + sentenciados + '}';
    }

  
    
}
