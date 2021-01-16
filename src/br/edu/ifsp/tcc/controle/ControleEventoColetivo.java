/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.controle;
import br.edu.ifsp.tcc.modelo.*;
import java.io.Serializable;
import javax.persistence.EntityManager;
import br.edu.ifsp.tcc.util.Conexao;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author macel
 */
public class ControleEventoColetivo implements Serializable{
    
public void salvar(EventoColetivo a) {
        EntityManager em = Conexao.getConexao();
        {
            try {
                em.getTransaction().begin();
                em.merge(a);
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Erro ao tentar salvar " + e.getMessage());
            }

        }
    }

 /**
     * METODO REMOVE UM OBJETO DO TIPO EVENTOCOLETIVO DO BANCO DE DADOS.
     *
     * @param f
     */
    public void remover(EventoColetivo f) {
        EntityManager em = Conexao.getConexao();
        EventoColetivo eventoColetivo;// crio uma variavel tipo eventoColetivo
        try {

            em.getTransaction().begin();
            eventoColetivo = em.merge(f);//recebe o parametro nesta variavel eventoColetivo criada
            em.remove(eventoColetivo);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Erro ao remover " + e.getMessage());
            if (!em.getTransaction().isActive()) {// se a conexão não estiver ativa
                em.getTransaction().begin();
                em.getTransaction().rollback();// desfaz transação
                em.getTransaction().commit();
            }

        }

    }

    /**
     * METODO REALIZA UMA BUSCA POR ID NO BANCO E RETORNA UM OBJETO
     * CORRESPONDENTE AO ID DESEJADO
     *
     * @param id
     * @return
     */
    public EventoColetivo buscarPorId(Integer id) {// aqui devolve um objeto o Integer pode trabalhar com NULL o inte não
        EntityManager em = Conexao.getConexao();//abre conexão
        EventoColetivo f;
        try {
            em.getTransaction().begin();
            f = em.find(EventoColetivo.class, id);// f recebe o objeto que  veio por parametro
            em.getTransaction().commit();// fecha ransação
            return f;

        } catch (Exception e) {
            System.out.println("Funcionário não encontrado! " + e.getMessage());

        }

        return null;
    }

    /**
     * METODO REALIZA A LISTAGEM DE TODOS OS OBJETOS DO TIPO EVENTOCOLETIVO NO
     * BANCO DE DADOS
     *
     * @return
     */
    public List listarTodos() {
        EntityManager em = Conexao.getConexao();
        List<EventoColetivo> lista; //aqui temos uma lista
        try {
            em.getTransaction().begin();// abre transação
            TypedQuery consulta = em.createQuery("From EventoColetivo f", EventoColetivo.class);// crio uma TypedQuery que recebe uma query no JPA não precisa colocar select
            lista = consulta.getResultList();// recebe a consulta que vem como uma lista
            em.getTransaction().commit();// Fechar Transação
            return lista; // retorna lista que recebeu
        } catch (Exception e) {
            System.out.println("Erro ao listar " + e.getMessage());
        }
        return null;

    }
    
    public List pesquisarEventoColetivos(String comando) {

        EntityManager em = Conexao.getConexao();
        List<EventoColetivo> lista = null;
        try {
            em.getTransaction().begin();
            TypedQuery consulta = em.createQuery(comando, EventoColetivo.class);
            lista = consulta.getResultList();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Erro ao pesquisar " + e.getMessage());

        }
        return lista;
    }

}
