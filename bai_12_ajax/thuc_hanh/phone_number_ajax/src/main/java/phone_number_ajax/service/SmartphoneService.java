package phone_number_ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone_number_ajax.model.Smartphone;
import phone_number_ajax.repository.ISmartphoneRepository;

import java.util.List;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(Long id) {
        smartphoneRepository.deleteById(id);
    }
}
