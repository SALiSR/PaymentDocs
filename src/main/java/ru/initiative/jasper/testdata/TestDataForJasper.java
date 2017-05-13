package ru.initiative.jasper.testdata;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;
import ru.initiative.jasper.dto.*;
import ru.initiative.jasper.utils.NumbersToWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by no on 11.05.2017.
 */
@Component
public class TestDataForJasper {

    public Map<String, Object> fillTheInvoice(DtoInvoice dtoInvoice){
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
        reportParams.put("totalSum", dtoInvoice.getTotalSum());
        reportParams.put("invoiceTableList", new JRBeanCollectionDataSource(getDtoInvoiceListSupport()));

        //reportParams.put("countPosition", dtoInvoice.getCountPosition());
        //reportParams.put("totalSumNDS", dtoInvoice.getTotalSumNDS());
        //reportParams.put("totalSumString", dtoInvoice.getTotalSumString());
        reportParams.put("countPosition", "1");
        reportParams.put("totalSumNDS", "106 779,70");
        reportParams.put("totalSumString",  new NumbersToWords(0, "700000.00").printResult());

        return reportParams;
    }

    public Map<String, Object> fillTheInvoiceTestData(DtoInvoice dtoInvoice){
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

    public Map<String, Object> fillTheOrder(DtoOrder dtoOrder){
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

    public Map<String, Object> fillTheOrderTestData() {
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

    public List<DtoInvoiceListSupport> getDtoInvoiceListSupport(){
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

    public DtoCharts getDtoCharts(){
        DtoCharts charts = new DtoCharts();

        DtoChartsData chartsData = new DtoChartsData();
        chartsData.setName("Бюджет");
        chartsData.setAmount(7500);
        chartsData.setSomeLabel("НИР и ОКР");

        DtoChartsData chartsData1 = new DtoChartsData();
        chartsData1.setName("Отклонение");
        chartsData1.setAmount(800);
        chartsData1.setSomeLabel("НИР и ОКР");

        DtoChartsData chartsData2 = new DtoChartsData();
        chartsData2.setName("Факт");
        chartsData2.setAmount(8300);
        chartsData2.setSomeLabel("НИР и ОКР");

        DtoChartsData chartsData3 = new DtoChartsData();
        chartsData3.setName("Бюджет");
        chartsData3.setAmount(11500);
        chartsData3.setSomeLabel("Основная продукция");

        DtoChartsData chartsData4 = new DtoChartsData();
        chartsData4.setName("Отклонение");
        chartsData4.setAmount(500);
        chartsData4.setSomeLabel("Основная продукция");

        DtoChartsData chartsData5 = new DtoChartsData();
        chartsData5.setName("Факт");
        chartsData5.setAmount(12000);
        chartsData5.setSomeLabel("Основная продукция");

        DtoChartsData chartsData6 = new DtoChartsData();
        chartsData6.setName("Бюджет");
        chartsData6.setAmount(35000);
        chartsData6.setSomeLabel("Основаные услуги");

        DtoChartsData chartsData7 = new DtoChartsData();
        chartsData7.setName("Отклонение");
        chartsData7.setAmount(2000);
        chartsData7.setSomeLabel("Основаные услуги");

        DtoChartsData chartsData8 = new DtoChartsData();
        chartsData8.setName("Факт");
        chartsData8.setAmount(37000);
        chartsData8.setSomeLabel("Основаные услуги");

        DtoChartsData chartsData9 = new DtoChartsData();
        chartsData9.setName("Бюджет");
        chartsData9.setAmount(1200);
        chartsData9.setSomeLabel("Прочие доходы");

        DtoChartsData chartsData10 = new DtoChartsData();
        chartsData10.setName("Отклонение");
        chartsData10.setAmount(1100);
        chartsData10.setSomeLabel("Прочие доходы");

        DtoChartsData chartsData11 = new DtoChartsData();
        chartsData11.setName("Факт");
        chartsData11.setAmount(2300);
        chartsData11.setSomeLabel("Прочие доходы");

        charts.getDtoChartsDataList().add(chartsData);
        charts.getDtoChartsDataList().add(chartsData1);
        charts.getDtoChartsDataList().add(chartsData2);
        charts.getDtoChartsDataList().add(chartsData3);
        charts.getDtoChartsDataList().add(chartsData4);
        charts.getDtoChartsDataList().add(chartsData5);
        charts.getDtoChartsDataList().add(chartsData6);
        charts.getDtoChartsDataList().add(chartsData7);
        charts.getDtoChartsDataList().add(chartsData8);
        charts.getDtoChartsDataList().add(chartsData9);
        charts.getDtoChartsDataList().add(chartsData10);
        charts.getDtoChartsDataList().add(chartsData11);

        return charts;
    }

    public DtoCharts getDtoChartsPie(){
        DtoCharts charts = new DtoCharts();

        DtoChartsData chartsData = new DtoChartsData();
        chartsData.setName("НИР и ОКР");
        chartsData.setAmount(8300);

        DtoChartsData chartsData1 = new DtoChartsData();
        chartsData1.setName("Основная продукция");
        chartsData1.setAmount(11500);

        DtoChartsData chartsData2 = new DtoChartsData();
        chartsData2.setName("Основные услуги");
        chartsData2.setAmount(37000);

        DtoChartsData chartsData3 = new DtoChartsData();
        chartsData3.setName("Прочие доходы");
        chartsData3.setAmount(3500);

        charts.getDtoChartsDataList().add(chartsData);
        charts.getDtoChartsDataList().add(chartsData1);
        charts.getDtoChartsDataList().add(chartsData2);
        charts.getDtoChartsDataList().add(chartsData3);

        return charts;
    }


    public Map<String, Object> fillTheCharts(DtoCharts dtoCharts, DtoCharts pieChartDataSet){
        Map<String, Object> reportParams = new HashMap<String, Object>();
        reportParams.put("usualDataset", new JRBeanCollectionDataSource(dtoCharts.getDtoChartsDataList()));
        reportParams.put("pieChartDataSet", new JRBeanCollectionDataSource(pieChartDataSet.getDtoChartsDataList()));

        return reportParams;
    }
}
