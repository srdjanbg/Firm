package application.repositories.impl;

import application.domains.Duties;
import application.domains.Employee;
import application.repositories.DutiesRepository;
import application.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Srdjan
 */
@Repository
public class DutiesRepositoryImpl implements DutiesRepository {

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
    public boolean dodajZaduzenje(Duties duties) {
        Transaction ts = null;

        try {
            ts = session.beginTransaction();
            session.save(duties);
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
    public List<Duties> listaZaduzenja() {
        Transaction ts = null;
        List<Duties> duties = new ArrayList<>();
        try {
            ts = session.beginTransaction();
            Query query = session.createQuery("FROM Duties");
            for (Object o : query.list()) {
                duties.add((Duties) o);
            }
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {
        }
        return duties;
    }

    @Override
    public void promeniZaduzenje(Duties duties) {
        Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.update(duties);
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
    public void obrisiZaduzenje(Duties duties) {
Transaction ts = null;
        try {
            ts = session.beginTransaction();
            session.delete(duties);
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
    public Duties pronadjiZaduzenje(int id) {
        Transaction ts = null;
        Duties duties = null;
        try {
            ts = session.beginTransaction();
            duties = (Duties) session.load(Duties.class, id);
            ts.commit();
        } catch (HibernateException e) {
            if (ts != null) {
                ts.rollback();
            }
            System.out.println("Greska");
        } finally {

        }
        return duties;
    }

}
