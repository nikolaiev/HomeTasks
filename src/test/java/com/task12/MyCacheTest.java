package com.task12;

import com.task15.MyPriorityQueue;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by vlad on 24.02.17.
 */
public class MyCacheTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private MyCache myChache;
    @Before
    public void init(){
        myChache=new MyCache (1000);
        System.setOut(new PrintStream(outContent));
    }

    /*constructor test*/
    @Test(expected = IllegalArgumentException.class)
    public void createObjException(){
        MyCache cache=new MyCache(-1);
    }

    /*constructor test*/
    @Test
    public void createObjSpecificCacheLiveTime(){
        long cacheLiveTime;
        MyCache cache;

        for(int i=0;i<100;i++) {
            cacheLiveTime = new Random().nextInt(Integer.MAX_VALUE) + 1;
            cache = new MyCache(cacheLiveTime);
            assertEquals(cacheLiveTime, cache.getCacheLiveTime());
        }
    }

    @Test(expected = NoSuchFileException.class)
    public void fileAccessException() throws IOException {
            myChache.getFileStream(".txt");
    }

    @Test
    public void getFileStreamFromCache() throws Exception {
        ByteArrayInputStream stream=myChache.getFileStream("books.zip");
        ByteArrayInputStream stream2=myChache.getFileStream("books.zip");
        assertEquals("From filesystem!\n" +
                "From cache\n",outContent.toString());
    }

    @Test
    public void getFileStreamFromFileSystemOld() throws Exception {
        ByteArrayInputStream stream=myChache.getFileStream("books.zip");

        Thread.sleep(myChache.getCacheLiveTime());

        ByteArrayInputStream stream2=myChache.getFileStream("books.zip");
        assertEquals("From filesystem!\n" +
                "From filesystem!\n",outContent.toString());
    }

    @Test
    public void getFileStreamFromFileSystem() throws Exception {
        String title="books.zip";

        ByteArrayInputStream stream=myChache.getFileStream(title);
        stream=null;

        ArrayList<SoftReference<byte[]>> refs=new ArrayList<>();

        for(int i=0;i<20;i++){
            refs.add(new SoftReference<>(Files.readAllBytes(Paths.get(title))));
        }

        stream=myChache.getFileStream(title);

        assertEquals("From filesystem!\n" +
                "From filesystem!\n",outContent.toString());
    }

}