/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author WIN 10
 */
public class FunctionDAO implements InterfaceDAO {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public FunctionDAO(SessionFactory factory) {
        this.factory = factory;
    }

    public boolean insertOrUpdate(Object object) {
        boolean flag = false;
        try {
            this.session = this.factory.openSession();
            this.transaction = this.session.beginTransaction();
            this.session.saveOrUpdate(object);
            this.transaction.commit();
            flag = true;
        } catch (HibernateException e) {
            e.printStackTrace();
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        } finally {
            this.session.close();
        }
        return flag;
    }

    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Object> get(String query) {
        List<Object> datas = new ArrayList<>();
        try {
            this.session = this.factory.openSession();
            this.transaction = this.session.beginTransaction();
            datas = this.session.createQuery(query).list();
            this.transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        } finally {
            this.session.close();
        }
        return datas;
    }

    public Object getById(String query) {
        Object data = new Object();
        try {
            this.session = this.factory.openSession();
            this.transaction = this.session.beginTransaction();
            data = this.session.createQuery(query)
                    .uniqueResult();
            this.transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        } finally {
            this.session.close();
        }
        return data;
    }

      public Object getAllone(String query) {
        Object data = new Object();
        try {
            this.session = this.factory.openSession();
            this.transaction = this.session.beginTransaction();
            data = this.session.createQuery(query);
            this.transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        } finally {
            this.session.close();
        }
        return data;
    }
    public Object getAutoId(String query) {
        Object data = new Object();
        try {
            this.session = this.factory.openSession();
            this.transaction = this.session.beginTransaction();
            data = this.session.createQuery(query)
                    .uniqueResult();
            this.transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        } finally {
            this.session.close();
        }
        return data;
    }

    @Override
    public boolean log(String query) {
         boolean flag = false;
    try {
            session = factory.getCurrentSession();
            transaction = session.beginTransaction();
            this.session.createQuery(query).uniqueResult();
            
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
//            session.close();
        } 
    return true;
    }
}
