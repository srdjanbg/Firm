package application.repositories;

import application.domains.Duties;
import application.domains.Employee;
import java.util.List;

/**
 *
 * @author Srdjan
 */
public interface DutiesRepository {

    public void startSession();

    public void stopSession();

    public boolean dodajZaduzenje(Duties duties);

    public List<Duties> listaZaduzenja();
    
     public Duties pronadjiZaduzenje(int id);

    public void promeniZaduzenje(Duties duties);

    public void obrisiZaduzenje(Duties duties);

}
