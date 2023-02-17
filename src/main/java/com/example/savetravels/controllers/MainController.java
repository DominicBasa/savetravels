//Pair programmed with Rochelle B. 
package com.example.savetravels.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.savetravels.models.Save;
import com.example.savetravels.services.SaveService;


@Controller
public class MainController {
  
  @Autowired SaveService saveService;

  //! CREATE/ READ ALL
  @RequestMapping("/")
  public String index(@ModelAttribute("save")Save save, Model model) {
    List<Save> saves = saveService.getAllSaves();
    System.out.println(saves);
    model.addAttribute("saves", saves);
    return "index.jsp";
  }


  @PostMapping("/saves")
  public String create(@Valid @ModelAttribute("save")Save save,  BindingResult result){
    if(result.hasErrors()) {
      return "index.jsp";
    } else {
      saveService.createSave(save);
    }
    return"redirect:/";
  }

  @RequestMapping("/edit/{id}")
  public String showOne(@PathVariable("id") Long id, Model model) {
    Save save = saveService.findSave(id);
    model.addAttribute("save", save);
    return "edit.jsp";
  }
  
  @PutMapping("/edit/{id}")
  public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("save")Save save,  BindingResult result, Model model) {
    if(result.hasErrors()) {
      model.addAttribute("save", save);
      return "edit.jsp";
    }else {
      saveService.updateSave(save);
      return "redirect:/";
    }
  }
}
