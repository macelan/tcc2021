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
    
    private int pavilhao;
    private int cela_id;

    public CelaPK() {
    }

    public CelaPK(int pavilhao, int cela_id) {
        this.pavilhao = pavilhao;
        this.cela_id = cela_id;
    }

    public int getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(int pavilhao) {
        this.pavilhao = pavilhao;
    }

    public int getCela_id() {
        return cela_id;
    }

    public void setCela_id(int cela_id) {
        this.cela_id = cela_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.pavilhao);
        hash = 23 * hash + Objects.hashCode(this.cela_id);
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
        if (!Objects.equals(this.pavilhao, other.pavilhao)) {
            return false;
        }
        if (!Objects.equals(this.cela_id, other.cela_id)) {
            return false;
        }
        return true;
    }

   
}
