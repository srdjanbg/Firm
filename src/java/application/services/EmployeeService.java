package application.services;

import application.domains.Employee;
import application.models.EmployeeModel;
import java.util.List;

/**
 *
 * @author Srdjan
 */
public interface EmployeeService {
    public boolean dodajZaposlenog(EmployeeModel noviZaposleni);
    
    public List<EmployeeModel> listaZaposlenih();
    
    public EmployeeModel pronadjiZaposlenog(int id);

    public void promeniZaposlenog(EmployeeModel promenjenZaposleni);

    public void obrisiZaposlenog(EmployeeModel obrisanZaposleni);

    public List<Employee> traziZaposlene(String theSearchName);

   
    
}
