package app.controller;

import app.model.ToKhai;
import app.service.ToKhaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private ToKhaiService khaiBaoRepo;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("toKhai",khaiBaoRepo.findAll());
        return "index";
    }
    @GetMapping("/list")
    public String showList1(Model model){
        model.addAttribute("toKhai",khaiBaoRepo.findAll());
        return "index";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("toKhai", new ToKhai());
        model.addAttribute("genderList", khaiBaoRepo.genderList());
        model.addAttribute("vehicleList", khaiBaoRepo.vehicleList());
        return "create";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("declaration") ToKhai toKhai) {
        khaiBaoRepo.create(toKhai);
        return "redirect:/list";
    }
    @GetMapping("/update")
    public String showUpdateForm(@RequestParam String iCard, Model model) {
        model.addAttribute("toKhai", khaiBaoRepo.findByIdentifyCard(iCard));
        model.addAttribute("genderList", khaiBaoRepo.genderList());
        model.addAttribute("vehicleList", khaiBaoRepo.vehicleList());
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("declaration") ToKhai toKhai){
        khaiBaoRepo.update(toKhai);
        return "redirect:/list";
    }
}
