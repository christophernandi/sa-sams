package co.sasams.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import za.co.sasams.dto.AddEditCustomerParameters;
import za.co.sasams.service.CustomerDataProvider;

@Repository
@SessionAttributes(value = "addEditCu")
public class AddEditCustomerAction {

//    @Autowired
//    private CustomerDataProvider customerDataProvider;

//    @RequestMapping(value = "/customers.do")
//    public String test(ModelMap modelMap) {
//        modelMap.put("test", "THIS IS A TEST");
//        return "customers";
//    }



//    @RequestMapping(value = "/customers.do")
//    public String showCustomers(ModelMap modelMap){
//        Customers customers = new Customers();        
//        return "customers";
//    }

  /*  @RequestMapping(value = "/addEdiClient.do", method = RequestMethod.GET)
    public String showAddEdit(ModelMap modelMap) {
        AddEditCustomerParameters addEditCustomerParameters = new AddEditCustomerParameters();
        modelMap.put("addEditCustomerParameters", addEditCustomerParameters);
        return "addEditCustomer";
    }

    @RequestMapping(value = "/addEditClient.do", method = RequestMethod.POST)
    public String addEditCustomer(@ModelAttribute AddEditCustomerParameters addEditCustomerParameters,
                                  BindingResult result, ModelMap modelMap) {

        return "addEditCustomer";
    }
*/
}
