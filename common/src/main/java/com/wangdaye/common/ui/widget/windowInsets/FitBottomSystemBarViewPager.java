package com.wangdaye.common.ui.widget.windowInsets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class FitBottomSystemBarViewPager extends ViewPager {

    private float insetsBottom = 0;

    public FitBottomSystemBarViewPager(@NonNull Context context) {
        super(context);
    }

    public FitBottomSystemBarViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean fitSystemWindows(Rect insets) {
        insetsBottom = insets.bottom;
        if (isInLayout()) {
            for (int i = 0; i < getChildCount(); i ++) {
                getChildAt(i).setPadding(0, 0, 0, (int) insetsBottom);
            }
        }
        return false;
    }

    public float getInsetsBottom() {
        return insetsBottom;
    }
}
