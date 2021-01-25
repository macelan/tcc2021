package br.edu.ifsp.tcc.modelo;

import br.edu.ifsp.tcc.pk.CelaPK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author macelan
 */
@Entity
@Table(name = "cela")
//@IdClass(CelaPK.class)
public class Cela implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Cela_id;
    
    @Column(name = "numero_cela")
    private Integer numeroCela;
    
    @Column(name = "lotacao", nullable = false)
    private Integer lotacao; 
     
    @ManyToOne
    @JoinColumn(name = "pavilhao_id", referencedColumnName = "pavilhao_id")
    private Pavilhao pavilhao;
   
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

    public Cela(int Cela_id, Integer numeroCela, Integer lotacao, Pavilhao pavilhao) {
        this.Cela_id = Cela_id;
        this.numeroCela = numeroCela;
        this.lotacao = lotacao;
        this.pavilhao = pavilhao;
    }

    public int getCela_id() {
        return Cela_id;
    }

    public void setCela_id(int Cela_id) {
        this.Cela_id = Cela_id;
    }

    public Integer getNumeroCela() {
        return numeroCela;
    }

    public void setNumeroCela(Integer numeroCela) {
        this.numeroCela = numeroCela;
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

  
}

