package za.co.sasams.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.sasams.dto.AddEditCustomerParameters;
import za.co.sasams.dto.ExtendedClass;
import za.co.sasams.model.Test;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope(value = "singleton")
public class InheritanceAction {
    private List<Test> testList = new ArrayList<Test>();
    @RequestMapping(value = "/edit.do",method = RequestMethod.GET)
    public String editResults(@RequestParam(value = "idParam") int id,ModelMap model){
        
        AddEditCustomerParameters addEditCustomerParameters = new AddEditCustomerParameters();
        ExtendedClass extendedClass = new ExtendedClass();
        extendedClass.setAddEditCustomerParameters(addEditCustomerParameters);
        model.addAttribute("extendedClass",extendedClass);
        return "edit";
    }
    @RequestMapping(value = "/edit.do",method = RequestMethod.POST)
    public String save(@ModelAttribute ExtendedClass extendedClass, BindingResult result,ModelMap model){
        return "edit";
    } 
}
