package customermanagerment.service;

import customermanagerment.model.Province;

import java.util.List;

public interface IProvinceService {
    List<Province> findAll();
    void saveProvince(Province province);
    void deleteProvince(Long id);
    Province findProvinceById(Long id);
}
