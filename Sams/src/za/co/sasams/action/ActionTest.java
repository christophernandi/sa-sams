package za.co.sasams.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.sasams.dto.AddEditCustomerParameters;
import za.co.sasams.dto.ExtendedClass;
import za.co.sasams.model.Customers;
import za.co.sasams.service.CustomerDataProvider;

import java.util.List;


@Controller
//@SessionAttributes(value = "addEditCustomerParameters")
@Scope(value = "session")
public class ActionTest {
    @Autowired
    private CustomerDataProvider customerDataProvider;

    @RequestMapping(value = "/customers.do", method = RequestMethod.GET)
    public String showClient(ModelMap map) {
        map.addAttribute("addEditCustomerParameters", new AddEditCustomerParameters());
        return "customers";
    }

    @RequestMapping(value = "/result.do", method = RequestMethod.POST)
    public String getCustomer(@ModelAttribute(value = "addEditCustomerParameters") AddEditCustomerParameters addEditCustomerParameters, BindingResult result, ModelMap map) {
        List<Customers> customers = customerDataProvider.searchCustomers();
        map.put("message", "WELL DONE MESSAGE FROM THE CONTROLLER");
        map.put("customers", customers);
        map.put("isPost", true);
        return "result";
    }

    @RequestMapping(value = "results2.do", method = RequestMethod.POST)
    public String secondResults(@ModelAttribute ExtendedClass extendedClass, BindingResult result, ModelMap model) {
        model.put("extendedClass", extendedClass);
        model.put("message", "WELL DONE MESSAGE FROM THE CONTROLLER");
        return "results2";
    }

    @RequestMapping(value = "editResult", method = RequestMethod.GET)
    public String editResults(ModelMap model) {
        AddEditCustomerParameters addEditCustomerParameters = new AddEditCustomerParameters();
//        AddEditCustomerParameters addEditCustomerParameters = (AddEditCustomerParameters) model.get("addEditCustomerParameters");

        System.out.println("EDIT RESULTS GET " + addEditCustomerParameters.getFirstName());
        ExtendedClass extendedClass = new ExtendedClass();
        extendedClass.setAddEditCustomerParameters(addEditCustomerParameters);
        extendedClass.setTestField("THATS A TEST");
        model.addAttribute("extendedClass", extendedClass);
        return "editResult";
    }

    @RequestMapping(value = "/javaScriptTest.do", method = RequestMethod.GET)
    public String getJavaScript(ModelMap modelMap) {
        modelMap.put("message", "Java Script Test");
        return "javaScriptTest";
    }

    @RequestMapping(value = "/xmlTest.do", method = RequestMethod.GET)
    public String getScript(ModelMap modelMap) {
        modelMap.put("message", "Java Script Test");
        return "xmlTest";
    }

    @RequestMapping(value = "/displayXml.do", method = RequestMethod.GET)
    public String displayXML() {
        return "displayXml";
    }

    @RequestMapping(value = "/parsingxml.do", method = RequestMethod.GET)
    public String parsingXML() {
        return "parsingxml";
    }

    @RequestMapping(value = "/readXml.do", method = RequestMethod.GET)
    public String readXml() {
        return "readXml";
    }

    @RequestMapping(value = "/saxParser.do", method = RequestMethod.GET)
    public String ajax() {
        return "saxParser";
    }
    @RequestMapping(value = "/dontKnow.do",method = RequestMethod.GET)
    public String dontKnow(){
        return "dontKnow";
    }
}


