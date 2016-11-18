package widget.ui.cbsa.scrollbar.demo;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {
    private static final int MAX_Y_OVERSCROLL_DISTANCE = 200;
    private int mMaxYOverscrollDistance;

    public CustomScrollView(Context context) {
        super(context);
        inits(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inits(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inits(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inits(context);
    }

    private void inits(Context context) {
        initBounceListView(context);
    }

    private void initBounceListView(Context context) {
        //get the density of the screen and do some maths with it on the max overscroll distance
        //variable so that you get similar behaviors no matter what the screen size

        final DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        final float density = metrics.density;

        mMaxYOverscrollDistance = (int) (density * MAX_Y_OVERSCROLL_DISTANCE);

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Log.i("vtt", "onScrollChanged");
        Log.i("vtt", "- current vertical:" + t);
        Log.i("vtt", "- current horizontal:" + l);

        Log.i("vtt", "- getMaxScrollAmount:" + getMaxScrollAmount());
        Log.i("vtt", "- getHeight:" + getChildAt(0).getHeight());
        Log.i("vtt", "- computeVerticalScrollRange:" + computeVerticalScrollRange());
        Log.i("vtt", "- getHeight:" + getChildAt(0).getHeight());


    }

    @Override
    public boolean fullScroll(int direction) {
        return super.fullScroll(direction);
    }

    //
//    @Override
//    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
//        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxYOverscrollDistance, isTouchEvent);
//    }

}
