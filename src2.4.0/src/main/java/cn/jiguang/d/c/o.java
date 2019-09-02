package cn.jiguang.d.c;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class o {
    private static o d;
    private String[] a = null;
    private j[] b = null;
    private int c = -1;

    static {
        o oVar = new o();
        synchronized (o.class) {
            d = oVar;
        }
    }

    public o() {
        if (!c() && !d()) {
            if (this.a == null || this.b == null) {
                String property = System.getProperty("os.name");
                String property2 = System.getProperty("java.vendor");
                if (property.indexOf("Windows") != -1) {
                    if (property.indexOf("95") == -1 && property.indexOf("98") == -1 && property.indexOf("ME") == -1) {
                        try {
                            Process exec = Runtime.getRuntime().exec("ipconfig /all");
                            a(exec.getInputStream());
                            exec.destroy();
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    String str = "winipcfg.out";
                    try {
                        Runtime runtime = Runtime.getRuntime();
                        StringBuilder stringBuilder = new StringBuilder("winipcfg /all /batch ");
                        stringBuilder.append(str);
                        runtime.exec(stringBuilder.toString()).waitFor();
                        a(new FileInputStream(new File(str)));
                        new File(str).delete();
                    } catch (Exception unused2) {
                    }
                } else if (property.indexOf("NetWare") != -1) {
                    b("sys:/etc/resolv.cfg");
                } else if (property2.indexOf("Android") != -1) {
                    e();
                } else {
                    b("/etc/resolv.conf");
                }
            }
        }
    }

    private static int a(String str) {
        try {
            int parseInt = Integer.parseInt(str.substring(6));
            if (parseInt >= 0) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        return -1;
    }

    private void a(InputStream inputStream) {
        int intValue = Integer.getInteger("org.xbill.DNS.windows.parse.buffer", 8192).intValue();
        InputStream bufferedInputStream = new BufferedInputStream(inputStream, intValue);
        bufferedInputStream.mark(intValue);
        a(bufferedInputStream, null);
        if (this.a == null) {
            try {
                bufferedInputStream.reset();
                a(bufferedInputStream, new Locale("", ""));
            } catch (IOException unused) {
            }
        }
    }

    private void a(InputStream inputStream, Locale locale) {
        Locale locale2 = locale;
        String name = o.class.getPackage().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(".windows.DNSServer");
        name = stringBuilder.toString();
        ResourceBundle bundle = locale2 != null ? ResourceBundle.getBundle(name, locale2) : ResourceBundle.getBundle(name);
        name = bundle.getString("host_name");
        String string = bundle.getString("primary_dns_suffix");
        String string2 = bundle.getString("dns_suffix");
        String string3 = bundle.getString("dns_servers");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            while (true) {
                Object obj = null;
                Object obj2 = obj;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                        if (!stringTokenizer.hasMoreTokens()) {
                            break;
                        }
                        String nextToken = stringTokenizer.nextToken();
                        if (readLine.indexOf(":") != -1) {
                            obj = null;
                            obj2 = obj;
                        }
                        if (readLine.indexOf(name) != -1) {
                            while (stringTokenizer.hasMoreTokens()) {
                                nextToken = stringTokenizer.nextToken();
                            }
                            try {
                                if (j.a(nextToken, null).b() != 1) {
                                    b(nextToken, arrayList2);
                                }
                            } catch (s unused) {
                            }
                        } else {
                            if (readLine.indexOf(string) != -1) {
                                while (stringTokenizer.hasMoreTokens()) {
                                    nextToken = stringTokenizer.nextToken();
                                }
                                if (nextToken.equals(":")) {
                                }
                            } else {
                                if (obj == null) {
                                    if (readLine.indexOf(string2) == -1) {
                                        if (obj2 != null || readLine.indexOf(string3) != -1) {
                                            while (stringTokenizer.hasMoreTokens()) {
                                                nextToken = stringTokenizer.nextToken();
                                            }
                                            if (!nextToken.equals(":")) {
                                                a(nextToken, arrayList);
                                                obj2 = 1;
                                            }
                                        }
                                    }
                                }
                                while (stringTokenizer.hasMoreTokens()) {
                                    nextToken = stringTokenizer.nextToken();
                                }
                                if (nextToken.equals(":")) {
                                }
                            }
                            b(nextToken, arrayList2);
                            obj = 1;
                        }
                    } else {
                        try {
                            a(arrayList, arrayList2);
                            return;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
        } catch (IOException unused3) {
        }
    }

    private static void a(String str, List list) {
        if (!list.contains(str)) {
            list.add(str);
        }
    }

    private void a(List list, List list2) {
        if (this.a == null && list.size() > 0) {
            this.a = (String[]) list.toArray(new String[0]);
        }
        if (this.b == null && list2.size() > 0) {
            this.b = (j[]) list2.toArray(new j[0]);
        }
    }

    public static synchronized o b() {
        o oVar;
        synchronized (o.class) {
            oVar = d;
        }
        return oVar;
    }

    private void b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            List arrayList = new ArrayList(0);
            List arrayList2 = new ArrayList(0);
            int i = -1;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    StringTokenizer stringTokenizer;
                    if (readLine == null) {
                        break;
                    } else if (readLine.startsWith("nameserver")) {
                        stringTokenizer = new StringTokenizer(readLine);
                        stringTokenizer.nextToken();
                        a(stringTokenizer.nextToken(), arrayList);
                    } else if (readLine.startsWith("domain")) {
                        stringTokenizer = new StringTokenizer(readLine);
                        stringTokenizer.nextToken();
                        if (stringTokenizer.hasMoreTokens() && arrayList2.isEmpty()) {
                            b(stringTokenizer.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("search")) {
                        if (!arrayList2.isEmpty()) {
                            arrayList2.clear();
                        }
                        stringTokenizer = new StringTokenizer(readLine);
                        stringTokenizer.nextToken();
                        while (stringTokenizer.hasMoreTokens()) {
                            b(stringTokenizer.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("options")) {
                        stringTokenizer = new StringTokenizer(readLine);
                        stringTokenizer.nextToken();
                        while (stringTokenizer.hasMoreTokens()) {
                            readLine = stringTokenizer.nextToken();
                            if (readLine.startsWith("ndots:")) {
                                i = a(readLine);
                            }
                        }
                    }
                } catch (IOException unused) {
                }
            }
            bufferedReader.close();
            a(arrayList, arrayList2);
            if (this.c < 0 && i > 0) {
                this.c = i;
            }
        } catch (FileNotFoundException unused2) {
        }
    }

    private static void b(String str, List list) {
        try {
            j a = j.a(str, j.a);
            if (!list.contains(a)) {
                list.add(a);
            }
        } catch (s unused) {
        }
    }

    private boolean c() {
        StringTokenizer stringTokenizer;
        List arrayList = new ArrayList(0);
        List arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken(), arrayList);
            }
        }
        property = System.getProperty("dns.search");
        if (property != null) {
            stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                b(stringTokenizer.nextToken(), arrayList2);
            }
        }
        a(arrayList, arrayList2);
        return (this.a == null || this.b == null) ? false : true;
    }

    private boolean d() {
        List arrayList = new ArrayList(0);
        List arrayList2 = new ArrayList(0);
        try {
            Class[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Class cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object invoke = cls.getDeclaredMethod("open", clsArr).invoke(null, objArr);
            List<String> list = (List) cls.getMethod("nameservers", clsArr).invoke(invoke, objArr);
            List<String> list2 = (List) cls.getMethod("searchlist", clsArr).invoke(invoke, objArr);
            if (list.size() == 0) {
                return false;
            }
            if (list.size() > 0) {
                for (String a : list) {
                    a(a, arrayList);
                }
            }
            if (list2.size() > 0) {
                for (String b : list2) {
                    b(b, arrayList2);
                }
            }
            a(arrayList, arrayList2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void e() {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            String[] strArr = new String[]{"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(null, new Object[]{strArr[i]});
                if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                    arrayList.add(str);
                }
            }
        } catch (Exception unused) {
        }
        a(arrayList, arrayList2);
    }

    public final String[] a() {
        return this.a;
    }
}
