package co.sasams.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.sasams.dto.TestScreenParameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestScreenAction {

    @RequestMapping(value = "/transactionScreen.do", method = RequestMethod.GET)
    public String displayForm(ModelMap model) {
        TestScreenParameters testScreenParameters = new TestScreenParameters();
        testScreenParameters.setSearchType("Date");
        initModel(model, testScreenParameters, "Search For Transactions");
        return "transactionScreen";
    }

    @RequestMapping(value = "/transactionScreen.do", method = RequestMethod.POST)
    public String displayTransactions(@ModelAttribute("testScreenParameters") TestScreenParameters parameters, ModelMap model) {
        System.out.println("---------" + parameters.getCardName());
        System.out.println("---------" + parameters.getClientId());
        System.out.println("---------" + parameters.getFlashNum());
        System.out.println("---------Search Type "+parameters.getSearchType());

        initModel(model, parameters, "Search");
        model.addAttribute("button","search button");
        model.addAttribute("isPost", true);
        return "transactionScreen";
    }

    @RequestMapping(value = "/transactionScreen.do", method = RequestMethod.POST,params = "Save to Disk")
    public String save(@ModelAttribute("testScreenParameters") TestScreenParameters parameters, ModelMap model) {
        System.out.println("---------" + parameters.getCardName());
        System.out.println("---------" + parameters.getClientId());
        System.out.println("---------" + parameters.getFlashNum());
        System.out.println("---------Search Type "+parameters.getSearchType());

        initModel(model, parameters, "Update");
        model.addAttribute("button","Save to Disk");
        model.addAttribute("isPost", true);
        return "transactionScreen";
    }

    private void initModel(ModelMap model, TestScreenParameters parameters, String title) {
        List<String> searchTypeList = new ArrayList<String>() {
            {
                add("Date");
                add("Canister");
                add("MSISDN");
                add("Flash");
                add("Seal");
                add("Card Name");
                add("Card Number");
                add("Client ID");
            }
        };
/*        Map radioOptionMap = new HashMap();
        radioOptionMap.put("numberList", searchTypeList);
        model.addAttribute("radioOptionMap",radioOptionMap);*/

        model.addAttribute("searchTypeList", searchTypeList);
        model.addAttribute("requiresJavaScript", true);
        model.addAttribute("testScreenParameters", parameters);
        model.addAttribute("title", title);
    }
}
