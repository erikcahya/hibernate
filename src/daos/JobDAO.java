/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import models.Job;
import idaos.IJobDAO;
import java.math.BigDecimal;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.lang.reflect.Field;
/**
 *
 * @author erik
 */
public class JobDAO implements IJobDAO {
    
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public JobDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Job> getAll() {
        List<Job> job = new ArrayList<Job>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "from Job";
            job = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return job;
    }

    @Override
    public Job getById(String id) {
        Job job = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "from job where Id = :id";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("id", id);
            job = (Job) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return job;
    }

    @Override
    public List<Job> search(Object keyword) {
        List<Job> job = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try { 
            String hql = "from Job where id like :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", "%" + keyword + "%");
//            query.setParameter("b", "%" + keyword + "%");
            job = query.list();
        } catch (Exception e) {
            e.getStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } return job;
    }

    @Override
    public boolean insert(Job job) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
            
        try {
            session.save(job);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public  boolean update(Job job) {
        boolean result = false;
        session = factory.openSession();
        transaction =  session.beginTransaction();
        try {
            session.update(job);
            transaction.commit();
            result= true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        session = factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(id);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());

        } finally {
            session.close();
        }
        return result;
    }
    
}
