package Xujunchao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.*;

public class Main {
    private static String path = "./";
    private static String type = ".java";
    private static String json = "[{" +
            "\"name\":\"hello\",\"type\":\"object\",\"description\":\"我是注释1\",\"children\":[{\"name\":\"test1\",\"type\":\"string\"}" +
            ",{\"name\":\"test2\",\"type\":\"object\",\"children\":[{\"name\":\"xjc\",\"type\":\"array\",\"children\":[{\"name\":\"最后一层\",\"type\":\"number\"}]}]}]" +
            "},{name:test,type:number,description:你妈嗨}]";


    public static void main(String[] args) {
        System.out.println(json);
        Map jsonMap = new HashMap<String, String>();
        List list = new Gson().fromJson(json, new TypeToken<List>() {
        }.getType());
        System.out.println(createClass("test", list));
        createFile("lalala","徐俊超测试名字",list);
        //getAndSet("hello","X[]");
        //如果是object类型的参数
        if (type.equals("object")) {

        }
    }

    public static boolean createFile(String fieName,String className,List params){
        String text="";
        text=createClass(className,params);
        File file=new File("test.java");

        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(text.getBytes());
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static String createClass(String className, List var) {
        String upperParams = upperCase(className);
        StringBuffer result = new StringBuffer();
        result.append("public class " + upperParams + "{\n");
        for (int i = 0; i < var.size(); i++) {
            Map map = (Map) var.get(i);
            String type = (String) map.get("type");
            String name = (String) map.get("name");
            String annotation=(String)map.get("description");
            List childrenList = (List) map.get("children");
            if(annotation!=null){
                result.append("//"+annotation+"\n");
            }
            else {
                result.append("//"+"\n");
            }
            if (type.equals("object")) {
                type=getType(type,name);

                result.append("private " + type + " " + name + ";\n");
                result.append(createClass(name, childrenList));
            } else if (type.equals("array")) {
                type=getType(type,name);
                result.append("private " + type + " " + name + ";\n");
                result.append(createClass(name, childrenList));
            } else {
                type=getType(type,name);
                result.append("private " + type + " " + name + ";\n");
            }
        }
        for (int i = 0; i < var.size(); i++) {
            Map paramMap = (Map) var.get(i);
            String type = (String) paramMap.get("type");
            String name = (String) paramMap.get("name");
            type=getType(type,name);
            result.append(getAndSet(name, type));
        }
        result.append("}\n");
        return result.toString();
    }

    /*
      获取bean中的get和set方法
     */
    public static StringBuffer getAndSet(String params, String type) {
        String upperParams = upperCase(params);
        type = getType(type,params);
        StringBuffer getAndSetStr = new StringBuffer();
        getAndSetStr.append("public " + "void" + " set" + upperParams + "(" + type + " " + params + "){");
        getAndSetStr.append("this." + params + "=" + params + ";");
        getAndSetStr.append("}");
        getAndSetStr.append("\n");
        getAndSetStr.append("public " + type + " get" + upperParams + "(){");
        getAndSetStr.append("return this." + params + ";");
        getAndSetStr.append("}");
        getAndSetStr.append("\n");
        return getAndSetStr;
    }


    //首字母大写
    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }


    public static String getType(String type,String name)  {
        switch (type) {

            case "number": {
                type= "Integer";
                break;
            }
            case "string": {
                type= "String";
                break;
            }
            case "object": {
                type= upperCase(name)+" ";
                break;
            }
            case "array": {
                type =upperCase(name)+"[] ";
                break;
            }
        }
        return type;
    }

}

