package br.edu.ifsp.tcc.modelo;

import br.edu.ifsp.tcc.pk.CelaPK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author macelan
 */
@Entity
@Table(name = "cela")
@IdClass(CelaPK.class)
public class Cela implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)// sera adicionado manualmente o id
    @Column(name = "cela_id",nullable = false)
    private Integer id;
    @Column(name = "lotacao", nullable = false)
    private Integer lotacao;
    
    private Pavilhao pavilhao;
    private List<MovimentacaoInterna> movimentacoes = new ArrayList<>();
 
 
////    @JoinColumn(name = "pav_cod", referencedColumnName = "pav_cod", insertable = false, updatable = false)
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

    public Cela(Integer id, Integer numero, Integer lotacao, Pavilhao pavilhao) {
        this.id = id;
        this.lotacao = lotacao;
        this.pavilhao = pavilhao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        this.lotacao = lotacao;
    }

    public Pavilhao getPavilhao() {
        return pavilhao;
    }

    public void setPavilhao(Pavilhao pavilhao) {
        this.pavilhao = pavilhao;
    }

    public List<MovimentacaoInterna> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<MovimentacaoInterna> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    @Override
    public String toString() {
        return "Cela{" + "id=" + id + ", lotacao=" + lotacao + ", pavilhao=" + pavilhao + ", movimentacoes=" + movimentacoes + '}';
    }

   

}

