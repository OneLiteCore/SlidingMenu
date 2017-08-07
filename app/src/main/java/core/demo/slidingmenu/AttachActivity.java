package core.demo.slidingmenu;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * @author DrkCore
 * @since 2017-08-07
 */
public class AttachActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            win.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            win.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        setContentView(R.layout.content);

        SlidingMenu slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.RIGHT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindWidthRes(R.dimen.menu_width);
        slidingMenu.setFadeEnabled(false);
        slidingMenu.setShadowDrawable(R.drawable.shadowright);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT, true);
        slidingMenu.setMenu(R.layout.menu);
    }

}
