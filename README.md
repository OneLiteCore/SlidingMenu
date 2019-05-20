# SlidingMenu

If you come here taking a look then you must have known the [SlidingMenu](https://github.com/jfeinstein10/SlidingMenu) widget. Maybe it is just too stable so that has't been updated for years, as a result someting in it had been out of time. So I forked it.

What is different between the original is here:

__1.__ Delete `com.jeremyfeinstein.slidingmenu.lib.app` package.  
__2.__ Add `actionbarOverlayEnable` attr to let you control it in xml.  
__3.__ Add `shadow` and `shadowright` drawable.  
__4.__ Fix `KeyEventCompat` issue.

# Setup

Add dependency in you module build.gradle:

```gradle
implementation 'core.mate:slidingmenu:1.0.1'
```

# How to Integrate this Library into Your Projects

In order to integrate SlidingMenu into your own projects you can do one of two things.

__1.__ You can wrap your Activities in a SlidingMenu by constructing it programmatically (`new SlidingMenu(Context context)`)
and then calling `SlidingMenu.attachToActivity(Activity activity, SlidingMenu.SLIDING_WINDOW | SlidingMenu.SLIDING_CONTENT)`.
`SLIDING_WINDOW` will include the Title/ActionBar in the content section of the SlidingMenu, while `SLIDING_CONTENT`
does not. You can check it out in the example app AttachExample Activity.

__2.__      You can use the SlidingMenu view directly in your xml layouts or programmatically in your Java code.
* This way, you can treat SlidingMenu as you would any other view type and put it in crazy awesome places like in the
rows of a ListView.
* So. Many. Possibilities.

Simple Example
-----
```java
public class SlidingExample extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(R.string.attach);
		// set the content view
		setContentView(R.layout.content);
		// configure the SlidingMenu
		SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setShadowDrawable(R.drawable.shadow);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		menu.setMenu(R.layout.menu);
	}

}
```

XML Usage
-----
If you decide to use SlidingMenu as a view, you can define it in your xml layouts like this:
```xml
<com.jeremyfeinstein.slidingmenu.lib.SlidingMenu
    xmlns:sliding="http://schemas.android.com/apk/res-auto"
    android:id="@+id/slidingmenulayout"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    sliding:viewAbove="@layout/YOUR_ABOVE_VIEW"
    sliding:viewBehind="@layout/YOUR_BEHIND_BEHIND"
    sliding:touchModeAbove="margin|fullscreen"
    sliding:behindOffset="@dimen/YOUR_OFFSET"
    sliding:behindWidth="@dimen/YOUR_WIDTH"
    sliding:behindScrollScale="@dimen/YOUR_SCALE"
    sliding:shadowDrawable="@drawable/YOUR_SHADOW"
    sliding:shadowWidth="@dimen/YOUR_SHADOW_WIDTH"
    sliding:fadeEnabled="true|false"
    sliding:fadeDegree="float"
    sliding:selectorEnabled="true|false"
    sliding:selectorDrawable="@drawable/YOUR_SELECTOR"
    sliding:actionbarOverlayEnable="true|false"/>
```

NOTE : you cannot use both behindOffset and behindWidth. You will get an exception if you try.
* `viewAbove` - a reference to the layout that you want to use as the above view of the SlidingMenu
* `viewBehind` - a reference to the layout that you want to use as the behind view of the SlidingMenu
* `touchModeAbove` - an enum that designates what part of the screen is touchable when the above view is
showing. Margin means only the left margin. Fullscreen means the entire screen. Default is margin.
* `behindOffset` - a dimension representing the number of pixels that you want the above view to show when the
behind view is showing. Default is 0.
* `behindWidth` - a dimension representing the width of the behind view. Default is the width of the screen
(equivalent to behindOffset = 0).
* `behindScrollScale` - a float representing the relationship between the above view scrolling and the behind
behind view scrolling. If set to 0.5f, the behind view will scroll 1px for every 2px that the above view scrolls.
If set to 1.0f, the behind view will scroll 1px for every 1px that the above view scrolls. And if set to 0.0f, the
behind view will never scroll; it will be static. This one is fun to play around with. Default is 0.25f.
* `shadowDrawable` - a reference to a drawable to be used as a drop shadow from the above view onto the below view.
Default is no shadow for now.
* `shadowWidth` - a dimension representing the width of the shadow drawable. Default is 0.
* `fadeEnabled` - a boolean representing whether or not the behind view should fade when the SlidingMenu is closing
and "un-fade" when opening
* `fadeDegree` - a float representing the "amount" of fade. `1.0f` would mean fade all the way to black when the
SlidingMenu is closed. `0.0f` would mean do not fade at all.
* `selectorEnabled` - a boolean representing whether or not a selector should be drawn on the left side of the above
view showing a selected view on the behind view.
* `selectorDrawable` - a reference to a drawable to be used as the selector
NOTE : in order to have the selector drawn, you must call SlidingMenu.setSelectedView(View v) with the selected view.
Note that this will most likely not work with items in a ListView because of the way that Android recycles item views.

# Caveats

* Your layouts have to be based on a viewgroup, unfortunatly this negates the `<merge>` optimisations.

# Developed By

* Jeremy Feinstein

# Modified By

- DrkCore

# License

    Copyright 2017 DrkCore

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
