/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.pk;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Programar
 */
@Embeddable
public class MovimentacaoInternaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "movimentacao_interna_id")
    private int movimentacaoInternaId;
    @Basic(optional = false)
    @Column(name = "sentenciado_id")
    private int sentenciadoId;

    public MovimentacaoInternaPK() {
    }

    public MovimentacaoInternaPK(int movimentacaoInternaId, int sentenciadoId) {
        this.movimentacaoInternaId = movimentacaoInternaId;
        this.sentenciadoId = sentenciadoId;
    }

    public int getMovimentacaoInternaId() {
        return movimentacaoInternaId;
    }

    public void setMovimentacaoInternaId(int movimentacaoInternaId) {
        this.movimentacaoInternaId = movimentacaoInternaId;
    }

    public int getSentenciadoId() {
        return sentenciadoId;
    }

    public void setSentenciadoId(int sentenciadoId) {
        this.sentenciadoId = sentenciadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) movimentacaoInternaId;
        hash += (int) sentenciadoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentacaoInternaPK)) {
            return false;
        }
        MovimentacaoInternaPK other = (MovimentacaoInternaPK) object;
        if (this.movimentacaoInternaId != other.movimentacaoInternaId) {
            return false;
        }
        if (this.sentenciadoId != other.sentenciadoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MovimentacaoInternaPK[ movimentacaoInternaId=" + movimentacaoInternaId + ", sentenciadoId=" + sentenciadoId + " ]";
    }
    
}

