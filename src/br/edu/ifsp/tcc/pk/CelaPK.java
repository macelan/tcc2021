/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.pk;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Programar
 */
public class CelaPK implements Serializable{
    
    private Integer pavilhao_id;
    private Integer cela_id;

    public CelaPK() {
    }

    public CelaPK(Integer pavilhao_id, Integer cela_id) {
        this.pavilhao_id = pavilhao_id;
        this.cela_id = cela_id;
    }

    
    
    public Integer getPavilhao_id() {
        return pavilhao_id;
    }

    public void setPavilhao_id(Integer pavilhao_id) {
        this.pavilhao_id = pavilhao_id;
    }

    public Integer getCela_id() {
        return cela_id;
    }

    public void setCela_id(Integer cela_id) {
        this.cela_id = cela_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.pavilhao_id);
        hash = 97 * hash + Objects.hashCode(this.cela_id);
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
        if (!Objects.equals(this.pavilhao_id, other.pavilhao_id)) {
            return false;
        }
        if (!Objects.equals(this.cela_id, other.cela_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CelaPK{" + "pavilhao_id=" + pavilhao_id + ", cela_id=" + cela_id + '}';
    }

}
