package com.factory;

import java.util.Random;

public final class SessionIdentifierGenerator {

    private SessionIdentifierGenerator(){};

    public static String getRandomString(){
        Random r = new Random();
        int stringLength=r.nextInt(10);
        StringBuilder sb= new StringBuilder();
        for(int j=0;j<stringLength;j++) {
            char c = (char) (r.nextInt(Character.MAX_VALUE));
            sb.append(c);
        }
        return sb.toString();
    }

}
