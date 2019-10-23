package com.java.base.annotation.Dao;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName SchoolTest
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/21 9:50
 * @Version 1.0
 **/
public class SchoolTest {
    public static void main(String[] args) {
        School s1 = new School();
        s1.setId(1001);// query id
        School s2 = new School();
        s2.setName("QsHua");
        s2.setBorn("1894");
        s2.setDepart("English,Computer,Business");
        System.out.println(query(s1));
        System.out.println(query(s2));

    }

    private static String query(Object o){
        StringBuffer sb = new StringBuffer();
        // get reflect class
        Class c = o.getClass();
        boolean isExist = c.isAnnotationPresent(Table.class);
        if (!isExist){
            return  null;
        }
        // get annotation table information
        Table table = (Table) c.getAnnotation(Table.class);
        String tableName = table.value();
        // query select table
        sb.append("select * from ").append(tableName).append(" where 1=1");
        // get reflect declare field
       Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            // get annotation column field
            boolean isColumnExist = field.isAnnotationPresent(Column.class);
            if (!isColumnExist){
                continue;
            }
            // get column name
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();
            // get column value
            String fieldName = field.getName();
            // get method name
            String getMethod = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Object fieldValue = null;
            // use reflect get method
            try {
                Method method = c.getMethod(getMethod);
                fieldValue = method.invoke(o);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //if fieldValue null or 0
            if (fieldValue == null || (fieldValue instanceof Integer && (int)fieldValue==0)){
                continue;
            }
            if (fieldValue instanceof String){
                if (((String) fieldValue).contains(",")){
                    String[] strings = ((String) fieldValue).split(",");
                    sb.append(" and ").append(columnName).append("=").append("(");
                    for (String st : strings) {
                        sb.append("'").append(st).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");
                }else {
                    sb.append(" and ").append(columnName).append("=").append("'").append(fieldValue).append("'");
                }
            }
            if (fieldValue instanceof  Integer){
                sb.append(" and ").append(columnName).append("=").append(fieldValue);
            }
        }
     return sb.toString();
    }

}
