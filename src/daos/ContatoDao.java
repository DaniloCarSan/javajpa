/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Contato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author DANILODOSSANTOSCARRE
 */
public class ContatoDao {
    
    public static void create(Contato contato){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();

        entityManager.persist(contato);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
	entityManagerFactory.close();

    }
    
    public static List<Contato> list(int representante_codigo){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Contato>  query =  entityManager.createQuery("SELECT c FROM Contato c WHERE c.representante_codigo = :representante_codigo",Contato.class);
        
        query.setParameter("representante_codigo", representante_codigo);
        
        List<Contato> contatos = query.getResultList();
        
        entityManager.close();
        
	entityManagerFactory.close();
        
        return contatos;
    }
    
    public static void update(Contato contato){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();

        entityManager.merge(contato);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
	entityManagerFactory.close();

    }
    
    public static void delete(Contato contato){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        contato = entityManager.find(Contato.class, contato.codigo);

        entityManager.remove(contato);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
	entityManagerFactory.close();

    }
    
}
