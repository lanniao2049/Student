package com.java.base.annotation.Dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName FilterTest
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/8/20 18:42
 * @Version 1.0
 **/
public class FilterTest {
    public static void main(String[] args) {
        Filter f1 = new Filter();
        f1.setId(32);

        Filter f2 = new Filter();
        f2.setUserName("BillGate");

        Filter f3 = new Filter();
        f3.setEmail("lanniao@sina.com,hongX@163.com,777@qq.com,maHua@123.com");

        Depart depart = new Depart();
        depart.setId(001);
        depart.setName("Internet technology");
        depart.setName("hangZhou");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);
        String sql4 = query(depart);
        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
        System.out.println(sql4);
    }

    private static String query(Object filter){
        StringBuilder sb = new StringBuilder();
        Class c = filter.getClass();
        // get table annotation
        boolean isExist = c.isAnnotationPresent(Table.class);
        if (!isExist){
            return null;
        }
        // get table name
        Table table = (Table) c.getAnnotation(Table.class);
        String tableName = table.value();
        // get query select
        sb.append("select * from ").append(tableName).append(" where 1=1");
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            boolean fExist = field.isAnnotationPresent(Column.class);
            if (!fExist){
                continue;
            }
            // get table column
            Column column = field.getAnnotation(Column.class);
            String columnName= column.value();
            // get field value
            String fieldName = field.getName();
            String getMethodName ="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method method = c.getMethod(getMethodName);
                fieldValue = method.invoke(filter);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (fieldValue == null ||(fieldValue instanceof Integer && (int)fieldValue==0) ){
                continue;
            }
            if (fieldValue instanceof String){
                if (((String) fieldValue).contains(",")){
                    String[] fieldS = ((String) fieldValue).split(",");
                    sb.append(" and ").append(columnName).append(" in(");
                    for (String s : fieldS) {
                        sb.append("'").append(s).append("',");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");
                }else {
                    sb.append(" and ").append(columnName).append("=").append("'").append(fieldValue).append("'");
                }
            }
            if (fieldValue instanceof Integer){
                sb.append(" and ").append(columnName).append("=").append(fieldValue);
            }
        }
        return sb.toString();
    }
}
