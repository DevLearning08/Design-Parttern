package presentation;

import java.util.ArrayList;

public class ManagementAppInfor {
    private String fullName;
    private String customerId;
    private String customerType;
    private String customerObject;
    private String invoiceDate;
    private String quantity;
    private String unitPrice;
    private String quota;
    private String nationality;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerObject() {
        return customerObject;
    }

    public void setCustomerObject(String customerObject) {
        this.customerObject = customerObject;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public ManagementAppInfor(String fullName, String customerId, String customerType, String customerObject,
                           String invoiceDate, String quantity, String unitPrice, String quota, String nationality) {
        this.fullName = fullName;
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerObject = customerObject;
        this.invoiceDate = invoiceDate;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.quota = quota;
        this.nationality = nationality;
    }

    public static ArrayList<ManagementAppInfor> getBillList() {
        return null;
    }

    // Getter và setter cho các thuộc tính
    // ...
}

