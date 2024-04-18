package com.giffing.bucket4j.spring.boot.starter.config.cache;

import com.giffing.bucket4j.spring.boot.starter.config.cache.hazelcast.HazelcastReactiveBucket4jCacheConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.cache.hazelcast.HazelcastSpringBucket4jCacheConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.cache.ignite.IgniteBucket4jCacheConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.cache.infinispan.InfinispanBucket4jCacheConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.cache.jcache.InfinispanJCacheBucket4jConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.cache.jcache.JCacheBucket4jConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.cache.redis.jedis.JedisBucket4jConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.cache.redis.lettuce.LettuceBucket4jConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.cache.redis.redisson.RedissonBucket4jConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.condition.ConditionalOnBucket4jEnabled;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Change to include IgniteBucket4jCacheConfiguration which support async
 *
 * Two Options
 * 1. Remove the customized Bucket4jCacheConfiguration.java and use another autoconfiguration Bucket4jIgniteConfiguration for Bucket4jIgniteConfiguration
 * 2. just use the current autoconfiguration which includes IgniteBucket4jCacheConfiguration.class
 */
@Configuration
@ConditionalOnBucket4jEnabled
@AutoConfigureAfter(CacheAutoConfiguration.class)
@Import(value = {
        JCacheBucket4jConfiguration.class,
        InfinispanJCacheBucket4jConfiguration.class,
        InfinispanBucket4jCacheConfiguration.class,
        HazelcastReactiveBucket4jCacheConfiguration.class,
        HazelcastSpringBucket4jCacheConfiguration.class,
        JedisBucket4jConfiguration.class,
        LettuceBucket4jConfiguration.class,
        RedissonBucket4jConfiguration.class,
        IgniteBucket4jCacheConfiguration.class
})
public class Bucket4jCacheConfiguration {
}