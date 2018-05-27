# 包名不混合大小写
-dontusemixedcaseclassnames
# 不忽略非公共的库类
-dontskipnonpubliclibraryclasses
# 输出混淆日志
#-verbose
# 不进行优化
#-dontoptimize
# 不进行预检验
-dontpreverify
# 不混淆注解（注解不能被混淆）
-keepattributes *Annotation*
# 不混淆指定类
-keep public class de.robv.android.xposed.** {*;}
-keep public class fybug.nulll.Importtypekit.xp.** {*;}
-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
# 不混淆native的方法
-keepclasseswithmembernames class * {
    native <methods>;
}
# 不混淆继承View的所有类的set和get方法
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}
# 不混淆继承Activity的所有类的中的参数类型为View的方法
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}
# 不混淆枚举类型的values和valueOf方法
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
# 不混淆继承Parcelable的所有类的CREATOR
-keepclassmembers class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator CREATOR;
}
# 不混淆R类中所有static字段
-keepclassmembers class **.R$* {
    public static <fields>;
}
# 忽略兼容库的所有警告
-dontwarn android.support.**
# 不混淆指定的类及其类成员
-keep class android.support.annotation.Keep
# 不混淆使用注解的类及其类成员
-keep @android.support.annotation.Keep class * {*;}
# 不混淆所有类及其类成员中的使用注解的方法
-keepclasseswithmembers class * {
    @android.support.annotation.Keep <methods>;
}
# 不混淆所有类及其类成员中的使用注解的字段
-keepclasseswithmembers class * {
    @android.support.annotation.Keep <fields>;
}
# 不混淆所有类及其类成员中的使用注解的初始化方法
-keepclasseswithmembers class * {
   @android.support.annotation.Keep <init>(...);
}