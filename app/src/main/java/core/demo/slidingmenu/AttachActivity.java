package core.demo.slidingmenu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * @author DrkCore
 * @since 2017-08-07
 */
public class AttachActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);

        SlidingMenu slidingMenu = new SlidingMenu(this);
        slidingMenu.setRelativeMode(SlidingMenu.RIGHT);
        slidingMenu.setRelativeShadow();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindWidthRes(R.dimen.menu_width);
        slidingMenu.setFadeEnabled(false);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT, true);
        slidingMenu.setMenu(R.layout.menu);
    }

}
