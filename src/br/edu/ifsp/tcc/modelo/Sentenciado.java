/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author macel
 */
@Entity
@Table(name = "sentenciado")
public class Sentenciado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sentenciado_id",nullable = false)
    private Integer id;
    @Column(name = "matricula",length = 13, nullable = false)
    private String matricula;
    @Column(name = "nome",length = 60, nullable = false)
    private String nome;
    @Column(name = "rg",length = 13, nullable = false)
    private String rg;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", nullable = true)
    private Date dataNascimento;
    @Column(name = "aliases",length = 30, nullable = true)
    private String aliases;
    @Column(name = "registro_ativo", nullable = false)
    private boolean ativo;
    
    
    @OneToOne
    @JoinColumn(name = "faccao_id")
    private Faccao faccao;
    //Coleções
    @ManyToMany(mappedBy = "sentenciados", cascade = CascadeType.ALL)// sentenciao é o nome do atributo na entidade sindicancia
    private List<Sindicancia> sindicancias = new ArrayList<>();
    
 
    private List<MovimentacaoExterna> movimentacoesExternas = new ArrayList<>();
    
    private List<MovimentacaoInterna> movimentacoesInternas = new ArrayList<>();
    
  
    private List<Observacao> observacoes = new ArrayList<>();
        
        
//  @JoinTable(name = "oco_sen", joinColumns = {
//  @JoinColumn(name = "os_sen_cod", referencedColumnName = "sen_cod")}, inverseJoinColumns = {
////  @JoinColumn(name = "os_oco_cod", referencedColumnName = "oco_cod")})
//    @ManyToMany
//    private List<Ocorrencia> ocorrenciaList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sentenciado")
//    private List<Observacao> observacaoList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sentenciado")
//    private List<Inclusao> inclusaoList;     

    public Sentenciado() {
    }

    public Sentenciado(Integer id, String matricula, String nome, String rg, Date dataNascimento, String aliases, boolean ativo, Faccao faccao) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.aliases = aliases;
        this.ativo = ativo;
        this.faccao = faccao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Faccao getFaccao() {
        return faccao;
    }

    public void setFaccao(Faccao faccao) {
        this.faccao = faccao;
    }

    public List<Sindicancia> getSindicancias() {
        return sindicancias;
    }

    public void setSindicancias(List<Sindicancia> sindicancias) {
        this.sindicancias = sindicancias;
    }

    public List<MovimentacaoExterna> getMovimentacoesExternas() {
        return movimentacoesExternas;
    }

    public void setMovimentacoesExternas(List<MovimentacaoExterna> movimentacoesExternas) {
        this.movimentacoesExternas = movimentacoesExternas;
    }

    public List<MovimentacaoInterna> getMovimentacoesInternas() {
        return movimentacoesInternas;
    }

    public void setMovimentacoesInternas(List<MovimentacaoInterna> movimentacoesInternas) {
        this.movimentacoesInternas = movimentacoesInternas;
    }

    public List<Observacao> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<Observacao> observacoes) {
        this.observacoes = observacoes;
    }

//    @Override
//    public String toString() {
//        return "Sentenciado{" + "id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", rg=" + rg + ", dataNascimento=" + dataNascimento + ", aliases=" + aliases + ", ativo=" + ativo + ", faccao=" + faccao + ", sindicancias=" + sindicancias + ", movimentacoesExternas=" + movimentacoesExternas + ", movimentacoesInternas=" + movimentacoesInternas + ", observacoes=" + observacoes + '}';
//    }

 
    @Override
    public String toString() {
        return this.getMatricula();
    }
    
}
