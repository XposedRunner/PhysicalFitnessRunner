package com.baidu.mapapi.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class z extends AnimatorListenerAdapter {
    final /* synthetic */ View a;
    final /* synthetic */ WearMapView b;

    z(WearMapView wearMapView, View view) {
        this.b = wearMapView;
        this.a = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.a.setVisibility(4);
        super.onAnimationEnd(animator);
    }
}
