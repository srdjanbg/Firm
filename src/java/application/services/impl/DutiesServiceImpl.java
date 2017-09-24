package application.services.impl;

import application.domains.Duties;
import application.domains.Employee;
import application.models.DutiesModel;
import application.repositories.DutiesRepository;
import application.services.DutiesService;
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
public class DutiesServiceImpl implements DutiesService {

    @Autowired
    private DutiesRepository dutiesRepository;

    public DutiesRepository getDutiesRepository() {
        return dutiesRepository;
    }

    public void setDutiesRepository(DutiesRepository dutiesRepository) {
        this.dutiesRepository = dutiesRepository;
    }

    @Override
    @Transactional
    public boolean dodajZaduzenje(DutiesModel novoZaduzenje) {
        if (novoZaduzenje != null) {
            Duties duties = new Duties(novoZaduzenje.getOblast(), novoZaduzenje.getNivo(),
                    novoZaduzenje.getEmployeeId());

            dutiesRepository.startSession();
            dutiesRepository.dodajZaduzenje(duties);
            dutiesRepository.stopSession();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<DutiesModel> listaZaduzenja() {
        List<DutiesModel> zaduzenja = new ArrayList<>();
        dutiesRepository.startSession();
        List<Duties> duties = dutiesRepository.listaZaduzenja();
        dutiesRepository.stopSession();
        for (Duties dutie : duties) {
            zaduzenja.add(new DutiesModel(dutie.getId(), dutie.getOblast(), dutie.getNivo(),
                    dutie.getEmployeeId()));
        }

        return zaduzenja;

    }

    @Override
    public DutiesModel pronadjiZaduzenje(int id) {
        dutiesRepository.startSession();
        Duties zaduzenje = dutiesRepository.pronadjiZaduzenje(id);
        DutiesModel dutiesModel = new DutiesModel(zaduzenje.getId(), zaduzenje.getOblast(), zaduzenje.getNivo(), zaduzenje.getEmployeeId());

        dutiesRepository.stopSession();

        return dutiesModel;
    }

    @Override
    public void promeniZaduzenje(DutiesModel promenjenoZaduzenje) {

        dutiesRepository.startSession();
        Duties duties = dutiesRepository.pronadjiZaduzenje(promenjenoZaduzenje.getId());
        duties.setOblast(promenjenoZaduzenje.getOblast());
        duties.setNivo(promenjenoZaduzenje.getNivo());
        duties.setEmployeeId(promenjenoZaduzenje.getEmployeeId());

        dutiesRepository.promeniZaduzenje(duties);

        dutiesRepository.stopSession();
    }

    @Override
    public void obrisiZaduzenje(DutiesModel obrisanoZaduzenje) {
        dutiesRepository.startSession();
        Duties duties = dutiesRepository.pronadjiZaduzenje(obrisanoZaduzenje.getId());
        dutiesRepository.obrisiZaduzenje(duties);
        dutiesRepository.stopSession();
    }

    @Override
    @Transactional
    public List<Duties> traziZaduzenja(String theSearchName) {
        dutiesRepository.startSession();
        List<Duties> duties = dutiesRepository.listaZaduzenja();
        dutiesRepository.stopSession();

        return duties.stream().filter(e -> e.getOblast().matches("(?i).*" + theSearchName + ".*")).collect(Collectors.toList());
    }

}
