package ru.initiative.jasper.controller;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.initiative.jasper.config.TemplateFileNameConfiguration;
import ru.initiative.jasper.dto.DtoInvoice;
import ru.initiative.jasper.dto.DtoInvoiceListSupport;
import ru.initiative.jasper.dto.DtoOrder;
import ru.initiative.jasper.service.TemplateProcessing;
import ru.initiative.jasper.utils.NumbersToWords;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    TemplateProcessing processing;

    @Autowired
    TemplateFileNameConfiguration fileNameConfiguration;

    @RequestMapping("/mainpage")
    public String mainPage(Model model) {
        model.addAttribute("order", new DtoOrder());
        return "mainpage";
    }

    @RequestMapping("/chartspage")
    public String chartpage(Model model) {
        model.addAttribute("order", new DtoOrder());
        return "chartspage";
    }
    @RequestMapping("/invoicepage")
    public String invoicePage(Model model) {
        model.addAttribute("invoice", new DtoInvoice());
        model.addAttribute("theTable", getDtoInvoiceListSupport());
        return "invoicepage";
    }

    @RequestMapping(value ="/order", method = RequestMethod.POST, produces = "application/pdf", consumes="*/*")
    @ResponseBody
    public byte[] order(Model model, HttpServletRequest request, @ModelAttribute("dtoOrder") DtoOrder dtoOrder) {

        Map<String, Object> reportParams = fillTheOrder(dtoOrder);
        //Map<String, Object> reportParams = fillTheOrderTestData();
        return processing.doTemplateFilled(fileNameConfiguration.getOrder(), request, reportParams);
    }

    @RequestMapping(value ="/invoice", method = RequestMethod.POST, produces = "application/pdf", consumes="*/*")
    @ResponseBody
    public byte[] invoice(HttpServletRequest request, @ModelAttribute("dtoInvoice") DtoInvoice dtoInvoice) {

        Map<String, Object> reportParams = fillTheInvoice(dtoInvoice);
        return processing.doTemplateFilled(fileNameConfiguration.getInvoice(), request, reportParams);
    }

    private Map<String, Object> fillTheInvoice(DtoInvoice dtoInvoice){
        Map<String, Object> reportParams = new HashMap<String, Object>();
        reportParams.put("recipientNameBank", dtoInvoice.getRecipientNameBank());
        reportParams.put("numberINN", dtoInvoice.getNumberINN());
        reportParams.put("numberKPP", dtoInvoice.getNumberKPP());
        reportParams.put("recipientName", dtoInvoice.getRecipientName());
        reportParams.put("recipientBIKBank", dtoInvoice.getRecipientBIKBank());
        reportParams.put("recipientBankAccount", dtoInvoice.getRecipientBankAccount());
        reportParams.put("recipientBankAccount2", dtoInvoice.getRecipientBankAccount2());

        reportParams.put("documentNumber", dtoInvoice.getDocumentNumber());

        reportParams.put("providerName", dtoInvoice.getProviderName());
        reportParams.put("buyerName", dtoInvoice.getBuyerName());

        reportParams.put("directorName", dtoInvoice.getDirectorName());
        reportParams.put("accounterName", dtoInvoice.getAccounterName());
        reportParams.put("countPosition", dtoInvoice.getCountPosition());
        reportParams.put("totalSum", dtoInvoice.getTotalSum());
        reportParams.put("totalSumString", dtoInvoice.getTotalSumString());
        reportParams.put("totalSumNDS", dtoInvoice.getTotalSumNDS());
        reportParams.put("invoiceTableList", new JRBeanCollectionDataSource(getDtoInvoiceListSupport()));

        return reportParams;
    }

    private Map<String, Object> fillTheInvoiceTestData(DtoInvoice dtoInvoice){
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
        reportParams.put("totalSumNDS", "106 779,70");
        reportParams.put("totalSumString", new NumbersToWords(0, "700000.00").printResult());

        return reportParams;
    }

    private Map<String, Object> fillTheOrder(DtoOrder dtoOrder){
        Map<String, Object> reportParams = new HashMap<String, Object>();
        reportParams.put("paymentOrderNum", "1234");
        reportParams.put("paymentOrderDate", "asdfs");
        reportParams.put("paymentOrderTypePayment", "Электронно");

        reportParams.put("payerSumQuant", dtoOrder.getPayerSumQuant());
        reportParams.put("payerSumChar", new NumbersToWords(0,dtoOrder.getPayerSumQuant()).printResult());

        reportParams.put("payerINN", dtoOrder.getPayerINN());
        reportParams.put("payerKPP", dtoOrder.getPayerKPP());
        reportParams.put("payerCompanyName", dtoOrder.getPayerCompanyName());
        reportParams.put("payerAccount", dtoOrder.getPayerAccount());
        reportParams.put("payerBankName", dtoOrder.getPayerBankName());
        reportParams.put("payerBankBIK", dtoOrder.getPayerBankBIK());
        reportParams.put("payerBankAccount", dtoOrder.getPayerBankAccount());

        reportParams.put("recipientBankName", dtoOrder.getRecipientBankName());
        reportParams.put("recipientBankBIK", dtoOrder.getRecipientBankBIK());
        reportParams.put("recipientBankAccount", dtoOrder.getRecipientBankAccount());
        reportParams.put("recipientINN", dtoOrder.getRecipientINN());
        reportParams.put("recipientKPP", dtoOrder.getRecipientKPP());
        reportParams.put("recipientAccount", dtoOrder.getRecipientAccount());
        reportParams.put("recipientCompanyName", dtoOrder.getRecipientCompanyName());

        reportParams.put("paymentOrderPurpose", dtoOrder.getPaymentOrderPurpose());

        return reportParams;
    }

    private Map<String, Object> fillTheOrderTestData() {
        Map<String, Object> reportParams = new HashMap<String, Object>();
        reportParams.put("paymentOrderNum", "481");
        reportParams.put("paymentOrderDate", "04.02.2017");
        reportParams.put("paymentOrderTypePayment", "Электронно");

        reportParams.put("payerSumQuant", "68678-00");
        reportParams.put("payerSumChar", new NumbersToWords(0, "68678.00").printResult());

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

        return reportParams;
    }

    private List<DtoInvoiceListSupport> getDtoInvoiceListSupport(){
        List<DtoInvoiceListSupport> invoiceListSupports = new ArrayList<>();

        DtoInvoiceListSupport invoiceListSupport = new DtoInvoiceListSupport();
        invoiceListSupport.setGoods("Выполненные работы по вводу в эксплуатацию\n" +
                "систем отопления, в т.ч. корректировка и\n" +
                "согласование проектной документации по договору\n" +
                "NoП-1/2011 от 10.04.2011г.");
        invoiceListSupport.setNumber("10");
        invoiceListSupport.setUnit("шт.");
        invoiceListSupport.setPrice("70 000.00");
        invoiceListSupport.setTotal("700 000,00");
        
        DtoInvoiceListSupport invoiceListSupport1 = new DtoInvoiceListSupport();
        invoiceListSupport1.setGoods("Разработка ПО\n" +
                "по договору\n" +
                "КоП-1/2013 от 11.05.2016г.");
        invoiceListSupport1.setNumber("8");
        invoiceListSupport1.setUnit("шт.");
        invoiceListSupport1.setPrice("60 000.00");
        invoiceListSupport1.setTotal("480 000,00");

        DtoInvoiceListSupport invoiceListSupport2 = new DtoInvoiceListSupport();
        invoiceListSupport2.setGoods("Выполненные работы по вводу в эксплуатацию\n" +
                "центра обработки данных, договор\n" +
                "НоП-1/2013 от 08.09.2014г.");
        invoiceListSupport2.setNumber("5");
        invoiceListSupport2.setUnit("шт.");
        invoiceListSupport2.setPrice("70 000.00");
        invoiceListSupport2.setTotal("350 000,00");

        invoiceListSupports.add(invoiceListSupport);
        invoiceListSupports.add(invoiceListSupport1);
        invoiceListSupports.add(invoiceListSupport2);

        return invoiceListSupports;
    }
}
