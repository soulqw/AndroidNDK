package com.qw.androidndksample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        test1(1);
        Log.d("qw",javaToNativeString(18,"qinwei"));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();


    /**
     * test1 java to  native
     *
     * @param a
     */
    public native void test1(
            int a);

    /**
     * test2 for java to native string
     * @param a
     * @param b
     * @return
     */
    public native String javaToNativeString(int a,String b);

}
