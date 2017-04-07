package com.huawei.vodafone.bean;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by Administrator on 2017/1/5.
 */
public class Envelope {
    private EnvelopeBean Envelope;

    public static Envelope objectFromData(String str) {

        return new Gson().fromJson(str, Envelope.class);
    }

    public EnvelopeBean getEnvelope() {
        return Envelope;
    }

    public void setEnvelope(EnvelopeBean Envelope) {
        this.Envelope = Envelope;
    }

    public static class EnvelopeBean {
        private BodyBean Body;
        private String soapenv;

        public static EnvelopeBean objectFromData(String str) {

            return new Gson().fromJson(str, EnvelopeBean.class);
        }

        public BodyBean getBody() {
            return Body;
        }

        public void setBody(BodyBean Body) {
            this.Body = Body;
        }

        public String getSoapenv() {
            return soapenv;
        }

        public void setSoapenv(String soapenv) {
            this.soapenv = soapenv;
        }

        public static class BodyBean {
            /**
             * QueryCustomerInfoResultMsg : {"QueryCustomerInfoResult":{"Account":{"AcctInfo":{"AcctBasicInfo":{"AcctProperty":[{"Code":"C_BILLING_GROUP_NO","Value":""},{"Code":"C_GRACE_PERIOD","Value":""},{"Code":"C_DDI_STATUS","Value":""},{"Code":"C_DCA_NAME","Value":""},{"Code":"C_FRAUD_WRITEOFF_FLAG","Value":"N"},{"Code":"C_IMG_IDX","Value":""},{"Code":"C_LATEFEE_FLAG","Value":"N"},{"Code":"C_DD_REFERENCE","Value":""},{"Code":"C_INIT_BALANCE","Value":""},{"Code":"C_OVER_DRAFT_FOR_PREPAID","Value":""},{"Code":"C_ACCOUNT_RELIABILITY","Value":""},{"Code":"C_ACCOUNT_CATEGORY","Value":""},{"Code":"C_SOCIETY","Value":""},{"Code":"C_MARKETING_CATEGORY","Value":""},{"Code":"C_RFC","Value":""},{"Code":"C_ACCOUNT_GRACE_PERIOD","Value":""},{"Code":"C_DUNNING_EXCEPTION_LIST","Value":"0000"},{"Code":"C_REF_A","Value":""},{"Code":"C_REF_B","Value":""},{"Code":"C_CREDIT_RECALCULATION_FLAG","Value":"N"}],"BillLang":2002,"DunningFlag":1,"LateFeeChargeable":"N","RedlistFlag":0},"AcctClass":2,"AcctCode":"CBS100000000000005132","AcctPayMethod":1,"AcctType":1,"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"BillCycleEndDate":20170131160000,"BillCycleOpenDate":20161231160000,"BillCycleType":1,"CurrencyID":1049,"PaymentType":0,"RootAcctKey":20160827221825,"UserCustomer":{"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}},"UserCustomerKey":20160827221825},"AcctKey":20160827221825},"Customer":{"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}},"Subscriber":{"PaymentMode":0,"PrimaryOffering":{"BundledFlag":"S","OfferingClass":"I","OfferingKey":{"OfferingID":120001,"PurchaseSeq":7046},"ProductInst":[{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"M","ProductID":1053,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1014,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1042,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1822969218,"ProductType":1}],"Status":2},"SubscriberInfo":{"ActivationTime":20160830100035,"ActiveTimeLimit":20151231000000,"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"Brand":1218989000,"NetworkType":1,"Status":2,"StatusDetail":"000000000000000000000000","SubBasicInfo":{"DunningFlag":1,"IVRLang":2002,"SubLevel":1,"SubProperty":[{"Code":"C_SUB_LOAN_FLAG","Value":1},{"Code":"C_SUB_REFEREE_IDENTIFER","Value":""},{"Code":"C_SUB_EXTEND_DAYS","Value":0},{"Code":"C_SUB_AUTOTOPUP_LOWBALANCE","Value":1},{"Code":"C_APP_ACTIVE_USAGE","Value":0},{"Code":"C_SUB_MEDIA_FLAG","Value":"N"},{"Code":"C_CONTRACT_END_DATE","Value":""},{"Code":"C_SUB_LASTRECHARGETIME","Value":20170105065600},{"Code":"C_HANDSET_NETWORK","Value":""},{"Code":"C_SUB_LOAN_STATUS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG","Value":0},{"Code":"C_SUB_MAX_VALIDITY","Value":365},{"Code":"C_SUB_MSCC_FEE_AMOUNT","Value":0},{"Code":"C_SUB_PROB","Value":""},{"Code":"C_SUB_SALT","Value":"5325DB061D037F06"},{"Code":"C_MGB_LEVEL","Value":0},{"Code":"C_RENT_START_DATE","Value":""},{"Code":"C_STARTTIME_OF_SWITCH_COS","Value":-1},{"Code":"C_BUYOUT_APPLY_DATE","Value":""},{"Code":"C_HANDSET_BRAND","Value":""},{"Code":"C_TOPUP_PEAK_FLAG","Value":0},{"Code":"C_SUBS_EX_TYPE_BAK","Value":-1},{"Code":"C_BUYOUT_SUB_NUMBER","Value":""},{"Code":"C_SUB_AUTOTOPUP_RECURRING","Value":1},{"Code":"C_SUBDISCOUNT","Value":"O"},{"Code":"C_SUB_MAX_BALANCE","Value":-1},{"Code":"C_DIC_OFFER_USE_DATE","Value":""},{"Code":"C_SALES_CHANNEL_ID","Value":""},{"Code":"C_BUYOUT_START_DATE","Value":""},{"Code":"C_SUB_SERVICEPROVIDER","Value":""},{"Code":"C_HANDSET_OS_TYPE","Value":""},{"Code":"C_DIC_OFFER_USE_TIMES","Value":0},{"Code":"C_SUB_LASTRECHARGEAMT","Value":2000},{"Code":"C_IS_GROUP_MEMBER","Value":0},{"Code":"C_SUB_ONNET_DAYS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG_BAK","Value":0},{"Code":"C_SUB_LOW_BAL_GATE_1","Value":10000},{"Code":"C_SUB_BARRINGCODE","Value":99999999999},{"Code":"C_RENT_END_DATE","Value":""},{"Code":"C_SUB_REGISTERED","Value":1},{"Code":"C_SWITCH_COS_NUM","Value":0},{"Code":"C_SUBS_BUYOUT_FEE","Value":""}],"WrittenLang":2002},"SubClass":2,"SubIdentity":{"PrimaryFlag":1,"SubIdentity":4915298006711,"SubIdentityType":1},"UserCustomer":{"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}},"UserCustomerKey":20160827221825},"SubscriberKey":20160827221825,"SupplementaryOffering":[{"ActivationMode":"A","ActivationTime":20160830100035,"BundledFlag":"S","EffectiveTime":20160830100035,"ExpirationTime":20361231230000,"OfferingClass":"I","OfferingKey":{"OfferingID":120002,"PurchaseSeq":7047},"Status":2,"OInstProperty":[{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}]},{"ActivationMode":"A","ActivationTime":20160901172100,"BundledFlag":"S","EffectiveTime":20160901172100,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010007372},"Status":2},{"ActivationMode":"A","ActivationTime":20161214052053,"BundledFlag":"S","EffectiveTime":20161214052053,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010016006},"Status":2},{"ActivationMode":"A","ActivationTime":20160901121315,"BundledFlag":"S","EffectiveTime":20160901121315,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010007389},"Status":2},{"ActivationMode":"A","ActivationTime":20160901112712,"BundledFlag":"S","EffectiveTime":20160901112712,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010007375},"Status":2},{"ActivationMode":"A","ActivationTime":20160909154332,"BundledFlag":"S","EffectiveTime":20160909154332,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":49900},{"SubPropCode":"C_UNIT_VOLUME","Value":300}]},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":69900},{"SubPropCode":"C_DATA_VOLUME","Value":524288000}]}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011174},"Status":2},{"ActivationMode":"A","ActivationTime":20160909102218,"BundledFlag":"S","EffectiveTime":20160909102218,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011186},"Status":2},{"ActivationMode":"A","ActivationTime":20160912102736,"BundledFlag":"S","EffectiveTime":20160912102736,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011226},"Status":2},{"ActivationMode":"A","ActivationTime":20160907122537,"BundledFlag":"S","EffectiveTime":20160907122537,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011099},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125641,"BundledFlag":"S","EffectiveTime":20160907125641,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011101},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125648,"BundledFlag":"S","EffectiveTime":20160907125648,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011102},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125700,"BundledFlag":"S","EffectiveTime":20160907125700,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011103},"Status":2},{"ActivationMode":"A","ActivationTime":20160907185633,"BundledFlag":"S","EffectiveTime":20160907185633,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011104},"Status":2},{"ActivationMode":"A","ActivationTime":20160907131447,"BundledFlag":"S","EffectiveTime":20160907131447,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011110},"Status":2},{"ActivationMode":"A","ActivationTime":20160907191421,"BundledFlag":"S","EffectiveTime":20160907191421,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011111},"Status":2},{"ActivationMode":"A","ActivationTime":20160907200549,"BundledFlag":"S","EffectiveTime":20160907200549,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010011112},"Status":2},{"ActivationMode":"A","ActivationTime":20160907123031,"BundledFlag":"S","EffectiveTime":20160907123031,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011100},"Status":2},{"ActivationMode":"A","ActivationTime":20160907130120,"BundledFlag":"S","EffectiveTime":20160907130120,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011105},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190048,"BundledFlag":"S","EffectiveTime":20160907190048,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011106},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190127,"BundledFlag":"S","EffectiveTime":20160907190127,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011107},"Status":2},{"ActivationMode":"A","ActivationTime":20160907130228,"BundledFlag":"S","EffectiveTime":20160907130228,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011108},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190156,"BundledFlag":"S","EffectiveTime":20160907190156,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011109},"Status":2},{"ActivationMode":"A","ActivationTime":20160907140906,"BundledFlag":"S","EffectiveTime":20160907140906,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010011113},"Status":2},{"ActivationMode":"A","ActivationTime":20160908032202,"BundledFlag":"S","EffectiveTime":20160908032202,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011139},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070014,"BundledFlag":"S","EffectiveTime":20160908070014,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011142},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070118,"BundledFlag":"S","EffectiveTime":20160908070118,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011143},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070131,"BundledFlag":"S","EffectiveTime":20160908070131,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011144},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141754,"BundledFlag":"S","EffectiveTime":20160908141754,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011149},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141846,"BundledFlag":"S","EffectiveTime":20160908141846,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011150},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141847,"BundledFlag":"S","EffectiveTime":20160908141847,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011151},"Status":2},{"ActivationMode":"A","ActivationTime":20160909154450,"BundledFlag":"S","EffectiveTime":20160909154450,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":69900},{"SubPropCode":"C_DATA_VOLUME","Value":524288000}]},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":19900},{"SubPropCode":"C_UNIT_VOLUME","Value":100}]},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011176},"Status":2},{"ActivationMode":"A","ActivationTime":20160912103050,"BundledFlag":"S","EffectiveTime":20160912103050,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0},{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011227},"Status":2},{"ActivationMode":"A","ActivationTime":20160912110134,"BundledFlag":"S","EffectiveTime":20160912110134,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011231},"Status":2},{"ActivationMode":"A","ActivationTime":20160912110215,"BundledFlag":"S","EffectiveTime":20160912110215,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011232},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193431,"BundledFlag":"S","EffectiveTime":20160912193431,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011239},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193431,"BundledFlag":"S","EffectiveTime":20160912193431,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011240},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193435,"BundledFlag":"S","EffectiveTime":20160912193435,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011241},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193437,"BundledFlag":"S","EffectiveTime":20160912193437,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011242},"Status":2},{"ActivationMode":"A","ActivationTime":20160908025540,"BundledFlag":"S","EffectiveTime":20160908025540,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011138},"Status":2},{"ActivationMode":"A","ActivationTime":20160908065305,"BundledFlag":"S","EffectiveTime":20160908065305,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011141},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141743,"BundledFlag":"S","EffectiveTime":20160908141743,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011148},"Status":2},{"ActivationMode":"A","ActivationTime":20160909101912,"BundledFlag":"S","EffectiveTime":20160909101912,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909101912,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":49900},{"SubPropCode":"C_DATA_VOLUME","Value":314572800}]},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":19900},{"SubPropCode":"C_UNIT_VOLUME","Value":100}]},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011184},"Status":2},{"ActivationMode":"A","ActivationTime":20160909102043,"BundledFlag":"S","EffectiveTime":20160909102043,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011185},"Status":2},{"ActivationMode":"A","ActivationTime":20160912103657,"BundledFlag":"S","EffectiveTime":20160912103657,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011228},"Status":2},{"ActivationMode":"A","ActivationTime":20160913022752,"BundledFlag":"S","EffectiveTime":20160913022752,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011252},"Status":2},{"ActivationMode":"A","ActivationTime":20160914082217,"BundledFlag":"S","EffectiveTime":20160914082217,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010012072},"Status":2},{"ActivationMode":"A","ActivationTime":20160914105033,"BundledFlag":"S","EffectiveTime":20160914105033,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010012099},"Status":2},{"ActivationMode":"A","ActivationTime":20160919053043,"BundledFlag":"S","EffectiveTime":20160919053043,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010012192},"Status":2},{"ActivationMode":"A","ActivationTime":20160919053045,"BundledFlag":"S","EffectiveTime":20160919053045,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010012193},"Status":2},{"ActivationMode":"A","ActivationTime":20160919073102,"BundledFlag":"S","EffectiveTime":20160919073102,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010012245},"Status":2},{"ActivationMode":"A","ActivationTime":20160919073126,"BundledFlag":"S","EffectiveTime":20160919073126,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010012246},"Status":2},{"ActivationMode":"A","ActivationTime":20160920084613,"BundledFlag":"S","EffectiveTime":20160920084613,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010012323},"Status":2},{"ActivationMode":"A","ActivationTime":20160921090701,"BundledFlag":"S","EffectiveTime":20160921090701,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010012588},"Status":2},{"ActivationMode":"A","ActivationTime":20160921090727,"BundledFlag":"S","EffectiveTime":20160921090727,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010012591},"Status":2},{"ActivationMode":"A","ActivationTime":20160921091315,"BundledFlag":"S","EffectiveTime":20160921091315,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010012595},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193710,"BundledFlag":"S","EffectiveTime":20161014193710,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014151},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193739,"BundledFlag":"S","EffectiveTime":20161014193739,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014152},"Status":2},{"ActivationMode":"A","ActivationTime":20161013021409,"BundledFlag":"S","EffectiveTime":20161013021409,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120008,"PurchaseSeq":101991010014116},"Status":2},{"ActivationMode":"A","ActivationTime":20161013023029,"BundledFlag":"S","EffectiveTime":20161013023029,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014117},"Status":2},{"ActivationMode":"A","ActivationTime":20161013023440,"BundledFlag":"S","EffectiveTime":20161013023440,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014118},"Status":2},{"ActivationMode":"A","ActivationTime":20161013030529,"BundledFlag":"S","EffectiveTime":20161013030529,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010014126},"Status":2},{"ActivationMode":"A","ActivationTime":20161013030623,"BundledFlag":"S","EffectiveTime":20161013030623,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120008,"PurchaseSeq":101991010014127},"Status":2},{"ActivationMode":"A","ActivationTime":20161013064040,"BundledFlag":"S","EffectiveTime":20161013064040,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014128},"Status":2},{"ActivationMode":"A","ActivationTime":20161014063111,"BundledFlag":"S","EffectiveTime":20161014063111,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014138},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193812,"BundledFlag":"S","EffectiveTime":20161014193812,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014153},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200847,"BundledFlag":"S","EffectiveTime":20161015200847,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014156},"Status":2},{"ActivationMode":"A","ActivationTime":20161015201007,"BundledFlag":"S","EffectiveTime":20161015201007,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010014158},"Status":2},{"ActivationMode":"A","ActivationTime":20161015201043,"BundledFlag":"S","EffectiveTime":20161015201043,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014159},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200756,"BundledFlag":"S","EffectiveTime":20161015200756,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014154},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200816,"BundledFlag":"S","EffectiveTime":20161015200816,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014155},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200919,"BundledFlag":"S","EffectiveTime":20161015200919,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014157},"Status":2},{"ActivationMode":"A","ActivationTime":20161011160407,"BundledFlag":"S","EffectiveTime":20161011160407,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014067},"Status":2},{"ActivationMode":"A","ActivationTime":20161011160527,"BundledFlag":"S","EffectiveTime":20161011160527,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014068},"Status":2},{"ActivationMode":"A","ActivationTime":20161027084258,"BundledFlag":"S","EffectiveTime":20161027084258,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010015132},"Status":2},{"ActivationMode":"A","ActivationTime":20161103152006,"BundledFlag":"S","EffectiveTime":20161103152006,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015215},"Status":2},{"ActivationMode":"A","ActivationTime":20161027084239,"BundledFlag":"S","EffectiveTime":20161027084239,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010015131},"Status":2},{"ActivationMode":"A","ActivationTime":20161018054107,"BundledFlag":"S","EffectiveTime":20161018054107,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010015055},"Status":2},{"ActivationMode":"A","ActivationTime":20161026101953,"BundledFlag":"S","EffectiveTime":20161026101953,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015098},"Status":2},{"ActivationMode":"A","ActivationTime":20161102082810,"BundledFlag":"S","EffectiveTime":20161102082810,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015165},"Status":2},{"ActivationMode":"A","ActivationTime":20161102104051,"BundledFlag":"S","EffectiveTime":20161102104051,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015171},"Status":2},{"ActivationMode":"A","ActivationTime":20161103152158,"BundledFlag":"S","EffectiveTime":20161103152158,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015216},"Status":2}]}},"ResultHeader":{"MsgLanguageCode":2002,"ResultCode":0,"ResultDesc":"Operation successfully.","Version":1},"bcc":"http://www.huawei.com/bme/cbsinterface/bccommon","bcs":"http://www.huawei.com/bme/cbsinterface/bcservices","cbs":"http://www.huawei.com/bme/cbsinterface/cbscommon"}
             */

            private QueryCustomerInfoResultMsgBean QueryCustomerInfoResultMsg;

            public static BodyBean objectFromData(String str) {

                return new Gson().fromJson(str, BodyBean.class);
            }

            public QueryCustomerInfoResultMsgBean getQueryCustomerInfoResultMsg() {
                return QueryCustomerInfoResultMsg;
            }

            public void setQueryCustomerInfoResultMsg(QueryCustomerInfoResultMsgBean QueryCustomerInfoResultMsg) {
                this.QueryCustomerInfoResultMsg = QueryCustomerInfoResultMsg;
            }

            public static class QueryCustomerInfoResultMsgBean {
                /**
                 * QueryCustomerInfoResult : {"Account":{"AcctInfo":{"AcctBasicInfo":{"AcctProperty":[{"Code":"C_BILLING_GROUP_NO","Value":""},{"Code":"C_GRACE_PERIOD","Value":""},{"Code":"C_DDI_STATUS","Value":""},{"Code":"C_DCA_NAME","Value":""},{"Code":"C_FRAUD_WRITEOFF_FLAG","Value":"N"},{"Code":"C_IMG_IDX","Value":""},{"Code":"C_LATEFEE_FLAG","Value":"N"},{"Code":"C_DD_REFERENCE","Value":""},{"Code":"C_INIT_BALANCE","Value":""},{"Code":"C_OVER_DRAFT_FOR_PREPAID","Value":""},{"Code":"C_ACCOUNT_RELIABILITY","Value":""},{"Code":"C_ACCOUNT_CATEGORY","Value":""},{"Code":"C_SOCIETY","Value":""},{"Code":"C_MARKETING_CATEGORY","Value":""},{"Code":"C_RFC","Value":""},{"Code":"C_ACCOUNT_GRACE_PERIOD","Value":""},{"Code":"C_DUNNING_EXCEPTION_LIST","Value":"0000"},{"Code":"C_REF_A","Value":""},{"Code":"C_REF_B","Value":""},{"Code":"C_CREDIT_RECALCULATION_FLAG","Value":"N"}],"BillLang":2002,"DunningFlag":1,"LateFeeChargeable":"N","RedlistFlag":0},"AcctClass":2,"AcctCode":"CBS100000000000005132","AcctPayMethod":1,"AcctType":1,"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"BillCycleEndDate":20170131160000,"BillCycleOpenDate":20161231160000,"BillCycleType":1,"CurrencyID":1049,"PaymentType":0,"RootAcctKey":20160827221825,"UserCustomer":{"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}},"UserCustomerKey":20160827221825},"AcctKey":20160827221825},"Customer":{"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}},"Subscriber":{"PaymentMode":0,"PrimaryOffering":{"BundledFlag":"S","OfferingClass":"I","OfferingKey":{"OfferingID":120001,"PurchaseSeq":7046},"ProductInst":[{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"M","ProductID":1053,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1014,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1042,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1822969218,"ProductType":1}],"Status":2},"SubscriberInfo":{"ActivationTime":20160830100035,"ActiveTimeLimit":20151231000000,"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"Brand":1218989000,"NetworkType":1,"Status":2,"StatusDetail":"000000000000000000000000","SubBasicInfo":{"DunningFlag":1,"IVRLang":2002,"SubLevel":1,"SubProperty":[{"Code":"C_SUB_LOAN_FLAG","Value":1},{"Code":"C_SUB_REFEREE_IDENTIFER","Value":""},{"Code":"C_SUB_EXTEND_DAYS","Value":0},{"Code":"C_SUB_AUTOTOPUP_LOWBALANCE","Value":1},{"Code":"C_APP_ACTIVE_USAGE","Value":0},{"Code":"C_SUB_MEDIA_FLAG","Value":"N"},{"Code":"C_CONTRACT_END_DATE","Value":""},{"Code":"C_SUB_LASTRECHARGETIME","Value":20170105065600},{"Code":"C_HANDSET_NETWORK","Value":""},{"Code":"C_SUB_LOAN_STATUS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG","Value":0},{"Code":"C_SUB_MAX_VALIDITY","Value":365},{"Code":"C_SUB_MSCC_FEE_AMOUNT","Value":0},{"Code":"C_SUB_PROB","Value":""},{"Code":"C_SUB_SALT","Value":"5325DB061D037F06"},{"Code":"C_MGB_LEVEL","Value":0},{"Code":"C_RENT_START_DATE","Value":""},{"Code":"C_STARTTIME_OF_SWITCH_COS","Value":-1},{"Code":"C_BUYOUT_APPLY_DATE","Value":""},{"Code":"C_HANDSET_BRAND","Value":""},{"Code":"C_TOPUP_PEAK_FLAG","Value":0},{"Code":"C_SUBS_EX_TYPE_BAK","Value":-1},{"Code":"C_BUYOUT_SUB_NUMBER","Value":""},{"Code":"C_SUB_AUTOTOPUP_RECURRING","Value":1},{"Code":"C_SUBDISCOUNT","Value":"O"},{"Code":"C_SUB_MAX_BALANCE","Value":-1},{"Code":"C_DIC_OFFER_USE_DATE","Value":""},{"Code":"C_SALES_CHANNEL_ID","Value":""},{"Code":"C_BUYOUT_START_DATE","Value":""},{"Code":"C_SUB_SERVICEPROVIDER","Value":""},{"Code":"C_HANDSET_OS_TYPE","Value":""},{"Code":"C_DIC_OFFER_USE_TIMES","Value":0},{"Code":"C_SUB_LASTRECHARGEAMT","Value":2000},{"Code":"C_IS_GROUP_MEMBER","Value":0},{"Code":"C_SUB_ONNET_DAYS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG_BAK","Value":0},{"Code":"C_SUB_LOW_BAL_GATE_1","Value":10000},{"Code":"C_SUB_BARRINGCODE","Value":99999999999},{"Code":"C_RENT_END_DATE","Value":""},{"Code":"C_SUB_REGISTERED","Value":1},{"Code":"C_SWITCH_COS_NUM","Value":0},{"Code":"C_SUBS_BUYOUT_FEE","Value":""}],"WrittenLang":2002},"SubClass":2,"SubIdentity":{"PrimaryFlag":1,"SubIdentity":4915298006711,"SubIdentityType":1},"UserCustomer":{"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}},"UserCustomerKey":20160827221825},"SubscriberKey":20160827221825,"SupplementaryOffering":[{"ActivationMode":"A","ActivationTime":20160830100035,"BundledFlag":"S","EffectiveTime":20160830100035,"ExpirationTime":20361231230000,"OfferingClass":"I","OfferingKey":{"OfferingID":120002,"PurchaseSeq":7047},"Status":2,"OInstProperty":[{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}]},{"ActivationMode":"A","ActivationTime":20160901172100,"BundledFlag":"S","EffectiveTime":20160901172100,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010007372},"Status":2},{"ActivationMode":"A","ActivationTime":20161214052053,"BundledFlag":"S","EffectiveTime":20161214052053,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010016006},"Status":2},{"ActivationMode":"A","ActivationTime":20160901121315,"BundledFlag":"S","EffectiveTime":20160901121315,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010007389},"Status":2},{"ActivationMode":"A","ActivationTime":20160901112712,"BundledFlag":"S","EffectiveTime":20160901112712,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010007375},"Status":2},{"ActivationMode":"A","ActivationTime":20160909154332,"BundledFlag":"S","EffectiveTime":20160909154332,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":49900},{"SubPropCode":"C_UNIT_VOLUME","Value":300}]},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":69900},{"SubPropCode":"C_DATA_VOLUME","Value":524288000}]}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011174},"Status":2},{"ActivationMode":"A","ActivationTime":20160909102218,"BundledFlag":"S","EffectiveTime":20160909102218,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011186},"Status":2},{"ActivationMode":"A","ActivationTime":20160912102736,"BundledFlag":"S","EffectiveTime":20160912102736,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011226},"Status":2},{"ActivationMode":"A","ActivationTime":20160907122537,"BundledFlag":"S","EffectiveTime":20160907122537,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011099},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125641,"BundledFlag":"S","EffectiveTime":20160907125641,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011101},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125648,"BundledFlag":"S","EffectiveTime":20160907125648,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011102},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125700,"BundledFlag":"S","EffectiveTime":20160907125700,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011103},"Status":2},{"ActivationMode":"A","ActivationTime":20160907185633,"BundledFlag":"S","EffectiveTime":20160907185633,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011104},"Status":2},{"ActivationMode":"A","ActivationTime":20160907131447,"BundledFlag":"S","EffectiveTime":20160907131447,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011110},"Status":2},{"ActivationMode":"A","ActivationTime":20160907191421,"BundledFlag":"S","EffectiveTime":20160907191421,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011111},"Status":2},{"ActivationMode":"A","ActivationTime":20160907200549,"BundledFlag":"S","EffectiveTime":20160907200549,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010011112},"Status":2},{"ActivationMode":"A","ActivationTime":20160907123031,"BundledFlag":"S","EffectiveTime":20160907123031,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011100},"Status":2},{"ActivationMode":"A","ActivationTime":20160907130120,"BundledFlag":"S","EffectiveTime":20160907130120,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011105},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190048,"BundledFlag":"S","EffectiveTime":20160907190048,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011106},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190127,"BundledFlag":"S","EffectiveTime":20160907190127,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011107},"Status":2},{"ActivationMode":"A","ActivationTime":20160907130228,"BundledFlag":"S","EffectiveTime":20160907130228,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011108},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190156,"BundledFlag":"S","EffectiveTime":20160907190156,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011109},"Status":2},{"ActivationMode":"A","ActivationTime":20160907140906,"BundledFlag":"S","EffectiveTime":20160907140906,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010011113},"Status":2},{"ActivationMode":"A","ActivationTime":20160908032202,"BundledFlag":"S","EffectiveTime":20160908032202,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011139},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070014,"BundledFlag":"S","EffectiveTime":20160908070014,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011142},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070118,"BundledFlag":"S","EffectiveTime":20160908070118,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011143},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070131,"BundledFlag":"S","EffectiveTime":20160908070131,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011144},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141754,"BundledFlag":"S","EffectiveTime":20160908141754,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011149},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141846,"BundledFlag":"S","EffectiveTime":20160908141846,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011150},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141847,"BundledFlag":"S","EffectiveTime":20160908141847,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011151},"Status":2},{"ActivationMode":"A","ActivationTime":20160909154450,"BundledFlag":"S","EffectiveTime":20160909154450,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":69900},{"SubPropCode":"C_DATA_VOLUME","Value":524288000}]},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":19900},{"SubPropCode":"C_UNIT_VOLUME","Value":100}]},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011176},"Status":2},{"ActivationMode":"A","ActivationTime":20160912103050,"BundledFlag":"S","EffectiveTime":20160912103050,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0},{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011227},"Status":2},{"ActivationMode":"A","ActivationTime":20160912110134,"BundledFlag":"S","EffectiveTime":20160912110134,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011231},"Status":2},{"ActivationMode":"A","ActivationTime":20160912110215,"BundledFlag":"S","EffectiveTime":20160912110215,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011232},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193431,"BundledFlag":"S","EffectiveTime":20160912193431,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011239},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193431,"BundledFlag":"S","EffectiveTime":20160912193431,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011240},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193435,"BundledFlag":"S","EffectiveTime":20160912193435,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011241},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193437,"BundledFlag":"S","EffectiveTime":20160912193437,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011242},"Status":2},{"ActivationMode":"A","ActivationTime":20160908025540,"BundledFlag":"S","EffectiveTime":20160908025540,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011138},"Status":2},{"ActivationMode":"A","ActivationTime":20160908065305,"BundledFlag":"S","EffectiveTime":20160908065305,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011141},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141743,"BundledFlag":"S","EffectiveTime":20160908141743,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011148},"Status":2},{"ActivationMode":"A","ActivationTime":20160909101912,"BundledFlag":"S","EffectiveTime":20160909101912,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909101912,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":49900},{"SubPropCode":"C_DATA_VOLUME","Value":314572800}]},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":19900},{"SubPropCode":"C_UNIT_VOLUME","Value":100}]},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011184},"Status":2},{"ActivationMode":"A","ActivationTime":20160909102043,"BundledFlag":"S","EffectiveTime":20160909102043,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011185},"Status":2},{"ActivationMode":"A","ActivationTime":20160912103657,"BundledFlag":"S","EffectiveTime":20160912103657,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011228},"Status":2},{"ActivationMode":"A","ActivationTime":20160913022752,"BundledFlag":"S","EffectiveTime":20160913022752,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011252},"Status":2},{"ActivationMode":"A","ActivationTime":20160914082217,"BundledFlag":"S","EffectiveTime":20160914082217,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010012072},"Status":2},{"ActivationMode":"A","ActivationTime":20160914105033,"BundledFlag":"S","EffectiveTime":20160914105033,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010012099},"Status":2},{"ActivationMode":"A","ActivationTime":20160919053043,"BundledFlag":"S","EffectiveTime":20160919053043,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010012192},"Status":2},{"ActivationMode":"A","ActivationTime":20160919053045,"BundledFlag":"S","EffectiveTime":20160919053045,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010012193},"Status":2},{"ActivationMode":"A","ActivationTime":20160919073102,"BundledFlag":"S","EffectiveTime":20160919073102,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010012245},"Status":2},{"ActivationMode":"A","ActivationTime":20160919073126,"BundledFlag":"S","EffectiveTime":20160919073126,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010012246},"Status":2},{"ActivationMode":"A","ActivationTime":20160920084613,"BundledFlag":"S","EffectiveTime":20160920084613,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010012323},"Status":2},{"ActivationMode":"A","ActivationTime":20160921090701,"BundledFlag":"S","EffectiveTime":20160921090701,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010012588},"Status":2},{"ActivationMode":"A","ActivationTime":20160921090727,"BundledFlag":"S","EffectiveTime":20160921090727,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010012591},"Status":2},{"ActivationMode":"A","ActivationTime":20160921091315,"BundledFlag":"S","EffectiveTime":20160921091315,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010012595},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193710,"BundledFlag":"S","EffectiveTime":20161014193710,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014151},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193739,"BundledFlag":"S","EffectiveTime":20161014193739,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014152},"Status":2},{"ActivationMode":"A","ActivationTime":20161013021409,"BundledFlag":"S","EffectiveTime":20161013021409,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120008,"PurchaseSeq":101991010014116},"Status":2},{"ActivationMode":"A","ActivationTime":20161013023029,"BundledFlag":"S","EffectiveTime":20161013023029,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014117},"Status":2},{"ActivationMode":"A","ActivationTime":20161013023440,"BundledFlag":"S","EffectiveTime":20161013023440,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014118},"Status":2},{"ActivationMode":"A","ActivationTime":20161013030529,"BundledFlag":"S","EffectiveTime":20161013030529,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010014126},"Status":2},{"ActivationMode":"A","ActivationTime":20161013030623,"BundledFlag":"S","EffectiveTime":20161013030623,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120008,"PurchaseSeq":101991010014127},"Status":2},{"ActivationMode":"A","ActivationTime":20161013064040,"BundledFlag":"S","EffectiveTime":20161013064040,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014128},"Status":2},{"ActivationMode":"A","ActivationTime":20161014063111,"BundledFlag":"S","EffectiveTime":20161014063111,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014138},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193812,"BundledFlag":"S","EffectiveTime":20161014193812,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014153},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200847,"BundledFlag":"S","EffectiveTime":20161015200847,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014156},"Status":2},{"ActivationMode":"A","ActivationTime":20161015201007,"BundledFlag":"S","EffectiveTime":20161015201007,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010014158},"Status":2},{"ActivationMode":"A","ActivationTime":20161015201043,"BundledFlag":"S","EffectiveTime":20161015201043,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014159},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200756,"BundledFlag":"S","EffectiveTime":20161015200756,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014154},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200816,"BundledFlag":"S","EffectiveTime":20161015200816,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014155},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200919,"BundledFlag":"S","EffectiveTime":20161015200919,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014157},"Status":2},{"ActivationMode":"A","ActivationTime":20161011160407,"BundledFlag":"S","EffectiveTime":20161011160407,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014067},"Status":2},{"ActivationMode":"A","ActivationTime":20161011160527,"BundledFlag":"S","EffectiveTime":20161011160527,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014068},"Status":2},{"ActivationMode":"A","ActivationTime":20161027084258,"BundledFlag":"S","EffectiveTime":20161027084258,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010015132},"Status":2},{"ActivationMode":"A","ActivationTime":20161103152006,"BundledFlag":"S","EffectiveTime":20161103152006,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015215},"Status":2},{"ActivationMode":"A","ActivationTime":20161027084239,"BundledFlag":"S","EffectiveTime":20161027084239,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010015131},"Status":2},{"ActivationMode":"A","ActivationTime":20161018054107,"BundledFlag":"S","EffectiveTime":20161018054107,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010015055},"Status":2},{"ActivationMode":"A","ActivationTime":20161026101953,"BundledFlag":"S","EffectiveTime":20161026101953,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015098},"Status":2},{"ActivationMode":"A","ActivationTime":20161102082810,"BundledFlag":"S","EffectiveTime":20161102082810,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015165},"Status":2},{"ActivationMode":"A","ActivationTime":20161102104051,"BundledFlag":"S","EffectiveTime":20161102104051,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015171},"Status":2},{"ActivationMode":"A","ActivationTime":20161103152158,"BundledFlag":"S","EffectiveTime":20161103152158,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015216},"Status":2}]}}
                 * ResultHeader : {"MsgLanguageCode":2002,"ResultCode":0,"ResultDesc":"Operation successfully.","Version":1}
                 * bcc : http://www.huawei.com/bme/cbsinterface/bccommon
                 * bcs : http://www.huawei.com/bme/cbsinterface/bcservices
                 * cbs : http://www.huawei.com/bme/cbsinterface/cbscommon
                 */

                private QueryCustomerInfoResultBean QueryCustomerInfoResult;
                private ResultHeaderBean ResultHeader;
                private String bcc;
                private String bcs;
                private String cbs;

                public static QueryCustomerInfoResultMsgBean objectFromData(String str) {

                    return new Gson().fromJson(str, QueryCustomerInfoResultMsgBean.class);
                }

                public QueryCustomerInfoResultBean getQueryCustomerInfoResult() {
                    return QueryCustomerInfoResult;
                }

                public void setQueryCustomerInfoResult(QueryCustomerInfoResultBean QueryCustomerInfoResult) {
                    this.QueryCustomerInfoResult = QueryCustomerInfoResult;
                }

                public ResultHeaderBean getResultHeader() {
                    return ResultHeader;
                }

                public void setResultHeader(ResultHeaderBean ResultHeader) {
                    this.ResultHeader = ResultHeader;
                }

                public String getBcc() {
                    return bcc;
                }

                public void setBcc(String bcc) {
                    this.bcc = bcc;
                }

                public String getBcs() {
                    return bcs;
                }

                public void setBcs(String bcs) {
                    this.bcs = bcs;
                }

                public String getCbs() {
                    return cbs;
                }

                public void setCbs(String cbs) {
                    this.cbs = cbs;
                }

                public static class QueryCustomerInfoResultBean {
                    /**
                     * Account : {"AcctInfo":{"AcctBasicInfo":{"AcctProperty":[{"Code":"C_BILLING_GROUP_NO","Value":""},{"Code":"C_GRACE_PERIOD","Value":""},{"Code":"C_DDI_STATUS","Value":""},{"Code":"C_DCA_NAME","Value":""},{"Code":"C_FRAUD_WRITEOFF_FLAG","Value":"N"},{"Code":"C_IMG_IDX","Value":""},{"Code":"C_LATEFEE_FLAG","Value":"N"},{"Code":"C_DD_REFERENCE","Value":""},{"Code":"C_INIT_BALANCE","Value":""},{"Code":"C_OVER_DRAFT_FOR_PREPAID","Value":""},{"Code":"C_ACCOUNT_RELIABILITY","Value":""},{"Code":"C_ACCOUNT_CATEGORY","Value":""},{"Code":"C_SOCIETY","Value":""},{"Code":"C_MARKETING_CATEGORY","Value":""},{"Code":"C_RFC","Value":""},{"Code":"C_ACCOUNT_GRACE_PERIOD","Value":""},{"Code":"C_DUNNING_EXCEPTION_LIST","Value":"0000"},{"Code":"C_REF_A","Value":""},{"Code":"C_REF_B","Value":""},{"Code":"C_CREDIT_RECALCULATION_FLAG","Value":"N"}],"BillLang":2002,"DunningFlag":1,"LateFeeChargeable":"N","RedlistFlag":0},"AcctClass":2,"AcctCode":"CBS100000000000005132","AcctPayMethod":1,"AcctType":1,"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"BillCycleEndDate":20170131160000,"BillCycleOpenDate":20161231160000,"BillCycleType":1,"CurrencyID":1049,"PaymentType":0,"RootAcctKey":20160827221825,"UserCustomer":{"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}},"UserCustomerKey":20160827221825},"AcctKey":20160827221825}
                     * Customer : {"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}}
                     * Subscriber : {"PaymentMode":0,"PrimaryOffering":{"BundledFlag":"S","OfferingClass":"I","OfferingKey":{"OfferingID":120001,"PurchaseSeq":7046},"ProductInst":[{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"M","ProductID":1053,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1014,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1042,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1822969218,"ProductType":1}],"Status":2},"SubscriberInfo":{"ActivationTime":20160830100035,"ActiveTimeLimit":20151231000000,"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"Brand":1218989000,"NetworkType":1,"Status":2,"StatusDetail":"000000000000000000000000","SubBasicInfo":{"DunningFlag":1,"IVRLang":2002,"SubLevel":1,"SubProperty":[{"Code":"C_SUB_LOAN_FLAG","Value":1},{"Code":"C_SUB_REFEREE_IDENTIFER","Value":""},{"Code":"C_SUB_EXTEND_DAYS","Value":0},{"Code":"C_SUB_AUTOTOPUP_LOWBALANCE","Value":1},{"Code":"C_APP_ACTIVE_USAGE","Value":0},{"Code":"C_SUB_MEDIA_FLAG","Value":"N"},{"Code":"C_CONTRACT_END_DATE","Value":""},{"Code":"C_SUB_LASTRECHARGETIME","Value":20170105065600},{"Code":"C_HANDSET_NETWORK","Value":""},{"Code":"C_SUB_LOAN_STATUS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG","Value":0},{"Code":"C_SUB_MAX_VALIDITY","Value":365},{"Code":"C_SUB_MSCC_FEE_AMOUNT","Value":0},{"Code":"C_SUB_PROB","Value":""},{"Code":"C_SUB_SALT","Value":"5325DB061D037F06"},{"Code":"C_MGB_LEVEL","Value":0},{"Code":"C_RENT_START_DATE","Value":""},{"Code":"C_STARTTIME_OF_SWITCH_COS","Value":-1},{"Code":"C_BUYOUT_APPLY_DATE","Value":""},{"Code":"C_HANDSET_BRAND","Value":""},{"Code":"C_TOPUP_PEAK_FLAG","Value":0},{"Code":"C_SUBS_EX_TYPE_BAK","Value":-1},{"Code":"C_BUYOUT_SUB_NUMBER","Value":""},{"Code":"C_SUB_AUTOTOPUP_RECURRING","Value":1},{"Code":"C_SUBDISCOUNT","Value":"O"},{"Code":"C_SUB_MAX_BALANCE","Value":-1},{"Code":"C_DIC_OFFER_USE_DATE","Value":""},{"Code":"C_SALES_CHANNEL_ID","Value":""},{"Code":"C_BUYOUT_START_DATE","Value":""},{"Code":"C_SUB_SERVICEPROVIDER","Value":""},{"Code":"C_HANDSET_OS_TYPE","Value":""},{"Code":"C_DIC_OFFER_USE_TIMES","Value":0},{"Code":"C_SUB_LASTRECHARGEAMT","Value":2000},{"Code":"C_IS_GROUP_MEMBER","Value":0},{"Code":"C_SUB_ONNET_DAYS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG_BAK","Value":0},{"Code":"C_SUB_LOW_BAL_GATE_1","Value":10000},{"Code":"C_SUB_BARRINGCODE","Value":99999999999},{"Code":"C_RENT_END_DATE","Value":""},{"Code":"C_SUB_REGISTERED","Value":1},{"Code":"C_SWITCH_COS_NUM","Value":0},{"Code":"C_SUBS_BUYOUT_FEE","Value":""}],"WrittenLang":2002},"SubClass":2,"SubIdentity":{"PrimaryFlag":1,"SubIdentity":4915298006711,"SubIdentityType":1},"UserCustomer":{"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}},"UserCustomerKey":20160827221825},"SubscriberKey":20160827221825,"SupplementaryOffering":[{"ActivationMode":"A","ActivationTime":20160830100035,"BundledFlag":"S","EffectiveTime":20160830100035,"ExpirationTime":20361231230000,"OfferingClass":"I","OfferingKey":{"OfferingID":120002,"PurchaseSeq":7047},"Status":2},{"ActivationMode":"A","ActivationTime":20160901172100,"BundledFlag":"S","EffectiveTime":20160901172100,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010007372},"Status":2},{"ActivationMode":"A","ActivationTime":20161214052053,"BundledFlag":"S","EffectiveTime":20161214052053,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010016006},"Status":2},{"ActivationMode":"A","ActivationTime":20160901121315,"BundledFlag":"S","EffectiveTime":20160901121315,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010007389},"Status":2},{"ActivationMode":"A","ActivationTime":20160901112712,"BundledFlag":"S","EffectiveTime":20160901112712,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010007375},"Status":2},{"ActivationMode":"A","ActivationTime":20160909154332,"BundledFlag":"S","EffectiveTime":20160909154332,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":49900},{"SubPropCode":"C_UNIT_VOLUME","Value":300}]},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":69900},{"SubPropCode":"C_DATA_VOLUME","Value":524288000}]}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011174},"Status":2},{"ActivationMode":"A","ActivationTime":20160909102218,"BundledFlag":"S","EffectiveTime":20160909102218,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011186},"Status":2},{"ActivationMode":"A","ActivationTime":20160912102736,"BundledFlag":"S","EffectiveTime":20160912102736,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011226},"Status":2},{"ActivationMode":"A","ActivationTime":20160907122537,"BundledFlag":"S","EffectiveTime":20160907122537,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011099},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125641,"BundledFlag":"S","EffectiveTime":20160907125641,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011101},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125648,"BundledFlag":"S","EffectiveTime":20160907125648,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011102},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125700,"BundledFlag":"S","EffectiveTime":20160907125700,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011103},"Status":2},{"ActivationMode":"A","ActivationTime":20160907185633,"BundledFlag":"S","EffectiveTime":20160907185633,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011104},"Status":2},{"ActivationMode":"A","ActivationTime":20160907131447,"BundledFlag":"S","EffectiveTime":20160907131447,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011110},"Status":2},{"ActivationMode":"A","ActivationTime":20160907191421,"BundledFlag":"S","EffectiveTime":20160907191421,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011111},"Status":2},{"ActivationMode":"A","ActivationTime":20160907200549,"BundledFlag":"S","EffectiveTime":20160907200549,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010011112},"Status":2},{"ActivationMode":"A","ActivationTime":20160907123031,"BundledFlag":"S","EffectiveTime":20160907123031,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011100},"Status":2},{"ActivationMode":"A","ActivationTime":20160907130120,"BundledFlag":"S","EffectiveTime":20160907130120,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011105},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190048,"BundledFlag":"S","EffectiveTime":20160907190048,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011106},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190127,"BundledFlag":"S","EffectiveTime":20160907190127,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011107},"Status":2},{"ActivationMode":"A","ActivationTime":20160907130228,"BundledFlag":"S","EffectiveTime":20160907130228,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011108},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190156,"BundledFlag":"S","EffectiveTime":20160907190156,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011109},"Status":2},{"ActivationMode":"A","ActivationTime":20160907140906,"BundledFlag":"S","EffectiveTime":20160907140906,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010011113},"Status":2},{"ActivationMode":"A","ActivationTime":20160908032202,"BundledFlag":"S","EffectiveTime":20160908032202,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011139},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070014,"BundledFlag":"S","EffectiveTime":20160908070014,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011142},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070118,"BundledFlag":"S","EffectiveTime":20160908070118,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011143},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070131,"BundledFlag":"S","EffectiveTime":20160908070131,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011144},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141754,"BundledFlag":"S","EffectiveTime":20160908141754,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011149},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141846,"BundledFlag":"S","EffectiveTime":20160908141846,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011150},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141847,"BundledFlag":"S","EffectiveTime":20160908141847,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011151},"Status":2},{"ActivationMode":"A","ActivationTime":20160909154450,"BundledFlag":"S","EffectiveTime":20160909154450,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":69900},{"SubPropCode":"C_DATA_VOLUME","Value":524288000}]},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":19900},{"SubPropCode":"C_UNIT_VOLUME","Value":100}]},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011176},"Status":2},{"ActivationMode":"A","ActivationTime":20160912103050,"BundledFlag":"S","EffectiveTime":20160912103050,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0},{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011227},"Status":2},{"ActivationMode":"A","ActivationTime":20160912110134,"BundledFlag":"S","EffectiveTime":20160912110134,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011231},"Status":2},{"ActivationMode":"A","ActivationTime":20160912110215,"BundledFlag":"S","EffectiveTime":20160912110215,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011232},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193431,"BundledFlag":"S","EffectiveTime":20160912193431,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011239},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193431,"BundledFlag":"S","EffectiveTime":20160912193431,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011240},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193435,"BundledFlag":"S","EffectiveTime":20160912193435,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011241},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193437,"BundledFlag":"S","EffectiveTime":20160912193437,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011242},"Status":2},{"ActivationMode":"A","ActivationTime":20160908025540,"BundledFlag":"S","EffectiveTime":20160908025540,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011138},"Status":2},{"ActivationMode":"A","ActivationTime":20160908065305,"BundledFlag":"S","EffectiveTime":20160908065305,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011141},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141743,"BundledFlag":"S","EffectiveTime":20160908141743,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011148},"Status":2},{"ActivationMode":"A","ActivationTime":20160909101912,"BundledFlag":"S","EffectiveTime":20160909101912,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909101912,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":49900},{"SubPropCode":"C_DATA_VOLUME","Value":314572800}]},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":19900},{"SubPropCode":"C_UNIT_VOLUME","Value":100}]},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011184},"Status":2},{"ActivationMode":"A","ActivationTime":20160909102043,"BundledFlag":"S","EffectiveTime":20160909102043,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011185},"Status":2},{"ActivationMode":"A","ActivationTime":20160912103657,"BundledFlag":"S","EffectiveTime":20160912103657,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011228},"Status":2},{"ActivationMode":"A","ActivationTime":20160913022752,"BundledFlag":"S","EffectiveTime":20160913022752,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011252},"Status":2},{"ActivationMode":"A","ActivationTime":20160914082217,"BundledFlag":"S","EffectiveTime":20160914082217,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010012072},"Status":2},{"ActivationMode":"A","ActivationTime":20160914105033,"BundledFlag":"S","EffectiveTime":20160914105033,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010012099},"Status":2},{"ActivationMode":"A","ActivationTime":20160919053043,"BundledFlag":"S","EffectiveTime":20160919053043,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010012192},"Status":2},{"ActivationMode":"A","ActivationTime":20160919053045,"BundledFlag":"S","EffectiveTime":20160919053045,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010012193},"Status":2},{"ActivationMode":"A","ActivationTime":20160919073102,"BundledFlag":"S","EffectiveTime":20160919073102,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010012245},"Status":2},{"ActivationMode":"A","ActivationTime":20160919073126,"BundledFlag":"S","EffectiveTime":20160919073126,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010012246},"Status":2},{"ActivationMode":"A","ActivationTime":20160920084613,"BundledFlag":"S","EffectiveTime":20160920084613,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010012323},"Status":2},{"ActivationMode":"A","ActivationTime":20160921090701,"BundledFlag":"S","EffectiveTime":20160921090701,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010012588},"Status":2},{"ActivationMode":"A","ActivationTime":20160921090727,"BundledFlag":"S","EffectiveTime":20160921090727,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010012591},"Status":2},{"ActivationMode":"A","ActivationTime":20160921091315,"BundledFlag":"S","EffectiveTime":20160921091315,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010012595},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193710,"BundledFlag":"S","EffectiveTime":20161014193710,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014151},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193739,"BundledFlag":"S","EffectiveTime":20161014193739,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014152},"Status":2},{"ActivationMode":"A","ActivationTime":20161013021409,"BundledFlag":"S","EffectiveTime":20161013021409,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120008,"PurchaseSeq":101991010014116},"Status":2},{"ActivationMode":"A","ActivationTime":20161013023029,"BundledFlag":"S","EffectiveTime":20161013023029,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014117},"Status":2},{"ActivationMode":"A","ActivationTime":20161013023440,"BundledFlag":"S","EffectiveTime":20161013023440,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014118},"Status":2},{"ActivationMode":"A","ActivationTime":20161013030529,"BundledFlag":"S","EffectiveTime":20161013030529,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010014126},"Status":2},{"ActivationMode":"A","ActivationTime":20161013030623,"BundledFlag":"S","EffectiveTime":20161013030623,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120008,"PurchaseSeq":101991010014127},"Status":2},{"ActivationMode":"A","ActivationTime":20161013064040,"BundledFlag":"S","EffectiveTime":20161013064040,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014128},"Status":2},{"ActivationMode":"A","ActivationTime":20161014063111,"BundledFlag":"S","EffectiveTime":20161014063111,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014138},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193812,"BundledFlag":"S","EffectiveTime":20161014193812,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014153},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200847,"BundledFlag":"S","EffectiveTime":20161015200847,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014156},"Status":2},{"ActivationMode":"A","ActivationTime":20161015201007,"BundledFlag":"S","EffectiveTime":20161015201007,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010014158},"Status":2},{"ActivationMode":"A","ActivationTime":20161015201043,"BundledFlag":"S","EffectiveTime":20161015201043,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014159},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200756,"BundledFlag":"S","EffectiveTime":20161015200756,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014154},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200816,"BundledFlag":"S","EffectiveTime":20161015200816,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014155},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200919,"BundledFlag":"S","EffectiveTime":20161015200919,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014157},"Status":2},{"ActivationMode":"A","ActivationTime":20161011160407,"BundledFlag":"S","EffectiveTime":20161011160407,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014067},"Status":2},{"ActivationMode":"A","ActivationTime":20161011160527,"BundledFlag":"S","EffectiveTime":20161011160527,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014068},"Status":2},{"ActivationMode":"A","ActivationTime":20161027084258,"BundledFlag":"S","EffectiveTime":20161027084258,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010015132},"Status":2},{"ActivationMode":"A","ActivationTime":20161103152006,"BundledFlag":"S","EffectiveTime":20161103152006,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015215},"Status":2},{"ActivationMode":"A","ActivationTime":20161027084239,"BundledFlag":"S","EffectiveTime":20161027084239,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010015131},"Status":2},{"ActivationMode":"A","ActivationTime":20161018054107,"BundledFlag":"S","EffectiveTime":20161018054107,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010015055},"Status":2},{"ActivationMode":"A","ActivationTime":20161026101953,"BundledFlag":"S","EffectiveTime":20161026101953,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015098},"Status":2},{"ActivationMode":"A","ActivationTime":20161102082810,"BundledFlag":"S","EffectiveTime":20161102082810,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015165},"Status":2},{"ActivationMode":"A","ActivationTime":20161102104051,"BundledFlag":"S","EffectiveTime":20161102104051,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015171},"Status":2},{"ActivationMode":"A","ActivationTime":20161103152158,"BundledFlag":"S","EffectiveTime":20161103152158,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015216},"Status":2}]}
                     */

                    private AccountBean Account;
                    private CustomerBean Customer;
                    private SubscriberBean Subscriber;

                    public static QueryCustomerInfoResultBean objectFromData(String str) {

                        return new Gson().fromJson(str, QueryCustomerInfoResultBean.class);
                    }

                    public AccountBean getAccount() {
                        return Account;
                    }

                    public void setAccount(AccountBean Account) {
                        this.Account = Account;
                    }

                    public CustomerBean getCustomer() {
                        return Customer;
                    }

                    public void setCustomer(CustomerBean Customer) {
                        this.Customer = Customer;
                    }

                    public SubscriberBean getSubscriber() {
                        return Subscriber;
                    }

                    public void setSubscriber(SubscriberBean Subscriber) {
                        this.Subscriber = Subscriber;
                    }

                    public static class AccountBean {
                        /**
                         * AcctInfo : {"AcctBasicInfo":{"AcctProperty":[{"Code":"C_BILLING_GROUP_NO","Value":""},{"Code":"C_GRACE_PERIOD","Value":""},{"Code":"C_DDI_STATUS","Value":""},{"Code":"C_DCA_NAME","Value":""},{"Code":"C_FRAUD_WRITEOFF_FLAG","Value":"N"},{"Code":"C_IMG_IDX","Value":""},{"Code":"C_LATEFEE_FLAG","Value":"N"},{"Code":"C_DD_REFERENCE","Value":""},{"Code":"C_INIT_BALANCE","Value":""},{"Code":"C_OVER_DRAFT_FOR_PREPAID","Value":""},{"Code":"C_ACCOUNT_RELIABILITY","Value":""},{"Code":"C_ACCOUNT_CATEGORY","Value":""},{"Code":"C_SOCIETY","Value":""},{"Code":"C_MARKETING_CATEGORY","Value":""},{"Code":"C_RFC","Value":""},{"Code":"C_ACCOUNT_GRACE_PERIOD","Value":""},{"Code":"C_DUNNING_EXCEPTION_LIST","Value":"0000"},{"Code":"C_REF_A","Value":""},{"Code":"C_REF_B","Value":""},{"Code":"C_CREDIT_RECALCULATION_FLAG","Value":"N"}],"BillLang":2002,"DunningFlag":1,"LateFeeChargeable":"N","RedlistFlag":0},"AcctClass":2,"AcctCode":"CBS100000000000005132","AcctPayMethod":1,"AcctType":1,"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"BillCycleEndDate":20170131160000,"BillCycleOpenDate":20161231160000,"BillCycleType":1,"CurrencyID":1049,"PaymentType":0,"RootAcctKey":20160827221825,"UserCustomer":{"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}},"UserCustomerKey":20160827221825}
                         * AcctKey : 20160827221825
                         */

                        private AcctInfoBean AcctInfo;
                        private long AcctKey;

                        public static AccountBean objectFromData(String str) {

                            return new Gson().fromJson(str, AccountBean.class);
                        }

                        public AcctInfoBean getAcctInfo() {
                            return AcctInfo;
                        }

                        public void setAcctInfo(AcctInfoBean AcctInfo) {
                            this.AcctInfo = AcctInfo;
                        }

                        public long getAcctKey() {
                            return AcctKey;
                        }

                        public void setAcctKey(long AcctKey) {
                            this.AcctKey = AcctKey;
                        }

                        public static class AcctInfoBean {
                            /**
                             * AcctBasicInfo : {"AcctProperty":[{"Code":"C_BILLING_GROUP_NO","Value":""},{"Code":"C_GRACE_PERIOD","Value":""},{"Code":"C_DDI_STATUS","Value":""},{"Code":"C_DCA_NAME","Value":""},{"Code":"C_FRAUD_WRITEOFF_FLAG","Value":"N"},{"Code":"C_IMG_IDX","Value":""},{"Code":"C_LATEFEE_FLAG","Value":"N"},{"Code":"C_DD_REFERENCE","Value":""},{"Code":"C_INIT_BALANCE","Value":""},{"Code":"C_OVER_DRAFT_FOR_PREPAID","Value":""},{"Code":"C_ACCOUNT_RELIABILITY","Value":""},{"Code":"C_ACCOUNT_CATEGORY","Value":""},{"Code":"C_SOCIETY","Value":""},{"Code":"C_MARKETING_CATEGORY","Value":""},{"Code":"C_RFC","Value":""},{"Code":"C_ACCOUNT_GRACE_PERIOD","Value":""},{"Code":"C_DUNNING_EXCEPTION_LIST","Value":"0000"},{"Code":"C_REF_A","Value":""},{"Code":"C_REF_B","Value":""},{"Code":"C_CREDIT_RECALCULATION_FLAG","Value":"N"}],"BillLang":2002,"DunningFlag":1,"LateFeeChargeable":"N","RedlistFlag":0}
                             * AcctClass : 2
                             * AcctCode : CBS100000000000005132
                             * AcctPayMethod : 1
                             * AcctType : 1
                             * AddressInfo : {"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020}
                             * BillCycleEndDate : 20170131160000
                             * BillCycleOpenDate : 20161231160000
                             * BillCycleType : 1
                             * CurrencyID : 1049
                             * PaymentType : 0
                             * RootAcctKey : 20160827221825
                             * UserCustomer : {"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}}
                             * UserCustomerKey : 20160827221825
                             */

                            private AcctBasicInfoBean AcctBasicInfo;
                            private int AcctClass;
                            private String AcctCode;
                            private int AcctPayMethod;
                            private int AcctType;
                            private AddressInfoBean AddressInfo;
                            private long BillCycleEndDate;
                            private long BillCycleOpenDate;
                            private int BillCycleType;
                            private int CurrencyID;
                            private int PaymentType;
                            private long RootAcctKey;
                            private UserCustomerBean UserCustomer;
                            private long UserCustomerKey;

                            public static AcctInfoBean objectFromData(String str) {

                                return new Gson().fromJson(str, AcctInfoBean.class);
                            }

                            public AcctBasicInfoBean getAcctBasicInfo() {
                                return AcctBasicInfo;
                            }

                            public void setAcctBasicInfo(AcctBasicInfoBean AcctBasicInfo) {
                                this.AcctBasicInfo = AcctBasicInfo;
                            }

                            public int getAcctClass() {
                                return AcctClass;
                            }

                            public void setAcctClass(int AcctClass) {
                                this.AcctClass = AcctClass;
                            }

                            public String getAcctCode() {
                                return AcctCode;
                            }

                            public void setAcctCode(String AcctCode) {
                                this.AcctCode = AcctCode;
                            }

                            public int getAcctPayMethod() {
                                return AcctPayMethod;
                            }

                            public void setAcctPayMethod(int AcctPayMethod) {
                                this.AcctPayMethod = AcctPayMethod;
                            }

                            public int getAcctType() {
                                return AcctType;
                            }

                            public void setAcctType(int AcctType) {
                                this.AcctType = AcctType;
                            }

                            public AddressInfoBean getAddressInfo() {
                                return AddressInfo;
                            }

                            public void setAddressInfo(AddressInfoBean AddressInfo) {
                                this.AddressInfo = AddressInfo;
                            }

                            public long getBillCycleEndDate() {
                                return BillCycleEndDate;
                            }

                            public void setBillCycleEndDate(long BillCycleEndDate) {
                                this.BillCycleEndDate = BillCycleEndDate;
                            }

                            public long getBillCycleOpenDate() {
                                return BillCycleOpenDate;
                            }

                            public void setBillCycleOpenDate(long BillCycleOpenDate) {
                                this.BillCycleOpenDate = BillCycleOpenDate;
                            }

                            public int getBillCycleType() {
                                return BillCycleType;
                            }

                            public void setBillCycleType(int BillCycleType) {
                                this.BillCycleType = BillCycleType;
                            }

                            public int getCurrencyID() {
                                return CurrencyID;
                            }

                            public void setCurrencyID(int CurrencyID) {
                                this.CurrencyID = CurrencyID;
                            }

                            public int getPaymentType() {
                                return PaymentType;
                            }

                            public void setPaymentType(int PaymentType) {
                                this.PaymentType = PaymentType;
                            }

                            public long getRootAcctKey() {
                                return RootAcctKey;
                            }

                            public void setRootAcctKey(long RootAcctKey) {
                                this.RootAcctKey = RootAcctKey;
                            }

                            public UserCustomerBean getUserCustomer() {
                                return UserCustomer;
                            }

                            public void setUserCustomer(UserCustomerBean UserCustomer) {
                                this.UserCustomer = UserCustomer;
                            }

                            public long getUserCustomerKey() {
                                return UserCustomerKey;
                            }

                            public void setUserCustomerKey(long UserCustomerKey) {
                                this.UserCustomerKey = UserCustomerKey;
                            }

                            public static class AcctBasicInfoBean {
                                /**
                                 * AcctProperty : [{"Code":"C_BILLING_GROUP_NO","Value":""},{"Code":"C_GRACE_PERIOD","Value":""},{"Code":"C_DDI_STATUS","Value":""},{"Code":"C_DCA_NAME","Value":""},{"Code":"C_FRAUD_WRITEOFF_FLAG","Value":"N"},{"Code":"C_IMG_IDX","Value":""},{"Code":"C_LATEFEE_FLAG","Value":"N"},{"Code":"C_DD_REFERENCE","Value":""},{"Code":"C_INIT_BALANCE","Value":""},{"Code":"C_OVER_DRAFT_FOR_PREPAID","Value":""},{"Code":"C_ACCOUNT_RELIABILITY","Value":""},{"Code":"C_ACCOUNT_CATEGORY","Value":""},{"Code":"C_SOCIETY","Value":""},{"Code":"C_MARKETING_CATEGORY","Value":""},{"Code":"C_RFC","Value":""},{"Code":"C_ACCOUNT_GRACE_PERIOD","Value":""},{"Code":"C_DUNNING_EXCEPTION_LIST","Value":"0000"},{"Code":"C_REF_A","Value":""},{"Code":"C_REF_B","Value":""},{"Code":"C_CREDIT_RECALCULATION_FLAG","Value":"N"}]
                                 * BillLang : 2002
                                 * DunningFlag : 1
                                 * LateFeeChargeable : N
                                 * RedlistFlag : 0
                                 */

                                private int BillLang;
                                private int DunningFlag;
                                private String LateFeeChargeable;
                                private int RedlistFlag;
                                private List<AcctPropertyBean> AcctProperty;

                                public static AcctBasicInfoBean objectFromData(String str) {

                                    return new Gson().fromJson(str, AcctBasicInfoBean.class);
                                }

                                public int getBillLang() {
                                    return BillLang;
                                }

                                public void setBillLang(int BillLang) {
                                    this.BillLang = BillLang;
                                }

                                public int getDunningFlag() {
                                    return DunningFlag;
                                }

                                public void setDunningFlag(int DunningFlag) {
                                    this.DunningFlag = DunningFlag;
                                }

                                public String getLateFeeChargeable() {
                                    return LateFeeChargeable;
                                }

                                public void setLateFeeChargeable(String LateFeeChargeable) {
                                    this.LateFeeChargeable = LateFeeChargeable;
                                }

                                public int getRedlistFlag() {
                                    return RedlistFlag;
                                }

                                public void setRedlistFlag(int RedlistFlag) {
                                    this.RedlistFlag = RedlistFlag;
                                }

                                public List<AcctPropertyBean> getAcctProperty() {
                                    return AcctProperty;
                                }

                                public void setAcctProperty(List<AcctPropertyBean> AcctProperty) {
                                    this.AcctProperty = AcctProperty;
                                }

                                public static class AcctPropertyBean {
                                    /**
                                     * Code : C_BILLING_GROUP_NO
                                     * Value :
                                     */

                                    private String Code;
                                    private String Value;

                                    public static AcctPropertyBean objectFromData(String str) {

                                        return new Gson().fromJson(str, AcctPropertyBean.class);
                                    }

                                    public String getCode() {
                                        return Code;
                                    }

                                    public void setCode(String Code) {
                                        this.Code = Code;
                                    }

                                    public String getValue() {
                                        return Value;
                                    }

                                    public void setValue(String Value) {
                                        this.Value = Value;
                                    }
                                }
                            }

                            public static class AddressInfoBean {
                                /**
                                 * Address1 : China
                                 * Address2 : JS
                                 * Address3 : NJ
                                 * AddressKey : 20160827221825
                                 * PostCode : 501020
                                 */

                                private String Address1;
                                private String Address2;
                                private String Address3;
                                private long AddressKey;
                                private int PostCode;

                                public static AddressInfoBean objectFromData(String str) {

                                    return new Gson().fromJson(str, AddressInfoBean.class);
                                }

                                public String getAddress1() {
                                    return Address1;
                                }

                                public void setAddress1(String Address1) {
                                    this.Address1 = Address1;
                                }

                                public String getAddress2() {
                                    return Address2;
                                }

                                public void setAddress2(String Address2) {
                                    this.Address2 = Address2;
                                }

                                public String getAddress3() {
                                    return Address3;
                                }

                                public void setAddress3(String Address3) {
                                    this.Address3 = Address3;
                                }

                                public long getAddressKey() {
                                    return AddressKey;
                                }

                                public void setAddressKey(long AddressKey) {
                                    this.AddressKey = AddressKey;
                                }

                                public int getPostCode() {
                                    return PostCode;
                                }

                                public void setPostCode(int PostCode) {
                                    this.PostCode = PostCode;
                                }
                            }

                            public static class UserCustomerBean {
                                private CustInfoBean CustInfo;
                                private long CustKey;
                                private IndividualInfoBean IndividualInfo;

                                public static UserCustomerBean objectFromData(String str) {

                                    return new Gson().fromJson(str, UserCustomerBean.class);
                                }

                                public CustInfoBean getCustInfo() {
                                    return CustInfo;
                                }

                                public void setCustInfo(CustInfoBean CustInfo) {
                                    this.CustInfo = CustInfo;
                                }

                                public long getCustKey() {
                                    return CustKey;
                                }

                                public void setCustKey(long CustKey) {
                                    this.CustKey = CustKey;
                                }

                                public IndividualInfoBean getIndividualInfo() {
                                    return IndividualInfo;
                                }

                                public void setIndividualInfo(IndividualInfoBean IndividualInfo) {
                                    this.IndividualInfo = IndividualInfo;
                                }

                                public static class CustInfoBean {
                                    private CustBasicInfoBean CustBasicInfo;
                                    private int CustClass;
                                    private String CustCode;
                                    private int CustNodeType;
                                    private int CustType;

                                    public static CustInfoBean objectFromData(String str) {

                                        return new Gson().fromJson(str, CustInfoBean.class);
                                    }

                                    public CustBasicInfoBean getCustBasicInfo() {
                                        return CustBasicInfo;
                                    }

                                    public void setCustBasicInfo(CustBasicInfoBean CustBasicInfo) {
                                        this.CustBasicInfo = CustBasicInfo;
                                    }

                                    public int getCustClass() {
                                        return CustClass;
                                    }

                                    public void setCustClass(int CustClass) {
                                        this.CustClass = CustClass;
                                    }

                                    public String getCustCode() {
                                        return CustCode;
                                    }

                                    public void setCustCode(String CustCode) {
                                        this.CustCode = CustCode;
                                    }

                                    public int getCustNodeType() {
                                        return CustNodeType;
                                    }

                                    public void setCustNodeType(int CustNodeType) {
                                        this.CustNodeType = CustNodeType;
                                    }

                                    public int getCustType() {
                                        return CustType;
                                    }

                                    public void setCustType(int CustType) {
                                        this.CustType = CustType;
                                    }

                                    public static class CustBasicInfoBean {
                                        private int DFTIVRLang;
                                        private int DFTWrittenLang;
                                        private int DunningFlag;
                                        private List<CustPropertyBean> CustProperty;

                                        public static CustBasicInfoBean objectFromData(String str) {

                                            return new Gson().fromJson(str, CustBasicInfoBean.class);
                                        }

                                        public int getDFTIVRLang() {
                                            return DFTIVRLang;
                                        }

                                        public void setDFTIVRLang(int DFTIVRLang) {
                                            this.DFTIVRLang = DFTIVRLang;
                                        }

                                        public int getDFTWrittenLang() {
                                            return DFTWrittenLang;
                                        }

                                        public void setDFTWrittenLang(int DFTWrittenLang) {
                                            this.DFTWrittenLang = DFTWrittenLang;
                                        }

                                        public int getDunningFlag() {
                                            return DunningFlag;
                                        }

                                        public void setDunningFlag(int DunningFlag) {
                                            this.DunningFlag = DunningFlag;
                                        }

                                        public List<CustPropertyBean> getCustProperty() {
                                            return CustProperty;
                                        }

                                        public void setCustProperty(List<CustPropertyBean> CustProperty) {
                                            this.CustProperty = CustProperty;
                                        }

                                        public static class CustPropertyBean {
                                            /**
                                             * Code : C_LEGAL_CATEGORY
                                             * Value :
                                             */

                                            private String Code;
                                            private String Value;

                                            public static CustPropertyBean objectFromData(String str) {

                                                return new Gson().fromJson(str, CustPropertyBean.class);
                                            }

                                            public String getCode() {
                                                return Code;
                                            }

                                            public void setCode(String Code) {
                                                this.Code = Code;
                                            }

                                            public String getValue() {
                                                return Value;
                                            }

                                            public void setValue(String Value) {
                                                this.Value = Value;
                                            }
                                        }
                                    }
                                }

                                public static class IndividualInfoBean {
                                    private long Birthday;
                                    private String Email;
                                    private String FirstName;
                                    private int Gender;
                                    private long HomeAddressKey;
                                    private IndividualPropertyBean IndividualProperty;
                                    private String LastName;
                                    private int Title;

                                    public static IndividualInfoBean objectFromData(String str) {

                                        return new Gson().fromJson(str, IndividualInfoBean.class);
                                    }

                                    public long getBirthday() {
                                        return Birthday;
                                    }

                                    public void setBirthday(long Birthday) {
                                        this.Birthday = Birthday;
                                    }

                                    public String getEmail() {
                                        return Email;
                                    }

                                    public void setEmail(String Email) {
                                        this.Email = Email;
                                    }

                                    public String getFirstName() {
                                        return FirstName;
                                    }

                                    public void setFirstName(String FirstName) {
                                        this.FirstName = FirstName;
                                    }

                                    public int getGender() {
                                        return Gender;
                                    }

                                    public void setGender(int Gender) {
                                        this.Gender = Gender;
                                    }

                                    public long getHomeAddressKey() {
                                        return HomeAddressKey;
                                    }

                                    public void setHomeAddressKey(long HomeAddressKey) {
                                        this.HomeAddressKey = HomeAddressKey;
                                    }

                                    public IndividualPropertyBean getIndividualProperty() {
                                        return IndividualProperty;
                                    }

                                    public void setIndividualProperty(IndividualPropertyBean IndividualProperty) {
                                        this.IndividualProperty = IndividualProperty;
                                    }

                                    public String getLastName() {
                                        return LastName;
                                    }

                                    public void setLastName(String LastName) {
                                        this.LastName = LastName;
                                    }

                                    public int getTitle() {
                                        return Title;
                                    }

                                    public void setTitle(int Title) {
                                        this.Title = Title;
                                    }

                                    public static class IndividualPropertyBean {
                                        /**
                                         * Code : C_MKT_P_STATUS
                                         * Value : 1
                                         */

                                        private String Code;
                                        private int Value;

                                        public static IndividualPropertyBean objectFromData(String str) {

                                            return new Gson().fromJson(str, IndividualPropertyBean.class);
                                        }

                                        public String getCode() {
                                            return Code;
                                        }

                                        public void setCode(String Code) {
                                            this.Code = Code;
                                        }

                                        public int getValue() {
                                            return Value;
                                        }

                                        public void setValue(int Value) {
                                            this.Value = Value;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    public static class CustomerBean {
                        /**
                         * AddressInfo : {"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020}
                         * CustInfo : {"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1}
                         * CustKey : 20160827221825
                         * IndividualInfo : {"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}
                         */

                        private AddressInfoBeanX AddressInfo;
                        private CustInfoBeanX CustInfo;
                        private long CustKey;
                        private IndividualInfoBeanX IndividualInfo;

                        public static CustomerBean objectFromData(String str) {

                            return new Gson().fromJson(str, CustomerBean.class);
                        }

                        public AddressInfoBeanX getAddressInfo() {
                            return AddressInfo;
                        }

                        public void setAddressInfo(AddressInfoBeanX AddressInfo) {
                            this.AddressInfo = AddressInfo;
                        }

                        public CustInfoBeanX getCustInfo() {
                            return CustInfo;
                        }

                        public void setCustInfo(CustInfoBeanX CustInfo) {
                            this.CustInfo = CustInfo;
                        }

                        public long getCustKey() {
                            return CustKey;
                        }

                        public void setCustKey(long CustKey) {
                            this.CustKey = CustKey;
                        }

                        public IndividualInfoBeanX getIndividualInfo() {
                            return IndividualInfo;
                        }

                        public void setIndividualInfo(IndividualInfoBeanX IndividualInfo) {
                            this.IndividualInfo = IndividualInfo;
                        }

                        public static class AddressInfoBeanX {
                            /**
                             * Address1 : China
                             * Address2 : JS
                             * Address3 : NJ
                             * AddressKey : 20160827221825
                             * PostCode : 501020
                             */

                            private String Address1;
                            private String Address2;
                            private String Address3;
                            private long AddressKey;
                            private int PostCode;

                            public static AddressInfoBeanX objectFromData(String str) {

                                return new Gson().fromJson(str, AddressInfoBeanX.class);
                            }

                            public String getAddress1() {
                                return Address1;
                            }

                            public void setAddress1(String Address1) {
                                this.Address1 = Address1;
                            }

                            public String getAddress2() {
                                return Address2;
                            }

                            public void setAddress2(String Address2) {
                                this.Address2 = Address2;
                            }

                            public String getAddress3() {
                                return Address3;
                            }

                            public void setAddress3(String Address3) {
                                this.Address3 = Address3;
                            }

                            public long getAddressKey() {
                                return AddressKey;
                            }

                            public void setAddressKey(long AddressKey) {
                                this.AddressKey = AddressKey;
                            }

                            public int getPostCode() {
                                return PostCode;
                            }

                            public void setPostCode(int PostCode) {
                                this.PostCode = PostCode;
                            }
                        }

                        public static class CustInfoBeanX {
                            /**
                             * CustBasicInfo : {"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1}
                             * CustClass : 2
                             * CustCode : CBS100000000000005130
                             * CustNodeType : 1
                             * CustType : 1
                             */

                            private CustBasicInfoBeanX CustBasicInfo;
                            private int CustClass;
                            private String CustCode;
                            private int CustNodeType;
                            private int CustType;

                            public static CustInfoBeanX objectFromData(String str) {

                                return new Gson().fromJson(str, CustInfoBeanX.class);
                            }

                            public CustBasicInfoBeanX getCustBasicInfo() {
                                return CustBasicInfo;
                            }

                            public void setCustBasicInfo(CustBasicInfoBeanX CustBasicInfo) {
                                this.CustBasicInfo = CustBasicInfo;
                            }

                            public int getCustClass() {
                                return CustClass;
                            }

                            public void setCustClass(int CustClass) {
                                this.CustClass = CustClass;
                            }

                            public String getCustCode() {
                                return CustCode;
                            }

                            public void setCustCode(String CustCode) {
                                this.CustCode = CustCode;
                            }

                            public int getCustNodeType() {
                                return CustNodeType;
                            }

                            public void setCustNodeType(int CustNodeType) {
                                this.CustNodeType = CustNodeType;
                            }

                            public int getCustType() {
                                return CustType;
                            }

                            public void setCustType(int CustType) {
                                this.CustType = CustType;
                            }

                            public static class CustBasicInfoBeanX {
                                /**
                                 * CustProperty : [{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}]
                                 * DFTIVRLang : 2002
                                 * DFTWrittenLang : 2002
                                 * DunningFlag : 1
                                 */

                                private int DFTIVRLang;
                                private int DFTWrittenLang;
                                private int DunningFlag;
                                private List<CustPropertyBeanX> CustProperty;

                                public static CustBasicInfoBeanX objectFromData(String str) {

                                    return new Gson().fromJson(str, CustBasicInfoBeanX.class);
                                }

                                public int getDFTIVRLang() {
                                    return DFTIVRLang;
                                }

                                public void setDFTIVRLang(int DFTIVRLang) {
                                    this.DFTIVRLang = DFTIVRLang;
                                }

                                public int getDFTWrittenLang() {
                                    return DFTWrittenLang;
                                }

                                public void setDFTWrittenLang(int DFTWrittenLang) {
                                    this.DFTWrittenLang = DFTWrittenLang;
                                }

                                public int getDunningFlag() {
                                    return DunningFlag;
                                }

                                public void setDunningFlag(int DunningFlag) {
                                    this.DunningFlag = DunningFlag;
                                }

                                public List<CustPropertyBeanX> getCustProperty() {
                                    return CustProperty;
                                }

                                public void setCustProperty(List<CustPropertyBeanX> CustProperty) {
                                    this.CustProperty = CustProperty;
                                }

                                public static class CustPropertyBeanX {
                                    /**
                                     * Code : C_LEGAL_CATEGORY
                                     * Value :
                                     */

                                    private String Code;
                                    private String Value;

                                    public static CustPropertyBeanX objectFromData(String str) {

                                        return new Gson().fromJson(str, CustPropertyBeanX.class);
                                    }

                                    public String getCode() {
                                        return Code;
                                    }

                                    public void setCode(String Code) {
                                        this.Code = Code;
                                    }

                                    public String getValue() {
                                        return Value;
                                    }

                                    public void setValue(String Value) {
                                        this.Value = Value;
                                    }
                                }
                            }
                        }

                        public static class IndividualInfoBeanX {
                            /**
                             * Birthday : 19600112101010
                             * Email : cbs@huawei.com
                             * FirstName : Tim
                             * Gender : 1
                             * HomeAddressKey : 20160827221825
                             * IndividualProperty : {"Code":"C_MKT_P_STATUS","Value":1}
                             * LastName : VDF
                             * Title : 1
                             */

                            private long Birthday;
                            private String Email;
                            private String FirstName;
                            private int Gender;
                            private long HomeAddressKey;
                            private IndividualPropertyBeanX IndividualProperty;
                            private String LastName;
                            private int Title;

                            public static IndividualInfoBeanX objectFromData(String str) {

                                return new Gson().fromJson(str, IndividualInfoBeanX.class);
                            }

                            public long getBirthday() {
                                return Birthday;
                            }

                            public void setBirthday(long Birthday) {
                                this.Birthday = Birthday;
                            }

                            public String getEmail() {
                                return Email;
                            }

                            public void setEmail(String Email) {
                                this.Email = Email;
                            }

                            public String getFirstName() {
                                return FirstName;
                            }

                            public void setFirstName(String FirstName) {
                                this.FirstName = FirstName;
                            }

                            public int getGender() {
                                return Gender;
                            }

                            public void setGender(int Gender) {
                                this.Gender = Gender;
                            }

                            public long getHomeAddressKey() {
                                return HomeAddressKey;
                            }

                            public void setHomeAddressKey(long HomeAddressKey) {
                                this.HomeAddressKey = HomeAddressKey;
                            }

                            public IndividualPropertyBeanX getIndividualProperty() {
                                return IndividualProperty;
                            }

                            public void setIndividualProperty(IndividualPropertyBeanX IndividualProperty) {
                                this.IndividualProperty = IndividualProperty;
                            }

                            public String getLastName() {
                                return LastName;
                            }

                            public void setLastName(String LastName) {
                                this.LastName = LastName;
                            }

                            public int getTitle() {
                                return Title;
                            }

                            public void setTitle(int Title) {
                                this.Title = Title;
                            }

                            public static class IndividualPropertyBeanX {
                                /**
                                 * Code : C_MKT_P_STATUS
                                 * Value : 1
                                 */

                                private String Code;
                                private int Value;

                                public static IndividualPropertyBeanX objectFromData(String str) {

                                    return new Gson().fromJson(str, IndividualPropertyBeanX.class);
                                }

                                public String getCode() {
                                    return Code;
                                }

                                public void setCode(String Code) {
                                    this.Code = Code;
                                }

                                public int getValue() {
                                    return Value;
                                }

                                public void setValue(int Value) {
                                    this.Value = Value;
                                }
                            }
                        }
                    }

                    public static class SubscriberBean {
                        /**
                         * PaymentMode : 0
                         * PrimaryOffering : {"BundledFlag":"S","OfferingClass":"I","OfferingKey":{"OfferingID":120001,"PurchaseSeq":7046},"ProductInst":[{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"M","ProductID":1053,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1014,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1042,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1822969218,"ProductType":1}],"Status":2}
                         * SubscriberInfo : {"ActivationTime":20160830100035,"ActiveTimeLimit":20151231000000,"AddressInfo":{"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020},"Brand":1218989000,"NetworkType":1,"Status":2,"StatusDetail":"000000000000000000000000","SubBasicInfo":{"DunningFlag":1,"IVRLang":2002,"SubLevel":1,"SubProperty":[{"Code":"C_SUB_LOAN_FLAG","Value":1},{"Code":"C_SUB_REFEREE_IDENTIFER","Value":""},{"Code":"C_SUB_EXTEND_DAYS","Value":0},{"Code":"C_SUB_AUTOTOPUP_LOWBALANCE","Value":1},{"Code":"C_APP_ACTIVE_USAGE","Value":0},{"Code":"C_SUB_MEDIA_FLAG","Value":"N"},{"Code":"C_CONTRACT_END_DATE","Value":""},{"Code":"C_SUB_LASTRECHARGETIME","Value":20170105065600},{"Code":"C_HANDSET_NETWORK","Value":""},{"Code":"C_SUB_LOAN_STATUS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG","Value":0},{"Code":"C_SUB_MAX_VALIDITY","Value":365},{"Code":"C_SUB_MSCC_FEE_AMOUNT","Value":0},{"Code":"C_SUB_PROB","Value":""},{"Code":"C_SUB_SALT","Value":"5325DB061D037F06"},{"Code":"C_MGB_LEVEL","Value":0},{"Code":"C_RENT_START_DATE","Value":""},{"Code":"C_STARTTIME_OF_SWITCH_COS","Value":-1},{"Code":"C_BUYOUT_APPLY_DATE","Value":""},{"Code":"C_HANDSET_BRAND","Value":""},{"Code":"C_TOPUP_PEAK_FLAG","Value":0},{"Code":"C_SUBS_EX_TYPE_BAK","Value":-1},{"Code":"C_BUYOUT_SUB_NUMBER","Value":""},{"Code":"C_SUB_AUTOTOPUP_RECURRING","Value":1},{"Code":"C_SUBDISCOUNT","Value":"O"},{"Code":"C_SUB_MAX_BALANCE","Value":-1},{"Code":"C_DIC_OFFER_USE_DATE","Value":""},{"Code":"C_SALES_CHANNEL_ID","Value":""},{"Code":"C_BUYOUT_START_DATE","Value":""},{"Code":"C_SUB_SERVICEPROVIDER","Value":""},{"Code":"C_HANDSET_OS_TYPE","Value":""},{"Code":"C_DIC_OFFER_USE_TIMES","Value":0},{"Code":"C_SUB_LASTRECHARGEAMT","Value":2000},{"Code":"C_IS_GROUP_MEMBER","Value":0},{"Code":"C_SUB_ONNET_DAYS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG_BAK","Value":0},{"Code":"C_SUB_LOW_BAL_GATE_1","Value":10000},{"Code":"C_SUB_BARRINGCODE","Value":99999999999},{"Code":"C_RENT_END_DATE","Value":""},{"Code":"C_SUB_REGISTERED","Value":1},{"Code":"C_SWITCH_COS_NUM","Value":0},{"Code":"C_SUBS_BUYOUT_FEE","Value":""}],"WrittenLang":2002},"SubClass":2,"SubIdentity":{"PrimaryFlag":1,"SubIdentity":4915298006711,"SubIdentityType":1},"UserCustomer":{"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}},"UserCustomerKey":20160827221825}
                         * SubscriberKey : 20160827221825
                         * SupplementaryOffering : [{"ActivationMode":"A","ActivationTime":20160830100035,"BundledFlag":"S","EffectiveTime":20160830100035,"ExpirationTime":20361231230000,"OfferingClass":"I","OfferingKey":{"OfferingID":120002,"PurchaseSeq":7047},"Status":2},{"ActivationMode":"A","ActivationTime":20160901172100,"BundledFlag":"S","EffectiveTime":20160901172100,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010007372},"Status":2},{"ActivationMode":"A","ActivationTime":20161214052053,"BundledFlag":"S","EffectiveTime":20161214052053,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161214052053,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010016006},"Status":2},{"ActivationMode":"A","ActivationTime":20160901121315,"BundledFlag":"S","EffectiveTime":20160901121315,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901121315,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010007389},"Status":2},{"ActivationMode":"A","ActivationTime":20160901112712,"BundledFlag":"S","EffectiveTime":20160901112712,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901112712,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010007375},"Status":2},{"ActivationMode":"A","ActivationTime":20160909154332,"BundledFlag":"S","EffectiveTime":20160909154332,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":49900},{"SubPropCode":"C_UNIT_VOLUME","Value":300}]},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909154332,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":69900},{"SubPropCode":"C_DATA_VOLUME","Value":524288000}]}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011174},"Status":2},{"ActivationMode":"A","ActivationTime":20160909102218,"BundledFlag":"S","EffectiveTime":20160909102218,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909102218,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011186},"Status":2},{"ActivationMode":"A","ActivationTime":20160912102736,"BundledFlag":"S","EffectiveTime":20160912102736,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912102736,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011226},"Status":2},{"ActivationMode":"A","ActivationTime":20160907122537,"BundledFlag":"S","EffectiveTime":20160907122537,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907122537,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011099},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125641,"BundledFlag":"S","EffectiveTime":20160907125641,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125641,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011101},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125648,"BundledFlag":"S","EffectiveTime":20160907125648,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125648,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011102},"Status":2},{"ActivationMode":"A","ActivationTime":20160907125700,"BundledFlag":"S","EffectiveTime":20160907125700,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907125700,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011103},"Status":2},{"ActivationMode":"A","ActivationTime":20160907185633,"BundledFlag":"S","EffectiveTime":20160907185633,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907185633,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011104},"Status":2},{"ActivationMode":"A","ActivationTime":20160907131447,"BundledFlag":"S","EffectiveTime":20160907131447,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907131447,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011110},"Status":2},{"ActivationMode":"A","ActivationTime":20160907191421,"BundledFlag":"S","EffectiveTime":20160907191421,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907191421,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011111},"Status":2},{"ActivationMode":"A","ActivationTime":20160907200549,"BundledFlag":"S","EffectiveTime":20160907200549,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907200549,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010011112},"Status":2},{"ActivationMode":"A","ActivationTime":20160907123031,"BundledFlag":"S","EffectiveTime":20160907123031,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907123031,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011100},"Status":2},{"ActivationMode":"A","ActivationTime":20160907130120,"BundledFlag":"S","EffectiveTime":20160907130120,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907130120,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011105},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190048,"BundledFlag":"S","EffectiveTime":20160907190048,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190048,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011106},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190127,"BundledFlag":"S","EffectiveTime":20160907190127,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190127,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011107},"Status":2},{"ActivationMode":"A","ActivationTime":20160907130228,"BundledFlag":"S","EffectiveTime":20160907130228,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907130228,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011108},"Status":2},{"ActivationMode":"A","ActivationTime":20160907190156,"BundledFlag":"S","EffectiveTime":20160907190156,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907190156,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011109},"Status":2},{"ActivationMode":"A","ActivationTime":20160907140906,"BundledFlag":"S","EffectiveTime":20160907140906,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160907140906,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010011113},"Status":2},{"ActivationMode":"A","ActivationTime":20160908032202,"BundledFlag":"S","EffectiveTime":20160908032202,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908032202,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011139},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070014,"BundledFlag":"S","EffectiveTime":20160908070014,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070014,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010011142},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070118,"BundledFlag":"S","EffectiveTime":20160908070118,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070118,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011143},"Status":2},{"ActivationMode":"A","ActivationTime":20160908070131,"BundledFlag":"S","EffectiveTime":20160908070131,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908070131,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011144},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141754,"BundledFlag":"S","EffectiveTime":20160908141754,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141754,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011149},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141846,"BundledFlag":"S","EffectiveTime":20160908141846,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141846,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011150},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141847,"BundledFlag":"S","EffectiveTime":20160908141847,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141847,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011151},"Status":2},{"ActivationMode":"A","ActivationTime":20160909154450,"BundledFlag":"S","EffectiveTime":20160909154450,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":69900},{"SubPropCode":"C_DATA_VOLUME","Value":524288000}]},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":19900},{"SubPropCode":"C_UNIT_VOLUME","Value":100}]},{"EffectiveTime":20160909154450,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011176},"Status":2},{"ActivationMode":"A","ActivationTime":20160912103050,"BundledFlag":"S","EffectiveTime":20160912103050,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0},{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912103050,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011227},"Status":2},{"ActivationMode":"A","ActivationTime":20160912110134,"BundledFlag":"S","EffectiveTime":20160912110134,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912110134,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011231},"Status":2},{"ActivationMode":"A","ActivationTime":20160912110215,"BundledFlag":"S","EffectiveTime":20160912110215,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912110215,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011232},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193431,"BundledFlag":"S","EffectiveTime":20160912193431,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011239},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193431,"BundledFlag":"S","EffectiveTime":20160912193431,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193431,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011240},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193435,"BundledFlag":"S","EffectiveTime":20160912193435,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193435,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011241},"Status":2},{"ActivationMode":"A","ActivationTime":20160912193437,"BundledFlag":"S","EffectiveTime":20160912193437,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912193437,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011242},"Status":2},{"ActivationMode":"A","ActivationTime":20160908025540,"BundledFlag":"S","EffectiveTime":20160908025540,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908025540,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120004,"PurchaseSeq":101991010011138},"Status":2},{"ActivationMode":"A","ActivationTime":20160908065305,"BundledFlag":"S","EffectiveTime":20160908065305,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908065305,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011141},"Status":2},{"ActivationMode":"A","ActivationTime":20160908141743,"BundledFlag":"S","EffectiveTime":20160908141743,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160908141743,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010011148},"Status":2},{"ActivationMode":"A","ActivationTime":20160909101912,"BundledFlag":"S","EffectiveTime":20160909101912,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909101912,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_DATA","PropType":2,"SubPropInst":[{"SubPropCode":"C_DATA_PRICE","Value":49900},{"SubPropCode":"C_DATA_VOLUME","Value":314572800}]},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_UNIT","PropType":2,"SubPropInst":[{"SubPropCode":"C_UNIT_PRICE","Value":19900},{"SubPropCode":"C_UNIT_VOLUME","Value":100}]},{"EffectiveTime":20161029171014,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":10102,"PurchaseSeq":101991010011184},"Status":2},{"ActivationMode":"A","ActivationTime":20160909102043,"BundledFlag":"S","EffectiveTime":20160909102043,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160909102043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011185},"Status":2},{"ActivationMode":"A","ActivationTime":20160912103657,"BundledFlag":"S","EffectiveTime":20160912103657,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160912103657,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011228},"Status":2},{"ActivationMode":"A","ActivationTime":20160913022752,"BundledFlag":"S","EffectiveTime":20160913022752,"ExpirationTime":20361231230000,"OInstProperty":[{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160913022752,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010011252},"Status":2},{"ActivationMode":"A","ActivationTime":20160914082217,"BundledFlag":"S","EffectiveTime":20160914082217,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160914082217,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010012072},"Status":2},{"ActivationMode":"A","ActivationTime":20160914105033,"BundledFlag":"S","EffectiveTime":20160914105033,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160914105033,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120003,"PurchaseSeq":101991010012099},"Status":2},{"ActivationMode":"A","ActivationTime":20160919053043,"BundledFlag":"S","EffectiveTime":20160919053043,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919053043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010012192},"Status":2},{"ActivationMode":"A","ActivationTime":20160919053045,"BundledFlag":"S","EffectiveTime":20160919053045,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919053045,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":700000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120005,"PurchaseSeq":101991010012193},"Status":2},{"ActivationMode":"A","ActivationTime":20160919073102,"BundledFlag":"S","EffectiveTime":20160919073102,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919073102,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010012245},"Status":2},{"ActivationMode":"A","ActivationTime":20160919073126,"BundledFlag":"S","EffectiveTime":20160919073126,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160919073126,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010012246},"Status":2},{"ActivationMode":"A","ActivationTime":20160920084613,"BundledFlag":"S","EffectiveTime":20160920084613,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160920084613,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010012323},"Status":2},{"ActivationMode":"A","ActivationTime":20160921090701,"BundledFlag":"S","EffectiveTime":20160921090701,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921090701,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010012588},"Status":2},{"ActivationMode":"A","ActivationTime":20160921090727,"BundledFlag":"S","EffectiveTime":20160921090727,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921090727,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010012591},"Status":2},{"ActivationMode":"A","ActivationTime":20160921091315,"BundledFlag":"S","EffectiveTime":20160921091315,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160921091315,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010012595},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193710,"BundledFlag":"S","EffectiveTime":20161014193710,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193710,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014151},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193739,"BundledFlag":"S","EffectiveTime":20161014193739,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193739,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014152},"Status":2},{"ActivationMode":"A","ActivationTime":20161013021409,"BundledFlag":"S","EffectiveTime":20161013021409,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013021409,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120008,"PurchaseSeq":101991010014116},"Status":2},{"ActivationMode":"A","ActivationTime":20161013023029,"BundledFlag":"S","EffectiveTime":20161013023029,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013023029,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014117},"Status":2},{"ActivationMode":"A","ActivationTime":20161013023440,"BundledFlag":"S","EffectiveTime":20161013023440,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013023440,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014118},"Status":2},{"ActivationMode":"A","ActivationTime":20161013030529,"BundledFlag":"S","EffectiveTime":20161013030529,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013030529,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120006,"PurchaseSeq":101991010014126},"Status":2},{"ActivationMode":"A","ActivationTime":20161013030623,"BundledFlag":"S","EffectiveTime":20161013030623,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013030623,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120008,"PurchaseSeq":101991010014127},"Status":2},{"ActivationMode":"A","ActivationTime":20161013064040,"BundledFlag":"S","EffectiveTime":20161013064040,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161013064040,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014128},"Status":2},{"ActivationMode":"A","ActivationTime":20161014063111,"BundledFlag":"S","EffectiveTime":20161014063111,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014063111,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014138},"Status":2},{"ActivationMode":"A","ActivationTime":20161014193812,"BundledFlag":"S","EffectiveTime":20161014193812,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161014193812,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014153},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200847,"BundledFlag":"S","EffectiveTime":20161015200847,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200847,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014156},"Status":2},{"ActivationMode":"A","ActivationTime":20161015201007,"BundledFlag":"S","EffectiveTime":20161015201007,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015201007,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010014158},"Status":2},{"ActivationMode":"A","ActivationTime":20161015201043,"BundledFlag":"S","EffectiveTime":20161015201043,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015201043,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014159},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200756,"BundledFlag":"S","EffectiveTime":20161015200756,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200756,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014154},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200816,"BundledFlag":"S","EffectiveTime":20161015200816,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200816,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010014155},"Status":2},{"ActivationMode":"A","ActivationTime":20161015200919,"BundledFlag":"S","EffectiveTime":20161015200919,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161015200919,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014157},"Status":2},{"ActivationMode":"A","ActivationTime":20161011160407,"BundledFlag":"S","EffectiveTime":20161011160407,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161011160407,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":100000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120010,"PurchaseSeq":101991010014067},"Status":2},{"ActivationMode":"A","ActivationTime":20161011160527,"BundledFlag":"S","EffectiveTime":20161011160527,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161011160527,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010014068},"Status":2},{"ActivationMode":"A","ActivationTime":20161027084258,"BundledFlag":"S","EffectiveTime":20161027084258,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161027084258,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010015132},"Status":2},{"ActivationMode":"A","ActivationTime":20161103152006,"BundledFlag":"S","EffectiveTime":20161103152006,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161103152006,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015215},"Status":2},{"ActivationMode":"A","ActivationTime":20161027084239,"BundledFlag":"S","EffectiveTime":20161027084239,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161027084239,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120098,"PurchaseSeq":101991010015131},"Status":2},{"ActivationMode":"A","ActivationTime":20161018054107,"BundledFlag":"S","EffectiveTime":20161018054107,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161018054107,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":0}],"OfferingClass":"I","OfferingKey":{"OfferingID":120096,"PurchaseSeq":101991010015055},"Status":2},{"ActivationMode":"A","ActivationTime":20161026101953,"BundledFlag":"S","EffectiveTime":20161026101953,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161026101953,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015098},"Status":2},{"ActivationMode":"A","ActivationTime":20161102082810,"BundledFlag":"S","EffectiveTime":20161102082810,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161102082810,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015165},"Status":2},{"ActivationMode":"A","ActivationTime":20161102104051,"BundledFlag":"S","EffectiveTime":20161102104051,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161102104051,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015171},"Status":2},{"ActivationMode":"A","ActivationTime":20161103152158,"BundledFlag":"S","EffectiveTime":20161103152158,"ExpirationTime":20361231160000,"OInstProperty":[{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20161103152158,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":200000}],"OfferingClass":"I","OfferingKey":{"OfferingID":120007,"PurchaseSeq":101991010015216},"Status":2}]
                         */

                        private int PaymentMode;
                        private PrimaryOfferingBean PrimaryOffering;
                        private SubscriberInfoBean SubscriberInfo;
                        private long SubscriberKey;
                        private List<SupplementaryOfferingBean> SupplementaryOffering;

                        public static SubscriberBean objectFromData(String str) {

                            return new Gson().fromJson(str, SubscriberBean.class);
                        }

                        public int getPaymentMode() {
                            return PaymentMode;
                        }

                        public void setPaymentMode(int PaymentMode) {
                            this.PaymentMode = PaymentMode;
                        }

                        public PrimaryOfferingBean getPrimaryOffering() {
                            return PrimaryOffering;
                        }

                        public void setPrimaryOffering(PrimaryOfferingBean PrimaryOffering) {
                            this.PrimaryOffering = PrimaryOffering;
                        }

                        public SubscriberInfoBean getSubscriberInfo() {
                            return SubscriberInfo;
                        }

                        public void setSubscriberInfo(SubscriberInfoBean SubscriberInfo) {
                            this.SubscriberInfo = SubscriberInfo;
                        }

                        public long getSubscriberKey() {
                            return SubscriberKey;
                        }

                        public void setSubscriberKey(long SubscriberKey) {
                            this.SubscriberKey = SubscriberKey;
                        }

                        public List<SupplementaryOfferingBean> getSupplementaryOffering() {
                            return SupplementaryOffering;
                        }

                        public void setSupplementaryOffering(List<SupplementaryOfferingBean> SupplementaryOffering) {
                            this.SupplementaryOffering = SupplementaryOffering;
                        }

                        public static class PrimaryOfferingBean {
                            /**
                             * BundledFlag : S
                             * OfferingClass : I
                             * OfferingKey : {"OfferingID":120001,"PurchaseSeq":7046}
                             * ProductInst : [{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"M","ProductID":1053,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1014,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1042,"ProductType":1},{"NetworkType":1,"PackageFlag":"A","PrimaryFlag":"A","ProductID":1822969218,"ProductType":1}]
                             * Status : 2
                             */

                            private String BundledFlag;
                            private String OfferingClass;
                            private OfferingKeyBean OfferingKey;
                            private int Status;
                            private List<ProductInstBean> ProductInst;

                            public static PrimaryOfferingBean objectFromData(String str) {

                                return new Gson().fromJson(str, PrimaryOfferingBean.class);
                            }

                            public String getBundledFlag() {
                                return BundledFlag;
                            }

                            public void setBundledFlag(String BundledFlag) {
                                this.BundledFlag = BundledFlag;
                            }

                            public String getOfferingClass() {
                                return OfferingClass;
                            }

                            public void setOfferingClass(String OfferingClass) {
                                this.OfferingClass = OfferingClass;
                            }

                            public OfferingKeyBean getOfferingKey() {
                                return OfferingKey;
                            }

                            public void setOfferingKey(OfferingKeyBean OfferingKey) {
                                this.OfferingKey = OfferingKey;
                            }

                            public int getStatus() {
                                return Status;
                            }

                            public void setStatus(int Status) {
                                this.Status = Status;
                            }

                            public List<ProductInstBean> getProductInst() {
                                return ProductInst;
                            }

                            public void setProductInst(List<ProductInstBean> ProductInst) {
                                this.ProductInst = ProductInst;
                            }

                            public static class OfferingKeyBean {
                                /**
                                 * OfferingID : 120001
                                 * PurchaseSeq : 7046
                                 */

                                private int OfferingID;
                                private int PurchaseSeq;

                                public static OfferingKeyBean objectFromData(String str) {

                                    return new Gson().fromJson(str, OfferingKeyBean.class);
                                }

                                public int getOfferingID() {
                                    return OfferingID;
                                }

                                public void setOfferingID(int OfferingID) {
                                    this.OfferingID = OfferingID;
                                }

                                public int getPurchaseSeq() {
                                    return PurchaseSeq;
                                }

                                public void setPurchaseSeq(int PurchaseSeq) {
                                    this.PurchaseSeq = PurchaseSeq;
                                }
                            }

                            public static class ProductInstBean {
                                /**
                                 * NetworkType : 1
                                 * PackageFlag : A
                                 * PrimaryFlag : M
                                 * ProductID : 1053
                                 * ProductType : 1
                                 */

                                private int NetworkType;
                                private String PackageFlag;
                                private String PrimaryFlag;
                                private int ProductID;
                                private int ProductType;

                                public static ProductInstBean objectFromData(String str) {

                                    return new Gson().fromJson(str, ProductInstBean.class);
                                }

                                public int getNetworkType() {
                                    return NetworkType;
                                }

                                public void setNetworkType(int NetworkType) {
                                    this.NetworkType = NetworkType;
                                }

                                public String getPackageFlag() {
                                    return PackageFlag;
                                }

                                public void setPackageFlag(String PackageFlag) {
                                    this.PackageFlag = PackageFlag;
                                }

                                public String getPrimaryFlag() {
                                    return PrimaryFlag;
                                }

                                public void setPrimaryFlag(String PrimaryFlag) {
                                    this.PrimaryFlag = PrimaryFlag;
                                }

                                public int getProductID() {
                                    return ProductID;
                                }

                                public void setProductID(int ProductID) {
                                    this.ProductID = ProductID;
                                }

                                public int getProductType() {
                                    return ProductType;
                                }

                                public void setProductType(int ProductType) {
                                    this.ProductType = ProductType;
                                }
                            }
                        }

                        public static class SubscriberInfoBean {
                            /**
                             * ActivationTime : 20160830100035
                             * ActiveTimeLimit : 20151231000000
                             * AddressInfo : {"Address1":"China","Address2":"JS","Address3":"NJ","AddressKey":20160827221825,"PostCode":501020}
                             * Brand : 1218989000
                             * NetworkType : 1
                             * Status : 2
                             * StatusDetail : 000000000000000000000000
                             * SubBasicInfo : {"DunningFlag":1,"IVRLang":2002,"SubLevel":1,"SubProperty":[{"Code":"C_SUB_LOAN_FLAG","Value":1},{"Code":"C_SUB_REFEREE_IDENTIFER","Value":""},{"Code":"C_SUB_EXTEND_DAYS","Value":0},{"Code":"C_SUB_AUTOTOPUP_LOWBALANCE","Value":1},{"Code":"C_APP_ACTIVE_USAGE","Value":0},{"Code":"C_SUB_MEDIA_FLAG","Value":"N"},{"Code":"C_CONTRACT_END_DATE","Value":""},{"Code":"C_SUB_LASTRECHARGETIME","Value":20170105065600},{"Code":"C_HANDSET_NETWORK","Value":""},{"Code":"C_SUB_LOAN_STATUS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG","Value":0},{"Code":"C_SUB_MAX_VALIDITY","Value":365},{"Code":"C_SUB_MSCC_FEE_AMOUNT","Value":0},{"Code":"C_SUB_PROB","Value":""},{"Code":"C_SUB_SALT","Value":"5325DB061D037F06"},{"Code":"C_MGB_LEVEL","Value":0},{"Code":"C_RENT_START_DATE","Value":""},{"Code":"C_STARTTIME_OF_SWITCH_COS","Value":-1},{"Code":"C_BUYOUT_APPLY_DATE","Value":""},{"Code":"C_HANDSET_BRAND","Value":""},{"Code":"C_TOPUP_PEAK_FLAG","Value":0},{"Code":"C_SUBS_EX_TYPE_BAK","Value":-1},{"Code":"C_BUYOUT_SUB_NUMBER","Value":""},{"Code":"C_SUB_AUTOTOPUP_RECURRING","Value":1},{"Code":"C_SUBDISCOUNT","Value":"O"},{"Code":"C_SUB_MAX_BALANCE","Value":-1},{"Code":"C_DIC_OFFER_USE_DATE","Value":""},{"Code":"C_SALES_CHANNEL_ID","Value":""},{"Code":"C_BUYOUT_START_DATE","Value":""},{"Code":"C_SUB_SERVICEPROVIDER","Value":""},{"Code":"C_HANDSET_OS_TYPE","Value":""},{"Code":"C_DIC_OFFER_USE_TIMES","Value":0},{"Code":"C_SUB_LASTRECHARGEAMT","Value":2000},{"Code":"C_IS_GROUP_MEMBER","Value":0},{"Code":"C_SUB_ONNET_DAYS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG_BAK","Value":0},{"Code":"C_SUB_LOW_BAL_GATE_1","Value":10000},{"Code":"C_SUB_BARRINGCODE","Value":99999999999},{"Code":"C_RENT_END_DATE","Value":""},{"Code":"C_SUB_REGISTERED","Value":1},{"Code":"C_SWITCH_COS_NUM","Value":0},{"Code":"C_SUBS_BUYOUT_FEE","Value":""}],"WrittenLang":2002}
                             * SubClass : 2
                             * SubIdentity : {"PrimaryFlag":1,"SubIdentity":4915298006711,"SubIdentityType":1}
                             * UserCustomer : {"CustInfo":{"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1},"CustKey":20160827221825,"IndividualInfo":{"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}}
                             * UserCustomerKey : 20160827221825
                             */

                            private long ActivationTime;
                            private long ActiveTimeLimit;
                            private AddressInfoBeanXX AddressInfo;
                            private int Brand;
                            private int NetworkType;
                            private int Status;
                            private String StatusDetail;
                            private SubBasicInfoBean SubBasicInfo;
                            private int SubClass;
                            private SubIdentityBean SubIdentity;
                            private UserCustomerBeanX UserCustomer;
                            private long UserCustomerKey;

                            public static SubscriberInfoBean objectFromData(String str) {

                                return new Gson().fromJson(str, SubscriberInfoBean.class);
                            }

                            public long getActivationTime() {
                                return ActivationTime;
                            }

                            public void setActivationTime(long ActivationTime) {
                                this.ActivationTime = ActivationTime;
                            }

                            public long getActiveTimeLimit() {
                                return ActiveTimeLimit;
                            }

                            public void setActiveTimeLimit(long ActiveTimeLimit) {
                                this.ActiveTimeLimit = ActiveTimeLimit;
                            }

                            public AddressInfoBeanXX getAddressInfo() {
                                return AddressInfo;
                            }

                            public void setAddressInfo(AddressInfoBeanXX AddressInfo) {
                                this.AddressInfo = AddressInfo;
                            }

                            public int getBrand() {
                                return Brand;
                            }

                            public void setBrand(int Brand) {
                                this.Brand = Brand;
                            }

                            public int getNetworkType() {
                                return NetworkType;
                            }

                            public void setNetworkType(int NetworkType) {
                                this.NetworkType = NetworkType;
                            }

                            public int getStatus() {
                                return Status;
                            }

                            public void setStatus(int Status) {
                                this.Status = Status;
                            }

                            public String getStatusDetail() {
                                return StatusDetail;
                            }

                            public void setStatusDetail(String StatusDetail) {
                                this.StatusDetail = StatusDetail;
                            }

                            public SubBasicInfoBean getSubBasicInfo() {
                                return SubBasicInfo;
                            }

                            public void setSubBasicInfo(SubBasicInfoBean SubBasicInfo) {
                                this.SubBasicInfo = SubBasicInfo;
                            }

                            public int getSubClass() {
                                return SubClass;
                            }

                            public void setSubClass(int SubClass) {
                                this.SubClass = SubClass;
                            }

                            public SubIdentityBean getSubIdentity() {
                                return SubIdentity;
                            }

                            public void setSubIdentity(SubIdentityBean SubIdentity) {
                                this.SubIdentity = SubIdentity;
                            }

                            public UserCustomerBeanX getUserCustomer() {
                                return UserCustomer;
                            }

                            public void setUserCustomer(UserCustomerBeanX UserCustomer) {
                                this.UserCustomer = UserCustomer;
                            }

                            public long getUserCustomerKey() {
                                return UserCustomerKey;
                            }

                            public void setUserCustomerKey(long UserCustomerKey) {
                                this.UserCustomerKey = UserCustomerKey;
                            }

                            public static class AddressInfoBeanXX {
                                /**
                                 * Address1 : China
                                 * Address2 : JS
                                 * Address3 : NJ
                                 * AddressKey : 20160827221825
                                 * PostCode : 501020
                                 */

                                private String Address1;
                                private String Address2;
                                private String Address3;
                                private long AddressKey;
                                private int PostCode;

                                public static AddressInfoBeanXX objectFromData(String str) {

                                    return new Gson().fromJson(str, AddressInfoBeanXX.class);
                                }

                                public String getAddress1() {
                                    return Address1;
                                }

                                public void setAddress1(String Address1) {
                                    this.Address1 = Address1;
                                }

                                public String getAddress2() {
                                    return Address2;
                                }

                                public void setAddress2(String Address2) {
                                    this.Address2 = Address2;
                                }

                                public String getAddress3() {
                                    return Address3;
                                }

                                public void setAddress3(String Address3) {
                                    this.Address3 = Address3;
                                }

                                public long getAddressKey() {
                                    return AddressKey;
                                }

                                public void setAddressKey(long AddressKey) {
                                    this.AddressKey = AddressKey;
                                }

                                public int getPostCode() {
                                    return PostCode;
                                }

                                public void setPostCode(int PostCode) {
                                    this.PostCode = PostCode;
                                }
                            }

                            public static class SubBasicInfoBean {
                                /**
                                 * DunningFlag : 1
                                 * IVRLang : 2002
                                 * SubLevel : 1
                                 * SubProperty : [{"Code":"C_SUB_LOAN_FLAG","Value":1},{"Code":"C_SUB_REFEREE_IDENTIFER","Value":""},{"Code":"C_SUB_EXTEND_DAYS","Value":0},{"Code":"C_SUB_AUTOTOPUP_LOWBALANCE","Value":1},{"Code":"C_APP_ACTIVE_USAGE","Value":0},{"Code":"C_SUB_MEDIA_FLAG","Value":"N"},{"Code":"C_CONTRACT_END_DATE","Value":""},{"Code":"C_SUB_LASTRECHARGETIME","Value":20170105065600},{"Code":"C_HANDSET_NETWORK","Value":""},{"Code":"C_SUB_LOAN_STATUS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG","Value":0},{"Code":"C_SUB_MAX_VALIDITY","Value":365},{"Code":"C_SUB_MSCC_FEE_AMOUNT","Value":0},{"Code":"C_SUB_PROB","Value":""},{"Code":"C_SUB_SALT","Value":"5325DB061D037F06"},{"Code":"C_MGB_LEVEL","Value":0},{"Code":"C_RENT_START_DATE","Value":""},{"Code":"C_STARTTIME_OF_SWITCH_COS","Value":-1},{"Code":"C_BUYOUT_APPLY_DATE","Value":""},{"Code":"C_HANDSET_BRAND","Value":""},{"Code":"C_TOPUP_PEAK_FLAG","Value":0},{"Code":"C_SUBS_EX_TYPE_BAK","Value":-1},{"Code":"C_BUYOUT_SUB_NUMBER","Value":""},{"Code":"C_SUB_AUTOTOPUP_RECURRING","Value":1},{"Code":"C_SUBDISCOUNT","Value":"O"},{"Code":"C_SUB_MAX_BALANCE","Value":-1},{"Code":"C_DIC_OFFER_USE_DATE","Value":""},{"Code":"C_SALES_CHANNEL_ID","Value":""},{"Code":"C_BUYOUT_START_DATE","Value":""},{"Code":"C_SUB_SERVICEPROVIDER","Value":""},{"Code":"C_HANDSET_OS_TYPE","Value":""},{"Code":"C_DIC_OFFER_USE_TIMES","Value":0},{"Code":"C_SUB_LASTRECHARGEAMT","Value":2000},{"Code":"C_IS_GROUP_MEMBER","Value":0},{"Code":"C_SUB_ONNET_DAYS","Value":0},{"Code":"C_CONTRACT_PAUSE_FLAG_BAK","Value":0},{"Code":"C_SUB_LOW_BAL_GATE_1","Value":10000},{"Code":"C_SUB_BARRINGCODE","Value":99999999999},{"Code":"C_RENT_END_DATE","Value":""},{"Code":"C_SUB_REGISTERED","Value":1},{"Code":"C_SWITCH_COS_NUM","Value":0},{"Code":"C_SUBS_BUYOUT_FEE","Value":""}]
                                 * WrittenLang : 2002
                                 */

                                private int DunningFlag;
                                private int IVRLang;
                                private int SubLevel;
                                private int WrittenLang;
                                private List<SubPropertyBean> SubProperty;

                                public static SubBasicInfoBean objectFromData(String str) {

                                    return new Gson().fromJson(str, SubBasicInfoBean.class);
                                }

                                public int getDunningFlag() {
                                    return DunningFlag;
                                }

                                public void setDunningFlag(int DunningFlag) {
                                    this.DunningFlag = DunningFlag;
                                }

                                public int getIVRLang() {
                                    return IVRLang;
                                }

                                public void setIVRLang(int IVRLang) {
                                    this.IVRLang = IVRLang;
                                }

                                public int getSubLevel() {
                                    return SubLevel;
                                }

                                public void setSubLevel(int SubLevel) {
                                    this.SubLevel = SubLevel;
                                }

                                public int getWrittenLang() {
                                    return WrittenLang;
                                }

                                public void setWrittenLang(int WrittenLang) {
                                    this.WrittenLang = WrittenLang;
                                }

                                public List<SubPropertyBean> getSubProperty() {
                                    return SubProperty;
                                }

                                public void setSubProperty(List<SubPropertyBean> SubProperty) {
                                    this.SubProperty = SubProperty;
                                }

                                public static class SubPropertyBean {
                                    /**
                                     * Code : C_SUB_LOAN_FLAG
                                     * Value : 1
                                     */

                                    private String Code;
                                    private int Value;

                                    public static SubPropertyBean objectFromData(String str) {

                                        return new Gson().fromJson(str, SubPropertyBean.class);
                                    }

                                    public String getCode() {
                                        return Code;
                                    }

                                    public void setCode(String Code) {
                                        this.Code = Code;
                                    }

                                    public int getValue() {
                                        return Value;
                                    }

                                    public void setValue(int Value) {
                                        this.Value = Value;
                                    }
                                }
                            }

                            public static class SubIdentityBean {
                                /**
                                 * PrimaryFlag : 1
                                 * SubIdentity : 4915298006711
                                 * SubIdentityType : 1
                                 */

                                private int PrimaryFlag;
                                private long SubIdentity;
                                private int SubIdentityType;

                                public static SubIdentityBean objectFromData(String str) {

                                    return new Gson().fromJson(str, SubIdentityBean.class);
                                }

                                public int getPrimaryFlag() {
                                    return PrimaryFlag;
                                }

                                public void setPrimaryFlag(int PrimaryFlag) {
                                    this.PrimaryFlag = PrimaryFlag;
                                }

                                public long getSubIdentity() {
                                    return SubIdentity;
                                }

                                public void setSubIdentity(long SubIdentity) {
                                    this.SubIdentity = SubIdentity;
                                }

                                public int getSubIdentityType() {
                                    return SubIdentityType;
                                }

                                public void setSubIdentityType(int SubIdentityType) {
                                    this.SubIdentityType = SubIdentityType;
                                }
                            }

                            public static class UserCustomerBeanX {
                                /**
                                 * CustInfo : {"CustBasicInfo":{"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1},"CustClass":2,"CustCode":"CBS100000000000005130","CustNodeType":1,"CustType":1}
                                 * CustKey : 20160827221825
                                 * IndividualInfo : {"Birthday":19600112101010,"Email":"cbs@huawei.com","FirstName":"Tim","Gender":1,"HomeAddressKey":20160827221825,"IndividualProperty":{"Code":"C_MKT_P_STATUS","Value":1},"LastName":"VDF","Title":1}
                                 */

                                private CustInfoBeanXX CustInfo;
                                private long CustKey;
                                private IndividualInfoBeanXX IndividualInfo;

                                public static UserCustomerBeanX objectFromData(String str) {

                                    return new Gson().fromJson(str, UserCustomerBeanX.class);
                                }

                                public CustInfoBeanXX getCustInfo() {
                                    return CustInfo;
                                }

                                public void setCustInfo(CustInfoBeanXX CustInfo) {
                                    this.CustInfo = CustInfo;
                                }

                                public long getCustKey() {
                                    return CustKey;
                                }

                                public void setCustKey(long CustKey) {
                                    this.CustKey = CustKey;
                                }

                                public IndividualInfoBeanXX getIndividualInfo() {
                                    return IndividualInfo;
                                }

                                public void setIndividualInfo(IndividualInfoBeanXX IndividualInfo) {
                                    this.IndividualInfo = IndividualInfo;
                                }

                                public static class CustInfoBeanXX {
                                    /**
                                     * CustBasicInfo : {"CustProperty":[{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}],"DFTIVRLang":2002,"DFTWrittenLang":2002,"DunningFlag":1}
                                     * CustClass : 2
                                     * CustCode : CBS100000000000005130
                                     * CustNodeType : 1
                                     * CustType : 1
                                     */

                                    private CustBasicInfoBeanXX CustBasicInfo;
                                    private int CustClass;
                                    private String CustCode;
                                    private int CustNodeType;
                                    private int CustType;

                                    public static CustInfoBeanXX objectFromData(String str) {

                                        return new Gson().fromJson(str, CustInfoBeanXX.class);
                                    }

                                    public CustBasicInfoBeanXX getCustBasicInfo() {
                                        return CustBasicInfo;
                                    }

                                    public void setCustBasicInfo(CustBasicInfoBeanXX CustBasicInfo) {
                                        this.CustBasicInfo = CustBasicInfo;
                                    }

                                    public int getCustClass() {
                                        return CustClass;
                                    }

                                    public void setCustClass(int CustClass) {
                                        this.CustClass = CustClass;
                                    }

                                    public String getCustCode() {
                                        return CustCode;
                                    }

                                    public void setCustCode(String CustCode) {
                                        this.CustCode = CustCode;
                                    }

                                    public int getCustNodeType() {
                                        return CustNodeType;
                                    }

                                    public void setCustNodeType(int CustNodeType) {
                                        this.CustNodeType = CustNodeType;
                                    }

                                    public int getCustType() {
                                        return CustType;
                                    }

                                    public void setCustType(int CustType) {
                                        this.CustType = CustType;
                                    }

                                    public static class CustBasicInfoBeanXX {
                                        /**
                                         * CustProperty : [{"Code":"C_LEGAL_CATEGORY","Value":""},{"Code":"C_FRAUD_FLAG","Value":"N"},{"Code":"C_CUST_DECEASED","Value":"N"},{"Code":"C_CUST_BANKRUPTCY","Value":"N"},{"Code":"C_EXTERNAL_CUST_ID","Value":""},{"Code":"C_CUST_MARKETING_CONSENT","Value":"N"},{"Code":"C_REG_FLAG","Value":"N"},{"Code":"C_CUST_MEDIA_FLAG","Value":"N"},{"Code":"C_TAX_PAYER_IDENTIFICATION_NO","Value":""},{"Code":"C_CUSTOMER_TAX_RATE","Value":""},{"Code":"C_ACCESSIBILITY_FLAG","Value":""},{"Code":"C_EVENING_PHONE","Value":""},{"Code":"C_DAYTIME_PHONE","Value":""}]
                                         * DFTIVRLang : 2002
                                         * DFTWrittenLang : 2002
                                         * DunningFlag : 1
                                         */

                                        private int DFTIVRLang;
                                        private int DFTWrittenLang;
                                        private int DunningFlag;
                                        private List<CustPropertyBeanXX> CustProperty;

                                        public static CustBasicInfoBeanXX objectFromData(String str) {

                                            return new Gson().fromJson(str, CustBasicInfoBeanXX.class);
                                        }

                                        public int getDFTIVRLang() {
                                            return DFTIVRLang;
                                        }

                                        public void setDFTIVRLang(int DFTIVRLang) {
                                            this.DFTIVRLang = DFTIVRLang;
                                        }

                                        public int getDFTWrittenLang() {
                                            return DFTWrittenLang;
                                        }

                                        public void setDFTWrittenLang(int DFTWrittenLang) {
                                            this.DFTWrittenLang = DFTWrittenLang;
                                        }

                                        public int getDunningFlag() {
                                            return DunningFlag;
                                        }

                                        public void setDunningFlag(int DunningFlag) {
                                            this.DunningFlag = DunningFlag;
                                        }

                                        public List<CustPropertyBeanXX> getCustProperty() {
                                            return CustProperty;
                                        }

                                        public void setCustProperty(List<CustPropertyBeanXX> CustProperty) {
                                            this.CustProperty = CustProperty;
                                        }

                                        public static class CustPropertyBeanXX {
                                            /**
                                             * Code : C_LEGAL_CATEGORY
                                             * Value :
                                             */

                                            private String Code;
                                            private String Value;

                                            public static CustPropertyBeanXX objectFromData(String str) {

                                                return new Gson().fromJson(str, CustPropertyBeanXX.class);
                                            }

                                            public String getCode() {
                                                return Code;
                                            }

                                            public void setCode(String Code) {
                                                this.Code = Code;
                                            }

                                            public String getValue() {
                                                return Value;
                                            }

                                            public void setValue(String Value) {
                                                this.Value = Value;
                                            }
                                        }
                                    }
                                }

                                public static class IndividualInfoBeanXX {
                                    /**
                                     * Birthday : 19600112101010
                                     * Email : cbs@huawei.com
                                     * FirstName : Tim
                                     * Gender : 1
                                     * HomeAddressKey : 20160827221825
                                     * IndividualProperty : {"Code":"C_MKT_P_STATUS","Value":1}
                                     * LastName : VDF
                                     * Title : 1
                                     */

                                    private long Birthday;
                                    private String Email;
                                    private String FirstName;
                                    private int Gender;
                                    private long HomeAddressKey;
                                    private IndividualPropertyBeanXX IndividualProperty;
                                    private String LastName;
                                    private int Title;

                                    public static IndividualInfoBeanXX objectFromData(String str) {

                                        return new Gson().fromJson(str, IndividualInfoBeanXX.class);
                                    }

                                    public long getBirthday() {
                                        return Birthday;
                                    }

                                    public void setBirthday(long Birthday) {
                                        this.Birthday = Birthday;
                                    }

                                    public String getEmail() {
                                        return Email;
                                    }

                                    public void setEmail(String Email) {
                                        this.Email = Email;
                                    }

                                    public String getFirstName() {
                                        return FirstName;
                                    }

                                    public void setFirstName(String FirstName) {
                                        this.FirstName = FirstName;
                                    }

                                    public int getGender() {
                                        return Gender;
                                    }

                                    public void setGender(int Gender) {
                                        this.Gender = Gender;
                                    }

                                    public long getHomeAddressKey() {
                                        return HomeAddressKey;
                                    }

                                    public void setHomeAddressKey(long HomeAddressKey) {
                                        this.HomeAddressKey = HomeAddressKey;
                                    }

                                    public IndividualPropertyBeanXX getIndividualProperty() {
                                        return IndividualProperty;
                                    }

                                    public void setIndividualProperty(IndividualPropertyBeanXX IndividualProperty) {
                                        this.IndividualProperty = IndividualProperty;
                                    }

                                    public String getLastName() {
                                        return LastName;
                                    }

                                    public void setLastName(String LastName) {
                                        this.LastName = LastName;
                                    }

                                    public int getTitle() {
                                        return Title;
                                    }

                                    public void setTitle(int Title) {
                                        this.Title = Title;
                                    }

                                    public static class IndividualPropertyBeanXX {
                                        /**
                                         * Code : C_MKT_P_STATUS
                                         * Value : 1
                                         */

                                        private String Code;
                                        private int Value;

                                        public static IndividualPropertyBeanXX objectFromData(String str) {

                                            return new Gson().fromJson(str, IndividualPropertyBeanXX.class);
                                        }

                                        public String getCode() {
                                            return Code;
                                        }

                                        public void setCode(String Code) {
                                            this.Code = Code;
                                        }

                                        public int getValue() {
                                            return Value;
                                        }

                                        public void setValue(int Value) {
                                            this.Value = Value;
                                        }
                                    }
                                }
                            }
                        }

                        public static class SupplementaryOfferingBean {
                            /**
                             * ActivationMode : A
                             * ActivationTime : 20160830100035
                             * BundledFlag : S
                             * EffectiveTime : 20160830100035
                             * ExpirationTime : 20361231230000
                             * OfferingClass : I
                             * OfferingKey : {"OfferingID":120002,"PurchaseSeq":7047}
                             * Status : 2
                             * OInstProperty : [{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_SALES_CHANNEL_ID","PropType":1,"Value":1001},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_COM_DISCOUNT","PropType":1,"Value":0},{"EffectiveTime":20160901172100,"ExpirationTime":20370101000000,"PropCode":"C_PRICE","PropType":1,"Value":400000}]
                             */

                            private String ActivationMode;
                            private long ActivationTime;
                            private String BundledFlag;
                            private long EffectiveTime;
                            private long ExpirationTime;
                            private String OfferingClass;
                            private OfferingKeyBeanX OfferingKey;
                            private int Status;
                            private List<OInstPropertyBean> OInstProperty;

                            public static SupplementaryOfferingBean objectFromData(String str) {

                                return new Gson().fromJson(str, SupplementaryOfferingBean.class);
                            }

                            public String getActivationMode() {
                                return ActivationMode;
                            }

                            public void setActivationMode(String ActivationMode) {
                                this.ActivationMode = ActivationMode;
                            }

                            public long getActivationTime() {
                                return ActivationTime;
                            }

                            public void setActivationTime(long ActivationTime) {
                                this.ActivationTime = ActivationTime;
                            }

                            public String getBundledFlag() {
                                return BundledFlag;
                            }

                            public void setBundledFlag(String BundledFlag) {
                                this.BundledFlag = BundledFlag;
                            }

                            public long getEffectiveTime() {
                                return EffectiveTime;
                            }

                            public void setEffectiveTime(long EffectiveTime) {
                                this.EffectiveTime = EffectiveTime;
                            }

                            public long getExpirationTime() {
                                return ExpirationTime;
                            }

                            public void setExpirationTime(long ExpirationTime) {
                                this.ExpirationTime = ExpirationTime;
                            }

                            public String getOfferingClass() {
                                return OfferingClass;
                            }

                            public void setOfferingClass(String OfferingClass) {
                                this.OfferingClass = OfferingClass;
                            }

                            public OfferingKeyBeanX getOfferingKey() {
                                return OfferingKey;
                            }

                            public void setOfferingKey(OfferingKeyBeanX OfferingKey) {
                                this.OfferingKey = OfferingKey;
                            }

                            public int getStatus() {
                                return Status;
                            }

                            public void setStatus(int Status) {
                                this.Status = Status;
                            }

                            public List<OInstPropertyBean> getOInstProperty() {
                                return OInstProperty;
                            }

                            public void setOInstProperty(List<OInstPropertyBean> OInstProperty) {
                                this.OInstProperty = OInstProperty;
                            }

                            public static class OfferingKeyBeanX {
                                /**
                                 * OfferingID : 120002
                                 * PurchaseSeq : 7047
                                 */

                                private int OfferingID;
                                private Long PurchaseSeq;

                                public static OfferingKeyBeanX objectFromData(String str) {

                                    return new Gson().fromJson(str, OfferingKeyBeanX.class);
                                }

                                public int getOfferingID() {
                                    return OfferingID;
                                }

                                public void setOfferingID(int OfferingID) {
                                    this.OfferingID = OfferingID;
                                }

                                public Long getPurchaseSeq() {
                                    return PurchaseSeq;
                                }

                                public void setPurchaseSeq(Long PurchaseSeq) {
                                    this.PurchaseSeq = PurchaseSeq;
                                }
                            }

                            public static class OInstPropertyBean {
                                /**
                                 * EffectiveTime : 20160901172100
                                 * ExpirationTime : 20370101000000
                                 * PropCode : C_SALES_CHANNEL_ID
                                 * PropType : 1
                                 * Value : 1001
                                 */

                                private long EffectiveTime;
                                private long ExpirationTime;
                                private String PropCode;
                                private int PropType;
                                private int Value;

                                public static OInstPropertyBean objectFromData(String str) {

                                    return new Gson().fromJson(str, OInstPropertyBean.class);
                                }

                                public long getEffectiveTime() {
                                    return EffectiveTime;
                                }

                                public void setEffectiveTime(long EffectiveTime) {
                                    this.EffectiveTime = EffectiveTime;
                                }

                                public long getExpirationTime() {
                                    return ExpirationTime;
                                }

                                public void setExpirationTime(long ExpirationTime) {
                                    this.ExpirationTime = ExpirationTime;
                                }

                                public String getPropCode() {
                                    return PropCode;
                                }

                                public void setPropCode(String PropCode) {
                                    this.PropCode = PropCode;
                                }

                                public int getPropType() {
                                    return PropType;
                                }

                                public void setPropType(int PropType) {
                                    this.PropType = PropType;
                                }

                                public int getValue() {
                                    return Value;
                                }

                                public void setValue(int Value) {
                                    this.Value = Value;
                                }
                            }
                        }
                    }
                }

                public static class ResultHeaderBean {
                    /**
                     * MsgLanguageCode : 2002
                     * ResultCode : 0
                     * ResultDesc : Operation successfully.
                     * Version : 1
                     */

                    private int MsgLanguageCode;
                    private int ResultCode;
                    private String ResultDesc;
                    private int Version;

                    public static ResultHeaderBean objectFromData(String str) {

                        return new Gson().fromJson(str, ResultHeaderBean.class);
                    }

                    public int getMsgLanguageCode() {
                        return MsgLanguageCode;
                    }

                    public void setMsgLanguageCode(int MsgLanguageCode) {
                        this.MsgLanguageCode = MsgLanguageCode;
                    }

                    public int getResultCode() {
                        return ResultCode;
                    }

                    public void setResultCode(int ResultCode) {
                        this.ResultCode = ResultCode;
                    }

                    public String getResultDesc() {
                        return ResultDesc;
                    }

                    public void setResultDesc(String ResultDesc) {
                        this.ResultDesc = ResultDesc;
                    }

                    public int getVersion() {
                        return Version;
                    }

                    public void setVersion(int Version) {
                        this.Version = Version;
                    }
                }
            }
        }
    }
}
