/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custsspringmvcjpa.controller;

import custsspringmvcjpa.business.Facade;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustsController {

    @Autowired
    Facade facade;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("customers", facade.allCusts());
        return "index";

    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
        model.addAttribute("custForm", new CustForm());
        return "addCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@Valid CustForm custForm, BindingResult br) {
        if (br.hasErrors()) {
            return "addCustomer";
        } else {
            facade.addCust(custForm.getName());
            return "redirect:/";
        }
    }

}
