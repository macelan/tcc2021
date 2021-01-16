/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author macel
 */

@Entity
@Table(name = "evento_Coletivo")
public class EventoColetivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_coletivo_id",nullable = false)
    private Integer id;
    @Column(name = "relato", length = 500, nullable = false)
    private String relato;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_ocorrido",nullable = false)
    private Date dataOcorrido;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_registro",nullable = false)
    private Date dataRegistro;

    @OneToOne
    @JoinColumn(name="pavilhao_id")
    private Pavilhao pavilhao;

    public EventoColetivo() {
    }

    public EventoColetivo(Integer id, String relato, Date dataOcorrido, Date dataRegistro, Pavilhao pavilhao) {
        this.id = id;
        this.relato = relato;
        this.dataOcorrido = dataOcorrido;
        this.dataRegistro = dataRegistro;
        this.pavilhao = pavilhao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    public Date getDataOcorrido() {
        return dataOcorrido;
    }

    public void setDataOcorrido(Date dataOcorrido) {
        this.dataOcorrido = dataOcorrido;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Pavilhao getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Pavilhao pavilhao) {
        this.pavilhao = pavilhao;
    }

    @Override
    public String toString() {
        return "EventoColetivo{" + "id=" + id + ", relato=" + relato + ", dataOcorrido=" + dataOcorrido + ", dataRegistro=" + dataRegistro + ", pavilhao=" + pavilhao + '}';
    }

    


}
