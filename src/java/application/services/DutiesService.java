package application.services;

import application.domains.Duties;
import application.models.DutiesModel;
import java.util.List;

/**
 *
 * @author Srdjan
 */
public interface DutiesService {
    
    
    public boolean dodajZaduzenje(DutiesModel novoZaduzenje);
    
    public List<DutiesModel> listaZaduzenja();
    
    public DutiesModel pronadjiZaduzenje(int id);

    public void promeniZaduzenje(DutiesModel promenjenoZaduzenje);

    public void obrisiZaduzenje(DutiesModel obrisanoZaduzenje);

    public List<Duties> traziZaduzenja(String theSearchName);
}
