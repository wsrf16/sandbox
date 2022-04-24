package com.sandbox.console.ng;

import com.aio.portable.swiss.middleware.nginx.NginxConfig;
import com.github.odiszapc.nginxparser.NgxBlock;
import com.github.odiszapc.nginxparser.NgxConfig;
import com.github.odiszapc.nginxparser.NgxEntry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ngx {
    public static void todo() {
        try {
            ff("sandbox-console/target/classes/nginx.conf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void ff(String path) throws IOException {
        NgxConfig read = NgxConfig.read(path);

        ArrayList<String> params = new ArrayList<>();
        List<String> condition = new ArrayList<>();

//        {
//            params.add("http");
//            params.add("upstream");
//            condition.add("server 10.124.163.77:8080 weight=1;");
//        }

        {
            params.add("http");
            params.add("server");
            condition.add("listen 80;");
        }


        List<NgxBlock> blockWithAllInMatch = NginxConfig.findBlockWithAllInMatch(read, params, condition);
        ((List<NgxEntry>) blockWithAllInMatch.get(0).getEntries()).remove(1);

        NginxConfig.dump(read, new File("d:/1.txt").toPath());



    }







}
