/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Telefone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author DANILODOSSANTOSCARRE
*/
public class TelefoneDao {
    
    public static void create(Telefone telefone){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();

        entityManager.persist(telefone);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
	entityManagerFactory.close();
    }
    
    public static Telefone getPerNumeroAndRepresentante(String numero,int representante_codigo){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Telefone>  query =  entityManager.createQuery("SELECT r FROM Telefone r WHERE r.numero = :numero AND r.representante_codigo = :representante_codigo ",Telefone.class);
        
        query.setParameter("numero", numero);
        
        query.setParameter("representante_codigo", representante_codigo);
        
        List<Telefone> telefones = query.getResultList();
        
        if(telefones.isEmpty())
        {
            return null;
        }
        
        return telefones.get(0);
    }
    
    public static List<Telefone> list(int representante_codigo){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Telefone>  query =  entityManager.createQuery("SELECT t FROM Telefone t WHERE t.representante_codigo = :representante_codigo",Telefone.class);
        
        query.setParameter("representante_codigo", representante_codigo);
        
        List<Telefone> telefones = query.getResultList();
        
        entityManager.close();
        
	entityManagerFactory.close();
        
        return telefones;
    }
    
    public static void delete(Telefone telefone){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        telefone = entityManager.find(Telefone.class, telefone.codigo);

        entityManager.remove(telefone);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
	entityManagerFactory.close();

    }
}
