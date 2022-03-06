package customermanagerment.controller;

import customermanagerment.model.Province;
import customermanagerment.service.IProvinceService;
import customermanagerment.service.impl.ProvinceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {
    @Autowired
    ProvinceServiceImpl provinceService;

    @GetMapping("/province")
    public ModelAndView getIndex() {
        return new ModelAndView("list", "provinces", provinceService.findAll());
    }


    @GetMapping("/create-province")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("province", new Province());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province") Province province) {
        provinceService.saveProvince(province);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("province", new Province());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Province province = provinceService.findProvinceById(id);
        if (province != null) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("province", province);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Province province) {
        provinceService.saveProvince(province);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("province", province);
        modelAndView.addObject("message", "Province update successfully");
        return modelAndView;
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Province province = provinceService.findProvinceById(id);
        if (province != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("province", province);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("delete-province")
    public String deleteProvince(@ModelAttribute("province") Province province) {
        provinceService.deleteProvince(province.getId());
        return "redirect:/";
    }


}
