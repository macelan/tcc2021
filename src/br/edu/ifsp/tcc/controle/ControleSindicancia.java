/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.tcc.controle;
import br.edu.ifsp.tcc.modelo.Sindicancia;
import java.io.Serializable;
import javax.persistence.EntityManager;
import br.edu.ifsp.tcc.util.Conexao;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author macel
 */
public class ControleSindicancia implements Serializable{
    
public void salvar(Sindicancia a) {
        EntityManager em = Conexao.getConexao();
                em.getTransaction().begin();
                em.merge(a);
                em.getTransaction().commit();
  
    }


/**
     * METODO REMOVE UM OBJETO DO TIPO SINDICANCIA DO BANCO DE DADOS.
     *
     * @param f
     */
    public void remover(Sindicancia f) {
        EntityManager em = Conexao.getConexao();
        Sindicancia sindicancia;// crio uma variavel tipo funcionario
        try {

            em.getTransaction().begin();
            sindicancia = em.merge(f);//recebe o parametro nesta variavel funcionario criada
            em.remove(sindicancia);
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
    public Sindicancia buscarPorId(Integer id) {// aqui devolve um objeto o Integer pode trabalhar com NULL o inte não
        EntityManager em = Conexao.getConexao();//abre conexão
        Sindicancia s;
        try {
            em.getTransaction().begin();
            s = em.find(Sindicancia.class, id);// f recebe o objeto que  veio por parametro
            em.getTransaction().commit();// fecha ransação
            return s;

        } catch (Exception e) {
            System.out.println("Funcionário não encontrado! " + e.getMessage());

        }

        return null;
    }

    /**
     * METODO REALIZA A LISTAGEM DE TODOS OS OBJETOS DO TIPO FUNCIONARIO NO
     * BANCO DE DADOS
     *
     * @return
     */
    public List listarTodos() {
        EntityManager em = Conexao.getConexao();
        List<Sindicancia> lista; //aqui temos uma lista
        try {
            em.getTransaction().begin();// abre transação
            TypedQuery consulta = em.createQuery("From Sindicancia S", Sindicancia.class);// crio uma TypedQuery que recebe uma query no JPA não precisa colocar select
            lista = consulta.getResultList();// recebe a consulta que vem como uma lista
            em.getTransaction().commit();// Fechar Transação
            return lista; // retorna lista que recebeu
        } catch (Exception e) {
            System.out.println("Erro ao listar " + e.getMessage());
        }
        return null;

    }
    
    
     public List listarSindicancia(Integer sindicancia_id) {
        EntityManager em = Conexao.getConexao();
        List<Sindicancia> lista = null;

        try {
            em.getTransaction().begin();
            TypedQuery<Sindicancia> sql = em.createQuery("select i FROM Sindicancia i where i.sindicancia.sindicancia_id=:a", Sindicancia.class);
            sql.setParameter("a", sindicancia_id);
            lista = sql.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao consultar os item de alimento! " + e);
        }
        return lista;

    }
    
    public List pesquisarSindicancias(String comando) {

        EntityManager em = Conexao.getConexao();
        List<Sindicancia> lista = null;
        try {
            em.getTransaction().begin();
            TypedQuery consulta = em.createQuery(comando, Sindicancia.class);
            lista = consulta.getResultList();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Erro ao pesquisar " + e.getMessage());

        }
        return lista;
    }
    
    
    /**
 * METODO SALVA UM ORCAMENTO VAZIO E  RETORNA O ID
     * @param orc
 * @return 
 */
    public Sindicancia novoSindicancia(Sindicancia sind){
        EntityManager em = Conexao.getConexao();
         {
            try {
                em.getTransaction().begin();
                em.persist(sind);
                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Sindicancia criado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.out.println("Erro ao tentar salvar " + e.getMessage());
            }

        }
         return sind;
        
    }
}
