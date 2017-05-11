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
import java.util.Iterator;
import java.util.List;
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

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParams, dataSource);

            //удаление пустых страниц
            removeBlankPage(jasperPrint.getPages());

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

    //"Жесточайщий" хак. Его суть, генериться последняя пустая страница, что с этим делать - не известно.
    //Для борьбы с этим мы проверяем если страница пуста то удаляем ее. Сейчас также на заоплненных страницах генерятся
    //хеадеры и футеры, соотвественно на пустых страницах они тоже пристутствуют. Проверка на 0 элеменнтов - первый случай,
    //проверка на 2 (хеадер + футер пристутствует) - второй случай.
    private void removeBlankPage(List<JRPrintPage> pages) {
        for (Iterator<JRPrintPage> i = pages.iterator(); i.hasNext();) {
            JRPrintPage page = i.next();
            if (page.getElements().size() == 0 || page.getElements().size() == 2)
                i.remove();
        }
    }
}
