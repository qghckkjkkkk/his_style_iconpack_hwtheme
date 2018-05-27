package com.hisstyle.emuitheme;
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;
final public class start
        extends Activity
{
    Handler handler;

    //com.huawei.android.thememanager.HwThemeManagerActivity
    @Override
    final protected void onCreate( final @Nullable Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);
        handler = new Handler();
    }

    @Override
    final protected void onResume(){
        super.onResume();
        if ( Build.VERSION.SDK_INT >= 23 ){
            final int i = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if ( i != PackageManager.PERMISSION_GRANTED ){
                if ( !ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ){
                    ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE }, 1);
                    new Thread(()->{
                        while( ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED )
                            ;
                        handler.post(()->{
                            Toast.makeText(this, "已授权成攻，请再次应用图标包", Toast.LENGTH_SHORT)
                                 .show();
                            finish();
                        });
                    }).start();
                }
            } else {
                app.self.r();
                s();
            }
        } else {
            app.self.r();
            s();
        }
    }

    private void s(){
        Intent intent = new Intent();
        intent.setClassName("com.huawei.android.thememanager", "com.huawei.android.thememanager.HwThemeManagerActivity");
        try {
            startActivity(intent);
        } catch ( Exception e ) {
            Toast.makeText(this, "找不到华为主题", Toast.LENGTH_SHORT)
                 .show();
        }
        finish();
    }
}