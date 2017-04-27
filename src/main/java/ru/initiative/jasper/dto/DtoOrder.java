package ru.initiative.jasper.dto;

/**
 * Created by noname on 15.04.2017.
 */
public class DtoOrder {
    private String paymentOrderNum;
    private String payerSumQuant;

    private String payerINN;
    private String payerKPP;
    private String payerCompanyName;
    private String payerAccount;
    private String payerBankName;
    private String payerBankBIK;
    private String payerBankAccount;

    private String recipientBankName;
    private String recipientBankBIK;
    private String recipientBankAccount;
    private String recipientINN;
    private String recipientKPP;
    private String recipientAccount;
    private String recipientCompanyName;

    private String paymentOrderPurpose;

    public String getPaymentOrderNum() {
        return paymentOrderNum;
    }

    public void setPaymentOrderNum(String paymentOrderNum) {
        this.paymentOrderNum = paymentOrderNum;
    }

    public String getPayerSumQuant() {
        return payerSumQuant;
    }

    public void setPayerSumQuant(String payerSumQuant) {
        this.payerSumQuant = payerSumQuant;
    }

    public String getPayerINN() {
        return payerINN;
    }

    public void setPayerINN(String payerINN) {
        this.payerINN = payerINN;
    }

    public String getPayerKPP() {
        return payerKPP;
    }

    public void setPayerKPP(String payerKPP) {
        this.payerKPP = payerKPP;
    }

    public String getPayerCompanyName() {
        return payerCompanyName;
    }

    public void setPayerCompanyName(String payerCompanyName) {
        this.payerCompanyName = payerCompanyName;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
    }

    public String getPayerBankName() {
        return payerBankName;
    }

    public void setPayerBankName(String payerBankName) {
        this.payerBankName = payerBankName;
    }

    public String getPayerBankBIK() {
        return payerBankBIK;
    }

    public void setPayerBankBIK(String payerBankBIK) {
        this.payerBankBIK = payerBankBIK;
    }

    public String getPayerBankAccount() {
        return payerBankAccount;
    }

    public void setPayerBankAccount(String payerBankAccount) {
        this.payerBankAccount = payerBankAccount;
    }

    public String getRecipientBankName() {
        return recipientBankName;
    }

    public void setRecipientBankName(String recipientBankName) {
        this.recipientBankName = recipientBankName;
    }

    public String getRecipientBankBIK() {
        return recipientBankBIK;
    }

    public void setRecipientBankBIK(String recipientBankBIK) {
        this.recipientBankBIK = recipientBankBIK;
    }

    public String getRecipientBankAccount() {
        return recipientBankAccount;
    }

    public void setRecipientBankAccount(String recipientBankAccount) {
        this.recipientBankAccount = recipientBankAccount;
    }

    public String getRecipientINN() {
        return recipientINN;
    }

    public void setRecipientINN(String recipientINN) {
        this.recipientINN = recipientINN;
    }

    public String getRecipientKPP() {
        return recipientKPP;
    }

    public void setRecipientKPP(String recipientKPP) {
        this.recipientKPP = recipientKPP;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public String getRecipientCompanyName() {
        return recipientCompanyName;
    }

    public void setRecipientCompanyName(String recipientCompanyName) {
        this.recipientCompanyName = recipientCompanyName;
    }

    public String getPaymentOrderPurpose() {
        return paymentOrderPurpose;
    }

    public void setPaymentOrderPurpose(String paymentOrderPurpose) {
        this.paymentOrderPurpose = paymentOrderPurpose;
    }
}
