package com.task12;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vlad on 21.02.17.
 */

public class MyCache {
    private long CACHE_LIVE_TIME = 10_000;//cache Item Live Time

    private Map<String, CacheItem> globalCache; //global items' cache

    /**
     * Empty Constructor
     */
    public MyCache() {
        globalCache = new HashMap<>();
    }

    /**
     * Constructor
     * @param cacheLiveTime specific cache live time
     */
    public MyCache(long cacheLiveTime) {
        if(cacheLiveTime<0){
            throw new IllegalArgumentException();
        }

        CACHE_LIVE_TIME=cacheLiveTime;
        globalCache = new HashMap<>();
    }

    /**
     * @return CACHE_LIVE_TIME
     */
    public long getCacheLiveTime(){
        return CACHE_LIVE_TIME;
    }

    /**
     *
     * @param title file name
     * @return ByteArrayInputStream of file
     * @throws IOException file read exception
     */
    public synchronized ByteArrayInputStream getFileStream(String title) throws IOException {
        /*try to get element from cache*/
        CacheItem cacheItem = globalCache.get(title);

        /*item context*/
        byte[] cacheItemContext = null;

        /*get item context from cache if possible*/
        if (cacheItem != null && cacheItem.context.get() != null) {
            /*check for cache item expiration live time*/
            if (System.currentTimeMillis() - cacheItem.creationTime < CACHE_LIVE_TIME) {
                cacheItemContext = cacheItem.context.get();
            } else {
                cacheItemContext = null;
            }
        }

        /*return item context*/
        if (cacheItemContext == null) {
            System.out.println("From filesystem!");

            cacheItemContext = Files.readAllBytes(Paths.get(title));
            cacheItem = new CacheItem(cacheItemContext);

            /*add new item to cache*/
            globalCache.put(title, cacheItem);

        } else {//cache was not allowed for specific file
            System.out.println("From cache");
        }

        return new ByteArrayInputStream(cacheItemContext);
    }

    /**
     * Class to store SoftReference to file context and it's creation time
     */
    private static class CacheItem {
        /*ref to context*/
        SoftReference<byte[]> context;
        /*creation time*/
        long creationTime;

        /**
         * Creates new item from specific param
         * @param context file's context
         */
        private CacheItem(byte[] context) {
            this.context = new SoftReference<>(context);
            creationTime = System.currentTimeMillis();
        }
    }
}
