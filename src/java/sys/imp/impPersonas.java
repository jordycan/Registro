/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sys.imp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.dao.daoPersonas;
import sys.model.Municipios;
import sys.model.Personas;
import sys.model.Promotores;
import sys.util.HibernateUtil;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class impPersonas implements daoPersonas{

    @Override
    public boolean insertarPersona(Personas persona) {
        
        boolean inserto = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(persona);
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
    public List<Promotores> verPromotores(Personas personas) {
        List<Promotores> prom = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Promotores as m inner join fetch m.municipios where m.municipios.idLocalidad='"+personas.getMunicipios().getIdLocalidad()+"'";
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
    public List<Personas> mostrarPersonas() {
        List<Personas> personas = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Personas as m inner join fetch m.municipios left join fetch m.promotores";
        try {
            personas = session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return personas;
    }

    @Override
    public boolean editarPersona(Personas persona) {
          boolean inserto = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(persona);
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
    public boolean eliminarPersona(Personas persona) {
          boolean inserto = false;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(persona);
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
