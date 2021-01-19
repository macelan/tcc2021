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
public class SentenciadoDaSindicanciaPK implements Serializable{
    
    private Integer sentenciado_id;
    private Integer sindicancia_id;

    public SentenciadoDaSindicanciaPK() {
    }

    public Integer getFuncionario_id() {
        return sentenciado_id;
    }

    public void setFuncionario_id(Integer funcionario_id) {
        this.sentenciado_id = funcionario_id;
    }

    public Integer getSindicancia_id() {
        return sindicancia_id;
    }

    public void setSindicancia_id(Integer sindicancia_id) {
        this.sindicancia_id = sindicancia_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.sentenciado_id);
        hash = 19 * hash + Objects.hashCode(this.sindicancia_id);
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
        final SentenciadoDaSindicanciaPK other = (SentenciadoDaSindicanciaPK) obj;
        if (!Objects.equals(this.sentenciado_id, other.sentenciado_id)) {
            return false;
        }
        if (!Objects.equals(this.sindicancia_id, other.sindicancia_id)) {
            return false;
        }
        return true;
    }

    
    
    
}
