# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in F:\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#-----------------混淆配置设定------------------------------------------------------------------------
-optimizationpasses 5                                                       #指定代码压缩级别
-dontusemixedcaseclassnames                                                 #混淆时不会产生形形色色的类名
-dontskipnonpubliclibraryclasses                                            #指定不忽略非公共类库
-dontpreverify                                                              #不预校验，如果需要预校验，是-dontoptimize
-ignorewarnings                                                             #屏蔽警告
-verbose                                                                    #混淆时记录日志
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*    #优化
#                              -libraryjars libs/fastjson-1.1.23.jar
#-----------------不需要混淆第三方类库------------------------------------------------------------------
-dontwarn android.support.v4.**                                             #去掉警告
-keep class android.support.v4.** { *; }                                    #过滤android.support.v4
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment

-dontwarn com.alibaba.fastjson.**                                            #过滤fastjson.jar等
-keep class com.alibaba.fastjson.** { *; }




-dontwarn com.google.zxing.**
-keep  class com.google.zxing.**{*;}

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature
# For using GSON @Expose annotation
-keepattributes *Annotation*
# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson
-keep class com.huawei.vodafone.bean.** { *; }
-keep class com.huawei.vodafone.db.JokeMsg { *; }

##---------------End: proguard configuration for Gson  ----------


 -dontwarn com.wefika.flowlayout.**
-keep class com.wefika.flowlayout.**{*;}                                    #过滤jackson-core-2.1.4.jar等

-dontwarn com.igexin.**
-keep class com.igexin.** { *; }

                             #过滤jackson-core-2.1.4.jar等
 -dontwarn org.apache.http.entity.mime**
-keep class org.apache.http.entity.mime.**{*;}                                    #过滤jackson-core-2.1.4.jar等
 -dontwarn com.github.**
-keep class com.github.mikephil.charting.**{*;}                                    #过滤jackson-core-2.1.4.jar等
 -dontwarn org.joda.time.**
-keep class org.joda.time.**{*;}
                            #过滤jackson-core-2.1.4.jar等
 -dontwarn Decoder.**
-keep class Decoder.**{*;}
                             #过滤jackson-core-2.1.4.jar等
 -dontwarn com.nostra13.universalimageloader.**
-keep class com.nostra13.universalimageloader.**{*;}
                             #过滤jackson-core-2.1.4.jar等
# volley
-dontwarn com.android.volley.jar.**
-keep class com.android.volley.**{*;}


                              #过滤jackson-core-2.1.4.jar等
#-----------------不需要混淆系统组件等-------------------------------------------------------------------
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

#----------------保护指定的类和类的成员，但条件是所有指定的类和类成员是要存在------------------------------------
-keepclasseswithmembers class * {
    public <init>(android.content.Context);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
# Explicitly preserve all serialization members. The Serializable interface
# is only a marker interface, so it wouldn't save them.
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

-keep public class * implements java.io.Serializable {*;}

-keep class * implements android.os.Parcelable {
public static final android.os.Parcelable$Creator *;
}
