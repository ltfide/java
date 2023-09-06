package com.local.table;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AebkLbhTrxHis {

    @JsonProperty("REF_NO")
    private String REF_NO;

    @JsonProperty("HIS_NO")
    private String HIS_NO;

    @JsonProperty("TRX_DT")
    private Date TRX_DT;

    @JsonProperty("TRX_AMT")
    private double TRX_AMT;

    @JsonProperty("AF_JAN")
    private String AF_JAN;

    @JsonProperty("TRX_NM")
    private String TRX_NM;

    @JsonProperty("TRX_FEE")
    private double TRX_FEE;

    @JsonProperty("RCV_NM1")
    private String RCV_NM1;

    @JsonProperty("RCV_ACCT_NO")
    private String RCV_ACCT_NO;

    @JsonProperty("REG_EMP_NO")
    private String REG_EMP_NO;

    @JsonProperty("REG_DT")
    private Date REG_DT;

    @JsonProperty("REG_TM")
    private String REG_TM;

    @JsonProperty("UPD_EMP_NO")
    private String UPD_EMP_NO;

    @JsonProperty("UPD_DT")
    private Date UPD_DT;

    @JsonProperty("UPD_TM")
    private String UPD_TM;

    public String getREF_NO() {
        return REF_NO;
    }

    public void setREF_NO(String REF_NO) {
        this.REF_NO = REF_NO;
    }

    public String getHIS_NO() {
        return HIS_NO;
    }

    public void setHIS_NO(String HIS_NO) {
        this.HIS_NO = HIS_NO;
    }

    public Date getTRX_DT() {
        return TRX_DT;
    }

    public void setTRX_DT(Date TRX_DT) {
        this.TRX_DT = TRX_DT;
    }

    public double getTRX_AMT() {
        return TRX_AMT;
    }

    public void setTRX_AMT(double TRX_AMT) {
        this.TRX_AMT = TRX_AMT;
    }

    public String getAF_JAN() {
        return AF_JAN;
    }

    public void setAF_JAN(String AF_JAN) {
        this.AF_JAN = AF_JAN;
    }

    public String getTRX_NM() {
        return TRX_NM;
    }

    public void setTRX_NM(String TRX_NM) {
        this.TRX_NM = TRX_NM;
    }

    public double getTRX_FEE() {
        return TRX_FEE;
    }

    public void setTRX_FEE(double TRX_FEE) {
        this.TRX_FEE = TRX_FEE;
    }

    public String getRCV_NM1() {
        return RCV_NM1;
    }

    public void setRCV_NM1(String RCV_NM1) {
        this.RCV_NM1 = RCV_NM1;
    }

    public String getRCV_ACCT_NO() {
        return RCV_ACCT_NO;
    }

    public void setRCV_ACCT_NO(String RCV_ACCT_NO) {
        this.RCV_ACCT_NO = RCV_ACCT_NO;
    }

    public String getREG_EMP_NO() {
        return REG_EMP_NO;
    }

    public void setREG_EMP_NO(String REG_EMP_NO) {
        this.REG_EMP_NO = REG_EMP_NO;
    }

    public Date getREG_DT() {
        return REG_DT;
    }

    public void setREG_DT(Date REG_DT) {
        this.REG_DT = REG_DT;
    }

    public String getREG_TM() {
        return REG_TM;
    }

    public void setREG_TM(String REG_TM) {
        this.REG_TM = REG_TM;
    }

    public String getUPD_EMP_NO() {
        return UPD_EMP_NO;
    }

    public void setUPD_EMP_NO(String UPD_EMP_NO) {
        this.UPD_EMP_NO = UPD_EMP_NO;
    }

    public Date getUPD_DT() {
        return UPD_DT;
    }

    public void setUPD_DT(Date UPD_DT) {
        this.UPD_DT = UPD_DT;
    }

    public String getUPD_TM() {
        return UPD_TM;
    }

    public void setUPD_TM(String UPD_TM) {
        this.UPD_TM = UPD_TM;
    }

    @Override
    public String toString() {
        return "AebkLbhTran{" +
                "REF_NO='" + REF_NO + '\'' +
                ", HIS_NO='" + HIS_NO + '\'' +
                ", TRX_DT=" + TRX_DT +
                ", TRX_AMT=" + TRX_AMT +
                ", AF_JAN='" + AF_JAN + '\'' +
                ", TRX_NM='" + TRX_NM + '\'' +
                ", TRX_FEE=" + TRX_FEE +
                ", RCV_NM1='" + RCV_NM1 + '\'' +
                ", RCV_ACCT_NO='" + RCV_ACCT_NO + '\'' +
                ", REG_EMP_NO='" + REG_EMP_NO + '\'' +
                ", REG_DT=" + REG_DT +
                ", REG_TM='" + REG_TM + '\'' +
                ", UPD_EMP_NO='" + UPD_EMP_NO + '\'' +
                ", UPD_DT=" + UPD_DT +
                ", UPD_TM='" + UPD_TM + '\'' +
                '}';
    }
}
