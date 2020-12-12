/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Representante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author DANILODOSSANTOSCARRE
 */
public class RepresentanteDao {
    
    public static void create(Representante representante){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();

        entityManager.persist(representante);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
	entityManagerFactory.close();

    }
    
    public static Representante getPerCPFNotByThisID(String cpf,int codigo){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Representante>  query =  entityManager.createQuery("SELECT r FROM Representante r WHERE r.cpf = :cpf AND r.codigo NOT IN(:codigo)",Representante.class);
        
        query.setParameter("cpf", cpf);
        
        query.setParameter("codigo", codigo);
        
        List<Representante> representantes = query.getResultList();
        
        if(representantes.isEmpty())
        {
            return null;
        }
        
        return representantes.get(0);
    }
   
    
    public static Representante getPerCPF(String cpf){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Representante>  query =  entityManager.createQuery("SELECT r FROM Representante r WHERE r.cpf = :cpf ",Representante.class);
        
        query.setParameter("cpf", cpf);
        
        List<Representante> representantes = query.getResultList();
        
        if(representantes.isEmpty())
        {
            return null;
        }
        
        return representantes.get(0);
    }
    
    public static List<Representante> list(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        TypedQuery<Representante>  query =  entityManager.createQuery("SELECT r FROM Representante r",Representante.class);

        List<Representante> representantes = query.getResultList();
        
        entityManager.close();
        
	entityManagerFactory.close();
        
        return representantes;
    }
    
    public static void update(Representante representante){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();

        entityManager.merge(representante);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
	entityManagerFactory.close();

    }
    
    public static void delete(Representante representante){
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javajpa");
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
        representante = entityManager.find(Representante.class, representante.codigo);

        entityManager.remove(representante);
        
        entityManager.getTransaction().commit();
        
        entityManager.close();
        
	entityManagerFactory.close();

    }
}
