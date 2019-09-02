package jp.co.cyberagent.android.gpuimage;

/* compiled from: GPUImageKuwaharaFilter */
public class O00OOo extends O00O00Oo {
    public static final String O000000o = "varying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform int radius;\n\nprecision highp float;\n\nconst vec2 src_size = vec2 (1.0 / 768.0, 1.0 / 1024.0);\n\nvoid main (void) \n{\nvec2 uv = textureCoordinate;\nfloat n = float((radius + 1) * (radius + 1));\nint i; int j;\nvec3 m0 = vec3(0.0); vec3 m1 = vec3(0.0); vec3 m2 = vec3(0.0); vec3 m3 = vec3(0.0);\nvec3 s0 = vec3(0.0); vec3 s1 = vec3(0.0); vec3 s2 = vec3(0.0); vec3 s3 = vec3(0.0);\nvec3 c;\n\nfor (j = -radius; j <= 0; ++j)  {\nfor (i = -radius; i <= 0; ++i)  {\nc = texture2D(inputImageTexture, uv + vec2(i,j) * src_size).rgb;\nm0 += c;\ns0 += c * c;\n}\n}\n\nfor (j = -radius; j <= 0; ++j)  {\nfor (i = 0; i <= radius; ++i)  {\nc = texture2D(inputImageTexture, uv + vec2(i,j) * src_size).rgb;\nm1 += c;\ns1 += c * c;\n}\n}\n\nfor (j = 0; j <= radius; ++j)  {\nfor (i = 0; i <= radius; ++i)  {\nc = texture2D(inputImageTexture, uv + vec2(i,j) * src_size).rgb;\nm2 += c;\ns2 += c * c;\n}\n}\n\nfor (j = 0; j <= radius; ++j)  {\nfor (i = -radius; i <= 0; ++i)  {\nc = texture2D(inputImageTexture, uv + vec2(i,j) * src_size).rgb;\nm3 += c;\ns3 += c * c;\n}\n}\n\n\nfloat min_sigma2 = 1e+2;\nm0 /= n;\ns0 = abs(s0 / n - m0 * m0);\n\nfloat sigma2 = s0.r + s0.g + s0.b;\nif (sigma2 < min_sigma2) {\nmin_sigma2 = sigma2;\ngl_FragColor = vec4(m0, 1.0);\n}\n\nm1 /= n;\ns1 = abs(s1 / n - m1 * m1);\n\nsigma2 = s1.r + s1.g + s1.b;\nif (sigma2 < min_sigma2) {\nmin_sigma2 = sigma2;\ngl_FragColor = vec4(m1, 1.0);\n}\n\nm2 /= n;\ns2 = abs(s2 / n - m2 * m2);\n\nsigma2 = s2.r + s2.g + s2.b;\nif (sigma2 < min_sigma2) {\nmin_sigma2 = sigma2;\ngl_FragColor = vec4(m2, 1.0);\n}\n\nm3 /= n;\ns3 = abs(s3 / n - m3 * m3);\n\nsigma2 = s3.r + s3.g + s3.b;\nif (sigma2 < min_sigma2) {\nmin_sigma2 = sigma2;\ngl_FragColor = vec4(m3, 1.0);\n}\n}\n";
    private int O00000Oo;
    private int O00000o0;

    public O00OOo(int i) {
    }

    public void O000000o() {
    }

    public void O000000o(int i) {
    }

    public void O00000Oo() {
    }
}
