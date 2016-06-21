/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.resource;

import br.ufmg.hc.telessaude.webservices.mobile.utils.GsonUtils;
import br.ufmg.hc.telessaude.webservices.mobile.utils.ObjetoRequisicao;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author breno.melo
 */
public abstract class CustomResources {

    public static final String FORWARD_SUCCESS = "Operação realizada com sucesso.";

    public static final String FORWARD_FAILURE = "There has been an error to save an object.";

    public static final String ENCODING = "ISO-8859-1";

    public static boolean encodeResponse;
    protected static Gson gson;
    protected static Base64 b64;

    static {
        encodeResponse = false;
        gson = GsonUtils.getInstanceWithStringDateAdapter();
        b64 = new Base64();
    }
//    public abstract String save(final String customJson) throws ServerException;

    protected String toJson(Object src, Type type) {
        return gson.toJson(src, type);
    }

    protected <T> T fromJson(String src, Class<T> type) {
        return gson.fromJson(src, type);
    }

    public String formatarResposta(String respostaGson) {
        return formatarResposta(respostaGson, false, "");
    }

    public String formatarResposta(String respostaGson, boolean erro, String mensagem) {
        return formatarResposta(null, respostaGson, erro, mensagem);
    }

    public String formatarResposta(Integer status, String respostaGson, boolean erro, String mensagem) {
        if (encodeResponse) {
            try {
                return toJson(new ObjetoRequisicao(
                        status != null ? status : erro ? 400 : 200,
                        respostaGson != null ? b64.encodeAsString(respostaGson.getBytes(ENCODING)) : "",
                        erro, mensagem), ObjetoRequisicao.class);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(CustomResources.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        } else {
            return toJson(new ObjetoRequisicao(
                    status != null ? status : erro ? 400 : 200,
                    respostaGson != null ? respostaGson : "",
                    erro, mensagem), ObjetoRequisicao.class);
        }

    }
}
