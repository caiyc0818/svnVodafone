package com.huawei.vodafone.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/6.
 */
public class DiyUtils2 {
    /**
     * body : {"diyItemList":[{"diyType":"2","itemTypeId":"C_DATA_LEVEL","itemTypeName":"DATA","levelList":[{"levelId":"100000","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":49900},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":300},"levelStatus":"0","leveldefault":"yes","sequence":1},{"levelId":"100001","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":69900},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":500},"levelStatus":"0","leveldefault":"no","sequence":2},{"levelId":"100002","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":99900},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":800},"levelStatus":"0","leveldefault":"no","sequence":3},{"levelId":"100038","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":20000},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":500},"levelStatus":"0","leveldefault":"no","sequence":4},{"levelId":"100039","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":30000},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":1024},"levelStatus":"0","leveldefault":"no","sequence":5},{"levelId":"100040","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":50000},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":2048},"levelStatus":"0","leveldefault":"no","sequence":6},{"levelId":"100041","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":70000},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":4096},"levelStatus":"0","leveldefault":"no","sequence":7}]},{"diyType":"2","itemTypeId":"C_SMS_LEVEL","itemTypeName":"SMS","levelList":[{"levelId":"100042","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":10000},"levelQuota":{"measureUnit":"One","measureValue":100},"levelStatus":"0","leveldefault":"yes","sequence":1},{"levelId":"100043","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":30000},"levelQuota":{"measureUnit":"One","measureValue":500},"levelStatus":"0","leveldefault":"no","sequence":2},{"levelId":"100044","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":40000},"levelQuota":{"measureUnit":"One","measureValue":1000},"levelStatus":"0","leveldefault":"no","sequence":3},{"levelId":"100045","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":20000},"levelQuota":{"measureUnit":"One","measureValue":200},"levelStatus":"0","leveldefault":"no","sequence":4}]},{"diyType":"2","itemTypeId":"C_VOICE_LEVEL","itemTypeName":"voice","levelList":[{"levelId":"100020","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":39900},"levelQuota":{"measureType":"Timelength","measureUnit":"Minute","measureValue":100},"levelStatus":"0","leveldefault":"no","sequence":1},{"levelId":"100021","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":59900},"levelQuota":{"measureType":"Timelength","measureUnit":"Minute","measureValue":200},"levelStatus":"0","leveldefault":"yes","sequence":2},{"levelId":"100034","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":10000},"levelQuota":{"measureType":"Timelength","measureUnit":"Minute","measureValue":200},"levelStatus":"0","leveldefault":"no","sequence":3},{"levelId":"100035","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":20000},"levelQuota":{"measureType":"Timelength","measureUnit":"Minute","measureValue":500},"levelStatus":"0","leveldefault":"no","sequence":4},{"levelId":"100036","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":30000},"levelQuota":{"measureType":"Timelength","measureUnit":"Minute","measureValue":1000},"levelStatus":"0","leveldefault":"no","sequence":5},{"levelId":"100037","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":40000},"levelQuota":{"measureType":"Timelength","measureUnit":"Minute","measureValue":2000},"levelStatus":"0","leveldefault":"no","sequence":6}]},{"diyType":"2","itemTypeId":"C_UNIT_LEVEL","itemTypeName":"Units","levelList":[{"levelId":"100008","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":79900},"levelQuota":{"measureType":"Number","measureUnit":"One","measureValue":500},"levelStatus":"0","leveldefault":"no","sequence":2}]}],"offerList":[{"addOnSubcategory":"AVT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"VOICE_500","offerId":"120010","offerName":"500Min Voice Add-on","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"AVT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"500Min Voice Add-on"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"10"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"500Min Voice Add-on"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":100000},"recurringOffer":"1","tryFlag":"0","offerDesc":"Initial 50 MB Data","onceFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":0}},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"Free 2G","offerId":"120096","offerName":"Free 2G Data Add-on for Point Redeem","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"Free 2G Data Add-on for Point Redeem"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"0"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"Free 2G Data Add-on for Point Redeem"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":0},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"1G_1","offerId":"12013","offerName":"1G Internet Add-on For Up-Sell_1","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"1G Internet Add-on For Up-Sell_1"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"5"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"1G Internet Add-on For Up-Sell_1"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":50000},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"One Off initial data packages","offerDesc":"Initial 50 MB Data","offerId":"10101","offerName":"One Off initial data packages","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"50 MB initiales Datenvolumen"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"0"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"0"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"20"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"50 MB initiales Datenvolumen"}],"onceFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":0},"recurringOffer":"0","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"INTERNET_10G","offerId":"120005","offerName":"10G Internet Add-on","offerType":"A","offeringPropSpec":[{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"10G Internet Add-on"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"70"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"10G Internet Add-on"},{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":700000},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"FACEBOOK_5G","offerId":"120006","offerName":"5G Internet Add-on For Facebook","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"5G Internet Add-on For Facebook"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"40"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"5G Internet Add-on For Facebook"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":400000},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"Free 500M","offerId":"120097","offerName":"Free 500M Internet Add-on","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"Free 500M Internet Add-on"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"0"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"Free 500M Internet Add-on"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":0},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"2G_1","offerId":"12014","offerName":"2G Internet Add-on_1","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"2G Internet Add-on_1"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"8"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"2G Internet Add-on_1"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":80000},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"AIT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"1GB International Roaming Data","offerId":"12010","offerName":"1GB International Roaming Data","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"AIT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"1GB International Roaming Data"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"20"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"1GB International Roaming Data"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":200000},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"AIP","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"\u20ac2 Starbucks Coupon","offerId":"12011","offerName":"\u20ac2 Starbucks Coupon","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"AIP"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"\u20ac2 Starbucks Coupon"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"0"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"0"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"30"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"\u20ac2 Starbucks Coupon"}],"onceFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":0},"recurringOffer":"0","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"2G Internet Add-on For Facebook","offerId":"12016","offerName":"2G Internet Add-on For Facebook","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"2GB Netflix Data Add-on_1"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"5"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"2GB Netflix Data Add-on_1"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":50000},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"99","offerCode":"INTERNET_1G","offerId":"120007","offerName":"1G Internet Add-on For Up-Sell","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"1G Internet Add-on For Up-Sell"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"20"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"1G Internet Add-on For Up-Sell"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":200000},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"AST","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"SMS_100","offerId":"120009","offerName":"100Item  SMS Add-on","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"AST"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"100Item  SMS Add-on"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"10"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"100Item  SMS Add-on"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":100000},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"2GB Netflix Data Add-on","offerId":"100123","offerName":"2GB Netflix Data Add-on","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"1"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"2"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"2GB Netflix Data Add-on"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"5"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"1"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"1"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"2GB Netflix Data Add-on"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":49950},"recurringOffer":"1","tryFlag":"1"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"FREE_10M","offerId":"120003","offerName":"Free 10M Internet","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"Free 10M Internet"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"0"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"Free 10M Internet"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":0},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"FREE_20M","offerId":"120004","offerName":"Free 20M Internet Add-on for Topup promotion","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"Free 20M Internet Add-on for Topup promotion"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"0"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"Free 20M Internet Add-on for Topup promotion"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":0},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"INTERNET_500M","offerId":"120008","offerName":"500M Internet Add-on","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"500M Internet Add-on"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"10"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"500M Internet Add-on"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":100000},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"99","offerCode":"Free 1G","offerId":"120098","offerName":"Free 1G Internet Add-on","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"Free 1G Internet Add-on"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"0"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"Free 1G Internet Add-on"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":0},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"500M_1","offerId":"12012","offerName":"500M Internet Add-on_1","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"500M Internet Add-on_1"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"3"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"500M Internet Add-on_1"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":30000},"recurringOffer":"1","tryFlag":"0"},{"addOnSubcategory":"ADT","catagoryId":"50003","catagoryName":"ucm","instParameterValueList":[],"maxNumber":"null","offerCode":"lllll","offerId":"10124","offerName":"llll","offerType":"A","offeringPropSpec":[{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"ADT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"mn"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"10"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"mn"}],"periodicFee":{"currencyType":"EUR","currencyUnit":"4","currencyValue":100000},"recurringOffer":"1","tryFlag":"0"}]}
     * header : {"resultCode":"0","resultMessage":"Successful","serialId":"c7450a0a-8f9f-469c-a319-b3f06d6bf8a6"}
     */

    private BodyBean body;
    private HeaderBean header;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public static class BodyBean {
        private List<DiyItemListBean> diyItemList;
        private List<OfferListBean> offerList;

        public List<DiyItemListBean> getDiyItemList() {
            return diyItemList;
        }

        public void setDiyItemList(List<DiyItemListBean> diyItemList) {
            this.diyItemList = diyItemList;
        }

        public List<OfferListBean> getOfferList() {
            return offerList;
        }

        public void setOfferList(List<OfferListBean> offerList) {
            this.offerList = offerList;
        }

        public static class DiyItemListBean {
            /**
             * diyType : 2
             * itemTypeId : C_DATA_LEVEL
             * itemTypeName : DATA
             * levelList : [{"levelId":"100000","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":49900},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":300},"levelStatus":"0","leveldefault":"yes","sequence":1},{"levelId":"100001","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":69900},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":500},"levelStatus":"0","leveldefault":"no","sequence":2},{"levelId":"100002","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":99900},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":800},"levelStatus":"0","leveldefault":"no","sequence":3},{"levelId":"100038","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":20000},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":500},"levelStatus":"0","leveldefault":"no","sequence":4},{"levelId":"100039","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":30000},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":1024},"levelStatus":"0","leveldefault":"no","sequence":5},{"levelId":"100040","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":50000},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":2048},"levelStatus":"0","leveldefault":"no","sequence":6},{"levelId":"100041","levelPrice":{"currencyType":"EUR","currencyUnit":"4","currencyValue":70000},"levelQuota":{"measureType":"Dataflow","measureUnit":"MB","measureValue":4096},"levelStatus":"0","leveldefault":"no","sequence":7}]
             */

            private String diyType;
            private String itemTypeId;
            private String itemTypeName;
            private List<LevelListBean> levelList;

            public String getDiyType() {
                return diyType;
            }

            public void setDiyType(String diyType) {
                this.diyType = diyType;
            }

            public String getItemTypeId() {
                return itemTypeId;
            }

            public void setItemTypeId(String itemTypeId) {
                this.itemTypeId = itemTypeId;
            }

            public String getItemTypeName() {
                return itemTypeName;
            }

            public void setItemTypeName(String itemTypeName) {
                this.itemTypeName = itemTypeName;
            }

            public List<LevelListBean> getLevelList() {
                return levelList;
            }

            public void setLevelList(List<LevelListBean> levelList) {
                this.levelList = levelList;
            }

            public static class LevelListBean {
                /**
                 * levelId : 100000
                 * levelPrice : {"currencyType":"EUR","currencyUnit":"4","currencyValue":49900}
                 * levelQuota : {"measureType":"Dataflow","measureUnit":"MB","measureValue":300}
                 * levelStatus : 0
                 * leveldefault : yes
                 * sequence : 1
                 */

                private String levelId;
                private LevelPriceBean levelPrice;
                private LevelQuotaBean levelQuota;
                private String levelStatus;
                private String leveldefault;
                private int sequence;

                public String getLevelId() {
                    return levelId;
                }

                public void setLevelId(String levelId) {
                    this.levelId = levelId;
                }

                public LevelPriceBean getLevelPrice() {
                    return levelPrice;
                }

                public void setLevelPrice(LevelPriceBean levelPrice) {
                    this.levelPrice = levelPrice;
                }

                public LevelQuotaBean getLevelQuota() {
                    return levelQuota;
                }

                public void setLevelQuota(LevelQuotaBean levelQuota) {
                    this.levelQuota = levelQuota;
                }

                public String getLevelStatus() {
                    return levelStatus;
                }

                public void setLevelStatus(String levelStatus) {
                    this.levelStatus = levelStatus;
                }

                public String getLeveldefault() {
                    return leveldefault;
                }

                public void setLeveldefault(String leveldefault) {
                    this.leveldefault = leveldefault;
                }

                public int getSequence() {
                    return sequence;
                }

                public void setSequence(int sequence) {
                    this.sequence = sequence;
                }

                public static class LevelPriceBean {
                    /**
                     * currencyType : EUR
                     * currencyUnit : 4
                     * currencyValue : 49900
                     */

                    private String currencyType;
                    private String currencyUnit;
                    private int currencyValue;

                    public String getCurrencyType() {
                        return currencyType;
                    }

                    public void setCurrencyType(String currencyType) {
                        this.currencyType = currencyType;
                    }

                    public String getCurrencyUnit() {
                        return currencyUnit;
                    }

                    public void setCurrencyUnit(String currencyUnit) {
                        this.currencyUnit = currencyUnit;
                    }

                    public int getCurrencyValue() {
                        return currencyValue;
                    }

                    public void setCurrencyValue(int currencyValue) {
                        this.currencyValue = currencyValue;
                    }
                }

                public static class LevelQuotaBean {
                    /**
                     * measureType : Dataflow
                     * measureUnit : MB
                     * measureValue : 300
                     */

                    private String measureType;
                    private String measureUnit;
                    private int measureValue;

                    public String getMeasureType() {
                        return measureType;
                    }

                    public void setMeasureType(String measureType) {
                        this.measureType = measureType;
                    }

                    public String getMeasureUnit() {
                        return measureUnit;
                    }

                    public void setMeasureUnit(String measureUnit) {
                        this.measureUnit = measureUnit;
                    }

                    public int getMeasureValue() {
                        return measureValue;
                    }

                    public void setMeasureValue(int measureValue) {
                        this.measureValue = measureValue;
                    }
                }
            }
        }

        public static class OfferListBean {
            /**
             * addOnSubcategory : AVT
             * catagoryId : 50003
             * catagoryName : ucm
             * instParameterValueList : []
             * maxNumber : null
             * offerCode : VOICE_500
             * offerId : 120010
             * offerName : 500Min Voice Add-on
             * offerType : A
             * offeringPropSpec : [{"parameterCode":"UCM_tryFlag","parameterId":"1458547902995713745","parameterValue":"0"},{"parameterCode":"C_CYCLE_UNIT","parameterId":"1458569362543569539","parameterValue":"0"},{"parameterCode":"UCM_addonType","parameterId":"1458615979632000547","parameterValue":"AVT"},{"parameterCode":"UCM_offerDesc","parameterId":"1458541787018491417","parameterValue":"500Min Voice Add-on"},{"parameterCode":"UCM_onceFee","parameterId":"1458610641310210814","parameterValue":"10"},{"parameterCode":"UCM_offerType","parameterId":"1458545874844944564","parameterValue":"A"},{"parameterCode":"UCM_periodType","parameterId":"1458548045333473782","parameterValue":"1"},{"parameterCode":"C_CYCLE_VALUE","parameterId":"1458569672068395587","parameterValue":"28"},{"parameterCode":"C_COM_DISCOUNT","parameterId":"1458570009586588471","parameterValue":"0"},{"parameterCode":"UCM_offerName","parameterId":"1458529578890201241","parameterValue":"500Min Voice Add-on"}]
             * periodicFee : {"currencyType":"EUR","currencyUnit":"4","currencyValue":100000}
             * recurringOffer : 1
             * tryFlag : 0
             * offerDesc : Initial 50 MB Data
             * onceFee : {"currencyType":"EUR","currencyUnit":"4","currencyValue":0}
             */

            private String addOnSubcategory;
            private String catagoryId;
            private String catagoryName;
            private String maxNumber;
            private String offerCode;
            private String offerId;
            private String offerName;
            private String offerType;
            private PeriodicFeeBean periodicFee;
            private String recurringOffer;
            private String tryFlag;
            private String offerDesc;
            private OnceFeeBean onceFee;
            private List<?> instParameterValueList;
            private List<OfferingPropSpecBean> offeringPropSpec;

            public String getAddOnSubcategory() {
                return addOnSubcategory;
            }

            public void setAddOnSubcategory(String addOnSubcategory) {
                this.addOnSubcategory = addOnSubcategory;
            }

            public String getCatagoryId() {
                return catagoryId;
            }

            public void setCatagoryId(String catagoryId) {
                this.catagoryId = catagoryId;
            }

            public String getCatagoryName() {
                return catagoryName;
            }

            public void setCatagoryName(String catagoryName) {
                this.catagoryName = catagoryName;
            }

            public String getMaxNumber() {
                return maxNumber;
            }

            public void setMaxNumber(String maxNumber) {
                this.maxNumber = maxNumber;
            }

            public String getOfferCode() {
                return offerCode;
            }

            public void setOfferCode(String offerCode) {
                this.offerCode = offerCode;
            }

            public String getOfferId() {
                return offerId;
            }

            public void setOfferId(String offerId) {
                this.offerId = offerId;
            }

            public String getOfferName() {
                return offerName;
            }

            public void setOfferName(String offerName) {
                this.offerName = offerName;
            }

            public String getOfferType() {
                return offerType;
            }

            public void setOfferType(String offerType) {
                this.offerType = offerType;
            }

            public PeriodicFeeBean getPeriodicFee() {
                return periodicFee;
            }

            public void setPeriodicFee(PeriodicFeeBean periodicFee) {
                this.periodicFee = periodicFee;
            }

            public String getRecurringOffer() {
                return recurringOffer;
            }

            public void setRecurringOffer(String recurringOffer) {
                this.recurringOffer = recurringOffer;
            }

            public String getTryFlag() {
                return tryFlag;
            }

            public void setTryFlag(String tryFlag) {
                this.tryFlag = tryFlag;
            }

            public String getOfferDesc() {
                return offerDesc;
            }

            public void setOfferDesc(String offerDesc) {
                this.offerDesc = offerDesc;
            }

            public OnceFeeBean getOnceFee() {
                return onceFee;
            }

            public void setOnceFee(OnceFeeBean onceFee) {
                this.onceFee = onceFee;
            }

            public List<?> getInstParameterValueList() {
                return instParameterValueList;
            }

            public void setInstParameterValueList(List<?> instParameterValueList) {
                this.instParameterValueList = instParameterValueList;
            }

            public List<OfferingPropSpecBean> getOfferingPropSpec() {
                return offeringPropSpec;
            }

            public void setOfferingPropSpec(List<OfferingPropSpecBean> offeringPropSpec) {
                this.offeringPropSpec = offeringPropSpec;
            }

            public static class PeriodicFeeBean {
                /**
                 * currencyType : EUR
                 * currencyUnit : 4
                 * currencyValue : 100000
                 */

                private String currencyType;
                private String currencyUnit;
                private int currencyValue;

                public String getCurrencyType() {
                    return currencyType;
                }

                public void setCurrencyType(String currencyType) {
                    this.currencyType = currencyType;
                }

                public String getCurrencyUnit() {
                    return currencyUnit;
                }

                public void setCurrencyUnit(String currencyUnit) {
                    this.currencyUnit = currencyUnit;
                }

                public int getCurrencyValue() {
                    return currencyValue;
                }

                public void setCurrencyValue(int currencyValue) {
                    this.currencyValue = currencyValue;
                }
            }

            public static class OnceFeeBean {
                /**
                 * currencyType : EUR
                 * currencyUnit : 4
                 * currencyValue : 0
                 */

                private String currencyType;
                private String currencyUnit;
                private int currencyValue;

                public String getCurrencyType() {
                    return currencyType;
                }

                public void setCurrencyType(String currencyType) {
                    this.currencyType = currencyType;
                }

                public String getCurrencyUnit() {
                    return currencyUnit;
                }

                public void setCurrencyUnit(String currencyUnit) {
                    this.currencyUnit = currencyUnit;
                }

                public int getCurrencyValue() {
                    return currencyValue;
                }

                public void setCurrencyValue(int currencyValue) {
                    this.currencyValue = currencyValue;
                }
            }

            public static class OfferingPropSpecBean {
                /**
                 * parameterCode : UCM_tryFlag
                 * parameterId : 1458547902995713745
                 * parameterValue : 0
                 */

                private String parameterCode;
                private String parameterId;
                private String parameterValue;

                public String getParameterCode() {
                    return parameterCode;
                }

                public void setParameterCode(String parameterCode) {
                    this.parameterCode = parameterCode;
                }

                public String getParameterId() {
                    return parameterId;
                }

                public void setParameterId(String parameterId) {
                    this.parameterId = parameterId;
                }

                public String getParameterValue() {
                    return parameterValue;
                }

                public void setParameterValue(String parameterValue) {
                    this.parameterValue = parameterValue;
                }
            }
        }
    }

    public static class HeaderBean {
        /**
         * resultCode : 0
         * resultMessage : Successful
         * serialId : c7450a0a-8f9f-469c-a319-b3f06d6bf8a6
         */

        private String resultCode;
        private String resultMessage;
        private String serialId;

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultMessage() {
            return resultMessage;
        }

        public void setResultMessage(String resultMessage) {
            this.resultMessage = resultMessage;
        }

        public String getSerialId() {
            return serialId;
        }

        public void setSerialId(String serialId) {
            this.serialId = serialId;
        }
    }
}
