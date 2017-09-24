package application.services.impl;

import application.domains.Duties;
import application.domains.Employee;
import application.models.EmployeeModel;
import application.repositories.DutiesRepository;
import application.repositories.EmployeeRepository;
import application.services.EmployeeService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




/**
 *
 * @author Srdjan
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DutiesRepository dutiesRepository;

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public boolean dodajZaposlenog(EmployeeModel noviZaposleni) {

        if (noviZaposleni != null) {
            Employee employee = new Employee(noviZaposleni.getIme(), noviZaposleni.getPrezime(),
                    noviZaposleni.getPozicija(), noviZaposleni.getPlata(), noviZaposleni.getStaz());

            employeeRepository.startSession();
            employeeRepository.dodajZaposlenog(employee);
            employeeRepository.stopSession();
            return true;
        } else {
            return false;
        }

    }

   @Override
public List<EmployeeModel> listaZaposlenih() {
	List<EmployeeModel> zaposleni = new ArrayList<>();

	employeeRepository.startSession();
	List<Employee> employees = employeeRepository.listaZaposlenih();
	employeeRepository.stopSession();

	dutiesRepository.startSession();
	List<Duties> duties = dutiesRepository.listaZaduzenja();
	dutiesRepository.stopSession();

	boolean hasDuty; // = true ako Employee ima min. 1 Duty

	for (Employee employee : employees) {
		EmployeeModel empmod = new EmployeeModel(employee.getId(), employee.getIme(), employee.getPrezime(),
				employee.getPozicija(), employee.getPlata(), employee.getStaz());
		hasDuty = false;
		for (Duties dutie : duties) {
			if (dutie.getEmployeeId() == empmod.getId()) {
				if(hasDuty!=true){
					empmod.setOblast(dutie.getOblast());
					empmod.setNivo(dutie.getNivo());
					zaposleni.add(empmod);
					hasDuty=true;
				}
				else{
					EmployeeModel empmod_tmp = new EmployeeModel(employee.getId(), employee.getIme(), employee.getPrezime(),
							employee.getPozicija(), employee.getPlata(), employee.getStaz());
					empmod_tmp.setIme("");
					empmod_tmp.setPrezime("");
					empmod_tmp.setOblast(dutie.getOblast());
					empmod_tmp.setNivo(dutie.getNivo());
					zaposleni.add(empmod_tmp);
				}
			}

		}
		if(hasDuty!=true)
			zaposleni.add(empmod);
		else
			hasDuty = false;
	}
	return zaposleni;
}
    @Override
    public EmployeeModel pronadjiZaposlenog(int id) {
        employeeRepository.startSession();
        Employee zaposleni = employeeRepository.pronadjiZaposlenog(id);
        EmployeeModel employeeModel = new EmployeeModel(zaposleni.getId(), zaposleni.getIme(), zaposleni.getPrezime(),
                zaposleni.getPozicija(), zaposleni.getPlata(), zaposleni.getStaz());

        employeeRepository.stopSession();

        return employeeModel;

    }

    @Override
    public void promeniZaposlenog(EmployeeModel promenjenZaposleni) {
        employeeRepository.startSession();
        Employee employee = employeeRepository.pronadjiZaposlenog(promenjenZaposleni.getId());
        employee.setIme(promenjenZaposleni.getIme());
        employee.setPrezime(promenjenZaposleni.getPrezime());
        employee.setPozicija(promenjenZaposleni.getPozicija());
        employee.setPlata(promenjenZaposleni.getPlata());
        employee.setStaz(promenjenZaposleni.getStaz());

        employeeRepository.promeniZaposlenog(employee);

        employeeRepository.stopSession();

    }

    @Override
    public void obrisiZaposlenog(EmployeeModel obrisanZaposleni) {
        employeeRepository.startSession();
        Employee employee = employeeRepository.pronadjiZaposlenog(obrisanZaposleni.getId());
        employeeRepository.obrisiZaposlenog(employee);
        employeeRepository.stopSession();

    }

    @Override
    @Transactional
    public List<Employee> traziZaposlene(String theSearchName) {
        employeeRepository.startSession();
        List<Employee> employees = employeeRepository.listaZaposlenih();
        employeeRepository.stopSession();

        return employees.stream().filter(e -> e.getIme().matches("(?i).*" + theSearchName + ".*")).collect(Collectors.toList());
    }
}
