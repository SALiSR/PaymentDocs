package ru.initiative.jasper.dto;

/**
 * Created by noname on 02.05.2017.
 */
public class DtoInvoiceListSupport {
    /*Товары (работы, услуги)*/
    private String goods;

    /*Кол-во*/
    private String number;

    /*Ед.*/
    private String unit;

    /*Цена*/
    private String price;

    /*Сумм*/
    private String total;

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
