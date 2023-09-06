package com.local.table;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AebkEohTran {

    @JsonProperty("TRX_DT")
    private String TRX_DT;

    @JsonProperty("TRX_TM")
    private String TRX_TM;

    @JsonProperty("TRC_AD_NO")
    private String TRC_AD_NO;

    @JsonProperty("RET_REF_NO")
    private String RET_REF_NO;

    @JsonProperty("VEN_CD")
    private String VEN_CD;

    @JsonProperty("REF_NO")
    private String REF_NO;

    @JsonProperty("HIS_NO")
    private String HIS_NO;

    @JsonProperty("PARTNER_ID")
    private String PARTNER_ID;

    @JsonProperty("ORG_TRC_AD_NO")
    private String ORG_TRC_AD_NO;

    @JsonProperty("REL_REF_NO")
    private String REL_REF_NO;

    @JsonProperty("DB_ACCT_NO")
    private String DB_ACCT_NO;

    @JsonProperty("CR_ACCT_NO")
    private String CR_ACCT_NO;

    @JsonProperty("BILL_CUST_NO")
    private String BILL_CUST_NO;

    @JsonProperty("BILL_PRD_CD")
    private String BILL_PRD_CD;

    @JsonProperty("TRX_CD")
    private String TRX_CD;

    @JsonProperty("SUB_TRX_CD")
    private String SUB_TRX_CD;

    @JsonProperty("TRX_TYPE")
    private String TRX_TYPE;

    @JsonProperty("STS")
    private String STS;

    @JsonProperty("RESP_CD")
    private String RESP_CD;

    @JsonProperty("REMARK")
    private String REMARK;

    @JsonProperty("TRX_AMT")
    private double TRX_AMT;

    @JsonProperty("TRX_FEE")
    private double TRX_FEE;

    @JsonProperty("FR_BANK_CD")
    private String FR_BANK_CD;

    @JsonProperty("TO_BANK_CD")
    private String TO_BANK_CD;

    @JsonProperty("REG_BR_NO")
    private String REG_BR_NO;

    @JsonProperty("REG_EMP_NO")
    private String REG_EMP_NO;

    @JsonProperty("REG_DT")
    private String REG_DT;

    @JsonProperty("REG_TM")
    private String REG_TM;

    @JsonProperty("UPD_EMP_NO")
    private String UPD_EMP_NO;

    @JsonProperty("UPD_DT")
    private String UPD_DT;

    @JsonProperty("UPD_TM")
    private String UPD_TM;

    @JsonProperty("CHNL_CD")
    private String CHNL_CD;

    public AebkEohTran() {
        TRX_DT = "TO_DATE('2023-09-01', 'YYYY-MM-DD')";
        TRX_TM = "05:49:07";
        TRC_AD_NO = "";
        RET_REF_NO = "";
        VEN_CD = "BIIH";
        REF_NO = "D431188223512191";
        HIS_NO = "0";
        PARTNER_ID = null;
        ORG_TRC_AD_NO = null;
        REL_REF_NO = null;
        DB_ACCT_NO = "118822111541712";
        CR_ACCT_NO = null;
        BILL_CUST_NO = "089687907179";
        BILL_PRD_CD = "26009";
        TRX_CD = "LO4200";
        SUB_TRX_CD = null;
        TRX_TYPE = "PP04";
        STS = "00";
        RESP_CD = "00";
        REMARK = null;
        TRX_AMT = 40000;
        TRX_FEE = 0;
        FR_BANK_CD = "484";
        TO_BANK_CD = null;
        REG_BR_NO = "1188";
        REG_EMP_NO = "L118802";
        UPD_EMP_NO = "L118802";
        REG_DT = "TO_DATE('2023-09-01', 'YYYY-MM-DD')";
        REG_TM = "05:49:07";
        UPD_DT = "TO_DATE('2023-09-01', 'YYYY-MM-DD')";
        UPD_TM = "05:49:07";
        CHNL_CD = "L";
    }

    public String getTRX_DT() {
        return TRX_DT;
    }

    public void setTRX_DT(String TRX_DT) {
        this.TRX_DT = TRX_DT;
    }

    public String getTRX_TM() {
        return TRX_TM;
    }

    public void setTRX_TM(String TRX_TM) {
        this.TRX_TM = TRX_TM;
    }

    public String getTRC_AD_NO() {
        return TRC_AD_NO;
    }

    public void setTRC_AD_NO(String TRC_AD_NO) {
        this.TRC_AD_NO = TRC_AD_NO;
    }

    public String getRET_REF_NO() {
        return RET_REF_NO;
    }

    public void setRET_REF_NO(String RET_REF_NO) {
        this.RET_REF_NO = RET_REF_NO;
    }

    public String getVEN_CD() {
        return VEN_CD;
    }

    public void setVEN_CD(String VEN_CD) {
        this.VEN_CD = VEN_CD;
    }

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

    public String getPARTNER_ID() {
        return PARTNER_ID;
    }

    public void setPARTNER_ID(String PARTNER_ID) {
        this.PARTNER_ID = PARTNER_ID;
    }

    public String getORG_TRC_AD_NO() {
        return ORG_TRC_AD_NO;
    }

    public void setORG_TRC_AD_NO(String ORG_TRC_AD_NO) {
        this.ORG_TRC_AD_NO = ORG_TRC_AD_NO;
    }

    public String getREL_REF_NO() {
        return REL_REF_NO;
    }

    public void setREL_REF_NO(String REL_REF_NO) {
        this.REL_REF_NO = REL_REF_NO;
    }

    public String getDB_ACCT_NO() {
        return DB_ACCT_NO;
    }

    public void setDB_ACCT_NO(String DB_ACCT_NO) {
        this.DB_ACCT_NO = DB_ACCT_NO;
    }

    public String getCR_ACCT_NO() {
        return CR_ACCT_NO;
    }

    public void setCR_ACCT_NO(String CR_ACCT_NO) {
        this.CR_ACCT_NO = CR_ACCT_NO;
    }

    public String getBILL_CUST_NO() {
        return BILL_CUST_NO;
    }

    public void setBILL_CUST_NO(String BILL_CUST_NO) {
        this.BILL_CUST_NO = BILL_CUST_NO;
    }

    public String getBILL_PRD_CD() {
        return BILL_PRD_CD;
    }

    public void setBILL_PRD_CD(String BILL_PRD_CD) {
        this.BILL_PRD_CD = BILL_PRD_CD;
    }

    public String getTRX_CD() {
        return TRX_CD;
    }

    public void setTRX_CD(String TRX_CD) {
        this.TRX_CD = TRX_CD;
    }

    public String getSUB_TRX_CD() {
        return SUB_TRX_CD;
    }

    public void setSUB_TRX_CD(String SUB_TRX_CD) {
        this.SUB_TRX_CD = SUB_TRX_CD;
    }

    public String getTRX_TYPE() {
        return TRX_TYPE;
    }

    public void setTRX_TYPE(String TRX_TYPE) {
        this.TRX_TYPE = TRX_TYPE;
    }

    public String getSTS() {
        return STS;
    }

    public void setSTS(String STS) {
        this.STS = STS;
    }

    public String getRESP_CD() {
        return RESP_CD;
    }

    public void setRESP_CD(String RESP_CD) {
        this.RESP_CD = RESP_CD;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }

    public double getTRX_AMT() {
        return TRX_AMT;
    }

    public void setTRX_AMT(double TRX_AMT) {
        this.TRX_AMT = TRX_AMT;
    }

    public double getTRX_FEE() {
        return TRX_FEE;
    }

    public void setTRX_FEE(double TRX_FEE) {
        this.TRX_FEE = TRX_FEE;
    }

    public String getFR_BANK_CD() {
        return FR_BANK_CD;
    }

    public void setFR_BANK_CD(String FR_BANK_CD) {
        this.FR_BANK_CD = FR_BANK_CD;
    }

    public String getTO_BANK_CD() {
        return TO_BANK_CD;
    }

    public void setTO_BANK_CD(String TO_BANK_CD) {
        this.TO_BANK_CD = TO_BANK_CD;
    }

    public String getREG_BR_NO() {
        return REG_BR_NO;
    }

    public void setREG_BR_NO(String REG_BR_NO) {
        this.REG_BR_NO = REG_BR_NO;
    }

    public String getREG_EMP_NO() {
        return REG_EMP_NO;
    }

    public void setREG_EMP_NO(String REG_EMP_NO) {
        this.REG_EMP_NO = REG_EMP_NO;
    }

    public String getREG_DT() {
        return REG_DT;
    }

    public void setREG_DT(String REG_DT) {
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

    public String getUPD_DT() {
        return UPD_DT;
    }

    public void setUPD_DT(String UPD_DT) {
        this.UPD_DT = UPD_DT;
    }

    public String getUPD_TM() {
        return UPD_TM;
    }

    public void setUPD_TM(String UPD_TM) {
        this.UPD_TM = UPD_TM;
    }

    public String getCHNL_CD() {
        return CHNL_CD;
    }

    public void setCHNL_CD(String CHNL_CD) {
        this.CHNL_CD = CHNL_CD;
    }

    @Override
    public String toString() {
        return "TransactionData{" +
                "TRX_DT=" + TRX_DT +
                ", TRX_TM='" + TRX_TM + '\'' +
                ", TRC_AD_NO='" + TRC_AD_NO + '\'' +
                ", RET_REF_NO='" + RET_REF_NO + '\'' +
                ", VEN_CD='" + VEN_CD + '\'' +
                ", REF_NO='" + REF_NO + '\'' +
                ", HIS_NO='" + HIS_NO + '\'' +
                ", PARTNER_ID='" + PARTNER_ID + '\'' +
                ", ORG_TRC_AD_NO='" + ORG_TRC_AD_NO + '\'' +
                ", REL_REF_NO='" + REL_REF_NO + '\'' +
                ", DB_ACCT_NO='" + DB_ACCT_NO + '\'' +
                ", CR_ACCT_NO='" + CR_ACCT_NO + '\'' +
                ", BILL_CUST_NO='" + BILL_CUST_NO + '\'' +
                ", BILL_PRD_CD='" + BILL_PRD_CD + '\'' +
                ", TRX_CD='" + TRX_CD + '\'' +
                ", SUB_TRX_CD='" + SUB_TRX_CD + '\'' +
                ", TRX_TYPE='" + TRX_TYPE + '\'' +
                ", STS='" + STS + '\'' +
                ", RESP_CD='" + RESP_CD + '\'' +
                ", REMARK='" + REMARK + '\'' +
                ", TRX_AMT=" + TRX_AMT +
                ", TRX_FEE=" + TRX_FEE +
                ", FR_BANK_CD='" + FR_BANK_CD + '\'' +
                ", TO_BANK_CD='" + TO_BANK_CD + '\'' +
                ", REG_BR_NO='" + REG_BR_NO + '\'' +
                ", REG_EMP_NO='" + REG_EMP_NO + '\'' +
                ", REG_DT=" + REG_DT +
                ", REG_TM='" + REG_TM + '\'' +
                ", UPD_EMP_NO='" + UPD_EMP_NO + '\'' +
                ", UPD_DT=" + UPD_DT +
                ", UPD_TM='" + UPD_TM + '\'' +
                ", CHNL_CD='" + CHNL_CD + '\'' +
                '}';
    }
}
