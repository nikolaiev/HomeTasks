package com.task12;

import com.task11.MyFactory;

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
    private Map<String,SoftReference<byte[]>> globalCache;

    public MyCache(){
        globalCache=new HashMap<>();
    }

    public synchronized ByteArrayInputStream getFileStream(String title) throws IOException {
        SoftReference<byte[]> content=globalCache.get(title);
        byte[] cache = content==null? null:content.get();

        if (cache == null) {
            System.out.println("From filesystem!");
            cache=Files.readAllBytes(Paths.get(title));
            content = new SoftReference<>(cache);
            globalCache.put(title,content);
        }
        else {
            System.out.println("From cache");
        }
        return new ByteArrayInputStream(cache);
    }
}
