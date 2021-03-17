package com.shanezhou.springcloud.test;

import com.shanezhou.springcloud.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ShaneZhou
 * @since 2020/9/22 周二
 */
public class Test {

    public static void main(String[] args) {
        //List<User> samplesList = new ArrayList<>();
        //
        //List<Map<String, Object>> nameList = new ArrayList<>();
        //
        //for (int i = 0; i < samplesList.size() && i < 1; i++) {
        //    int finalI = i;
        //    nameList.add(new HashMap<String, Object>() {
        //        {
        //            put("value", samplesList.get(finalI).getName());
        //        }
        //    });
        //}

        System.out.println(new DecimalFormat("#.00").format(11.33333));
        System.out.println(new DecimalFormat("#.00").format(11.33733));
        System.out.println(String.format("%.1f", 11.367));
        System.out.println(String.format("%.1f", 21.363));
        double round = Math.round(1.232);
        System.out.println(round);
    }
}
