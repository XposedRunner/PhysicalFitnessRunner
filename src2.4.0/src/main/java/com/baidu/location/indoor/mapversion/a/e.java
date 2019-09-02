package com.baidu.location.indoor.mapversion.a;

import android.support.v4.app.SemesterTipDialog;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void run() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://loc.map.baidu.com/check_indoor_data_update").openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection.setReadTimeout(SemesterTipDialog.REQUEST_CODE_SEMESTER_DIALOG);
            httpURLConnection.setConnectTimeout(SemesterTipDialog.REQUEST_CODE_SEMESTER_DIALOG);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("&data_type=ps");
            stringBuilder.append("&bid=");
            stringBuilder.append(this.a.e);
            if (this.a.f != null) {
                stringBuilder.append("&md5=");
                stringBuilder.append(this.a.f);
            }
            httpURLConnection.getOutputStream().write(stringBuilder.toString().getBytes());
            if (httpURLConnection.getResponseCode() == 200) {
                String headerField = httpURLConnection.getHeaderField("Hash");
                if (headerField != null && (this.a.f == null || !headerField.equalsIgnoreCase(this.a.f))) {
                    this.a.f = headerField;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    FileWriter fileWriter = new FileWriter(new File(this.a.c, this.a.e));
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(headerField);
                    stringBuilder2.append("\n");
                    headerField = stringBuilder2.toString();
                    while (true) {
                        fileWriter.write(headerField);
                        headerField = bufferedReader.readLine();
                        if (headerField == null) {
                            break;
                        }
                        fileWriter.write(headerField);
                        headerField = "\n";
                    }
                    fileWriter.flush();
                    fileWriter.close();
                }
                this.a.d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.a.d = false;
        }
        this.a.d = false;
    }
}
