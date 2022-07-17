package com.company.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ClassName JsonToBeanUtils
 * @company 公司
 * @Description TODO
 * @createTime 2022年07月16日 13:59:59
 */
public class JsonToBeanUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * JSON格式字符串与JSON对象之间的转换
     * @param jsonObjStr
     * //json字符串-简单对象型
     * private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
     * @return
     */
    public static JSONObject JsonStrToJsonObject(String jsonObjStr) {
        JSONObject jsonObject = JSON.parseObject(jsonObjStr);
        return jsonObject;
    }

    /**
     * JSON格式字符串与JSON对象之间的转换
     * @param jsonArrayStr
     * //json字符串-数组类型
     * private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
     * @return
     */
    public static JSONObject JsonStrToJsonArray(String jsonArrayStr) {
        JSONObject jsonObject = JSON.parseObject(jsonArrayStr);
        return jsonObject;
    }

    /**
     * 复杂类型的JSON对象字符串与JSON对象之间的转换
     * @param complexJsonStr
     * @return
     */
    public static JSONObject ComplexJsonStrToJsonArray(String complexJsonStr) {
        JSONObject jsonObject = JSON.parseObject(complexJsonStr);
        return jsonObject;
    }

    /**
     * json字符串-简单对象与JavaBean_obj之间的转换
     */
    public static <T> T JsonObjStrToJavaBeanObj(String jsonObjStr, T t1){
        T t = JSON.parseObject(jsonObjStr, new TypeReference<T>() {});
        return t;
    }

    /**
     * json字符串-数组类型与JavaBean_List之间的转换
     */
    public static <T> ArrayList<T> JsonArrayStrToJavaBeanObj(String jsonArrayStr, Class<T> type){
        ArrayList<T> t = JSON.parseObject(jsonArrayStr, new TypeReference<ArrayList<T>>() {});
        return t;
    }

    /**
     * 复杂json格式字符串与JavaBean_obj之间的转换,自己传Class的类型
     */
    public static <T> T ComplexJsonStrToJavaBean(String complexJsonStr, Class<T> type){

        //T t = JSON.parseObject(complexJsonStr, new TypeReference<T>() {});
        T t = JSON.parseObject(complexJsonStr, type);
        return t;
    }


    /**
     * 用fastjson 将json字符串解析为一个 JavaBean
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> T getJson(String jsonString, Class<T> cls) {
        T t = null;
        try {
            t = JSON.parseObject(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 用fastjson 将json字符串解析为一个 JavaBean
     *
     * @param jsonString
     * @return
     */
    public static <T> T getJson(String jsonString) {
        T t = null;
        try {
            t = (T) JSON.parseObject(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 用fastjson 将json字符串 解析成为一个 List<JavaBean> 及 List<String>
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> List<T> getArrayJson(String jsonString, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        try {
            list = JSON.parseArray(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 用fastjson 将json字符串 解析成为一个 List<JavaBean> 及 List<String>
     *
     * @param jsonString
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> getArrayJson(String jsonString) {
        List<T> list = new ArrayList<T>();
        try {
            list = (List<T>) JSON.parseArray(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 用fastjson 将jsonString 解析成 List<Map<String,Object>>
     *
     * @param jsonString
     * @return
     */
    public static List<Map<String, Object>> getListMap(String jsonString) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            list = JSON.parseObject(jsonString, new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 对象转json
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}