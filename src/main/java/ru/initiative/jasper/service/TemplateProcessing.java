package ru.initiative.jasper.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/**
 * Created by mikhail on 16.03.2017.
 */
@Service
public class TemplateProcessing {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateProcessing.class);

    public byte[] doTemplateFilled(Resource template, Map<String, Object> reportParams){
        JRDataSource dataSource = new JREmptyDataSource();
        JasperDesign jasperDesign;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            jasperDesign = JRXmlLoader.load(template.getInputStream());
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParams, dataSource);;
            out = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, out);

            return out.toByteArray();
        } catch (JRException e) {
            LOGGER.error(e.getMessage());
            return null;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return null;
        }
    }
}
