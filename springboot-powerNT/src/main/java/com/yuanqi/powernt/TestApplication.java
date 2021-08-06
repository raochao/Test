package com.yuanqi.powernt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
//        try {
//            pnbclient.alias.SQLCommandService srv = new pnbclient.alias.SQLCommandService();
//            srv.setLangId("sc");
//            List list = srv.getList("find_all_user_sql");
//            System.out.println(list.size());
//        }catch(Exception e){
//            e.printStackTrace();
//        }

    }

}
