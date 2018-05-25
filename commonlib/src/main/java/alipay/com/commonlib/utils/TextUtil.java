package alipay.com.commonlib.utils;

import android.content.ClipboardManager;
import android.content.Context;
import android.widget.TextView;

import java.security.MessageDigest;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/12/1 0001.
 */

public class TextUtil {

    /**
     * 加密
     *
     * @param plaintext 明文
     * @return ciphertext 密文
     */
    public final static String encrypt(String plaintext) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = plaintext.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String setNumberFloat(double d) {
        DecimalFormat df = new DecimalFormat("######0.00");
        return df.format(d);
    }

    public static String setNumberFloat(String d) {
        DecimalFormat df = new DecimalFormat("######0.00");
        Double number = Double.valueOf(d);
        return df.format(number);
    }

    public static String setNumberFloat(double d, String string) {
        DecimalFormat df = new DecimalFormat(string);
        return df.format(d);
    }

    public static String deCode(String text) {
        return text.replace("&lt;/div&gt;&lt;div&gt;", "\n\n    ")
                .replace("&lt;br&gt;", "\n\n")
                .replace("&lt;div&gt;", "    ")
                .replace("&lt;/div&gt;", "")
                .replace("&ldquo;", "\"")
                .replace("&lt;/p&gt;&lt;p&gt;", "\n    ")
                .replace("&rdquo;", "\"")
                .replace("&lt;/p&gt;", "")
                .replace("&lt;p&gt;", "")
                .replaceAll("^&", "")
                .replace("&lt;span style=&quot;font-size: 14px;&quot;&gt;", "    ")
                .replace("&lt;/span&gt;", "")
                .replace("\n\n\n\n", "\n\n")
                .replace("&amp;", "")
                .replace("nbsp;", "");
    }

    public static String setPercent(Double d) {
        d = d == null ? 0 : d;
        return setNumberFloat(d * 100, "######0.0") + "%";
    }

    public static String setTimeUtil(String s) {
        switch (s) {
            case "year":
                return "月";
            case "month":
                return "月";
            case "day":
                return "天";
            default:
                return "月";
        }
    }

    public static String financeStatus(String d) {
        String content = d.replace(";", "");
        switch (content) {
            case "new_p":
                return "新人专享";
            case "hot":
                return "热门标";
            case "earn_double":
                return "收益翻倍";
            default:
                return content;
        }
    }

    public static void setStringToBord(Context context, String s) {
        // 从API11开始android推荐使用android.content.ClipboardManager
        // 为了兼容低版本我们这里使用旧版的android.text.ClipboardManager，虽然提示deprecated，但不影响使用。
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        // 将文本内容放到系统剪贴板里。
        if (cm != null) {
            cm.setText(s);
        }
    }

    public static void setRepaymentType(TextView repayment_type_tv, String type) {
        switch (type) {
            case "acpi":
                repayment_type_tv.setText("等额本息");
                break;
            case "aecl":
                repayment_type_tv.setText("等额本金");
                break;
            case "epei":
                repayment_type_tv.setText("等本等息");
                break;
            case "fiaa":
                repayment_type_tv.setText("先息后本");
                break;
            case "mopai":
                repayment_type_tv.setText("到期还本付息");
                break;
            default:
                break;
        }
    }
}
