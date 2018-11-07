package com.example.diego.desafioandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;

import java.lang.reflect.Field;

class CustomScrollView extends ScrollView {

    private OverScroller scroller;
    private boolean scrollable = true;
    private ImageBox fakeBox;

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public CustomScrollView(Context context){
        super(context);

        init(context);
    }

    public void setScrollingEnabled(boolean scrollable) {
        this.scrollable = scrollable;
    }

    public boolean isScrollable() { return scrollable; }

    private void init(Context context)
    {
        fakeBox = new ImageBox(context, this);
        fakeBox.getContainer().setAlpha(0);

        try
        {
            Class parent = this.getClass();
            do
            {
                parent = parent.getSuperclass();
            } while (!parent.getName().equals("android.widget.ScrollView"));

            Log.i("Scroller", "class: " + parent.getName());
            Field field = parent.getDeclaredField("mScroller");
            field.setAccessible(true);
            scroller = (OverScroller) field.get(this);

        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // if we can scroll pass the event to the superclass
                if (scrollable) return super.onTouchEvent(ev);
                // only continue to handle the touch event if scrolling enabled
                return scrollable; // scrollable is always false at this point
            default:
                return super.onTouchEvent(ev);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        // Don't do anything with intercepted touch events if
        // we are not scrollable
        if (!scrollable) return false;
        else return super.onInterceptTouchEvent(ev);
    }

    public void customSmoothScrollBy(int dx, int dy)
    {
        if (scroller == null)
        {
            smoothScrollBy(dx, dy);
            return;
        }

        if (getChildCount() == 0)
            return;

        final int width = getWidth() - getPaddingRight() - getPaddingLeft();
        final int right = getChildAt(0).getWidth();
        final int maxX = Math.max(0, right - width);
        final int scrollX = getScrollX();

        final int height = getHeight() - getPaddingTop() - getPaddingBottom();
        final int bottom = getChildAt(0).getHeight();
        final int maxY = Math.max(0, bottom - height);
        final int scrollY = getScrollY();

        dx = Math.max(0, Math.min(scrollX + dx, maxX)) - scrollX;
        dy = Math.max(0, Math.min(scrollY + dy, maxY)) - scrollY;

        scroller.startScroll(scrollX, scrollY, dx, dy, 500);
        invalidate();
    }

    public void customSmoothScrollTo(int x, int y)
    {
        customSmoothScrollBy(x - getScrollX(), y - getScrollY());
    }
}
