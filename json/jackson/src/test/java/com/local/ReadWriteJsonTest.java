package com.local;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.local.table.AebkEohTran;
import com.local.table.AebkLbhTrxHis;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteJsonTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    void testReadCsv() throws IOException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        ObjectMapper om = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);

        Path path = Path.of("query_2.json");
        List<AebkLbhTrxHis> aebkLbhTrxHisList = om.readValue(path.toFile(), new TypeReference<List<AebkLbhTrxHis>>() {
        });

        path = Path.of("sample_2.json");

        om.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        List<AebkEohTran> aebkEohTrans = om.readValue(path.toFile(), new TypeReference<List<AebkEohTran>>() {
        });

        int success = 0;

        for (int i = 0; i < aebkEohTrans.size(); i++) {
            AebkLbhTrxHis A = null;
            AebkEohTran B = aebkEohTrans.get(i);

            for (int j = 0; j < aebkLbhTrxHisList.size(); j++) {
                AebkLbhTrxHis C = aebkLbhTrxHisList.get(j);

                if (C.getREG_TM().charAt(1) == ':') {
                    C.setREG_TM("0" + C.getREG_TM());
                }

                if (C.getREF_NO().equals(B.getDB_ACCT_NO()) && C.getREG_TM().equals(B.getTRX_TM())) {
                    A = C;
                    log.debug("Line: {}", success);
                    log.debug("DB_ACCT_NO: {}", B.getDB_ACCT_NO());
                    log.debug("TRX_TM: {}", B.getTRX_TM());
                    log.debug("BILL_CUST_NO: {}", C.getRCV_ACCT_NO());
                    log.debug("===============");
                }

                // Parsing string waktu ke objek LocalTime
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                LocalTime localTime = LocalTime.parse(B.getTRX_TM(), formatter);

                // localTime = localTime.minusSeconds(1);
                // String waktuAkhir = localTime.format(formatter);

                if (C.getREF_NO().equals(B.getDB_ACCT_NO())
                        && C.getREG_TM().equals(localTime.minusSeconds(1).toString())) {
                    B.setTRX_TM(localTime.minusSeconds(1).toString());
                    A = C;
                    log.debug("Line: {}", success);
                    log.debug("DB_ACCT_NO: {}", B.getDB_ACCT_NO());
                    log.debug("TRX_TM: {}", B.getTRX_TM());
                    log.debug("BILL_CUST_NO: {}", C.getRCV_ACCT_NO());
                    log.debug("===============");
                } else if (C.getREF_NO().equals(B.getDB_ACCT_NO())
                        && C.getREG_TM().equals(localTime.plusMinutes(1).toString())) {
                    B.setTRX_TM(localTime.plusSeconds(1).toString());
                    A = C;
                    log.debug("Line: {}", success);
                    log.debug("DB_ACCT_NO: {}", B.getDB_ACCT_NO());
                    log.debug("TRX_TM: {}", B.getTRX_TM());
                    log.debug("BILL_CUST_NO: {}", C.getRCV_ACCT_NO());
                    log.debug("===============");
                }

            }

            if (A != null) {
                success = i + 1;
                System.out.println(success);
                // System.out.println("B.DB_ACCT_NO: " + B.getDB_ACCT_NO());
                // System.out.println("B.TRX_TM: " + B.getTRX_TM());
                // System.out.println("BILL_CUST_NO: " + A.getRCV_ACCT_NO());
                if (A.getREF_NO().equals(B.getDB_ACCT_NO()) && A.getREG_TM().equals(B.getTRX_TM())) {
                    B.setTRX_TM(A.getREG_TM());
                    B.setBILL_CUST_NO(A.getRCV_ACCT_NO());
                    B.setREG_TM(A.getREG_TM());
                    B.setUPD_TM(A.getUPD_TM());
                    B.setTRX_TM(A.getREG_TM());

                    // log.debug("Asdasd: {}", A.getUPD_TM());

                    String switchId = A.getRCV_NM1().replaceAll("[\\[\\]\"]", "");
                    if (switchId.equals("26009")) {
                        B.setBILL_PRD_CD("26009");
                        B.setTRX_CD("LO4200");
                        B.setTRX_TYPE("PP04");
                    } else if (switchId.equals("26007")) {
                        B.setBILL_PRD_CD("26007");
                        B.setTRX_CD("LO4200");
                        B.setTRX_TYPE("PP40");
                    } else if (switchId.equals("28004")) {
                        B.setBILL_PRD_CD("28004");
                        B.setTRX_CD("LO4200");
                        B.setTRX_TYPE("KK04");
                    } else if (switchId.equals("28010")) {
                        B.setBILL_PRD_CD("28010");
                        B.setTRX_CD("LO4200");
                        B.setTRX_TYPE("KK10");
                    } else {
                        throw new RuntimeException("ERROR SWITCH NOT FOUND");
                    }

                    B.setTRX_AMT(A.getTRX_AMT());
                    B.setTRX_FEE(A.getTRX_FEE());

                    String insertSql = """
                            INSERT INTO AEBK_EOH_TRAN (TRX_DT, TRX_TM, TRC_AD_NO, RET_REF_NO, VEN_CD, REF_NO, HIS_NO, PARTNER_ID, ORG_TRC_AD_NO, REL_REF_NO, DB_ACCT_NO, CR_ACCT_NO, BILL_CUST_NO, BILL_PRD_CD, TRX_CD, SUB_TRX_CD, TRX_TYPE, STS, RESP_CD, REMARK, TRX_AMT, TRX_FEE, FR_BANK_CD, TO_BANK_CD, REG_BR_NO, REG_EMP_NO, REG_DT, REG_TM, UPD_EMP_NO, UPD_DT, UPD_TM, CHNL_CD)
                            VALUES (TO_DATE ('2023-09-01','yyyy-mm-dd'), :TRX_TM, :TRC_AD_NO, :RET_REF_NO, :VEN_CD, :REF_NO, 0, null, null, null, :DB_ACCT_NO, null, :BILL_CUST_NO, :BILL_PRD_CD, :TRX_CD, null, :TRX_TYPE, '00', '00', null, :TRX_AMT, :TRX_FEE, '484', null, :REG_BR_NO, :REG_EMP_NO, TO_DATE ('2023-06-27','yyyy-mm-dd'), :REG_TM, :UPD_EMP_NO, TO_DATE ('2023-06-27','yyyy-mm-dd'), :UPD_TM, 'L');
                            """
                            .replace(":TRX_TM", "'" + B.getTRX_TM() + "'")
                            .replace(":TRC_AD_NO", "'" + B.getTRC_AD_NO() + "'")
                            .replace(":RET_REF_NO", "'" + B.getRET_REF_NO() + "'")
                            .replace(":VEN_CD", "'" + B.getVEN_CD() + "'")
                            .replace(":REF_NO", "'" + B.getREF_NO() + "'")
                            .replace(":HIS_NO", String.valueOf(B.getHIS_NO()))
                            .replace(":PARTNER_ID", "'" + B.getPARTNER_ID() + "'")
                            .replace(":ORG_TRC_AD_NO", "'" + B.getORG_TRC_AD_NO() + "'")
                            .replace(":REL_REF_NO", "'" + B.getREL_REF_NO() + "'")
                            .replace(":DB_ACCT_NO", "'" + B.getDB_ACCT_NO() + "'")
                            .replace(":CR_ACCT_NO", "'" + B.getCR_ACCT_NO() + "'")
                            .replace(":BILL_CUST_NO", "'" + B.getBILL_CUST_NO() + "'")
                            .replace(":BILL_PRD_CD", "'" + B.getBILL_PRD_CD() + "'")
                            .replace(":TRX_CD", "'" + B.getTRX_CD() + "'")
                            .replace(":SUB_TRX_CD", "'" + B.getSUB_TRX_CD() + "'")
                            .replace(":TRX_TYPE", "'" + B.getTRX_TYPE() + "'")
                            .replace(":STS", "'" + B.getSTS() + "'")
                            .replace(":RESP_CD", "'" + B.getRESP_CD() + "'")
                            .replace(":REMARK", "'" + B.getREMARK() + "'")
                            .replace(":TRX_AMT", String.valueOf(B.getTRX_AMT()))
                            .replace(":TRX_FEE", String.valueOf(B.getTRX_FEE()))
                            .replace(":FR_BANK_CD", "'" + B.getFR_BANK_CD() + "'")
                            .replace(":TO_BANK_CD", "'" + B.getTO_BANK_CD() + "'")
                            .replace(":REG_BR_NO", "'" + B.getREG_BR_NO() + "'")
                            .replace(":REG_EMP_NO", "'" + B.getREG_EMP_NO() + "'")
                            .replace(":REG_DT", "'" + B.getREG_DT() + "'")
                            .replace(":REG_TM", "'" + B.getREG_TM() + "'")
                            .replace(":UPD_EMP_NO", "'" + B.getUPD_EMP_NO() + "'")
                            .replace(":UPD_DT", "'" + B.getUPD_DT() + "'")
                            .replace(":UPD_TM", "'" + B.getUPD_TM() + "'")
                            .replace(":CHNL_CD", "'" + B.getCHNL_CD() + "'");

                    FileWriter fileWriter = new FileWriter("output_2.txt", true);

                    // Tulis string ke dalam file
                    fileWriter.write(insertSql + "\n");

                    // Tutup fileWriter
                    fileWriter.close();
                }

                // NewObject newObject = new NewObject();
                // newObject.setTrx_dt(B.getTRX_DT());
                // newObject.setTrx_tm(B.getTRX_TM());
                // newObject.setTrc_ad_no(B.getTRC_AD_NO());
                // newObject.setRet_ref_no(B.getRET_REF_NO());
                // newObject.setVen_cd(B.getVEN_CD());
                // newObject.setRef_no(B.getREF_NO());
                // newObject.setHis_no(B.getHIS_NO());
                // newObject.setPartner_id(B.getPARTNER_ID());
                // newObject.setOrg_trc_ad_no(B.getORG_TRC_AD_NO());
                // newObject.setRel_ref_no(B.getREL_REF_NO());
                // newObject.setDb_acct_no(B.getDB_ACCT_NO());
                // newObject.setCr_acct_no(B.getCR_ACCT_NO());
                // newObject.setBill_cust_no(B.getBILL_CUST_NO());
                // newObject.setBill_prd_cd(B.getBILL_PRD_CD());
                // newObject.setTrx_cd(B.getTRX_CD());
                // newObject.setSub_trx_cd(B.getSUB_TRX_CD());
                // newObject.setTrx_type(B.getTRX_TYPE());
                // newObject.setSts(B.getSTS());
                // newObject.setResp_cd(B.getRESP_CD());
                // newObject.setRemark(B.getREMARK());
                // newObject.setTrx_amt(B.getTRX_AMT());
                // newObject.setTrx_fee(B.getTRX_FEE());
                // newObject.setFr_bank_cd(B.getFR_BANK_CD());
                // newObject.setTo_bank_cd(B.getTO_BANK_CD());
                // newObject.setReg_br_no(B.getREG_BR_NO());
                // newObject.setReg_emp_no(B.getREG_EMP_NO());
                // newObject.setReg_dt(B.getREG_DT());
                // newObject.setReg_tm(B.getREG_TM());
                // newObject.setUpd_emp_no(B.getUPD_EMP_NO());
                // newObject.setUpd_dt(B.getUPD_DT());
                // newObject.setUpd_tm(B.getUPD_TM());
                // newObject.setChnl_cd(B.getCHNL_CD());
                //
                // newObjects.add(newObject);
                // newAebkEohTran.add(B);
                // String s = om.writeValueAsString(B);
                // System.out.println(s);
            }
        }

        // om.writeValue(new File("output.json"), newObjects);
        // String s = om.writeValueAsString(newObjects);
        // System.out.println(s);

        // reader.close();
        // parser.close();
    }

    @Test
    void testString() {
        String a = "5:32:32";

        if (a.charAt(1) == ':') {
            a = "0" + a;
        }

        System.out.println(a);
        // System.out.println(a.charAt(1) == ':');
        // System.out.println(a.charAt(0) == ':');

        char l = "05:32:32".charAt("05:32:32".length() - 1);
        System.out.println(l);
        String ll = "05:32:32".substring(0, "05:32:32".length() - 1);
        String lll = ll + String.valueOf(l);
        System.out.println(lll);

        String s = """
                asd ASDASD :ASDASD
                """.replace(":ASDASD", "OK");
        System.out.println(s);
    }

    @Test
    void setupValues() throws IOException {
        String[] REF_NO = {
                "D431188223512282",
                "D431188223512283",
                "D431188223512288",
                "D431188223512289",
                "D431188223512290",
                "D431188223512294",
                "D431188223512298",
                "D431188223512300",
                "D431188223512303",
                "D431188223512304",
                "D431188223512306",
                "D431188223512308",
                "D431188223512309",
                "D431188223512312",
                "D431188223512314",
                "D431188223512317",
                "D431188223512318",
                "D431188223512319",
                "D431188223512323",
                "D431188223512324",
                "D431188223512327",
                "D431188223512330",
                "D431188223512332",
                "D431188223512333",
                "D431188223512336",
                "D431188223512337",
                "D431188223512339",
                "D431188223512340",
                "D431188223512341",
                "D431188223512343",
                "D431188223512344",
                "D431188223512345",
                "D431188223512346",
                "D431188223512349",
                "D431188223512354",
                "D431188223512361",
                "D431188223512364",
                "D431188223512366",
                "D431188223512368",
                "D431188223512369",
                "D431188223512371",
                "D431188223512375",
                "D431188223512380",
                "D431188223512381",
                "D431188223512384",
                "D431188223512386",
                "D431188223512392",
                "D431188223512393",
                "D431188223512398"
        };

        String[] DB_ACCT_NO = {
                "118822107692412",
                "118822122830612",
                "118822105951812",
                "118822135831912",
                "118822124585112",
                "118822303324512",
                "118822107756012",
                "118822123723012",
                "118822111648812",
                "118822111648812",
                "118822111648812",
                "118822224828812",
                "118822312616212",
                "118822133583312",
                "118822219137412",
                "118822107415512",
                "118822208590112",
                "118822214653712",
                "118822227249212",
                "118822120553212",
                "118822305331512",
                "118822228598912",
                "118822126008012",
                "118822118263412",
                "118822105951812",
                "118822311319912",
                "118822102723312",
                "118822215795412",
                "118822112912812",
                "118822129006212",
                "118822102723312",
                "118822319953512",
                "118822228952012",
                "118822127927112",
                "118822316801412",
                "118822122898312",
                "118822122898312",
                "118822130708712",
                "118822215795412",
                "118822210851012",
                "118822229544012",
                "118822206128312",
                "118822202505712",
                "118822306803312",
                "118822306803312",
                "118822315168212",
                "118822305325212",
                "118822122891512",
                "118822302257912"
        };

        String[] TRX_TM = {
                "07:46:05",
                "07:46:36",
                "07:57:07",
                "07:58:35",
                "07:59:31",
                "08:03:45",
                "08:06:08",
                "08:10:43",
                "08:13:16",
                "08:13:53",
                "08:14:35",
                "08:15:40",
                "08:16:57",
                "08:23:34",
                "08:26:30",
                "08:28:47",
                "08:29:02",
                "08:29:36",
                "08:33:16",
                "08:34:03",
                "08:36:43",
                "08:46:26",
                "08:48:57",
                "08:54:08",
                "08:56:40",
                "08:57:17",
                "08:59:37",
                "09:01:52",
                "09:04:09",
                "09:07:05",
                "09:07:15",
                "09:09:08",
                "09:09:09",
                "09:10:08",
                "09:14:42",
                "09:20:09",
                "09:21:45",
                "09:24:38",
                "09:28:01",
                "09:28:10",
                "09:29:24",
                "09:32:18",
                "09:36:20",
                "09:39:37",
                "09:40:33",
                "09:41:20",
                "09:43:31",
                "09:45:15",
                "09:51:48"
        };

        Path path = Path.of("aebk_eoh_tran.json");

        ObjectMapper om = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        List<AebkEohTran> aebkEohTrans = new ArrayList<>();

        for (int i = 0; i < REF_NO.length; i++) {

            LocalTime localTime = LocalTime.parse(TRX_TM[i], formatter);
            localTime = localTime.plusSeconds(1);
            String trxTm = localTime.format(formatter);

            AebkEohTran aebkEohTran = om.readValue(path.toFile(), AebkEohTran.class);
            aebkEohTran.setTRX_TM(trxTm);
            aebkEohTran.setREF_NO(REF_NO[i]);
            aebkEohTran.setDB_ACCT_NO(DB_ACCT_NO[i]);
            aebkEohTran.setREG_TM(trxTm);
            aebkEohTran.setUPD_TM(trxTm);

            aebkEohTrans.add(aebkEohTran);
        }

        om.writeValue(new File("aebk_eoh_tran_output.json"), aebkEohTrans);
    }

    @Test
    void setupValues2() throws IOException {
        String[] REF_NO = {
                "D431188223512104",
                "D431188223512107",
                "D431188223512111",
                "D431188223512112",
                "D431188223512114",
                "D431188223512115",
                "D431188223512116",
                "D431188223512125",
                "D431188223512126",
                "D431188223512127",
                "D431188223512131",
                "D431188223512136",
                "D431188223512137",
                "D431188223512138",
                "D431188223512143",
                "D431188223512145",
                "D431188223512149",
                "D431188223512158",
                "D431188223512159",
                "D431188223512160",
                "D431188223512165",
                "D431188223512166",
                "D431188223512167",
                "D431188223512168",
                "D431188223512174",
                "D431188223512178",
                "D431188223512189",
                "D431188223512190",
                "D431188223512191",
                "D431188223512192",
                "D431188223512193",
                "D431188223512194",
                "D431188223512201",
                "D431188223512203",
                "D431188223512204",
                "D431188223512206",
                "D431188223512211",
                "D431188223512213",
                "D431188223512216",
                "D431188223512219",
                "D431188223512220",
                "D431188223512222",
                "D431188223512224",
                "D431188223512225",
                "D431188223512226",
                "D431188223512228",
                "D431188223512230",
                "D431188223512236",
                "D431188223512245",
                "D431188223512255",
                "D431188223512260",
                "D431188223512263",
                "D431188223512264",
                "D431188223512265",
                "D431188223512266",
                "D431188223512267",
                "D431188223512268",
                "D431188223512274",
                "D431188223512275",
                "D431188223512277",
                "D431188223512278",
                "D431188223512279"
        };

        String[] DB_ACCT_NO = {
                "118822228895312",
                "118822111539212",
                "118822100318112",
                "118822127913012",
                "118822101838412",
                "118822201882212",
                "118822121335612",
                "118822114709112",
                "118822114709112",
                "118822114709112",
                "118822204961312",
                "118822122286312",
                "118822130789812",
                "118822318420712",
                "118822136438912",
                "118822136438912",
                "118822109930812",
                "118822220646612",
                "118822305353712",
                "118822305353712",
                "118822303542712",
                "118822212312112",
                "118822133888112",
                "118822133888112",
                "118822226135512",
                "118822308713212",
                "118822203244112",
                "118822111541712",
                "118822111541712",
                "118822119270812",
                "118822139273612",
                "118822321433612",
                "118822207731012",
                "118822209809812",
                "118822207821312",
                "118822207821312",
                "118822321147412",
                "118822122728012",
                "118822135255112",
                "118822115106812",
                "118822115106812",
                "118822127927112",
                "118822305617412",
                "118822305617412",
                "118822206388712",
                "118822304873012",
                "118822308786812",
                "118822118238112",
                "118822111541712",
                "118822317169112",
                "118822128416812",
                "118822215973812",
                "118822123641712",
                "118822109835912",
                "118822206151512",
                "118822111805212",
                "118822103620512",
                "118822109040412",
                "118822300210712",
                "118822317815512",
                "118822222919812",
                "118822109040412"
        };

        String[] TRX_TM = {
                "00:03:54",
                "00:07:25",
                "00:18:00",
                "00:18:03",
                "00:19:46",
                "00:19:49",
                "00:20:54",
                "00:58:31",
                "00:58:58",
                "01:00:52",
                "01:13:55",
                "01:42:30",
                "01:54:04",
                "01:55:14",
                "02:38:31",
                "02:44:50",
                "03:36:09",
                "04:31:20",
                "04:45:03",
                "04:45:45",
                "05:14:17",
                "05:18:18",
                "05:23:35",
                "05:26:02",
                "05:28:49",
                "05:38:08",
                "05:48:16",
                "05:48:36",
                "05:49:06",
                "05:49:48",
                "05:51:04",
                "05:52:32",
                "06:13:44",
                "06:14:38",
                "06:19:20",
                "06:19:57",
                "06:24:19",
                "06:27:20",
                "06:32:08",
                "06:36:20",
                "06:36:39",
                "06:41:21",
                "06:42:37",
                "06:45:26",
                "06:46:36",
                "06:48:34",
                "06:53:45",
                "06:57:40",
                "07:01:36",
                "07:15:50",
                "07:20:35",
                "07:23:43",
                "07:25:43",
                "07:31:14",
                "07:34:34",
                "07:36:09",
                "07:36:14",
                "07:42:10",
                "07:42:32",
                "07:43:27",
                "07:43:40",
                "07:45:22"
        };

        Path path = Path.of("aebk_eoh_tran.json");

        ObjectMapper om = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, true);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        List<AebkEohTran> aebkEohTrans = new ArrayList<>();

        for (int i = 0; i < REF_NO.length; i++) {

            LocalTime localTime = LocalTime.parse(TRX_TM[i], formatter);
            localTime = localTime.plusSeconds(1);
            String trxTm = localTime.format(formatter);

            AebkEohTran aebkEohTran = om.readValue(path.toFile(), AebkEohTran.class);
            aebkEohTran.setTRX_TM(trxTm);
            aebkEohTran.setREF_NO(REF_NO[i]);
            aebkEohTran.setDB_ACCT_NO(DB_ACCT_NO[i]);
            aebkEohTran.setREG_TM(trxTm);
            aebkEohTran.setUPD_TM(trxTm);

            aebkEohTrans.add(aebkEohTran);
        }

        om.writeValue(new File("aebk_eoh_tran_output_2.json"), aebkEohTrans);
    }
}
