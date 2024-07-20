## Android Layout

### LinearLayout

元件呈垂直或水平方向排列。

![img.png](img.png)

``` 
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" // 垂直 水平
    android:paddingStart="50dp"
    android:paddingTop="10dp"
    tools:context=".MainActivity">
<!--    &lt;!&ndash;    android:gravity="center"&ndash;&gt;   居中-->

android:paddingStart="50dp"
android:paddingTop="10dp"

上方：top
左方：start (left)
右方：end (right)
下方：bottom
padding 控制


<!--    wrap_content 弹性的更具内容决定大小-->
<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:text="@string/hello_world" />


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    >

    <Button
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:backgroundTint="@color/black"
        android:text="hello world" />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="hello world2" />


</LinearLayout>
```

### RelativeLayout 相对布局

``` 
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <Button
        android:id="@+id/btn1"
        android:layout_width="184dp"
        android:layout_height="73dp"
        android:text="Fuck" />

    <Button
        android:id="@+id/btn2"
        android:layout_width="184dp"
        android:layout_height="173dp"
        android:layout_below="@id/btn1"
        android:text="Fuck2" />
</RelativeLayout>

layout_above 相对于某个元素的上面
layout_below 相对于某个元素的下面
layout_toRightOf 相对于 某个元素的right
layout_toLeftOf
```


### ConstraintLayout
![img_1.png](img_1.png)


### FrameLayout：用於元件有堆疊 (Stack)層次交錯擺放的需求。
![img_2.png](img_2.png)

``` 
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

 <Button
     android:layout_width="300dp"
     android:layout_height="300dp"
     android:text="layout_gravity:center"
     android:layout_gravity="center"/>

    <Button
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:backgroundTint="@color/black"
        android:text="layout_gravity:center"
        android:layout_gravity="center"/>

    <Button
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:text="layout_gravity:center"
        android:layout_gravity="center"/>
</FrameLayout>
```

### TableLayout：將元件放在表格中，表格可以有多行多列方式呈現。
![img_3.png](img_3.png)

### GridLayout：將元件放在網格中，網格有可以有多行多列方式呈現。如：Instagram、小紅書首頁顯示貼文方式。
![img_4.png](img_4.png)


### material ui  新版本默认
``` 
    <com.google.android.material.button.MaterialButton
        android:layout_width="150dp"
        android:layout_height="60dp"
        app:cornerRadius="10dp"
        app:strokeColor="#ff0000"
        app:strokeWidth="3dp"
        android:text="this is button"
        android:textColor="#ff0000"
        android:textSize="18dp"
        />
```