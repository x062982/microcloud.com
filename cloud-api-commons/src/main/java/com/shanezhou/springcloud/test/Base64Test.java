package com.shanezhou.springcloud.test;

import com.shanezhou.springcloud.entity.User;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author ShaneZhou
 * @since 2020/9/11 周五
 */
public class Base64Test {

    public static void main(String[] args) {
        try {
            String s = Base64.getEncoder().encodeToString("shane-shane".getBytes("UTF-8"));
            String s1 = Base64.getUrlEncoder().encodeToString("shane-shane".getBytes("UTF-8"));
            String s2 = Base64.getMimeEncoder().encodeToString("shane-shane".getBytes("UTF-8"));
            System.out.println(s);
            System.out.println(s1);
            System.out.println(s2);
            int a = 1;
            double b = a;
            short c = (short)a;

            byte[] decode = Base64.getDecoder().decode(s);
            System.out.println(new String(decode, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Integer i = 10;
        Integer j = 20;
        swap(i, j);
        System.out.println("i = " + i + ", j = " + j);
        List<User> list = new ArrayList<>();
        for (int k = 0; k < 5; k++) {
            User u = new User();
            u.setId((long)k);
            list.add(u);
        }
        while (list.size() > 0) {
            for (int k = 0; k < 4; k ++) {
                list.remove(0);
                if (list.size() == 0) {
                    break;
                }
            }
        }
        System.out.println(list);
    }

    public static void swap(Integer i, Integer j) {
        Integer temp = i;
        i = j;
        j = temp;
    }
}
