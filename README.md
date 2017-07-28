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
两种设置paddingTop的方法
- 布局文件中，在标题栏添加
```
android:clipToPadding="true"
android:fitsSystemWindows="true"
```
- Java代码中，找到标题View,设置paddingTop
```
tvTitle.setPadding(0, tvTitle.getPaddingTop() + statusHeight, 0, 0);
```

ps:再提供一种方法，同样的思路还可以布局文件中标题栏前添加一个0.1dp高的View,然后动态设置View为状态栏高度，再设置此View的背景色达到与标题栏一致的颜色；