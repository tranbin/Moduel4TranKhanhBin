package phone_number_ajax.service;

import phone_number_ajax.model.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();

    Smartphone findById(Long id);

    void save(Smartphone smartphone);

    void remove(Long id);
}
