package com.qiyukf.nim.uikit.session.module.a;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.c.c.d;
import com.qiyukf.nim.uikit.common.a.e;
import com.qiyukf.nim.uikit.common.a.f;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.nim.uikit.common.ui.listview.MessageListView;
import com.qiyukf.nim.uikit.session.helper.c;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.AttachmentProgress;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.nimlib.sdk.msg.model.QueryDirectionEnum;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.ImageLoaderListener;
import com.qiyukf.unicorn.api.RequestCallback;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.f.a.e.o;
import com.qiyukf.unicorn.ui.b.a.h;
import com.qiyukf.unicorn.ui.fragment.TranslateFragment;
import com.qiyukf.unicorn.widget.a.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b implements e {
    private com.qiyukf.nim.uikit.session.module.a a;
    private View b;
    private MessageListView c;
    private List<IMMessage> d;
    private c e;
    private ImageView f;
    private a g;
    private Handler h;
    private View i;
    private TextView j;
    private ImageView k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private int p;
    private com.qiyukf.nim.uikit.session.helper.d.a q;
    private com.qiyukf.nim.uikit.session.helper.c.a r;
    private Observer<IMMessage> s;
    private Observer<AttachmentProgress> t;
    private com.qiyukf.nim.uikit.a.b.a u;
    private Runnable v;

    private class a implements com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.b {
        private QueryDirectionEnum b = null;
        private IMMessage c = null;
        private boolean d;
        private boolean e = true;
        private RequestCallback<List<IMMessage>> f = new RequestCallbackWrapper<List<IMMessage>>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                List list = (List) obj;
                if (list != null) {
                    a.a(a.this, list);
                }
            }
        };

        public a(boolean z) {
            this.d = z;
            if (z) {
                c();
            } else {
                a(QueryDirectionEnum.QUERY_OLD);
            }
        }

        static /* synthetic */ void a(a aVar, List list) {
            int size = list.size();
            if (aVar.d) {
                Collections.reverse(list);
            }
            if (aVar.e && b.this.d.size() > 0) {
                for (IMMessage iMMessage : list) {
                    for (IMMessage iMMessage2 : b.this.d) {
                        if (iMMessage2.isTheSame(iMMessage)) {
                            b.this.d.remove(iMMessage2);
                            break;
                        }
                    }
                }
            }
            if (aVar.e && aVar.c != null) {
                b.this.d.add(aVar.c);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            if (aVar.b == QueryDirectionEnum.QUERY_NEW) {
                b.this.d.addAll(arrayList);
            } else {
                b.this.d.addAll(0, arrayList);
            }
            if (aVar.e) {
                com.qiyukf.nim.uikit.common.ui.listview.a.a(b.this.c);
            }
            b.this.e.a(b.this.d, true, aVar.e);
            b.this.d();
            b.this.c.c(size);
            aVar.e = false;
        }

        private void a(QueryDirectionEnum queryDirectionEnum) {
            this.b = queryDirectionEnum;
            b.this.c.b(queryDirectionEnum == QueryDirectionEnum.QUERY_NEW ? com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.a.b : com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.a.a);
            ((MsgService) NIMClient.getService(MsgService.class)).queryMessageListEx(d(), queryDirectionEnum, 20, true).setCallback(this.f);
        }

        private void c() {
            this.b = QueryDirectionEnum.QUERY_OLD;
            ((MsgService) NIMClient.getService(MsgService.class)).pullMessageHistory(d(), 20, true).setCallback(this.f);
        }

        private IMMessage d() {
            if (b.this.d.size() == 0) {
                return this.c == null ? MessageBuilder.createEmptyMessage(b.this.a.c, b.this.a.d, 0) : this.c;
            } else {
                return (IMMessage) b.this.d.get(this.b == QueryDirectionEnum.QUERY_NEW ? b.this.d.size() - 1 : 0);
            }
        }

        public final void a() {
            if (this.d) {
                c();
            } else {
                a(QueryDirectionEnum.QUERY_OLD);
            }
        }

        public final void b() {
            if (!this.d) {
                a(QueryDirectionEnum.QUERY_NEW);
            }
        }
    }

    private class b implements com.qiyukf.nim.uikit.session.module.a.c.a {

        /* renamed from: com.qiyukf.nim.uikit.session.module.a.b$b$3 */
        class AnonymousClass3 implements com.qiyukf.unicorn.widget.a.g.a {
            final /* synthetic */ IMMessage a;

            AnonymousClass3(IMMessage iMMessage) {
                this.a = iMMessage;
            }

            public final void a(int i) {
                if (i == 0) {
                    b.this.e(this.a);
                }
            }
        }

        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        private void d(final IMMessage iMMessage) {
            g.a(b.this.a.a, b.this.a.a.getString(R.string.ysf_re_download_message), true, new com.qiyukf.unicorn.widget.a.g.a() {
                public final void a(int i) {
                    if (i == 0 && iMMessage.getAttachment() != null && (iMMessage.getAttachment() instanceof FileAttachment)) {
                        ((MsgService) NIMClient.getService(MsgService.class)).downloadAttachment(iMMessage, true);
                    }
                }
            });
        }

        private void e(IMMessage iMMessage) {
            com.qiyukf.nimlib.i.a aVar = (com.qiyukf.nimlib.i.a) iMMessage;
            aVar.setTime(System.currentTimeMillis());
            aVar.b(b.this.a.c);
            aVar.setStatus(MsgStatusEnum.sending);
            aVar.a(b.this.a.d);
            if (aVar.getMsgType() == MsgTypeEnum.audio) {
                AudioAttachment audioAttachment = (AudioAttachment) aVar.getAttachment();
                audioAttachment.setAutoTransform(b.this.n);
                aVar.setAttachment(audioAttachment);
            }
            b.this.e.a(iMMessage);
            b.this.a.e.sendMessage(aVar, true);
            b.this.a(iMMessage);
        }

        public final void a(com.qiyukf.nim.uikit.session.helper.d.a aVar) {
            b.this.q = aVar;
            TFragment tFragment = (TFragment) b.this.a.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d.b());
            stringBuilder.append(".jpg");
            c.a(tFragment, 8, false, com.qiyukf.nimlib.k.c.c.a(stringBuilder.toString(), com.qiyukf.nimlib.k.c.b.TYPE_TEMP), false);
        }

        public final void a(IMMessage iMMessage) {
            if (iMMessage.getDirect() != MsgDirectionEnum.Out) {
                d(iMMessage);
            } else if (iMMessage.getStatus() == MsgStatusEnum.fail) {
                e(iMMessage);
            } else if (iMMessage.getAttachment() instanceof FileAttachment) {
                FileAttachment fileAttachment = (FileAttachment) iMMessage.getAttachment();
                if (TextUtils.isEmpty(fileAttachment.getPath()) && TextUtils.isEmpty(fileAttachment.getThumbPath())) {
                    d(iMMessage);
                }
            } else {
                e(iMMessage);
            }
        }

        public final boolean a() {
            return b.this.a.e.isAllowSendMessage(true);
        }

        public final void b() {
            b.this.a.e.shouldCollapseInputPanel();
        }

        public final boolean b(IMMessage iMMessage) {
            if (b.this.a.e.isLongClickEnabled()) {
                ArrayList arrayList = new ArrayList();
                final String string = b.this.a.a.getString(R.string.ysf_re_send_has_blank);
                if (iMMessage.getStatus() == MsgStatusEnum.fail) {
                    arrayList.add(string);
                }
                final String string2 = b.this.a.a.getString(R.string.ysf_copy_has_blank);
                if (iMMessage.getMsgType() == MsgTypeEnum.text || (iMMessage.getAttachment() instanceof com.qiyukf.unicorn.f.a.c)) {
                    arrayList.add(string2);
                }
                final String string3 = b.this.a.a.getString(com.qiyukf.unicorn.b.b.i() ? R.string.ysf_audio_play_by_speaker : R.string.ysf_audio_play_by_earphone);
                final String string4 = b.this.a.a.getString(R.string.ysf_audio_translate);
                if (iMMessage.getMsgType() == MsgTypeEnum.audio) {
                    arrayList.add(string3);
                    arrayList.add(string4);
                }
                final String string5 = b.this.a.a.getString(R.string.ysf_delete_has_blank);
                CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
                final CharSequence[] charSequenceArr2 = charSequenceArr;
                final IMMessage iMMessage2 = iMMessage;
                g.a(b.this.a.a, null, charSequenceArr, new com.qiyukf.unicorn.widget.a.g.a() {
                    public final void a(int i) {
                        b bVar;
                        IMMessage iMMessage;
                        if (TextUtils.equals(charSequenceArr2[i], string)) {
                            bVar = b.this;
                            iMMessage = iMMessage2;
                            if (b.this.a(iMMessage.getUuid()) >= 0) {
                                g.a(b.this.a.a, b.this.a.a.getString(R.string.ysf_re_send_message), true, new AnonymousClass3(iMMessage));
                            }
                        } else if (TextUtils.equals(charSequenceArr2[i], string2)) {
                            bVar = b.this;
                            iMMessage = iMMessage2;
                            if (iMMessage.getMsgType() == MsgTypeEnum.text) {
                                com.qiyukf.basesdk.c.d.a.a(b.this.a.a, iMMessage.getContent());
                                return;
                            }
                            if (iMMessage.getAttachment() instanceof com.qiyukf.unicorn.f.a.c) {
                                com.qiyukf.basesdk.c.d.a.a(b.this.a.a, ((com.qiyukf.unicorn.f.a.c) iMMessage.getAttachment()).a(b.this.a.a));
                            }
                        } else if (TextUtils.equals(charSequenceArr2[i], string3)) {
                            com.qiyukf.unicorn.b.b.a(com.qiyukf.unicorn.b.b.i() ^ 1);
                            b.this.b(com.qiyukf.unicorn.b.b.i() ? R.string.ysf_audio_current_mode_is_earphone : R.string.ysf_audio_current_mode_is_speaker);
                        } else if (TextUtils.equals(charSequenceArr2[i], string4)) {
                            bVar = b.this;
                            iMMessage = iMMessage2;
                            if (iMMessage.getDirect() != MsgDirectionEnum.In || iMMessage.getAttachStatus() == AttachStatusEnum.transferred) {
                                if (iMMessage.getStatus() != MsgStatusEnum.read && iMMessage.getDirect() == MsgDirectionEnum.In) {
                                    iMMessage.setStatus(MsgStatusEnum.read);
                                    ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage, true);
                                }
                                com.qiyukf.basesdk.c.d.b.a(b.this.a.a);
                                b.this.a.b.getActivity().getSupportFragmentManager().beginTransaction().replace(16908290, TranslateFragment.newInstance(iMMessage)).addToBackStack(null).commitAllowingStateLoss();
                                return;
                            }
                            com.qiyukf.basesdk.c.d.g.a(R.string.ysf_no_permission_audio_error);
                        } else {
                            if (TextUtils.equals(charSequenceArr2[i], string5)) {
                                bVar = b.this;
                                iMMessage = iMMessage2;
                                ((MsgService) NIMClient.getService(MsgService.class)).deleteChattingHistory(iMMessage);
                                b.this.e.a(iMMessage);
                            }
                        }
                    }
                });
            }
            return true;
        }

        public final void c() {
            if (b.this.g()) {
                b.this.h();
            }
        }

        public final void c(IMMessage iMMessage) {
            b.this.a.e.sendMessage(iMMessage, false);
        }
    }

    public b(com.qiyukf.nim.uikit.session.module.a aVar, View view) {
        this(aVar, view, (byte) 0);
    }

    private b(com.qiyukf.nim.uikit.session.module.a aVar, View view, byte b) {
        MessageListView messageListView;
        int i;
        this.n = false;
        this.o = false;
        this.p = 0;
        this.r = new com.qiyukf.nim.uikit.session.helper.c.a() {
            public final void a(File file) {
                MediaPlayer a = b.this.a(file);
                b.this.a.e.sendMessage(MessageBuilder.createVideoMessage(b.this.a.c, SessionTypeEnum.Ysf, file, a == null ? 0 : (long) a.getDuration(), a == null ? 0 : a.getVideoWidth(), a == null ? 0 : a.getVideoHeight(), file.getName()), false);
            }
        };
        this.s = new Observer<IMMessage>() {
            public final /* synthetic */ void onEvent(Object obj) {
                IMMessage iMMessage = (IMMessage) obj;
                if (b.this.b(iMMessage)) {
                    b.b(b.this, iMMessage);
                }
            }
        };
        this.t = new Observer<AttachmentProgress>() {
            public final /* synthetic */ void onEvent(Object obj) {
                b.a(b.this, (AttachmentProgress) obj);
            }
        };
        this.v = new Runnable() {
            public final void run() {
                b.this.i.setVisibility(8);
            }
        };
        this.a = aVar;
        this.b = view;
        this.l = false;
        this.m = false;
        this.d = new ArrayList();
        this.e = new c(this.a.a, this.d, this);
        this.e.a(new b(this, (byte) 0));
        this.f = (ImageView) this.b.findViewById(R.id.message_activity_background);
        this.c = (MessageListView) this.b.findViewById(R.id.messageListView);
        this.c.requestDisallowInterceptTouchEvent(true);
        if (!this.l || this.m) {
            messageListView = this.c;
            i = com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.a.a;
        } else {
            messageListView = this.c;
            i = com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.a.c;
        }
        messageListView.a(i);
        if (VERSION.SDK_INT >= 9) {
            this.c.setOverScrollMode(2);
        }
        this.c.a(this.e);
        this.c.a(new com.qiyukf.nim.uikit.common.ui.listview.MessageListView.b() {
            public final void a() {
                b.this.a.e.shouldCollapseInputPanel();
            }

            public final void a(int i, int i2) {
                if (i2 - i > com.qiyukf.basesdk.c.d.d.d() + com.qiyukf.basesdk.c.d.d.e() || b.this.g()) {
                    com.qiyukf.nim.uikit.common.ui.listview.a.a(b.this.c);
                }
            }

            public final void b() {
                com.qiyukf.basesdk.c.d.b.a(b.this.a.b);
            }
        });
        this.c.a((com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.b) new a(this.m));
        this.h = new Handler();
        if (!this.l) {
            this.g = new a(this.a.a, this.b, this.c);
        }
        c(true);
        this.i = this.b.findViewById(R.id.play_audio_mode_tips_bar);
        this.j = (TextView) this.b.findViewById(R.id.play_audio_mode_tips_label);
        this.k = (ImageView) this.b.findViewById(R.id.play_audio_mode_tips_indicator);
        UICustomization uICustomization = com.qiyukf.unicorn.d.e().uiCustomization;
        if (uICustomization != null && uICustomization.msgListViewDividerHeight > 0) {
            this.c.setDividerHeight(uICustomization.msgListViewDividerHeight);
        }
    }

    private int a(String str) {
        for (int i = 0; i < this.d.size(); i++) {
            if (TextUtils.equals(((IMMessage) this.d.get(i)).getUuid(), str)) {
                return i;
            }
        }
        return -1;
    }

    private MediaPlayer a(File file) {
        try {
            return MediaPlayer.create(this.a.a, Uri.fromFile(file));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static /* synthetic */ void b(b bVar, IMMessage iMMessage) {
        int a = bVar.a(iMMessage.getUuid());
        if (a >= 0 && a < bVar.d.size()) {
            IMMessage iMMessage2 = (IMMessage) bVar.d.get(a);
            iMMessage2.setStatus(iMMessage.getStatus());
            iMMessage2.setAttachStatus(iMMessage.getAttachStatus());
            iMMessage2.setAttachment(iMMessage.getAttachment());
            iMMessage2.setExt(iMMessage.getExt());
            bVar.c(a);
            bVar.e.notifyDataSetChanged();
            if (bVar.g() || bVar.p != 0) {
                bVar.p = 0;
                bVar.b(false);
            }
        }
    }

    private void b(final boolean z) {
        this.h.postDelayed(new Runnable() {
            public final void run() {
                if (z) {
                    MessageListView b = b.this.c;
                    int count = b.this.e.getCount();
                    if (VERSION.SDK_INT >= 11) {
                        b.smoothScrollToPositionFromTop(count, 0, 100);
                        return;
                    } else {
                        b.setSelection(count);
                        return;
                    }
                }
                com.qiyukf.nim.uikit.common.ui.listview.a.a(b.this.c);
            }
        }, 10);
    }

    private boolean b(IMMessage iMMessage) {
        return iMMessage.getSessionType() == this.a.d && iMMessage.getSessionId() != null && iMMessage.getSessionId().equals(this.a.c);
    }

    private void c(final int i) {
        this.a.a.runOnUiThread(new Runnable() {
            public final void run() {
                if (i >= 0) {
                    MessageListView b = b.this.c;
                    int i = i;
                    int firstVisiblePosition = b.getFirstVisiblePosition() - b.getHeaderViewsCount();
                    Object tag = (i < firstVisiblePosition || i > b.getLastVisiblePosition() - b.getHeaderViewsCount()) ? null : b.getChildAt(i - firstVisiblePosition).getTag();
                    if (tag instanceof com.qiyukf.nim.uikit.session.viewholder.b) {
                        ((com.qiyukf.nim.uikit.session.viewholder.b) tag).refreshCurrentItem();
                    }
                }
            }
        });
    }

    private void c(boolean z) {
        MsgServiceObserve msgServiceObserve = (MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class);
        msgServiceObserve.observeMsgStatus(this.s, z);
        msgServiceObserve.observeAttachmentProgress(this.t, z);
        if (z) {
            if (this.u == null) {
                this.u = new com.qiyukf.nim.uikit.a.b.a() {
                };
            }
            com.qiyukf.nim.uikit.a.a.a(this.u);
            return;
        }
        if (this.u != null) {
            com.qiyukf.nim.uikit.a.a.b(this.u);
        }
    }

    public final int a() {
        return com.qiyukf.nim.uikit.session.viewholder.c.a();
    }

    public final Class<? extends f> a(int i) {
        return com.qiyukf.nim.uikit.session.viewholder.c.a((IMMessage) this.d.get(i));
    }

    public final void a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 1) {
                switch (i) {
                    case 8:
                        com.qiyukf.nim.uikit.session.helper.d.a(this.a.b, intent, 9, this.q);
                        return;
                    case 9:
                        com.qiyukf.nim.uikit.session.helper.d.a(this.a.b, intent, i, 8, this.q);
                        return;
                    default:
                        return;
                }
            }
            c.a(intent, this.r);
        }
    }

    public final void a(com.qiyukf.nim.uikit.session.module.a aVar) {
        this.a = aVar;
        this.d.clear();
        this.c.a((com.qiyukf.nim.uikit.common.ui.listview.AutoRefreshListView.b) new a(this.m));
    }

    public final void a(IMMessage iMMessage) {
        this.d.add(iMMessage);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(iMMessage);
        this.e.a(arrayList, false, true);
        this.e.notifyDataSetChanged();
        if (this.o) {
            this.p++;
        }
        com.qiyukf.nim.uikit.common.ui.listview.a.a(this.c);
    }

    public final void a(String str, int i) {
        if (com.qiyukf.nim.uikit.a.b(str)) {
            com.qiyukf.nim.uikit.a.a(str, com.qiyukf.basesdk.c.d.d.a(), com.qiyukf.basesdk.c.d.d.b(), new ImageLoaderListener() {
                public final void onLoadComplete(@NonNull Bitmap bitmap) {
                    b.this.f.setImageBitmap(bitmap);
                }

                public final void onLoadFailed(Throwable th) {
                }
            });
            return;
        }
        if (i != 0) {
            this.f.setBackgroundColor(i);
        }
    }

    public final void a(List<IMMessage> list) {
        g();
        ArrayList arrayList = new ArrayList(list.size());
        boolean z = false;
        int i = z;
        for (IMMessage iMMessage : list) {
            if (b(iMMessage)) {
                this.d.add(iMMessage);
                arrayList.add(iMMessage);
                i++;
                z = true;
            }
            if (iMMessage.getAttachment() instanceof com.qiyukf.unicorn.f.a.a.a.f) {
                h.b(iMMessage.getUuid());
            }
        }
        if (z) {
            this.e.notifyDataSetChanged();
        }
        this.e.a(arrayList, false, true);
        if (i > 0) {
            b(true);
        }
        if (com.qiyukf.unicorn.d.g().l(this.a.c) != null && "1".equals(com.qiyukf.unicorn.d.g().l(this.a.c).a()) && com.qiyukf.unicorn.d.g().e(this.a.c) == 0 && !this.o) {
            o oVar = new o();
            oVar.a(String.valueOf(com.qiyukf.unicorn.d.g().c(this.a.c)));
            com.qiyukf.unicorn.h.c.a(oVar, list.get(0) != null ? ((IMMessage) list.get(0)).getSessionId() : this.a.c, true);
        }
    }

    public final void a(boolean z) {
        this.n = z;
    }

    public final void b(int i) {
        int i2 = com.qiyukf.unicorn.b.b.i() ? R.drawable.ysf_play_audio_mode_earphone : R.drawable.ysf_play_audio_mode_speaker;
        this.j.setText(i);
        this.k.setBackgroundResource(i2);
        this.i.setVisibility(0);
        this.h.removeCallbacks(this.v);
        this.h.postDelayed(this.v, 3000);
    }

    public final boolean b() {
        return false;
    }

    public final void c() {
        this.h.removeCallbacks(null);
        c(false);
    }

    public final void d() {
        this.a.a.runOnUiThread(new Runnable() {
            public final void run() {
                b.this.e.notifyDataSetChanged();
            }
        });
    }

    public final void e() {
        this.o = true;
    }

    public final void f() {
        this.o = false;
    }

    public final boolean g() {
        MessageListView messageListView = this.c;
        if (!(messageListView == null || messageListView.getAdapter() == null || messageListView.getLastVisiblePosition() < (messageListView.getAdapter().getCount() - 1) - messageListView.getFooterViewsCount())) {
            View childAt = messageListView.getChildAt(messageListView.getChildCount() - 1);
            return childAt != null && childAt.getBottom() - messageListView.getBottom() < com.qiyukf.basesdk.c.d.d.a(30.0f);
        }
    }

    public final void h() {
        b(false);
    }
}
