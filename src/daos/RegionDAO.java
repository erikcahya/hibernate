/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author erik
 */
public class RegionDAO implements IRegionDAO {
    
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
    
    public RegionDAO(SessionFactory factory) {
        this.factory = factory; 
    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String query = "from region";
            regions = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return regions;
    }
    
    @Override
    public Region getById(BigDecimal id) {
        Region region = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "from region where regionId = :a";
            Query query = (Query) session.createQuery(hql);
            query.setParameter("a", id );
            region = (Region) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
              transaction.rollback();
            } 
        } return region;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public Region search(String key) {
        Region region = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Region WHERE regionId LIKE :regionId OR regionName LIKE :regionName";
            Query query = session.createQuery(hql);
            query.setParameter("regionId", new BigDecimal(key));
            query.setParameter("regionName", key);
            region = (Region) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return region ;
    }

    @Override
    public boolean insert(Region region) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(region);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();;
        }
    } finally {
            session.close();
        }
        return result;
    }
    
    @Override
    public boolean update(Region region) {
        boolean result = false;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(region);
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
    public boolean delete(int id) {
        boolean result = false;
        session = this.factory.openSession();
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

    

    

