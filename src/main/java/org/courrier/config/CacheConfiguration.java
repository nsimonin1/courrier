package org.courrier.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import javax.annotation.PreDestroy;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.Set;
import java.util.SortedSet;

/**
 * Created by SimonPascal on 04/17/2016.
 */
@Configuration
@EnableCaching
//@AutoConfigureAfter(value = { PersistenceContext.class })
@Slf4j
public class CacheConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    private net.sf.ehcache.CacheManager cacheManager;


    @PreDestroy
    public void destroy() {
        log.info("Closing Cache Manager");
        cacheManager.shutdown();
    }

    @Bean
    public CacheManager cacheManager() {
        final CourrierProperties courrierProperties=new CourrierProperties();
        log.debug("Starting Ehcache");
        cacheManager = net.sf.ehcache.CacheManager.create();
        cacheManager.getConfiguration().setMaxBytesLocalHeap(courrierProperties.getCache().getEhcache().getMaxBytesLocalHeap());
        log.debug("Registering Ehcache Metrics gauges");
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        for (EntityType<?> entity : entities) {

            String name = entity.getName();
            if (name == null || entity.getJavaType() != null) {
                name = entity.getJavaType().getName();
            }
            Assert.notNull(name, "entity cannot exist without a identifier");

            net.sf.ehcache.Cache cache = cacheManager.getCache(name);
           /* if (cache != null) {
                cache.getCacheConfiguration().setTimeToLiveSeconds(courrierProperties.getCache().getTimeToLiveSeconds());

                cacheManager.replaceCacheWithDecoratedCache(cache);
            }*/
        }
        EhCacheCacheManager ehCacheManager = new EhCacheCacheManager();
        ehCacheManager.setCacheManager(cacheManager);
        return ehCacheManager;
    }
}
