/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.webservices.mobile.commons;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author breno.melo
 */
public class StringUtil {

    /**
     * dd/MM/yyyy
     */
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    /**
     * HH:mm:ss
     */
    public static final String HH_MM_SS = "HH:mm:ss";
    /**
     * dd/MM/yyyy - HH:mm:ss
     */
    public static final String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy - HH:mm:ss";
    /**
     * dd/MM/yyyy - HH:mm
     */
    public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy - HH:mm";

    /**
     * Formata data apenas com dia mes e ano
     *
     * @param date
     * @return
     */
    public static String formatarData(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DD_MM_YYYY).format(date);
    }

    /**
     * Formata data com hora minutos e segundos
     *
     * @param date
     * @return
     */
    public static String formatarDataComHora(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DD_MM_YYYY_HH_MM_SS).format(date);
    }

    public static String formatarDataMaximaHoraDoDia(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DD_MM_YYYY + " 23:59:59").format(date);
    }

    public static Date paraMaximaHoraDoDia(Date date) throws ParseException {
        if (date == null) {
            date = Calendar.getInstance().getTime();
        }
        return new SimpleDateFormat().parse(formatarDataMaximaHoraDoDia(date));
    }

    public static String formatarDataMinimaHoraDoDia(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DD_MM_YYYY + " 00:00:00").format(date);
    }

    public static Date paraMinimaHoraDoDia(Date date) throws ParseException {
        if (date == null) {
            date = Calendar.getInstance().getTime();
        }
        return new SimpleDateFormat().parse(formatarDataMinimaHoraDoDia(date));
    }

    public static String formatDateOnlyNumbers(Date date) {
        return formatarData(date).replaceAll("[^\\d]", "");
    }

    public static String formatarData(Date date, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        if (date != null) {
            format = new SimpleDateFormat(pattern);
            return format.format(date);
        }
        return format.format(new Date());
    }

    public static Date parse(String dateStr, String pattern) {
        DateFormat format = null;
        Date date = null;

        try {
            format = new SimpleDateFormat(pattern);
            date = format.parse(dateStr);
        } catch (ParseException ex) {
        }

        return date;
    }

    public static Long toLong(String str) {
        Long value = 0L;
        try {
            value = Long.parseLong(str);
        } catch (Exception ex) {
        }
        return value;
    }

    public static Long toLong(Object obj) {
        try {
            return toLong(obj.toString());
        } catch (Exception ex) {
            return 0L;
        }
    }

    public static boolean validarEmail(String email) {
        boolean valido = false;
        if (email == null || email.indexOf("@") <= 1
                || email.trim().isEmpty() || email.indexOf(".") <= 1) {
            return valido;
        }
        String auxEmail = email.replace("@", "");
        if (auxEmail.indexOf("..") > 0 || auxEmail.indexOf("__") > 0 || auxEmail.indexOf("--") > 0) {
            return valido;
        }
        String regex = "^[\\w\\d\\.\\_\\-]+@([\\w\\d\\.\\_\\-]+\\.)+[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String removeAcentos(String str) {
        if (str != null && !str.isEmpty()) {
            str = Normalizer.normalize(str, Normalizer.Form.NFD);
            str = str.replaceAll("[^\\p{ASCII}]", "");
            str = str.toUpperCase();
//        str = str.replaceAll("[^a-zA-Z0-9\\.\\_\\-\\ ]", "");
        }
        return str;
    }

    /**
     * Remove todos os caracteres especiais
     *
     * @param str
     * @return
     */
    public static String normalizar(String str) {

        /**
         * Troca os caracteres acentuados por não acentuados *
         */
        String[][] caracteresAcento = {
            {"Á", "A"}, {"á", "a"},
            {"É", "E"}, {"é", "e"},
            {"Í", "I"}, {"í", "i"},
            {"Ó", "O"}, {"ó", "o"},
            {"Ú", "U"}, {"ú", "u"},
            {"À", "A"}, {"à", "a"},
            {"È", "E"}, {"è", "e"},
            {"Ì", "I"}, {"ì", "i"},
            {"Ò", "O"}, {"ò", "o"},
            {"Ù", "U"}, {"ù", "u"},
            {"Â", "A"}, {"â", "a"},
            {"Ê", "E"}, {"ê", "e"},
            {"Î", "I"}, {"î", "i"},
            {"Ô", "O"}, {"ô", "o"},
            {"Û", "U"}, {"û", "u"},
            {"Ä", "A"}, {"ä", "a"},
            {"Ë", "E"}, {"ë", "e"},
            {"Ï", "I"}, {"ï", "i"},
            {"Ö", "O"}, {"ö", "o"},
            {"Ü", "U"}, {"ü", "u"},
            {"Ã", "A"}, {"ã", "a"},
            {"Õ", "O"}, {"õ", "o"},
            {"Ç", "C"}, {"ç", "c"},};

        for (int i = 0; i < caracteresAcento.length; i++) {
            str = str.replaceAll(caracteresAcento[i][0], caracteresAcento[i][1]);
        }

        /**
         * Troca os caracteres especiais da string por "" *
         */
        str = str.replaceAll("[^a-zA-Z^0-9^\\.^\\-^\\_^\\ ^\\@]", " ");

        return str;
    }

    public static String removerMask(String[] valores, String valor, boolean moeda) {
        
        valor = valor.replaceAll(" ", "");
        
        if (moeda) {
            valor = valor.replaceAll(",", "/");
        }

        for (String s : valores) {
            valor = valor.replace(s, "");
        }
        
        valor = valor.replaceAll("/", ".");

        return (valor.replaceAll(" ", ""));
    }
    
    public static String formatarMoeda(Number valor){
        return String.format("%.2f", valor);
    }

}
