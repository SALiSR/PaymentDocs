package ru.initiative.jasper.dto;

/**
 * Created by no on 10.05.2017.
 */
public class DtoChartsData {
    private String name;
    private Integer amount;
    private String someLabel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getSomeLabel() {
        return someLabel;
    }

    public void setSomeLabel(String someLabel) {
        this.someLabel = someLabel;
    }
}
