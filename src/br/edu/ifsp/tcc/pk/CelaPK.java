/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.pk;

import br.edu.ifsp.tcc.modelo.Pavilhao;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Programar
 */
@Embeddable
public class CelaPK implements Serializable{
    
    private int Cela_id;
    @ManyToOne
    @JoinColumn(name = "pavilhao_id", referencedColumnName = "pavilhao_id", insertable = false, updatable = false)
    private Pavilhao pavilhao;

    public CelaPK() {
    }

    public CelaPK(int Cela_id, Pavilhao pavilhao) {
        this.Cela_id = Cela_id;
        this.pavilhao = pavilhao;
    }

    public int getCela_id() {
        return Cela_id;
    }

    public void setCela_id(int Cela_id) {
        this.Cela_id = Cela_id;
    }

    public Pavilhao getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Pavilhao pavilhao) {
        this.pavilhao = pavilhao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.Cela_id;
        hash = 79 * hash + Objects.hashCode(this.pavilhao);
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
        final CelaPK other = (CelaPK) obj;
        if (this.Cela_id != other.Cela_id) {
            return false;
        }
        if (!Objects.equals(this.pavilhao, other.pavilhao)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
