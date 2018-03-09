/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sys.imp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.daoPromotores;
import sys.model.Municipios;
import sys.model.Promotores;
import sys.util.HibernateUtil;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class impPromotores implements daoPromotores{

    @Override
    public boolean insertarPromotores(Promotores promotores) {
          boolean inserto = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(promotores);
            session.getTransaction().commit();
            inserto = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return inserto;
    }

    @Override
    public List<Municipios> verMunicipios() {
         List<Municipios> municipios = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "From Municipios";
        try {
            municipios = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return municipios;
    }

    @Override
    public List<Promotores> verPromotoresPorNomre(Promotores promotores) {
        List<Promotores> prom = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Promotores as m inner join fetch m.municipios where m.nombreCompleto='"+promotores.getNombreCompleto()+"'";
        try {
            prom = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return prom;
    }

    @Override
    public boolean editarPromotor(Promotores promotores) {
          boolean inserto = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(promotores);
            session.getTransaction().commit();
            inserto = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return inserto;
    }

    @Override
    public boolean eliminarPromotor(Promotores promotores) {
          boolean inserto = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(promotores);
            session.getTransaction().commit();
            inserto = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return inserto;
    }

  

}
