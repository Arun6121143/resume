package com.example.laborhiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
import com.example.laborhiring.model.Labour;
import com.example.laborhiring.repository.LabourRepository;
import com.example.laborhiring.service.EmailService;
import com.example.laborhiring.service.LabourService;

@Controller
public class LabourController {

    @Autowired
    LabourService service;

    @Autowired
    LabourRepository lRepo;

    @Autowired
    EmailService eService;

    @PostMapping("/add-labour-details")
    public String addLabourDetails(@ModelAttribute Labour details) {
        Labour lab = validLabour(details);
        if (lab.getEmail() == null) {
            return "alreadyExist";
        } else if (lab.getPassword() == null) {
            return "alreadyExistPassword";
        }
        service.addLabour(lab);
        return "login";
    }

    private Labour validLabour(Labour details) {
        String email = details.getEmail();
        List<Labour> labour = lRepo.getByEmailId(email);
        Labour error = new Labour();
        if (!labour.isEmpty()) {
            return error;
        }

        String password = details.getPassword();
        List<Labour> pass = lRepo.getPassword(password);

        if (!pass.isEmpty()) {
            error.setEmail(details.getEmail());
            return error;
        }
        details.setCount(0);
        return details;
    }

    @GetMapping("/getLabourPage")
    public String getLabourPage() {
        return "getLabourPage";
    }

    @GetMapping("/email-password")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new Labour());
        return "labourPage";
    }

    static String email = "";

    @PostMapping("/email-password")
    public String checkMailPassword(@ModelAttribute("details") Labour details, Labour lab, Model model) {
        email = details.getEmail();
        String pass = details.getPassword();
        List<Labour> list = lRepo.getByEmailId(email);
        if (list.isEmpty()) {
            return "loginValidation";
        } else {
            if (pass.equals(list.get(0).getPassword())) {
                Labour l = lRepo.getByEmailLabourList(email);
                model.addAttribute("labourPage", l);
                return "labourPage";
            }
        }
        return "loginValidation";
    }

    @GetMapping("/forgot")
    public String forgotPassword() {
        return "forgotPassword";
    }

    @GetMapping("/SendPasswordToMail")
    public String sendMail() {
        return "login";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/send-mail")
    public String getEmail(@ModelAttribute Labour mail) {
        String sendMail = mail.getEmail();
        List<Labour> list = lRepo.getByEmailId(sendMail);
        if (list.isEmpty()) {
            return "PleaseEnterValidEmailPassword";
        }
        String password = list.get(0).getPassword();
        eService.sendMailPass(sendMail, password);
        return "login";

    }

    @GetMapping("/change-password")
    public String changePasswordPage() {
        return "changePassword";
    }

    @PostMapping("/enter-change-password")
    public String changePassword(@ModelAttribute @RequestBody Labour pass) {
        String newPass = pass.getPassword();
        Labour lab = lRepo.getByEmailLabourList(email);
        lab.setPassword(newPass);
        service.addLabour(lab);
        return "redirect:/loginPage";
    }

    @GetMapping("/Get-edit-profile")
    public String getEditProfile() {
        return "editProfile";
    }

    @PostMapping("/Post-edit-details")
    public String editDetails(@ModelAttribute @RequestBody Labour details) {
        String name = details.getName();
        String phNum = details.getPhNum();
        String mail = details.getEmail();
        String skill = details.getSkill();
        String wage = details.getWages();
        String location = details.getLocation();
        Integer age = details.getAge();

        Labour lab = lRepo.getByEmailLabourList(email);
        if (name != "") {
            lab.setName(name);
        } else {
            lab.setName(lab.getName());
        }

        if (phNum != "") {
            lab.setPhNum(phNum);
        } else {
            lab.setPhNum(lab.getPhNum());
        }

        if (mail != "") {
            lab.setEmail(mail);
        } else {
            lab.setEmail(lab.getEmail());
        }

        if (skill != "") {
            lab.setSkill(skill);
        }

        else {
            lab.setSkill(lab.getSkill());
        }

        if (wage != "") {
            lab.setWages(wage);
        } else {
            lab.setWages(lab.getWages());
        }

        if (location != "") {
            lab.setLocation(location);
        } else {
            lab.setLocation(lab.getLocation());
        }

        if (age != null) {
            lab.setAge(age);
        } else {
            lab.setAge(lab.getAge());
        }
        service.addLabour(lab);
        return "redirect:/loginPage";

    }
}
