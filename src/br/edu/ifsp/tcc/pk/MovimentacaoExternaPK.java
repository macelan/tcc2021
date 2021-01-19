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
public class MovimentacaoExternaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "movimentacao_externa_id")
    private int movimentacaoExternaId;
    @Basic(optional = false)
    @Column(name = "sentenciado_id")
    private int sentenciadoId;

    public MovimentacaoExternaPK() {
    }

    public MovimentacaoExternaPK(int movimentacaoExternaId, int sentenciadoId) {
        this.movimentacaoExternaId = movimentacaoExternaId;
        this.sentenciadoId = sentenciadoId;
    }

    public int getMovimentacaoExternaId() {
        return movimentacaoExternaId;
    }

    public void setMovimentacaoExternaId(int movimentacaoExternaId) {
        this.movimentacaoExternaId = movimentacaoExternaId;
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
        hash += (int) movimentacaoExternaId;
        hash += (int) sentenciadoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentacaoExternaPK)) {
            return false;
        }
        MovimentacaoExternaPK other = (MovimentacaoExternaPK) object;
        if (this.movimentacaoExternaId != other.movimentacaoExternaId) {
            return false;
        }
        if (this.sentenciadoId != other.sentenciadoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.MovimentacaoExternaPK[ movimentacaoExternaId=" + movimentacaoExternaId + ", sentenciadoId=" + sentenciadoId + " ]";
    }
    
}

