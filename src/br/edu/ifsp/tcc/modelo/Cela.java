package br.edu.ifsp.tcc.modelo;

import br.edu.ifsp.tcc.pk.CelaPK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author macelan
 */
@Entity
@Table(name = "cela")
public class Cela implements Serializable {
    
    @EmbeddedId
    private CelaPK id;
    @Column(name = "lotacao", nullable = false)
    private Integer lotacao; 
 
    
    private List<MovimentacaoInterna> movimentacoes = new ArrayList<>();
 
 
////  @JoinColumn(name = "pav_cod", referencedColumnName = "pav_cod", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Pavilhao pavilhao;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cela")
//    private List<movimentacao> inclusaoList;
//
//    public void incluirCela() {
//
//    }

    public Cela() {
    }

    public Cela(CelaPK id, Integer lotacao) {
        this.id = id;
        this.lotacao = lotacao;
    }

    public CelaPK getId() {
        return id;
    }

    public void setId(CelaPK id) {
        this.id = id;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        this.lotacao = lotacao;
    }

    public List<MovimentacaoInterna> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<MovimentacaoInterna> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    @Override
    public String toString() {
        return "Cela{" + "id=" + id + ", lotacao=" + lotacao + ", movimentacoes=" + movimentacoes + '}';
    }



   

}

