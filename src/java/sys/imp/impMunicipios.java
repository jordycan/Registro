/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.imp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.daoMunicipios;
import sys.model.Municipios;
import sys.util.HibernateUtil;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class impMunicipios implements daoMunicipios {

    @Override
    public boolean registroMunicipios(Municipios municipios) {
        boolean inserto = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(municipios);
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
    public List<Municipios> mostrarMunicipios() {    
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
    public boolean actualizarMunicipios(Municipios municipios) {
        boolean inserto = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(municipios);
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
    public boolean eliminarMunicipios(Municipios municipios) {
        boolean inserto = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(municipios);
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
