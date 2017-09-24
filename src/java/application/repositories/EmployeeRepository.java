package application.repositories;

import application.domains.Employee;
import application.models.EmployeeModel;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Srdjan
 */
@Repository
public interface EmployeeRepository {

    public void startSession();

    public void stopSession();

    public boolean dodajZaposlenog(Employee employee);

    public List<Employee> listaZaposlenih();

    public Employee pronadjiZaposlenog(int id);

    public void promeniZaposlenog(Employee employee);

    public void obrisiZaposlenog(Employee employee);

    public List<Employee> traziZaposlene(String theSearchName);
    
}
