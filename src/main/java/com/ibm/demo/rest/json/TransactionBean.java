// Bean based on Word doc with transaction content.
package com.ibm.demo.rest.json;

public class TransactionBean {

    private String row_number;
    private String client_id;
    private String account_id;
    private String date;
    private String type;
    private String k_symbol;
    private String amount;
    private String balance;
    
    public TransactionBean() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"row_number\":\"" + row_number + "\"" +
                ", \"client_id\":\"" + client_id + "\"" +
                ", \"account_id\":\"" + account_id + "\"" +
                ", \"date\":\"" + date + "\"" +
                ", \"type\":\"" + type + "\"" +
                ", \"k_symbol\":\"" + k_symbol + "\"" +
                ", \"amount\":\"" + amount + "\"" +
                ", \"balance\":\"" + balance + "\"" +
                "}";
    }

    /**
     * @return String return the client_id
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     * @param client_id the client_id to set
     */
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /**
     * @return String return the account_id
     */
    public String getAccount_id() {
        return account_id;
    }

    /**
     * @param account_id the account_id to set
     */
    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    /**
     * @return String return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return String return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return String return the k_symbol
     */
    public String getK_symbol() {
        return k_symbol;
    }

    /**
     * @param k_symbol the k_symbol to set
     */
    public void setK_symbol(String k_symbol) {
        this.k_symbol = k_symbol;
    }

    /**
     * @return String return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return String return the balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }


    /**
     * @return String return the row_number
     */
    public String getRow_number() {
        return row_number;
    }

    /**
     * @param row_number the row_number to set
     */
    public void setRow_number(String row_number) {
        this.row_number = row_number;
    }

}