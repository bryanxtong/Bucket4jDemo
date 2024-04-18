package com.giffing.bucket4j.spring.boot.starter.config.cache;

import com.giffing.bucket4j.spring.boot.starter.config.cache.Bucket4jCacheConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.cache.ignite.IgniteBucket4jCacheConfiguration;
import com.giffing.bucket4j.spring.boot.starter.config.condition.ConditionalOnBucket4jEnabled;
import com.giffing.bucket4j.spring.boot.starter.config.filter.reactive.webflux.Bucket4JAutoConfigurationWebfluxFilter;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnBucket4jEnabled
@AutoConfigureAfter({CacheAutoConfiguration.class, Bucket4jCacheConfiguration.class})
@AutoConfigureBefore({Bucket4JAutoConfigurationWebfluxFilter.class})
@Import(value = {
        IgniteBucket4jCacheConfiguration.class
})
public class Bucket4jIgniteConfiguration {
}

