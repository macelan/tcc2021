package br.edu.ifsp.tcc.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author macelan
 */
@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id",nullable = false)
    private Integer id;
    @Column(name = "rg", length = 18, nullable = false)
    private String rg;
    @Column(name = "nome", length = 60, nullable = false)
    private String nome;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento",nullable = false)
    private Date dataNascimento;
    @Column(name = "usuario", length = 70, nullable = false)
    private String usuario;
    @Column(name = "senha", length = 50, nullable = false)
    private String senha;
    
   @OneToOne
   @JoinColumn(name="Presidio_id")
   private Presidio presidio;     /*Aqui tem mesmo Presidio? Sera que quando é não-identificado não viria como atributo*/  
   //Coleção
   @ManyToMany(mappedBy = "funcionarios",  cascade = CascadeType.ALL)
    private List<Sindicancia> sindicancias = new ArrayList<>();
 
 
//        
//    @JoinTable(name = "oco_fun", joinColumns = {
//    @JoinColumn(name = "of_fun_cod", referencedColumnName = "fun_cod")}, inverseJoinColumns = {
//    @JoinColumn(name = "of_oco_cod", referencedColumnName = "oco_cod")})
//    @ManyToMany
//    private List<Ocorrencia> ocorrenciaList;
//    @JoinColumn(name = "pre_cod", referencedColumnName = "pre_cod")
//    @ManyToOne
//    @JoinColumn(name = "presidio_id")
//    private Presidio presidio;

    public Funcionario() {
    }

    public Funcionario(Integer id, String rg, String nome, Date dataNascimento, String usuario, String senha, Presidio presidio) {
        this.id = id;
        this.rg = rg;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
        this.senha = senha;
        this.presidio = presidio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Presidio getPresidio() {
        return presidio;
    }

    public void setPresidio(Presidio presidio) {
        this.presidio = presidio;
    }

    public List<Sindicancia> getSindicancias() {
        return sindicancias;
    }

    public void setSindicancias(List<Sindicancia> sindicancias) {
        this.sindicancias = sindicancias;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", rg=" + rg + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", usuario=" + usuario + ", senha=" + senha + ", presidio=" + presidio + ", sindicancias=" + sindicancias + '}';
    }


   
    
}
