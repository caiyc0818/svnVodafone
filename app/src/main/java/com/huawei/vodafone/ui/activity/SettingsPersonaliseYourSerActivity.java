package com.huawei.vodafone.ui.activity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager.LayoutParams;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.bcinfo.photoselector.model.PhotoModel;
import com.huawei.vodafone.R;
import com.huawei.vodafone.bean.PersonItemInfo;
import com.huawei.vodafone.bean.UserInfo;
import com.huawei.vodafone.ui.adapter.PersonAdapter;
import com.huawei.vodafone.ui.myview.MyListview;
import com.huawei.vodafone.ui.myview.dialog.SelectPicDialog2;
import com.huawei.vodafone.ui.myview.dialog.SelectPicDialog2.OperationListener;
import com.huawei.vodafone.util.BitmapUtil;
import com.huawei.vodafone.util.PreferenceUtils;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;



public class SettingsPersonaliseYourSerActivity extends BaseActivity implements
        OnClickListener {
    private static final int REQUEST_CODE_PERMISSION_OTHER = 200;
    private static final int REQUEST_CODE_SETTING = 300;
    private ImageView image1;
    private TextView change_picture;
    private EditText edit_name;
    private TextView text_name;
    private String path = "";
    private Uri uri;
    private final int ADD_BACKGROUND_CODE = 1002;
    private int screenW;
    private PopupWindow pw;
    private Bitmap bmap;
    private ImageView iamge_goLeft;
    private ImageView iamge_goRight;
    private TextView name;
    private TextView number;
    private TextView phone;
    private MyListview person_listView;
    private ArrayList<PersonItemInfo> PerListList = new ArrayList<PersonItemInfo>();
    private PersonAdapter PersonAdapter;
    private boolean isDavid;
    private boolean isJen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_personalise_main_lay);
        initSecondTitle(getString(R.string.settings_personalise_services));
        if (savedInstanceState != null) {
            path = savedInstanceState.getString("path");
            uri = savedInstanceState.getParcelable("uri");
        }
        initView();

    }

    private void initView() {

        image1 = (ImageView) findViewById(R.id.image1);
        iamge_goLeft = (ImageView) findViewById(R.id.go_left);
        iamge_goRight = (ImageView) findViewById(R.id.go_right);
        change_picture = (TextView) findViewById(R.id.chang_picture);
        edit_name = (EditText) findViewById(R.id.edit_name);
        name = (TextView) findViewById(R.id.name);
        number = (TextView) findViewById(R.id.number);
        text_name = (TextView) findViewById(R.id.text_name);
        // edit_name.setSelection(edit_name.getText().toString().length());
        edit_name.setCursorVisible(false);
        edit_name.setOnClickListener(this);
        edit_name.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                // TODO Auto-generated method stub
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    UserInfo.setUserName(edit_name.getText().toString());
                    name.setText(UserInfo.getUserName() + "'s phone");
                    PreferenceUtils.setBoolean(
                            SettingsPersonaliseYourSerActivity.this, "name",
                            true);
                }
                return false;
            }
        });
        ((LinearLayout) edit_name.getParent())
                .setBackgroundResource(R.drawable.settings_personalise_the_app_personalise_your_services_edit_name_07);
        edit_name.addTextChangedListener(new MyTextChangeWatcher());

        phone = (TextView) findViewById(R.id.phone);
        person_listView = (MyListview) findViewById(R.id.person_listView);

        image1.setOnClickListener(this);
        change_picture.setOnClickListener(this);
        iamge_goRight.setOnClickListener(this);
        iamge_goLeft.setOnClickListener(this);

        initdata();
        PersonAdapter = new PersonAdapter(PerListList,
                SettingsPersonaliseYourSerActivity.this);
        person_listView.setAdapter(PersonAdapter);
        person_listView.setFocusable(false);
    }

    private void initdata() {
        // TODO Auto-generated method stub
        String[] titlt = getResources().getStringArray(R.array.person_array1);
        String[] content = getResources().getStringArray(R.array.person_array2);
        for (int i = 0; i < titlt.length; i++) {
            PersonItemInfo PersonItemInfo = new PersonItemInfo();
            PersonItemInfo.setTitle(titlt[i]);
            PersonItemInfo.setContent(content[i]);
            PerListList.add(PersonItemInfo);
        }
        String mobile = UserInfo.getUserMobile();
        // number.setText(mobile.substring(0, 4) + " "
        // + mobile.subSequence(4, mobile.length()));
        number.setText(mobile);
        name.setText(UserInfo.getUserName() + "'s" + " phone");
        image1.setImageBitmap(UserInfo.getIcon(getBaseContext()));
        // edit_name.setText(UserInfo.getUserName() + "'s" + " phone");
        edit_name.setText(UserInfo.getUserName());
        phone.setText(mobile);
        if (("David".equals(UserInfo.getUserName()))) {
            isDavid = true;
            PerListList.get(0).setContent("Mir");
        } else if (("Jen".equals(UserInfo.getUserName()))) {
            isJen = true;
            PerListList.get(0).setContent("Miss");
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.chang_picture:
                if (AndPermission.hasPermission(this, Manifest.permission.CAMERA) &&
                        AndPermission.hasPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        ) {
                    // 有权限，直接do anything.
                    new SelectPicDialog2(SettingsPersonaliseYourSerActivity.this,
                            mOperationListener).show();
                } else {
                    // 申请多个权限。
                    AndPermission.with(this)
                            .requestCode(REQUEST_CODE_PERMISSION_OTHER)
                            .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA

                            )
                            // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框，避免用户勾选不再提示。
                            .rationale((requestCode, rationale) ->
                                    // 这里的对话框可以自定义，只要调用rationale.resume()就可以继续申请。
                                    AndPermission.rationaleDialog(SettingsPersonaliseYourSerActivity.this, rationale).show()
                            )
                            .send();
                }
                break;
            case R.id.image1:
                if (AndPermission.hasPermission(this, Manifest.permission.CAMERA) &&
                        AndPermission.hasPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        ) {
                    // 有权限，直接do anything.
                    new SelectPicDialog2(SettingsPersonaliseYourSerActivity.this,
                            mOperationListener).show();
                } else {
                    // 申请多个权限。
                    AndPermission.with(this)
                            .requestCode(REQUEST_CODE_PERMISSION_OTHER)
                            .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                            // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框，避免用户勾选不再提示。
                            .rationale((requestCode, rationale) ->
                                    // 这里的对话框可以自定义，只要调用rationale.resume()就可以继续申请。
                                    AndPermission.rationaleDialog(SettingsPersonaliseYourSerActivity.this, rationale).show()
                            )
                            .send();
                }
                break;
            case R.id.edit_name:
                edit_name.setCursorVisible(true);
                break;
            case R.id.go_left:
                if (isDavid) {
                    image1.setImageResource(R.drawable.david_ic);
                    name.setText(UserInfo.getUserName() + "'s" + " phone");
                    // edit_name.setText(UserInfo.getUserName() + "'s" + " phone");
                    edit_name.setText(UserInfo.getUserName());
                    number.setText(UserInfo.getUserMobile());
                    phone.setText(UserInfo.getUserMobile().substring(0, 4)
                            + " "
                            + UserInfo.getUserMobile().subSequence(4,
                            UserInfo.getUserMobile().length()));
                    PerListList.get(0).setContent("Mir");
                    PersonAdapter.notifyDataSetChanged();

                }
                if (isJen) {
                    image1.setImageResource(R.drawable.jen);
                    name.setText(UserInfo.getUserName() + "'s" + " phone");
                    // edit_name.setText(UserInfo.getUserName() + "'s" + " phone");
                    edit_name.setText(UserInfo.getUserName());
                    number.setText(UserInfo.getUserMobile());
                    phone.setText(UserInfo.getUserMobile().substring(0, 4)
                            + " "
                            + UserInfo.getUserMobile().subSequence(4,
                            UserInfo.getUserMobile().length()));
                    PerListList.get(0).setContent("Miss");
                    PersonAdapter.notifyDataSetChanged();
                }
                iamge_goLeft.setEnabled(false);
                iamge_goRight.setEnabled(true);
                iamge_goLeft.setBackgroundResource(R.drawable.settings_go_left);
                iamge_goRight.setBackgroundResource(R.drawable.settings_go_right11);
                break;
            case R.id.go_right:
                if (isDavid) {
                    image1.setImageResource(R.drawable.jen);
                    name.setText(UserInfo.getUserName(1) + "'s" + " phone");
                    // edit_name.setText(UserInfo.getUserName(1) + "'s" + " phone");
                    edit_name.setText(UserInfo.getUserName(1));
                    number.setText(UserInfo.getUserMobile(1));
                    phone.setText(UserInfo.getUserMobile(1).substring(0, 4)
                            + " "
                            + UserInfo.getUserMobile(1).subSequence(4,
                            UserInfo.getUserMobile(1).length()));
                    PerListList.get(0).setContent("Miss");
                    PersonAdapter.notifyDataSetChanged();
                }
                if (isJen) {
                    image1.setImageResource(R.drawable.david_ic);
                    name.setText(UserInfo.getUserName(1) + "'s" + " phone");
                    // edit_name.setText(UserInfo.getUserName(1) + "'s" + " phone");
                    edit_name.setText(UserInfo.getUserName(1));
                    number.setText(UserInfo.getUserMobile(1));
                    phone.setText(UserInfo.getUserMobile(1).substring(0, 4)
                            + " "
                            + UserInfo.getUserMobile(1).subSequence(4,
                            UserInfo.getUserMobile(1).length()));
                    PerListList.get(0).setContent("Mir");
                    PersonAdapter.notifyDataSetChanged();
                }
                // if ("David".equals(UserInfo.getUserName())) {
                // image1.setImageResource(R.drawable.jen);
                // name.setText("Jen's phone");
                // number.setText("0778 3947975");
                // phone.setText("0778 3947975");
                // text1.setText("Jen's phone");
                // PerListList.get(0).setContent("Miss");
                // PersonAdapter.notifyDataSetChanged();
                // } else {
                // image1.setImageResource(R.drawable.david_ic);
                // name.setText("David's phone");
                // text1.setText("David's phone");
                // number.setText("0778 5460399");
                // phone.setText("0778 5460399");
                // PerListList.get(0).setContent("Mir");
                // PersonAdapter.notifyDataSetChanged();
                // }
                iamge_goLeft.setEnabled(true);
                iamge_goRight.setEnabled(false);
                iamge_goLeft.setBackgroundResource(R.drawable.settings_go_left11);
                iamge_goRight.setBackgroundResource(R.drawable.settings_go_right22);
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int arg0, int arg1, Intent arg2) {
        // TODO Auto-generated method stub
        super.onActivityResult(arg0, arg1, arg2);
        switch (arg0) {
            case 0:
                if (arg0 == 0 && arg1 == Activity.RESULT_OK && null != arg2) {
                    Uri selectedImage = arg2.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = SettingsPersonaliseYourSerActivity.this
                            .getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    cursor.close();
                    if (null == picturePath)
                        return;
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(selectedImage, "image/*");// mUri是已经选择的图片Uri
                    intent.putExtra("crop", "true");
                    intent.putExtra("aspectX", 1);// 裁剪框比例
                    intent.putExtra("aspectY", 1);
                    intent.putExtra("outputX", 150);// 输出图片大小
                    intent.putExtra("outputY", 150);
                    intent.putExtra("return-data", true);

                    startActivityForResult(intent, 200);

                }
                break;
            case 2:
                if (null == path)
                    return;
                Intent intent = new Intent("com.android.camera.action.CROP");
                intent.setDataAndType(uri, "image/*");// mUri是已经选择的图片Uri
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 1);// 裁剪框比例
                intent.putExtra("aspectY", 1);
                intent.putExtra("outputX", 150);// 输出图片大小
                intent.putExtra("outputY", 150);
                intent.putExtra("return-data", true);

                startActivityForResult(intent, 200);

                break;
            case 100:
                break;
            case 200:
                if (arg1 == Activity.RESULT_OK && arg2 != null) {
                    // 拿到剪切数据
                    bmap = arg2.getParcelableExtra("data");
                    ByteArrayOutputStream output = new ByteArrayOutputStream();// 初始化一个流对象
                    ((Bitmap) bmap).compress(CompressFormat.PNG, 100, output);// 把bitmap100%高质量压缩
                    // 到 output对象里

                    Intent intent2 = new Intent(
                            SettingsPersonaliseYourSerActivity.this,
                            SettingsPersonaliseYourSerPicActivity.class);
                    intent2.putExtra("bitmap", bmap);
                    startActivityForResult(intent2, 1001);

                    // bmap.recycle();// 自由选择是否进行回收

                    byte[] result = output.toByteArray();// 转换成功了
                    try {
                        output.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // getUploadTokenUrl(result);

                }
                // File file = new File(picturePath);
                // getUploadTokenUrl(file);
                break;
            case ADD_BACKGROUND_CODE:
                if (arg2 != null) {
                    List<PhotoModel> photos = (List<PhotoModel>) arg2.getExtras()
                            .getSerializable("photos");
                    if (photos.size() > 0) {
                        PhotoModel info = photos.get(0);
                        List<String> uriList = new ArrayList<String>(1);
                        uriList.add(info.getOriginalPath());

                        // uploadPicUtil.uploadPicData(uriList);

                    }
                }
                break;
            case 1001:
                if (arg1 == 1004) {
                    bmap = BitmapUtil.toRoundBitmap(bmap);
                    PreferenceUtils.setBitmap(getBaseContext(),
                            "image" + UserInfo.getUserMobile(), bmap);
                    image1.setImageBitmap(bmap);
                    Intent intent2 = new Intent("com.vodafone.set_pic_sucess");
                    intent2.putExtra("bitmap", bmap);
                    sendBroadcast(intent2);
                    showPopuwindow(R.string.settings_save_picture_success);
                }
                break;
            case REQUEST_CODE_SETTING:
                Toast.makeText(this, "用户从设置回来了", Toast.LENGTH_LONG).show();
                if (AndPermission.hasPermission(this, Manifest.permission.CAMERA) &&
                        AndPermission.hasPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        ) {
                    // 有权限，直接do anything.
                    new SelectPicDialog2(SettingsPersonaliseYourSerActivity.this,
                            mOperationListener).show();
                } else {
                    // 申请多个权限。
                    AndPermission.with(this)
                            .requestCode(REQUEST_CODE_PERMISSION_OTHER)
                            .permission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA

                            )
                            // rationale作用是：用户拒绝一次权限，再次申请时先征求用户同意，再打开授权对话框，避免用户勾选不再提示。
                            .rationale((requestCode, rationale) ->
                                    // 这里的对话框可以自定义，只要调用rationale.resume()就可以继续申请。
                                    AndPermission.rationaleDialog(SettingsPersonaliseYourSerActivity.this, rationale).show()
                            )
                            .send();
                }
                break;
        }
    }

    private void showPopuwindow(int resId) {
        // 获取屏幕宽度
        DisplayMetrics metrics = new DisplayMetrics();
        SettingsPersonaliseYourSerActivity.this.getWindowManager()
                .getDefaultDisplay().getMetrics(metrics);
        screenW = metrics.widthPixels;
        View convView = LayoutInflater.from(
                SettingsPersonaliseYourSerActivity.this).inflate(
                R.layout.settings_popuw, null);
        pw = new PopupWindow(convView, screenW, LayoutParams.WRAP_CONTENT);
        // 设置pw中的控件可点击
        pw.setFocusable(true);
        // 调用展示方法，设置展示位置
        /*
         * 在展示pw的同时，让窗口的其余部分显示半透明的颜色
		 */
        WindowManager.LayoutParams params = SettingsPersonaliseYourSerActivity.this
                .getWindow().getAttributes();
        params.alpha = 0.6f;
        SettingsPersonaliseYourSerActivity.this.getWindow().addFlags(
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);// 此行代码主要是解决在华为手机上半透明效果无效的bug
        SettingsPersonaliseYourSerActivity.this.getWindow().setAttributes(
                params);

        // 设置pw可以在点击外部区域时关闭显示
        pw.setBackgroundDrawable(new BitmapDrawable());
        pw.setOutsideTouchable(true);
        pw.setTouchable(true);

        // 设置pw弹出和隐藏时的动画效果
        /*
         * 注意：此处的动画效果是通过style样式指定的
		 */
        pw.setAnimationStyle(R.style.pw_anim_style);

        // 监控pw何时被关闭，并且，在pw被关闭的时候，将窗口的背景色调节回来
        pw.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                // TODO Auto-generated method stub
                // 将窗口颜色调回完全透明
                WindowManager.LayoutParams params = SettingsPersonaliseYourSerActivity.this
                        .getWindow().getAttributes();
                params.alpha = 1;
                SettingsPersonaliseYourSerActivity.this.getWindow()
                        .setAttributes(params);
            }
        });

        // 设置pw中button的点击事件
        TextView photo = (TextView) convView
                .findViewById(R.id.setting_set_sucess);
        photo.setText(getString(resId));
        // 展示对话框，并设置展示位置
        pw.showAtLocation(image1, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,
                0, 0);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save away the original text, so we still have it if the activity
        // needs to be killed while paused.
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("path", path);
        savedInstanceState.putParcelable("uri", uri);
    }

    OperationListener mOperationListener = new OperationListener() {
        @Override
        public void operationPhoto(int witch) {
            // TODO Auto-generated method stub
            Intent intent = null;
            switch (witch) {
                case 1:
                    Intent intent1 = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent1, 0);
                    break;
                case 2:
                    String haveSD = Environment.getExternalStorageState();
                    if (!haveSD.equals(Environment.MEDIA_MOUNTED)) {
                        Toast.makeText(SettingsPersonaliseYourSerActivity.this,
                                "存储卡不可用", Toast.LENGTH_LONG).show();
                        return;
                    }
                    File dir = new File(Environment.getExternalStorageDirectory()
                            + "/" + "vodafone");
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");// 获取当前时间，进一步转化为字符串
                    Date date = new Date();
                    String str = format.format(date);
                    path = Environment.getExternalStorageDirectory() + "/"
                            + "vodafone" + "/" + str + "photo.jpg";
                    intent = new Intent(
                            android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    File imgFile = new File(dir, str + "photo.jpg");
                    uri = Uri.fromFile(imgFile);
                    intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    startActivityForResult(intent, 2);
                    break;
                default:
            }
        }
    };

    class MyTextChangeWatcher implements TextWatcher {

        @Override
        public void afterTextChanged(Editable s) {
            handler.sendEmptyMessage(1);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

        }

    }

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            int number = 16 - edit_name.getText().toString().length();
            if (number == 0) {
                text_name.setText("");
            } else {
                text_name.setText(String.valueOf(number));
            }

        }

        ;
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // 只需要调用这一句，其它的交给AndPermission吧，最后一个参数是PermissionListener。
        AndPermission.onRequestPermissionsResult(requestCode, permissions, grantResults, listener);
    }

    private PermissionListener listener = new PermissionListener() {
        @Override
        public void onSucceed(int requestCode, List<String> grantedPermissions) {
            // 权限申请成功回调。
            if (requestCode == REQUEST_CODE_PERMISSION_OTHER) {
                // TODO 相应代码。
                Toast.makeText(SettingsPersonaliseYourSerActivity.this, R.string.photo_post_success, Toast.LENGTH_SHORT).show();
                new SelectPicDialog2(SettingsPersonaliseYourSerActivity.this,
                        mOperationListener).show();
            } else if (requestCode == 101) {
                // TODO 相应代码。
            }
        }

        @Override
        public void onFailed(int requestCode, List<String> deniedPermissions) {
            // 权限申请失败回调。
            Toast.makeText(SettingsPersonaliseYourSerActivity.this, R.string.photo_post_failed, Toast.LENGTH_SHORT).show();
            // 用户否勾选了不再提示并且拒绝了权限，那么提示用户到设置中授权。
            if (AndPermission.hasAlwaysDeniedPermission(SettingsPersonaliseYourSerActivity.this, deniedPermissions)) {
                // 第一种：用默认的提示语。
                AndPermission.defaultSettingDialog(SettingsPersonaliseYourSerActivity.this, REQUEST_CODE_SETTING).show();

//				 第二种：用自定义的提示语。
//                AndPermission.defaultSettingDialog(SettingsPersonaliseYourSerActivity.this, REQUEST_CODE_SETTING)
//                        .setTitle("权限申请失败")
//                        .setMessage("我们需要的一些权限被您拒绝或者系统发生错误申请失败，请您到设置页面手动授权，否则功能无法正常使用！")
//                        .setPositiveButton("好，去设置")
//                        .show();

                // 第三种：自定义dialog样式。
                // SettingService settingService =
                //    AndPermission.defineSettingDialog(this, REQUEST_CODE_SETTING);
                // 你的dialog点击了确定调用：
                // settingService.execute();
                // 你的dialog点击了取消调用：
                // settingService.cancel();
            }
        }
    };


}
