package com.task12;

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

import static org.junit.Assert.*;

/**
 * Created by vlad on 24.02.17.
 */
public class MyCacheTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private MyCache myChache;
    @Before
    public void init(){
        myChache=new MyCache ();
        System.setOut(new PrintStream(outContent));
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