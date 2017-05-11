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
import ru.initiative.jasper.dto.*;
import ru.initiative.jasper.service.TemplateProcessing;
import ru.initiative.jasper.testdata.TestDataForJasper;
import ru.initiative.jasper.utils.NumbersToWords;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    TemplateProcessing processing;

    @Autowired
    TemplateFileNameConfiguration fileNameConfiguration;

    @Autowired
    TestDataForJasper dataForJasper;

    @RequestMapping("/mainpage")
    public String mainPage(Model model) {
        model.addAttribute("order", new DtoOrder());
        return "mainpage";
    }

    @RequestMapping("/invoicepage")
    public String invoicePage(Model model) {
        model.addAttribute("invoice", new DtoInvoice());
        model.addAttribute("theTable", dataForJasper.getDtoInvoiceListSupport());
        return "invoicepage";
    }

    @RequestMapping(value ="/order", method = RequestMethod.POST, produces = "application/pdf", consumes="*/*")
    @ResponseBody
    public byte[] order(Model model, HttpServletRequest request, @ModelAttribute("dtoOrder") DtoOrder dtoOrder) {

        Map<String, Object> reportParams = dataForJasper.fillTheOrder(dtoOrder);
        //Map<String, Object> reportParams = fillTheOrderTestData();
        return processing.doTemplateFilled(fileNameConfiguration.getOrder(), reportParams);
    }

    @RequestMapping(value ="/invoice", method = RequestMethod.POST, produces = "application/pdf", consumes="*/*")
    @ResponseBody
    public byte[] invoice(HttpServletRequest request, @ModelAttribute("dtoInvoice") DtoInvoice dtoInvoice) {

        Map<String, Object> reportParams = dataForJasper.fillTheInvoice(dtoInvoice);
        return processing.doTemplateFilled(fileNameConfiguration.getInvoice(), reportParams);
    }

    @RequestMapping("/chartspage")
    public String chartpage(Model model) {
        model.addAttribute("order", new DtoOrder());
        return "chartspage";
    }

    @RequestMapping(value="/charts", method = RequestMethod.POST, produces = "application/pdf", consumes="*/*")
    @ResponseBody
    public byte[] charts(Model model) {

        Map<String, Object> reportParams = dataForJasper.fillTheCharts(dataForJasper.getDtoCharts(),
                dataForJasper.getDtoChartsPie());
        return processing.doTemplateFilled(fileNameConfiguration.getCharts(), reportParams);
    }

}
