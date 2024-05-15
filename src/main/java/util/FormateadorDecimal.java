package util;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author sergio
 */
public class FormateadorDecimal implements Serializable {

    public FormateadorDecimal() {
    }

    public static String darFormato(double number) {
        DecimalFormat formato = new DecimalFormat("#.##");
        return formato.format(number);
    }
}
