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

    @RequestMapping(value ="/order", method = RequestMethod.POST, produces = "application/pdf", consumes="*/*")
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
        reportParams.put("recipientNameBank", "АО \"ВТБ 24\" г.Москва");
        reportParams.put("numberINN", "7710701721");
        reportParams.put("numberKPP", "771001001");
        reportParams.put("recipientName", "ООО \"Система\"");
        reportParams.put("recipientBIKBank", "44525716");
        reportParams.put("recipientBankAccount", "30101810100000000112");
        reportParams.put("recipientBankAccount2", "40702810471000007231");
        reportParams.put("documentNumber", "1-НИ от 22 апреля 2011 г.");
        reportParams.put("providerName", "ООО \"Система\", ИНН 7710701721, КПП 771001001, 125047, Москва г, Тверская-Ямская 4-я ул, дом № 11, строение 1, тел.: (495) 121-11-88, факс: (495) 121-11-88");
        reportParams.put("buyerName", "ООО \"НЕРО ГРУП\", ИНН 7716599123, КПП 771601001, 107497, Москва г, Щелковское ш, дом № 65, строение 3");
        reportParams.put("directorName", "Кожевин Д.А.");
        reportParams.put("accounterName", "Иванова И.О.");
        reportParams.put("countPosition", " 1");
        reportParams.put("totalSum", "700 000,00");
        reportParams.put("totalSumString", "Семьсот тысяч рублей 00 копеек");
        reportParams.put("totalSumNDS", "106 779,70");


        return processing.doTemplateFilled(fileNameConfiguration.getInvoice(), request, reportParams);
    }

}
