package codegym.controller;

import codegym.model.EmailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailConfigController {
    @GetMapping(value = "/")
    public String getIndex(Model model){
        model.addAttribute("form",new EmailConfig());
        return "index";
    }

    @ModelAttribute("language")
    public List<String> getLanguage(){
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");

        return languages;
    }
    @ModelAttribute("pageSize")
    public List<Integer> getPageSize(){
        List<Integer> pageSizes = new ArrayList<>();
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
        return pageSizes;
    }

    @PostMapping("/submit")
    public ModelAndView submit(@ModelAttribute EmailConfig emailConfig){
        ModelAndView modelAndView = new ModelAndView("info","outputForm",emailConfig);
        return modelAndView;

    }
}
