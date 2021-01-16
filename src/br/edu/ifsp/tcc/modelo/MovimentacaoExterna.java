/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author macel
 */
@Entity
@Table(name = "movimentacao_externa")
public class MovimentacaoExterna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "movimentacao_externa_id",nullable = false)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_movimentacao", nullable = false)
    private Date dataMovimentacao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_ocorrido",nullable = false)
    private Date dataOcorrido;
    @Column(name = "tipo", length = 12, nullable = false)/*IE -> inclusão esterna *************  EE -> exclusão externa  */
    private String tipo;

    private Presidio presidio;
    private Sentenciado sentenciado;
    
    

////        
////    @JoinColumn(name = "cel_cod", referencedColumnName = "cel_cod", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Cela cela;
////    @JoinColumn(name = "sen_cod", referencedColumnName = "sen_cod", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Sentenciado sentenciado;
////

    public MovimentacaoExterna() {
    }

    public MovimentacaoExterna(Integer id, Date dataMovimentacao, Date dataOcorrido, String tipo, Presidio presidio, Sentenciado sentenciado) {
        this.id = id;
        this.dataMovimentacao = dataMovimentacao;
        this.dataOcorrido = dataOcorrido;
        this.tipo = tipo;
        this.presidio = presidio;
        this.sentenciado = sentenciado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Date getDataOcorrido() {
        return dataOcorrido;
    }

    public void setDataOcorrido(Date dataOcorrido) {
        this.dataOcorrido = dataOcorrido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Presidio getPresidio() {
        return presidio;
    }

    public void setPresidio(Presidio presidio) {
        this.presidio = presidio;
    }

    public Sentenciado getSentenciado() {
        return sentenciado;
    }

    public void setSentenciado(Sentenciado sentenciado) {
        this.sentenciado = sentenciado;
    }

    @Override
    public String toString() {
        return "MovimentacaoExterna{" + "id=" + id + ", dataMovimentacao=" + dataMovimentacao + ", dataOcorrido=" + dataOcorrido + ", tipo=" + tipo + ", presidio=" + presidio + ", sentenciado=" + sentenciado + '}';
    }

    

    
}
