package application.repositories.impl;

import application.domains.Employee;
import application.repositories.EmployeeRepository;

import application.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Srdjan
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    public Session session;

    @Override
    public void startSession() {

        session = HibernateUtil.createSessionFactory().openSession();

    }

    @Override
    public void stopSession() {
        session.close();
    }

    @Override
    public boolean dodajZaposlenog(Employee employee) {

        Transaction ts = null;

        try {
            ts = session.beginTransaction();
            session.save(employee);
            ts.commit();

        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {
            return true;
        }
    }

    @Override
    public List<Employee> listaZaposlenih() {
        Transaction ts = null;
        List<Employee> employees = new ArrayList<>();
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("FROM Employee");
            for (Object o : query.list()) {
                employees.add((Employee) o);
            }
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {
        }
        return employees;
    }

    @Override
    public Employee pronadjiZaposlenog(int id) {
        Transaction ts = null;
        Employee employee = null;
        try {
            ts = session.beginTransaction();
            employee = (Employee) session.load(Employee.class, id);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {

        }
        return employee;
    }

    @Override
    public void promeniZaposlenog(Employee employee) {
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.update(employee);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {

        }
    }

    @Override
    public void obrisiZaposlenog(Employee employee) {
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.delete(employee);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {

        }
    }

    @Override
    public List<Employee> traziZaposlene(String theSearchName) {

        Transaction ts = null;
        TypedQuery theQuery = null;
        List<Employee> employees = new ArrayList<>();
        try {
            ts = session.beginTransaction();
            if (theSearchName != null && theSearchName.trim().length() > 0) {

                // search for firstName or lastName ... case insensitive
                theQuery = (TypedQuery) session.createQuery("from Employee where lower(firstName) like :theName or lower(lastName) like :theName");
                theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

            } else {
                // theSearchName is empty ... so just get all customers
                theQuery = (TypedQuery) session.createQuery("from Employee");
            }

            // execute query and get result list
             employees = theQuery.getResultList();

            // return th;e results		
            ts.commit();

        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {

        }

        return employees;

    }
}
