/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.modelo;

import br.edu.ifsp.tcc.pk.SentenciadoDaSindicanciaPK;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Programar
 */
@Entity
@Table(name = "sindicancia_sentenciado")
@IdClass(SentenciadoDaSindicanciaPK.class)
public class SentenciadoDaSindicancia implements Serializable {
  
    @Id
    @ManyToOne
    @JoinColumn(name = "sentenciado_id")
    private Sentenciado sentenciado;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "sindicancia_id")
    private Sindicancia sindicancia;

    public SentenciadoDaSindicancia() {
    }

    public SentenciadoDaSindicancia(Sentenciado sentenciado, Sindicancia sindicancia) {
        this.sentenciado = sentenciado;
        this.sindicancia = sindicancia;
    }

    public Sentenciado getSentenciado() {
        return sentenciado;
    }

    public void setSentenciado(Sentenciado sentenciado) {
        this.sentenciado = sentenciado;
    }

    public Sindicancia getSindicancia() {
        return sindicancia;
    }

    public void setSindicancia(Sindicancia sindicancia) {
        this.sindicancia = sindicancia;
    }

    
   
    
}
