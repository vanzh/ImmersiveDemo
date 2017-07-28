参考：http://blog.csdn.net/ys408973279/article/details/49994407
-  此方法在4.4以后都适用


思路:要设置成沉浸式，需要设置以下内容：
## 1、theme设置Theme.AppCompat.Light.NoActionBar
布局内容将从屏幕顶点开始；
## 2、将Activity的window设置状态栏透明
将状态栏那部分高度设置成透明
```
getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
```
## 3、将标题View设置paddingTop，其paddingTop值相等于状态栏高度；
可通过以下方法设置
```
android:clipToPadding="true"
android:fitsSystemWindows="true"
```
在Java中设置，找到标题View,
```
tvTitle.setPadding(0, tvTitle.getPaddingTop() + statusHeight, 0, 0);
```