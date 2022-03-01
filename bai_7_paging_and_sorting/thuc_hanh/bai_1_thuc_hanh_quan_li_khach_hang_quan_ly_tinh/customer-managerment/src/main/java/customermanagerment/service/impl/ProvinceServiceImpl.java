package customermanagerment.service.impl;

import customermanagerment.model.Province;
import customermanagerment.repository.IProvinceRepository;
import customermanagerment.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceServiceImpl implements IProvinceService {
    @Autowired
    IProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public void saveProvince(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void deleteProvince(Long id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public Province findProvinceById(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }
}
