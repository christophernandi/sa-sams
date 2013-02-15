package za.co.sasams.dto;


import za.co.sasams.util.Util;

import java.util.Date;

public class TestScreenParameters {
    private String dateFrom = Util.format(new Date());
    private String dateTo = Util.format(new Date());
    private int canisterNum;
    private int flashNum;
    private String msisdn;
    private int sealNum;
    private String cardName;
    private long cardNumber;
    private String clientId;
    private int type;
    private String searchType;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public int getCanisterNum() {
        return canisterNum;
    }

    public void setCanisterNum(int canisterNum) {
        this.canisterNum = canisterNum;
    }

    public int getFlashNum() {
        return flashNum;
    }

    public void setFlashNum(int flashNum) {
        this.flashNum = flashNum;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getSealNum() {
        return sealNum;
    }

    public void setSealNum(int sealNum) {
        this.sealNum = sealNum;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
