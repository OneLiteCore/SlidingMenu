package core.demo.slidingmenu;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author DrkCore
 * @since 2017-08-07
 */
public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            win.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            win.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        setContentView(R.layout.activity_layout);
//
//        SlidingMenu slidingMenu = new SlidingMenu(this);
//        slidingMenu.setMode(SlidingMenu.RIGHT);
//        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        slidingMenu.setBehindWidth(360);
//        slidingMenu.setFadeEnabled(false);
//        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
//        slidingMenu.setMenu(R.layout.menu);
    }

}
