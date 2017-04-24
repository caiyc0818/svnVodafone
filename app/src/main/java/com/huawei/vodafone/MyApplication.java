package com.huawei.vodafone;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import com.huawei.vodafone.util.AppConfig;
import com.huawei.vodafone.util.SPUtils;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.util.Properties;
import java.util.UUID;

import skin.support.SkinCompatManager;
import skin.support.design.SkinMaterialManager;


public class MyApplication extends Application {
    private static MyApplication mInstance = null;

    /**
     * applicationContext
     */
    public static Context applicationContext = null;

    /**
     * 屏幕的宽度
     */
    public static int screenWidth;

    /**
     * 屏幕的高度
     */
    public static int screenHeight;

    /**
     * 屏幕的密度
     */
    public static float screenDensity;

    public static String sdPath;

    public boolean m_bKeyRight = true;

    /**
     * 是否使用使用demo
     */
    public static boolean isOntrial = false;
    private static final String TAG = MyApplication.class.getName();
    public static final String UPDATE_STATUS_ACTION = "com.umeng.message.example.action.UPDATE_STATUS";
    private Handler handler;
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        SkinMaterialManager.init(this);
        SkinCompatManager.init(this).loadSkin();
        SPUtils.init(this);
        mInstance = this;
        applicationContext = getApplicationContext();
        iniData();
        initEngineManager(this);
        File cacheDir = StorageUtils.getOwnCacheDirectory(applicationContext,
                "com.huawei.vodafone/cache");
        DisplayImageOptions options = new DisplayImageOptions.Builder()/*
                                                                         * .
																		 * showImageOnLoading
																		 * (R.
																		 * drawable
																		 * .
																		 * no_picture
																		 * ) .
																		 * showImageForEmptyUri
																		 * (R.
																		 * drawable
																		 * .
																		 * no_picture
																		 * ) .
																		 * showImageOnFail
																		 * (R.
																		 * drawable
																		 * .
																		 * no_picture
																		 * )
																		 */
                .cacheInMemory(true).cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new FadeInBitmapDisplayer(100)).build();

        ImageLoaderConfiguration.Builder builder









                 = new ImageLoaderConfiguration.Builder(
                applicationContext);
        builder.memoryCacheExtraOptions(480, 800);
        builder.diskCacheExtraOptions(480, 800, null);
        builder.threadPoolSize(3);
        builder.threadPriority(Thread.NORM_PRIORITY - 2);
        builder.tasksProcessingOrder(QueueProcessingType.FIFO);
        builder.denyCacheImageMultipleSizesInMemory();
        builder.memoryCache(new LruMemoryCache(2 * 1024 * 1024));
        builder.diskCache(new UnlimitedDiscCache(cacheDir));
        builder.diskCacheSize(50 * 1024 * 1024);
        builder.diskCacheFileCount(100);
        builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        builder.imageDownloader(
                new BaseImageDownloader(applicationContext, 5 * 1000,
                        30 * 1000));
        builder.defaultDisplayImageOptions(options);
        ImageLoaderConfiguration config = builder.build();
        ImageLoader.getInstance().init(config);// 全局初始化此配置



    }



    public static MyApplication getInstance() {
        return mInstance;
    }

    private void iniData() {
        // TODO Auto-generated method stub
        /*
         * 收集收集数据
		 */
        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        screenDensity = dm.density;
        //
    }

    public static int getLarge() {
        return screenWidth - screenHeight > 0 ? screenWidth : screenHeight;
    }

    public static int getLess() {
        return screenWidth - screenHeight < 0 ? screenWidth : screenHeight;
    }

    /**
     * 获取App安装包信息
     *
     * @return
     */
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        if (info == null)
            info = new PackageInfo();
        return info;
    }

    /**
     * 检测网络是否可用
     *
     * @return
     */
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }

    /**
     * 获取App唯一标识
     *
     * @return
     */
    public String getAppId() {
        String uniqueID = getProperty(AppConfig.CONF_APP_UNIQUEID);
        if (TextUtils.isEmpty(uniqueID)) {
            uniqueID = UUID.randomUUID().toString();
            setProperty(AppConfig.CONF_APP_UNIQUEID, uniqueID);
        }
        return uniqueID;
    }

    public boolean containsProperty(String key) {
        Properties props = getProperties();
        return props.containsKey(key);
    }

    public void setProperties(Properties ps) {
        AppConfig.getAppConfig(this).set(ps);
    }

    public Properties getProperties() {
        return AppConfig.getAppConfig(this).get();
    }

    public void setProperty(String key, String value) {
        AppConfig.getAppConfig(this).set(key, value);
    }

    public String getProperty(String key) {
        return AppConfig.getAppConfig(this).get(key);
    }

    public void removeProperty(String... key) {
        AppConfig.getAppConfig(this).remove(key);
    }

    @Override
    // 建议在您app的退出之前调用mapadpi的destroy()函数，避免重复初始化带来的时间消耗
    public void onTerminate() {
        // TODO Auto-generated method stub
        super.onTerminate();
    }

    public void initEngineManager(Context context) {
    }
}
