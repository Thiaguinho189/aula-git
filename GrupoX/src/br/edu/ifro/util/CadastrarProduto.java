package br.edu.ifro.util;

import br.edu.ifro.model.Cidade;
import br.edu.ifro.model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastrarProduto {
    public static void main(String[] args) {
        Produto p1 = new Produto();
        p1.setDescricao("Curso Java");
        p1.setValor(100);
        
        Produto p2 = new Produto();
        p2.setDescricao("Curso C++");
        p2.setValor(100);
        
        Produto p3 = new Produto();
        p3.setDescricao("Curso C");
        p3.setValor(100);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
    }
}
