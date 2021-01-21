/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.controle;

import br.edu.ifsp.tcc.util.Conexao;
import javax.persistence.EntityManager;

/**
 *
 * @author Programar
 */
public class ControleFuncionarioDaSindicancia {

    public void excluir(ControleFuncionarioDaSindicancia item) {

        EntityManager em = Conexao.getConexao();

        em.getTransaction().begin();
        ControleFuncionarioDaSindicancia sentSind = em.merge(item);
        em.remove(sentSind);
        em.getTransaction().commit();
        System.out.println("removeu o item");

    }
    
     public void salvar(ControleFuncionarioDaSindicancia item) {

        EntityManager em = Conexao.getConexao();

        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        System.out.println("salvou o item");

    }
    
}
