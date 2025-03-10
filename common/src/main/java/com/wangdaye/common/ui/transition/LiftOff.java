package com.wangdaye.common.ui.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;

import com.wangdaye.common.R;

/**
 * Lift off.
 *
 * This transition is used to change elevation of a target view.
 *
 * */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class LiftOff extends Transition {

    private static final String PROPNAME_ELEVATION = "mysplash:liftoff:elevation";

    private static final String[] transitionProperties = {
            PROPNAME_ELEVATION
    };

    private final float initialElevation;
    private final float finalElevation;

    public LiftOff(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LiftOff);
        initialElevation = a.getDimension(R.styleable.LiftOff_initElevation, 0f);
        finalElevation = a.getDimension(R.styleable.LiftOff_finalElevation, 0f);
        a.recycle();
    }

    @Override
    public String[] getTransitionProperties() {
        return transitionProperties;
    }

    @Override
    public void captureStartValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_ELEVATION, initialElevation);
    }

    @Override
    public void captureEndValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_ELEVATION, finalElevation);
    }

    @Override
    public Animator createAnimator(ViewGroup sceneRoot, TransitionValues startValues,
                                   TransitionValues endValues) {
        if (startValues == null || endValues == null) {
            return null;
        }

        return ObjectAnimator.ofFloat(
                endValues.view,
                View.TRANSLATION_Z,
                (Float) startValues.values.get(PROPNAME_ELEVATION),
                (Float) endValues.values.get(PROPNAME_ELEVATION)
        );
    }
}
