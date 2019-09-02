package com.qiyukf.unicorn.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import s.h.e.l.l.C;

public class TranslateFragment extends TFragment {
    private Button a;
    private TextView b;
    private ProgressBar c;
    private AudioAttachment d;
    private AbortableFuture<String> e;
    private RequestCallbackWrapper<String> f = new RequestCallbackWrapper<String>() {
        public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
            String str = (String) obj;
            TranslateFragment.b(TranslateFragment.this);
            if (i == 200) {
                TranslateFragment.this.b.setTextSize(22.0f);
                TranslateFragment.this.b.setText(str);
                return;
            }
            TranslateFragment.d(TranslateFragment.this);
        }
    };

    static {
        C.i(32);
    }

    static /* synthetic */ void b(TranslateFragment translateFragment) {
        translateFragment.c.setVisibility(8);
        translateFragment.a.setVisibility(8);
    }

    static /* synthetic */ void d(TranslateFragment translateFragment) {
        Drawable drawable = ContextCompat.getDrawable(translateFragment.getContext(), R.drawable.ysf_ic_failed);
        int a = d.a(24.0f);
        drawable.setBounds(0, 0, a, a);
        translateFragment.b.setCompoundDrawables(drawable, null, null, null);
        translateFragment.b.setCompoundDrawablePadding(d.a(6.0f));
        translateFragment.b.setText(translateFragment.getString(R.string.ysf_audio_translate_failed));
        translateFragment.b.setTextSize(15.0f);
    }

    public static native TranslateFragment newInstance(IMMessage iMMessage);

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() != null) {
            this.a.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    TranslateFragment.this.getActivity().onBackPressed();
                }
            });
            if (getView() != null) {
                getView().setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (TranslateFragment.this.a.getVisibility() == 8) {
                            TranslateFragment.this.getActivity().onBackPressed();
                        }
                    }
                });
            }
        }
        AudioAttachment audioAttachment = this.d;
        this.e = ((MsgService) NIMClient.getService(MsgService.class)).transVoiceToText(audioAttachment.getUrl(), audioAttachment.getPath(), audioAttachment.getDuration());
        this.e.setCallback(this.f);
    }

    public native void onCreate(Bundle bundle);

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDetach();
}
