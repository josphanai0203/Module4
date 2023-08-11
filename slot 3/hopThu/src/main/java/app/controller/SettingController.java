package app.controller;

import app.modal.SettingMail;
import app.service.SettingMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SettingController {
    @Autowired
    public SettingMailService settingMailService;
    @GetMapping("/setting")
    public String getSetting(Model model){
        model.addAttribute("settingMail",new SettingMail());
        model.addAttribute("languages",settingMailService.getLanguages());
        model.addAttribute("sizes",settingMailService.getSize());
        return "WEB-INF/update";
    }
    @PostMapping ("/setting")
    public String doSave(Model model, @ModelAttribute("settingMail") SettingMail settingMail){
        model.addAttribute("mail",settingMail);
        return "WEB-INF/save";
    }

}
