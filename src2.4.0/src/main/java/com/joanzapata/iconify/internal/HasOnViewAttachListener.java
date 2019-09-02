package com.joanzapata.iconify.internal;

import android.support.v4.view.ViewCompat;
import android.widget.TextView;

public interface HasOnViewAttachListener {

    public static class HasOnViewAttachListenerDelegate {
        private OnViewAttachListener listener;
        private final TextView view;

        public HasOnViewAttachListenerDelegate(TextView textView) {
            this.view = textView;
        }

        public void onAttachedToWindow() {
            if (this.listener != null) {
                this.listener.onAttach();
            }
        }

        public void onDetachedFromWindow() {
            if (this.listener != null) {
                this.listener.onDetach();
            }
        }

        public void setOnViewAttachListener(OnViewAttachListener onViewAttachListener) {
            if (this.listener != null) {
                this.listener.onDetach();
            }
            this.listener = onViewAttachListener;
            if (ViewCompat.isAttachedToWindow(this.view) && onViewAttachListener != null) {
                onViewAttachListener.onAttach();
            }
        }
    }

    public interface OnViewAttachListener {
        void onAttach();

        void onDetach();
    }

    void setOnViewAttachListener(OnViewAttachListener onViewAttachListener);
}
