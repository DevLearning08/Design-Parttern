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

