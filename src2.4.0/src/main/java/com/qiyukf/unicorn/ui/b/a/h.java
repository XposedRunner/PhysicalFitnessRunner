package com.qiyukf.unicorn.ui.b.a;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.f.a.a.a.f;
import com.qiyukf.unicorn.ui.activity.UrlImagePreviewActivity;
import com.qiyukf.unicorn.widget.FileNameTextView;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class h extends e implements OnDismissListener, OnClickListener {
    private static String a;
    private TextView b;
    private View c;
    private Dialog d;
    private View e;
    private View f;
    private Button g;
    private f h;
    private List<com.qiyukf.unicorn.f.a.a.a.f.a> i;
    private final List<c> j = new ArrayList();

    private abstract class c {
        private TextView a = ((TextView) this.b.findViewById(R.id.ysf_message_form_item_label));
        protected View b;
        protected com.qiyukf.unicorn.f.a.a.a.f.a c;
        private View e = this.b.findViewById(R.id.ysf_message_form_item_required);
        private View f = this.b.findViewById(R.id.ysf_message_form_item_error);

        public c(ViewGroup viewGroup) {
            this.b = LayoutInflater.from(viewGroup.getContext()).inflate(a(), viewGroup, false);
        }

        public abstract int a();

        /* Access modifiers changed, original: protected */
        public void a(com.qiyukf.unicorn.f.a.a.a.f.a aVar) {
            this.c = aVar;
            this.a.setText(aVar.c());
            this.e.setVisibility(aVar.d() ? 0 : 8);
        }

        public final View b() {
            return this.b;
        }
    }

    private class a extends c implements OnClickListener {
        private Button e = ((Button) this.b.findViewById(R.id.ysf_message_form_item_image_select));
        private View f = this.b.findViewById(R.id.ysf_message_form_item_image_layout);
        private FileNameTextView g = ((FileNameTextView) this.b.findViewById(R.id.ysf_message_form_item_image_name));
        private TextView h = ((TextView) this.b.findViewById(R.id.ysf_message_form_item_image_size));
        private View i = this.b.findViewById(R.id.ysf_message_form_item_image_delete);
        private String j;
        private boolean k;
        private com.qiyukf.nim.uikit.session.helper.d.a l = new com.qiyukf.nim.uikit.session.helper.d.a() {
            public final void sendImage(File file, String str, boolean z) {
                a aVar = a.this;
                StringBuilder stringBuilder = new StringBuilder("file://");
                stringBuilder.append(file.getPath());
                aVar.j = stringBuilder.toString();
                a.this.k = true;
                a.a(a.this);
                FileAttachment fileAttachment = new FileAttachment();
                fileAttachment.setPath(file.getPath());
                fileAttachment.setSize(file.length());
                fileAttachment.setDisplayName(str);
                ((MsgService) NIMClient.getService(MsgService.class)).sendFile(fileAttachment).setCallback(new RequestCallbackWrapper<FileAttachment>() {
                    public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                        FileAttachment fileAttachment = (FileAttachment) obj;
                        if (a.this.b.getTag() == h.this.d) {
                            a.this.k = false;
                            a.a(a.this);
                            if (i == 200) {
                                JSONObject jSONObject = new JSONObject();
                                com.qiyukf.basesdk.c.b.a(jSONObject, "name", fileAttachment.getDisplayName());
                                com.qiyukf.basesdk.c.b.a(jSONObject, "size", fileAttachment.getSize());
                                com.qiyukf.basesdk.c.b.a(jSONObject, SocialConstants.PARAM_URL, fileAttachment.getUrl());
                                a.this.c.a(jSONObject);
                                a.this.c();
                                return;
                            }
                            g.a(R.string.ysf_bot_form_upload_image_failed);
                        }
                    }
                });
            }
        };

        public a(ViewGroup viewGroup) {
            super(viewGroup);
        }

        private void c() {
            JSONObject h = this.c.h();
            if (h == null) {
                this.e.setVisibility(0);
                this.f.setVisibility(8);
                return;
            }
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            String e = com.qiyukf.basesdk.c.b.e(h, "name");
            String a = com.qiyukf.basesdk.c.a.b.a(com.qiyukf.basesdk.c.b.c(h, "size"));
            this.g.a(e);
            this.h.setText(a);
        }

        /* Access modifiers changed, original: protected|final */
        public final int a() {
            return R.layout.ysf_message_item_form_notify_item_image;
        }

        /* Access modifiers changed, original: protected|final */
        public final void a(com.qiyukf.unicorn.f.a.a.a.f.a aVar) {
            super.a(aVar);
            this.e.setOnClickListener(this);
            this.f.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.b.setTag(h.this.d);
            c();
        }

        public final void onClick(View view) {
            if (view == this.e) {
                h.this.getAdapter().d().a(this.l);
                return;
            }
            if (view == this.f) {
                if (!TextUtils.isEmpty(this.j)) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(this.j);
                    UrlImagePreviewActivity.start(h.this.context, arrayList, 0);
                }
            } else if (view == this.i) {
                this.j = null;
                this.c.a(null);
                c();
            }
        }
    }

    private class b extends c implements TextWatcher {
        private EditText e = ((EditText) this.b.findViewById(R.id.ysf_message_form_item_input_edit));

        public b(ViewGroup viewGroup) {
            super(viewGroup);
        }

        /* Access modifiers changed, original: protected|final */
        public final int a() {
            return R.layout.ysf_message_item_form_notify_item_input;
        }

        /* Access modifiers changed, original: protected|final */
        public final void a(com.qiyukf.unicorn.f.a.a.a.f.a aVar) {
            super.a(aVar);
            this.e.addTextChangedListener(this);
            if (!TextUtils.isEmpty(aVar.g())) {
                this.e.setText(aVar.g());
                this.e.setSelection(this.e.length());
            }
        }

        public final void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            String trim = obj.replace(HttpUtils.PARAMETERS_SEPARATOR, "").trim();
            if (!TextUtils.equals(obj, trim)) {
                this.e.setText(trim);
                this.e.setSelection(trim.length());
            }
            this.c.a(trim);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    private void a(Dialog dialog) {
        TextView textView = (TextView) dialog.findViewById(R.id.ysf_message_form_window_title);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.ysf_message_form_window_item_container);
        this.e = dialog.findViewById(R.id.ysf_message_form_window_placeholder);
        this.f = dialog.findViewById(R.id.ysf_message_form_window_close);
        this.g = (Button) dialog.findViewById(R.id.ysf_message_form_window_submit);
        textView.setText(this.h.c());
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.j.clear();
        for (com.qiyukf.unicorn.f.a.a.a.f.a aVar : this.i) {
            c aVar2 = aVar.e() ? new a(linearLayout) : new b(linearLayout);
            aVar2.a(aVar);
            linearLayout.addView(aVar2.b());
            this.j.add(aVar2);
        }
    }

    public static void b(String str) {
        if (a == null) {
            a = str;
        }
    }

    private long d() {
        try {
            return Long.valueOf(this.message.getUuid().substring(0, this.message.getUuid().indexOf(35))).longValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private void e() {
        if (TextUtils.equals(a, this.message.getUuid()) && this.d == null) {
            getAdapter().d().b();
            this.d = new Dialog(this.context, R.style.ysf_form_dialog_style);
            this.d.setContentView(R.layout.ysf_popup_window_form);
            this.d.setOnDismissListener(this);
            LayoutParams attributes = this.d.getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            a(this.d);
            this.d.show();
        }
    }

    private void f() {
        if (this.d != null) {
            com.qiyukf.basesdk.c.d.b.b(this.d.getWindow().getDecorView());
            this.d.dismiss();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        this.h = (f) this.message.getAttachment();
        this.i = this.h.e();
        this.b.setText(this.h.c());
        this.c.setVisibility(this.h.f() ? 8 : 0);
        this.c.setOnClickListener(this);
        if (!this.h.f()) {
            e();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean b() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_form_notify;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.b = (TextView) findViewById(R.id.ysf_message_form_title);
        this.c = findViewById(R.id.ysf_message_form_expand);
    }

    public void onClick(View view) {
        long d;
        if (view == this.c) {
            d = d();
            if (d <= 0 || d != d.g().c(this.message.getSessionId())) {
                g.a(R.string.ysf_bot_form_disabled);
                return;
            }
            if (a == null) {
                a = this.message.getUuid();
                e();
            }
        } else if (view == this.e || view == this.f) {
            f();
        } else {
            if (view == this.g) {
                d = d();
                if (d <= 0 || d != d.g().c(this.message.getSessionId())) {
                    g.a(R.string.ysf_bot_form_disabled);
                    f();
                } else {
                    boolean z = true;
                    for (c a : this.j) {
                        if (!c.a(a)) {
                            z = false;
                        }
                    }
                    if (z) {
                        f();
                        String d2 = this.h.d() == null ? "" : this.h.d();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(d2);
                        stringBuilder.append("&msgIdClient=");
                        stringBuilder.append(this.message.getUuid());
                        d2 = stringBuilder.toString();
                        for (com.qiyukf.unicorn.f.a.a.a.f.a aVar : this.i) {
                            String obj = aVar.f() == null ? "" : aVar.f().toString();
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(d2);
                            stringBuilder2.append(HttpUtils.PARAMETERS_SEPARATOR);
                            stringBuilder2.append(aVar.a());
                            stringBuilder2.append(HttpUtils.EQUAL_SIGN);
                            stringBuilder2.append(obj);
                            d2 = stringBuilder2.toString();
                        }
                        com.qiyukf.unicorn.f.a.a.b.a aVar2 = new com.qiyukf.unicorn.f.a.a.b.a();
                        aVar2.a(this.i);
                        com.qiyukf.unicorn.a.a.a.a.b bVar = new com.qiyukf.unicorn.a.a.a.a.b();
                        bVar.b(d2);
                        bVar.a(aVar2.c());
                        aVar2.a(bVar);
                        getAdapter().d().c(MessageBuilder.createCustomMessage(this.message.getSessionId(), SessionTypeEnum.Ysf, aVar2));
                        this.h.g();
                        ((com.qiyukf.unicorn.a.a.a.a.a) this.h.a()).a("hasCommit", Boolean.valueOf(true));
                        ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(this.message, true);
                    }
                }
            }
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        a = null;
        this.d = null;
    }
}
