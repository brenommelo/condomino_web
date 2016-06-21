/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.webservices.mobile.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breno.melo
 */
public class GsonUtils {

//    public static Gson getInstanceWithDateAdapter() {
//        GsonBuilder builder = new GsonBuilder();
//        builder.registerTypeAdapter(Date.class, new DateDeserializer());
//        builder.registerTypeAdapter(Date.class, new DateSerializer());
//        return builder.create();
//    }
    public static Gson getInstanceWithStringDateAdapter() {
        GsonBuilder builder = new GsonBuilder();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        final SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss a");
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

            @Override
            public Date deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
                String data_str = "";
                Date data = null;
                try {
                    data_str = je.getAsJsonPrimitive().getAsString();
                    if (data_str.replaceAll("[\\-\\d]", "").isEmpty()) {
                        data = new Date(Long.parseLong(data_str));

                    } else {
                        if (data_str.length() == 12) {
                            data = new SimpleDateFormat("MMM dd, yyyy").parse(data_str);
                        } else if (data_str.length() == 11) {
                            data = new SimpleDateFormat("MMM d, yyyy").parse(data_str);
                        }else if(data_str.length() == 10){
                             data = new SimpleDateFormat("dd/MM/yyyy").parse(data_str);
                        } else {

                            data = sdf.parse(data_str);
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(GsonUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
                return data;
            }
        });
        builder.registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
            @Override
            public JsonElement serialize(Date t, Type type, JsonSerializationContext jsc) {
                if (t == null) {
                    return new JsonPrimitive((String) null);
                }
                return new JsonPrimitive(sdf.format(t));
            }
        });

        builder.registerTypeAdapter(java.sql.Date.class, new JsonSerializer<java.sql.Date>() {
            @Override
            public JsonElement serialize(java.sql.Date t, Type type, JsonSerializationContext jsc) {
                if (t == null) {
                    return new JsonPrimitive((String) null);
                }
                return new JsonPrimitive(sdf.format(t));
            }
        });
        return builder.create();
    }

    public static Gson getSimpleInstance() {
        return new Gson();
    }

    static class DateSerializer implements JsonSerializer<Date> {

        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(String.valueOf(src.getTime()));
        }
    }

    static class DateDeserializer implements JsonDeserializer<Date> {

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                throws JsonParseException {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(Long.parseLong(json.getAsJsonPrimitive().getAsString()));
            return cal.getTime();
        }
    }

}
