package core.demo.slidingmenu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * @author DrkCore
 * @since 2017-08-07
 */
public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        SlidingMenu menu = findViewById(R.id.sliding_menu);
        menu.setRelativeMode(SlidingMenu.RIGHT);
        menu.setRelativeShadow();
    }

}
