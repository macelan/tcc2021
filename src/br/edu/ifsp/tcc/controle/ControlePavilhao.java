/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.controle;
import java.io.Serializable;
import javax.persistence.EntityManager;
import br.edu.ifsp.tcc.modelo.Pavilhao;
import br.edu.ifsp.tcc.util.Conexao;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author macel
 */
public class ControlePavilhao implements Serializable{
    
public void salvar(Pavilhao a) {
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
     * METODO REMOVE UM OBJETO DO TIPO PAVILHÃO DO BANCO DE DADOS.
     *
     * @param f
     */
    public void remover(Pavilhao f) {
        EntityManager em = Conexao.getConexao();
        Pavilhao pavilhao;// crio uma variavel tipo pavilhao
        try {

            em.getTransaction().begin();
            pavilhao = em.merge(f);//recebe o parametro nesta variavel pavilhao criada
            em.remove(pavilhao);
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
    public Pavilhao buscarPorId(Integer id) {// aqui devolve um objeto o Integer pode trabalhar com NULL o inte não
        EntityManager em = Conexao.getConexao();//abre conexão
        Pavilhao f;
        try {
            em.getTransaction().begin();
            f = em.find(Pavilhao.class, id);// f recebe o objeto que  veio por parametro
            em.getTransaction().commit();// fecha ransação
            return f;

        } catch (Exception e) {
            System.out.println("Pavilhao não encontrado! " + e.getMessage());

        }

        return null;
    }

    /**
     * METODO REALIZA A LISTAGEM DE TODOS OS OBJETOS DO TIPO PAVILHÃO NO
     * BANCO DE DADOS
     *
     * @return
     */
    public List listarTodos() {
        EntityManager em = Conexao.getConexao();
        List<Pavilhao> lista; //aqui temos uma lista
        try {
            em.getTransaction().begin();// abre transação
            TypedQuery consulta = em.createQuery("From Pavilhao f", Pavilhao.class);// crio uma TypedQuery que recebe uma query no JPA não precisa colocar select
            lista = consulta.getResultList();// recebe a consulta que vem como uma lista
            em.getTransaction().commit();// Fechar Transação
            return lista; // retorna lista que recebeu
        } catch (Exception e) {
            System.out.println("Erro ao listar " + e.getMessage());
        }
        return null;
    }
    
      public List pesquisarPavilhoes(String comando) {

        EntityManager em = Conexao.getConexao();
        List<Pavilhao> lista = null;
        try {
            em.getTransaction().begin();
            TypedQuery consulta = em.createQuery(comando, Pavilhao.class);
            lista = consulta.getResultList();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Erro ao pesquisar " + e.getMessage());

        }
        return lista;
    }
}
