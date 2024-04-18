package com.example.ratelimitserver;

import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;

public class Test {

    public static void main(String[] args) {
        IgniteConfiguration igniteCfg = new IgniteConfiguration();
        //setting a work directory
        igniteCfg.setWorkDirectory("/path/to/work/directory");

        //defining a partitioned cache
        CacheConfiguration cacheCfg = new CacheConfiguration("myCache");
        cacheCfg.setCacheMode(CacheMode.PARTITIONED);

        igniteCfg.setCacheConfiguration(cacheCfg);
    }
}
