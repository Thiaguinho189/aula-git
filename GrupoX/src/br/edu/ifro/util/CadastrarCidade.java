package br.edu.ifro.util;

import br.edu.ifro.model.Cidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastrarCidade {
    public static void main(String[] args) {
        Cidade cidade1 = new Cidade();
        cidade1.setNome("Curitiba");
        
        Cidade cidade2 = new Cidade();
        cidade2.setNome("Cuiaba");
        
        Cidade cidade3 = new Cidade();
        cidade3.setNome("Cujubim");
        
        Cidade cidade4 = new Cidade();
        cidade4.setNome("Curumbiara");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(cidade1);
        em.persist(cidade2);
        em.persist(cidade3);
        em.persist(cidade4);
        em.getTransaction().commit();
    }
}
