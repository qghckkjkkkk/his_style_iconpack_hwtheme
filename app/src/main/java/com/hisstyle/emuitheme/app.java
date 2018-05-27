package com.hisstyle.emuitheme;
import android.app.Application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
public final class app
        extends Application
{
    public static app self;
    byte[] b;

    @Override
    final public void onCreate(){
        super.onCreate();
        self = this;
        {
            InputStream inputStream = null;
            try {
                inputStream = getAssets().open("ta.hwt");
            } catch ( final IOException e ) {
            }
            try {
                b = new byte[inputStream.available()];
                inputStream.read(b);
            } catch ( final IOException ignored ) {
            } finally {
                try {
                    inputStream.close();
                } catch ( final Exception ignored ) {
                }
            }
        }
    }

    final public void r(){
        File file = new File("mnt/sdcard", "HWThemes");
        file.mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(file, "TA.hwt"), false);
            fileOutputStream.write(b);
        } catch ( final Exception ignored ) {
        } finally {
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch ( final Exception ignored ) {
            }
        }
    }
}