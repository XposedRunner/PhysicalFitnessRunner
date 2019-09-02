package defpackage;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.PrizeListActivity;
import com.zjwh.android_wh_physicalfitness.activity.RunPictureActivity;
import com.zjwh.android_wh_physicalfitness.activity.mine.RunHistoryDetailActivity;
import com.zjwh.android_wh_physicalfitness.entity.UploadEntity;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RunHistoryAdapter */
/* renamed from: es */
public class es extends Adapter<O000000o> {
    private List<UploadEntity> O000000o = new ArrayList();

    /* compiled from: RunHistoryAdapter */
    /* renamed from: es$1 */
    class 1 implements OnClickListener {
        1() {
        }

        public void onClick(View view) {
            view.getContext().startActivity(new Intent(view.getContext(), PrizeListActivity.class));
        }
    }

    /* compiled from: RunHistoryAdapter */
    /* renamed from: es$O000000o */
    class O000000o extends ViewHolder {
        private View O00000Oo;
        private TextView O00000o;
        private View O00000o0;
        private TextView O00000oO;
        private TextView O00000oo;
        private TextView O0000O0o;
        private TextView O0000OOo;
        private ImageView O0000Oo;
        private TextView O0000Oo0;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = view.findViewById(R.id.lin_gift);
            this.O00000o0 = view.findViewById(R.id.line);
            this.O00000o = (TextView) view.findViewById(R.id.tv_gift_name);
            this.O00000oO = (TextView) view.findViewById(R.id.tv_start_time);
            this.O00000oo = (TextView) view.findViewById(R.id.tv_total_time);
            this.O0000O0o = (TextView) view.findViewById(R.id.tv_distance);
            this.O0000OOo = (TextView) view.findViewById(R.id.tv_complete_status);
            this.O0000Oo0 = (TextView) view.findViewById(R.id.tv_upload_status);
            this.O0000Oo = (ImageView) view.findViewById(R.id.iv_node);
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.run_history_list_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        CharSequence charSequence;
        final UploadEntity uploadEntity = (UploadEntity) this.O000000o.get(i);
        o000000o.O00000oO.setText(O000O0o0.O000000o(O000O0o0.O0000o00, uploadEntity.getStartTime()));
        o000000o.O00000oo.setText(O00Oo0.O000000o(uploadEntity.getTotalTime()));
        TextView O00000o0 = o000000o.O0000O0o;
        if (uploadEntity.getTotalDis() == 0.0d) {
            charSequence = "0.00公里";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O00Oo0.O000000o(uploadEntity.getTotalDis()));
            stringBuilder.append("公里");
            charSequence = stringBuilder.toString();
        }
        O00000o0.setText(charSequence);
        ImageView O00000o = o000000o.O0000Oo;
        Context context = o000000o.itemView.getContext();
        int i2 = (uploadEntity.getIsUpload() && uploadEntity.getStatus() == 0 && uploadEntity.getComplete()) ? R.drawable.blue_dot : R.drawable.red_dot;
        O00000o.setBackground(ContextCompat.getDrawable(context, i2));
        boolean isUpload = uploadEntity.getIsUpload();
        int i3 = R.color.sport_green;
        i2 = R.string.uncomplete;
        Context context2;
        if (!isUpload) {
            O00000o0 = o000000o.O0000OOo;
            if (uploadEntity.getComplete()) {
                i2 = R.string.complete;
            }
            O00000o0.setText(i2);
            O00000o0 = o000000o.O0000OOo;
            context2 = o000000o.itemView.getContext();
            if (!uploadEntity.getComplete()) {
                i3 = R.color.red_1;
            }
            O00000o0.setTextColor(ContextCompat.getColor(context2, i3));
        } else if (uploadEntity.getStatus() == gf.O0000oOo) {
            o000000o.O0000OOo.setText(R.string.msg_record_exception);
            o000000o.O0000OOo.setTextColor(ContextCompat.getColor(o000000o.itemView.getContext(), R.color.red_1));
        } else if (uploadEntity.getStatus() == 2) {
            o000000o.O0000OOo.setText(R.string.msg_record_cheat);
            o000000o.O0000OOo.setTextColor(ContextCompat.getColor(o000000o.itemView.getContext(), R.color.red_1));
        } else {
            O00000o0 = o000000o.O0000OOo;
            if (uploadEntity.getComplete()) {
                i2 = R.string.complete;
            }
            O00000o0.setText(i2);
            O00000o0 = o000000o.O0000OOo;
            context2 = o000000o.itemView.getContext();
            if (!uploadEntity.getComplete()) {
                i3 = R.color.red_1;
            }
            O00000o0.setTextColor(ContextCompat.getColor(context2, i3));
        }
        if (uploadEntity.getIsUpload()) {
            switch (uploadEntity.getAppealStatus()) {
                case 2:
                    o000000o.O0000Oo0.setVisibility(0);
                    o000000o.O0000Oo0.setText("审核中");
                    break;
                case 3:
                    o000000o.O0000Oo0.setVisibility(0);
                    o000000o.O0000Oo0.setText("审核通过");
                    break;
                case 4:
                    o000000o.O0000Oo0.setVisibility(0);
                    o000000o.O0000Oo0.setText("审核未通过");
                    break;
                default:
                    o000000o.O0000Oo0.setVisibility(8);
                    break;
            }
        }
        o000000o.O0000Oo0.setVisibility(0);
        o000000o.O0000Oo0.setText(R.string.un_upload);
        if (TextUtils.isEmpty(uploadEntity.getPrizeName())) {
            o000000o.O00000Oo.setVisibility(8);
            o000000o.O00000Oo.setOnClickListener(null);
            o000000o.O00000o0.setVisibility(8);
        } else {
            o000000o.O00000o0.setVisibility(0);
            o000000o.O00000Oo.setVisibility(0);
            o000000o.O00000o.setText(o000000o.itemView.getContext().getString(R.string.has_reward, new Object[]{uploadEntity.getPrizeName()}));
            o000000o.O00000Oo.setOnClickListener(new 1());
        }
        o000000o.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (TextUtils.isEmpty(uploadEntity.getRecordUrl())) {
                    RunHistoryDetailActivity.O000000o(O00Oo0.O00000oo(view.getContext()), uploadEntity.getRecordId(), null, false, uploadEntity.getSportType(), null, uploadEntity.getRrid());
                    return;
                }
                Intent intent = new Intent(view.getContext(), RunPictureActivity.class);
                intent.putExtra("recordUrl", uploadEntity.getRecordUrl());
                view.getContext().startActivity(intent);
            }
        });
    }

    public void O000000o(List<UploadEntity> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
