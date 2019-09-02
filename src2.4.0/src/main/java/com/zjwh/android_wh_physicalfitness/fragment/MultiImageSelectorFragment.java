package com.zjwh.android_wh_physicalfitness.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.Folder;
import com.zjwh.android_wh_physicalfitness.entity.ImageEntity;
import com.zjwh.android_wh_physicalfitness.utils.O000OOOo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import defpackage.O00Oo;
import defpackage.ef;
import defpackage.eh;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiImageSelectorFragment extends BaseFragment {
    public static final String O000000o = "max_select_count";
    public static final String O00000oo = "select_count_mode";
    public static final String O0000O0o = "show_camera";
    public static final String O0000OOo = "default_result";
    public static final int O0000Oo = 1;
    public static final int O0000Oo0 = 0;
    private static final String O0000OoO = "key_temp_file";
    private static final int O0000Ooo = 0;
    private static final int O0000o0 = 100;
    private static final int O0000o00 = 1;
    private GridView O0000o;
    private ArrayList<String> O0000o0O = new ArrayList();
    private ArrayList<Folder> O0000o0o = new ArrayList();
    private eh O0000oO;
    private O000000o O0000oO0;
    private ef O0000oOO;
    private ListPopupWindow O0000oOo;
    private Button O0000oo;
    private TextView O0000oo0;
    private View O0000ooO;
    private int O0000ooo;
    private File O000O00o;
    private LoaderCallbacks<Cursor> O000O0OO = new LoaderCallbacks<Cursor>() {
        private final String[] O00000Oo = new String[]{"_data", "_display_name", "date_added", "mime_type", "_size", "_id"};

        private boolean O000000o(String str) {
            return !TextUtils.isEmpty(str) ? new File(str).exists() : false;
        }

        /* renamed from: O000000o */
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                try {
                    List arrayList = new ArrayList();
                    cursor.moveToFirst();
                    do {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow(this.O00000Oo[0]));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(this.O00000Oo[1]));
                        long j = cursor.getLong(cursor.getColumnIndexOrThrow(this.O00000Oo[2]));
                        ImageEntity imageEntity = null;
                        if (O000000o(string)) {
                            imageEntity = new ImageEntity(string, string2, j);
                            arrayList.add(imageEntity);
                        }
                        if (!MultiImageSelectorFragment.this.O00oOooO) {
                            File parentFile = new File(string).getParentFile();
                            if (parentFile != null && parentFile.exists()) {
                                string2 = parentFile.getAbsolutePath();
                                Folder O000000o = MultiImageSelectorFragment.this.O000000o(string2);
                                if (O000000o == null) {
                                    O000000o = new Folder();
                                    O000000o.name = parentFile.getName();
                                    O000000o.path = string2;
                                    O000000o.cover = imageEntity;
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(imageEntity);
                                    O000000o.images = arrayList2;
                                    MultiImageSelectorFragment.this.O0000o0o.add(O000000o);
                                } else {
                                    O000000o.images.add(imageEntity);
                                }
                            }
                        }
                    } while (cursor.moveToNext());
                    MultiImageSelectorFragment.this.O0000oO.O000000o(arrayList);
                    if (MultiImageSelectorFragment.this.O0000o0O != null && MultiImageSelectorFragment.this.O0000o0O.size() > 0) {
                        MultiImageSelectorFragment.this.O0000oO.O000000o(MultiImageSelectorFragment.this.O0000o0O);
                    }
                    if (!MultiImageSelectorFragment.this.O00oOooO) {
                        MultiImageSelectorFragment.this.O0000oOO.O000000o(MultiImageSelectorFragment.this.O0000o0o);
                        MultiImageSelectorFragment.this.O00oOooO = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            int i2 = i;
            StringBuilder stringBuilder;
            if (i2 == 0) {
                FragmentActivity activity = MultiImageSelectorFragment.this.getActivity();
                Uri uri = Media.EXTERNAL_CONTENT_URI;
                String[] strArr = this.O00000Oo;
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.O00000Oo[4]);
                stringBuilder.append(">0 AND ");
                stringBuilder.append(this.O00000Oo[3]);
                stringBuilder.append("=? OR ");
                stringBuilder.append(this.O00000Oo[3]);
                stringBuilder.append("=? ");
                String stringBuilder2 = stringBuilder.toString();
                String[] strArr2 = new String[]{"image/jpeg", "image/png"};
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(this.O00000Oo[2]);
                stringBuilder3.append(" DESC");
                return new CursorLoader(activity, uri, strArr, stringBuilder2, strArr2, stringBuilder3.toString());
            } else if (i2 != 1) {
                return null;
            } else {
                FragmentActivity activity2 = MultiImageSelectorFragment.this.getActivity();
                Uri uri2 = Media.EXTERNAL_CONTENT_URI;
                String[] strArr3 = this.O00000Oo;
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.O00000Oo[4]);
                stringBuilder.append(">0 AND ");
                stringBuilder.append(this.O00000Oo[0]);
                stringBuilder.append(" like '%");
                stringBuilder.append(bundle.getString("path"));
                stringBuilder.append("%'");
                String stringBuilder4 = stringBuilder.toString();
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(this.O00000Oo[2]);
                stringBuilder5.append(" DESC");
                return new CursorLoader(activity2, uri2, strArr3, stringBuilder4, null, stringBuilder5.toString());
            }
        }

        public void onLoaderReset(Loader<Cursor> loader) {
        }
    };
    private boolean O00oOooO = false;
    private boolean O00oOooo = false;

    public interface O000000o {
        void O000000o(File file);

        void O000000o(String str);

        void O00000Oo(String str);

        void O00000o();

        void O00000o0(String str);
    }

    private Folder O000000o(String str) {
        if (this.O0000o0o != null) {
            Iterator it = this.O0000o0o.iterator();
            while (it.hasNext()) {
                Folder folder = (Folder) it.next();
                if (TextUtils.equals(folder.path, str)) {
                    return folder;
                }
            }
        }
        return null;
    }

    private void O000000o(ImageEntity imageEntity, int i) {
        if (imageEntity != null) {
            if (i == 1) {
                Button button;
                StringBuilder stringBuilder;
                if (this.O0000o0O.contains(imageEntity.path)) {
                    this.O0000o0O.remove(imageEntity.path);
                    if (this.O0000o0O.size() != 0) {
                        this.O0000oo.setEnabled(true);
                        button = this.O0000oo;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(getResources().getString(R.string.preview));
                        stringBuilder.append("(");
                        stringBuilder.append(this.O0000o0O.size());
                        stringBuilder.append(")");
                        button.setText(stringBuilder.toString());
                    } else {
                        this.O0000oo.setEnabled(false);
                        this.O0000oo.setText(R.string.preview);
                    }
                    if (this.O0000oO0 != null) {
                        this.O0000oO0.O00000o0(imageEntity.path);
                    }
                } else if (this.O0000ooo == this.O0000o0O.size()) {
                    Toast.makeText(getActivity(), R.string.msg_amount_limit, 0).show();
                    return;
                } else {
                    this.O0000o0O.add(imageEntity.path);
                    this.O0000oo.setEnabled(true);
                    button = this.O0000oo;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(getResources().getString(R.string.preview));
                    stringBuilder.append("(");
                    stringBuilder.append(this.O0000o0O.size());
                    stringBuilder.append(")");
                    button.setText(stringBuilder.toString());
                    if (this.O0000oO0 != null) {
                        this.O0000oO0.O00000Oo(imageEntity.path);
                    }
                }
                this.O0000oO.O000000o(imageEntity);
            } else if (i == 0 && this.O0000oO0 != null) {
                this.O0000oO0.O000000o(imageEntity.path);
            }
        }
    }

    private void O00000Oo() {
        Point O00000o0 = O00Oo0.O00000o0(getActivity());
        int i = O00000o0.x;
        int i2 = (int) (((float) O00000o0.y) * 0.5625f);
        this.O0000oOo = new ListPopupWindow(getActivity());
        this.O0000oOo.setBackgroundDrawable(new ColorDrawable(-1));
        this.O0000oOo.setAdapter(this.O0000oOO);
        this.O0000oOo.setContentWidth(i);
        this.O0000oOo.setWidth(i);
        this.O0000oOo.setHeight(i2);
        this.O0000oOo.setAnchorView(this.O0000ooO);
        this.O0000oOo.setModal(true);
        this.O0000oOo.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long j) {
                MultiImageSelectorFragment.this.O0000oOO.O00000Oo(i);
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        MultiImageSelectorFragment.this.O0000oOo.dismiss();
                        if (i == 0) {
                            MultiImageSelectorFragment.this.getActivity().getSupportLoaderManager().restartLoader(0, null, MultiImageSelectorFragment.this.O000O0OO);
                            MultiImageSelectorFragment.this.O0000oo0.setText(R.string.folder_all);
                            if (MultiImageSelectorFragment.this.O00oOooo) {
                                MultiImageSelectorFragment.this.O0000oO.O00000Oo(true);
                            } else {
                                MultiImageSelectorFragment.this.O0000oO.O00000Oo(false);
                            }
                        } else {
                            Folder folder = (Folder) adapterView.getAdapter().getItem(i);
                            if (folder != null) {
                                MultiImageSelectorFragment.this.O0000oO.O000000o(folder.images);
                                MultiImageSelectorFragment.this.O0000oo0.setText(folder.name);
                                if (MultiImageSelectorFragment.this.O0000o0O != null && MultiImageSelectorFragment.this.O0000o0O.size() > 0) {
                                    MultiImageSelectorFragment.this.O0000oO.O000000o(MultiImageSelectorFragment.this.O0000o0O);
                                }
                            }
                            MultiImageSelectorFragment.this.O0000oO.O00000Oo(false);
                        }
                        MultiImageSelectorFragment.this.O0000o.smoothScrollToPosition(0);
                    }
                }, 100);
            }
        });
    }

    private void O00000o0() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            try {
                this.O000O00o = O000OOOo.O000000o(getActivity());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (this.O000O00o == null || !this.O000O00o.exists()) {
                Toast.makeText(getActivity(), "图片错误", 0).show();
                return;
            }
            intent.putExtra("output", Uri.fromFile(this.O000O00o));
            startActivityForResult(intent, 100);
            return;
        }
        Toast.makeText(getActivity(), R.string.msg_no_camera, 0).show();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        getActivity().getSupportLoaderManager().initLoader(0, null, this.O000O0OO);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 100) {
            return;
        }
        if (i2 != -1) {
            while (this.O000O00o != null && this.O000O00o.exists()) {
                if (this.O000O00o.delete()) {
                    this.O000O00o = null;
                }
            }
        } else if (this.O000O00o != null && this.O0000oO0 != null) {
            this.O0000oO0.O000000o(this.O000O00o);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.O0000oO0 = (O000000o) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException("The Activity must implement MultiImageSelectorFragment.Callback interface...");
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.O0000oOo != null && this.O0000oOo.isShowing()) {
            this.O0000oOo.dismiss();
        }
        super.onConfigurationChanged(configuration);
    }

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_multi_image, viewGroup, false);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(O0000OoO, this.O000O00o);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000ooo = getArguments().getInt("max_select_count");
        final int i = getArguments().getInt("select_count_mode");
        if (i == 1) {
            ArrayList stringArrayList = getArguments().getStringArrayList(O0000OOo);
            if (stringArrayList != null && stringArrayList.size() > 0) {
                this.O0000o0O = stringArrayList;
            }
        }
        this.O00oOooo = getArguments().getBoolean("show_camera", true);
        this.O0000oO = new eh(getActivity(), this.O00oOooo, 3);
        this.O0000oO.O000000o(i == 1);
        this.O0000ooO = view.findViewById(R.id.footer);
        this.O0000oo0 = (TextView) view.findViewById(R.id.category_btn);
        this.O0000oo0.setText(R.string.folder_all);
        this.O0000oo0.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MultiImageSelectorFragment.this.O0000oOo == null) {
                    MultiImageSelectorFragment.this.O00000Oo();
                }
                if (MultiImageSelectorFragment.this.O0000oOo.isShowing()) {
                    MultiImageSelectorFragment.this.O0000oOo.dismiss();
                    return;
                }
                MultiImageSelectorFragment.this.O0000oOo.show();
                int O000000o = MultiImageSelectorFragment.this.O0000oOO.O000000o();
                if (O000000o != 0) {
                    O000000o--;
                }
                MultiImageSelectorFragment.this.O0000oOo.getListView().setSelection(O000000o);
            }
        });
        this.O0000oo = (Button) view.findViewById(R.id.preview);
        this.O0000oo.setVisibility(i == 1 ? 0 : 8);
        if (this.O0000o0O == null || this.O0000o0O.size() <= 0) {
            this.O0000oo.setText(R.string.preview);
            this.O0000oo.setEnabled(false);
        }
        this.O0000oo.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MultiImageSelectorFragment.this.O0000oO0 != null) {
                    MultiImageSelectorFragment.this.O0000oO0.O00000o();
                }
            }
        });
        this.O0000o = (GridView) view.findViewById(R.id.grid);
        this.O0000o.setAdapter(this.O0000oO);
        this.O0000o.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (!MultiImageSelectorFragment.this.O0000oO.O000000o()) {
                    MultiImageSelectorFragment.this.O000000o((ImageEntity) adapterView.getAdapter().getItem(i), i);
                } else if (i == 0) {
                    MultiImageSelectorFragment.this.O00000o0();
                } else {
                    MultiImageSelectorFragment.this.O000000o((ImageEntity) adapterView.getAdapter().getItem(i), i);
                }
            }
        });
        this.O0000o.setOnScrollListener(new OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (MultiImageSelectorFragment.this.O0000Ooo()) {
                    if (i == 2) {
                        O00Oo.O00000o0(absListView.getContext()).O00000o0();
                    } else {
                        O00Oo.O00000o0(absListView.getContext()).O00000oO();
                    }
                }
            }
        });
        this.O0000oOO = new ef(getActivity());
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            this.O000O00o = (File) bundle.getSerializable(O0000OoO);
        }
    }
}
