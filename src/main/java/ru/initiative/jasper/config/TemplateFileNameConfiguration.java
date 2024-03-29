package ru.initiative.jasper.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class TemplateFileNameConfiguration {
    private static final String ORDER = "PaymentOrder.v.5.jrxml";
    private static final String INVOICE = "Invoice.jrxml";
    private static final String CHARTS = "charts.jrxml";

    @Value(value = "classpath:reports/" + ORDER)
    private Resource order;

    @Value(value = "classpath:reports/" + INVOICE)
    private Resource invoice;

    @Value(value = "classpath:reports/" + CHARTS)
    private Resource charts;

    public Resource getOrder() {
        return order;
    }

    public void setOrder(Resource order) {
        this.order = order;
    }

    public Resource getInvoice() {
        return invoice;
    }

    public void setInvoice(Resource invoice) {
        this.invoice = invoice;
    }

    public Resource getCharts() {
        return charts;
    }

    public void setCharts(Resource charts) {
        this.charts = charts;
    }
}