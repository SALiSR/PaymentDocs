package ru.initiative.jasper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.initiative.jasper.config.TemplateFileNameConfiguration;
import ru.initiative.jasper.dto.DtoOrder;
import ru.initiative.jasper.service.TemplateProcessing;
import ru.initiative.jasper.utils.NumbersToWords;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Controller
public class MainController {

    @Autowired
    TemplateProcessing processing;

    @Autowired
    TemplateFileNameConfiguration fileNameConfiguration;

    @RequestMapping("/mainpage")
    public String greeting2(Model model) {
        model.addAttribute("name", "name");
        return "mainpage";
    }

    @RequestMapping(value ="/order", method = RequestMethod.DELETE, produces = "application/pdf", consumes="*/*")
    @ResponseBody
    public byte[] order(Model model, HttpServletRequest request, @ModelAttribute("dtoOrder") DtoOrder dtoOrder) {
        model.addAttribute("name", "name");

        Map<String, Object> reportParams = new HashMap<String, Object>();
        reportParams.put("paymentOrderNum", "481");
        reportParams.put("paymentOrderDate", "04.02.2017");
        reportParams.put("paymentOrderTypePayment", "Электронно");

        reportParams.put("payerSumQuant", "68678-00");
        reportParams.put("payerSumChar", new NumbersToWords(0,"68678.00").printResult());

        reportParams.put("payerINN", "7505005550");
        reportParams.put("payerKPP", "750501001");
        reportParams.put("payerCompanyName", "ООО \"Рассвет\"");
        reportParams.put("payerAccount", "40703920007330010255");
        reportParams.put("payerBankName", "АО \"Банк\" Г.Магнитогорск");
        reportParams.put("payerBankBIK", "047501711");
        reportParams.put("payerBankAccount", "30101910500000000811");

        reportParams.put("recipientBankName", "ГРКЦ ГУ БАНКА РОССИИ ПО ЧЕЛЯБИНСКОЙ ОБЛ. Г. МАГНИТОГОРСК");
        reportParams.put("recipientBankBIK", "0475010011");
        reportParams.put("recipientBankAccount", "");
        reportParams.put("recipientINN", "7459000015");
        reportParams.put("recipientKPP", "745901001");
        reportParams.put("recipientAccount", "40101810400000010801");
        reportParams.put("recipientCompanyName", "УФК (Межрайонная ИФНС России №20 по Челябинской обл.)");

        reportParams.put("paymentOrderPurpose", "УИН ... Налог на доходы физических лиц за февраль 2017");

        return processing.doTemplateFilled(fileNameConfiguration.getOrder(), request, reportParams);
    }

    @RequestMapping(value ="/invoice", method = RequestMethod.GET, produces = "application/pdf", consumes="*/*")
    @ResponseBody
    public byte[] invoice(HttpServletRequest request) {
        Map<String, Object> reportParams = new HashMap<String, Object>();
        reportParams.put("paymentOrderNum", "481");
        reportParams.put("paymentOrderDate", "04.02.2017");
        reportParams.put("paymentOrderTypePayment", "Электронно");

        return processing.doTemplateFilled(fileNameConfiguration.getInvoice(), request, reportParams);
    }
}
