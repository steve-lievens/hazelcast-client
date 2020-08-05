// Bean based on Word doc with transaction content.
package com.ibm.demo.rest.json;


public class TransactionBean {

    private String ROW;
    private String CLIENT_ID;
    private String ACCOUNT_ID;
    private String TRANS_ID;
    private String DATE;
    private String TYPE;
    private String OPERATION;
    private String K_SYMBOL;
    private String AMOUNT;
    private String BALANCE;
    
    public TransactionBean() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"ROW\":\"" + ROW + "\"" +
                ", \"CLIENT_ID\":\"" + CLIENT_ID + "\"" +
                ", \"ACCOUNT_ID\":\"" + ACCOUNT_ID + "\"" +
                ", \"TRANS_ID\":\"" + TRANS_ID + "\"" +
                ", \"DATE\":\"" + DATE + "\"" +
                ", \"TYPE\":\"" + TYPE + "\"" +
                ", \"OPERATION\":\"" + OPERATION + "\"" +
                ", \"K_SYMBOL\":\"" + K_SYMBOL + "\"" +
                ", \"AMOUNT\":\"" + AMOUNT + "\"" +
                ", \"BALANCE\":\"" + BALANCE + "\"" +
                "}";
    }



    /**
     * @return String return the ROW
     */
    public String getROW() {
        return ROW;
    }

    /**
     * @param ROW the ROW to set
     */
    public void setROW(String ROW) {
        this.ROW = ROW;
    }

    /**
     * @return String return the CLIENT_ID
     */
    public String getCLIENT_ID() {
        return CLIENT_ID;
    }

    /**
     * @param CLIENT_ID the CLIENT_ID to set
     */
    public void setCLIENT_ID(String CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }

    /**
     * @return String return the ACCOUNT_ID
     */
    public String getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    /**
     * @param ACCOUNT_ID the ACCOUNT_ID to set
     */
    public void setACCOUNT_ID(String ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    /**
     * @return String return the TRANS_ID
     */
    public String getTRANS_ID() {
        return TRANS_ID;
    }

    /**
     * @param TRANS_ID the TRANS_ID to set
     */
    public void setTRANS_ID(String TRANS_ID) {
        this.TRANS_ID = TRANS_ID;
    }

    /**
     * @return String return the DATE
     */
    public String getDATE() {
        return DATE;
    }

    /**
     * @param DATE the DATE to set
     */
    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    /**
     * @return String return the TYPE
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * @param TYPE the TYPE to set
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    /**
     * @return String return the OPERATION
     */
    public String getOPERATION() {
        return OPERATION;
    }

    /**
     * @param OPERATION the OPERATION to set
     */
    public void setOPERATION(String OPERATION) {
        this.OPERATION = OPERATION;
    }

    /**
     * @return String return the K_SYMBOL
     */
    public String getK_SYMBOL() {
        return K_SYMBOL;
    }

    /**
     * @param K_SYMBOL the K_SYMBOL to set
     */
    public void setK_SYMBOL(String K_SYMBOL) {
        this.K_SYMBOL = K_SYMBOL;
    }

    /**
     * @return String return the AMOUNT
     */
    public String getAMOUNT() {
        return AMOUNT;
    }

    /**
     * @param AMOUNT the AMOUNT to set
     */
    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    /**
     * @return String return the BALANCE
     */
    public String getBALANCE() {
        return BALANCE;
    }

    /**
     * @param BALANCE the BALANCE to set
     */
    public void setBALANCE(String BALANCE) {
        this.BALANCE = BALANCE;
    }

}