package com.task23;

import com.task23.states.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by vlad on 10.03.17.
 */
public class GrantTest {
    Grant grant;
    Field stateField;
    @Before
    public void init() throws NoSuchFieldException {
        grant=new Grant();
        stateField=Grant.class.getDeclaredField("state");
        stateField.setAccessible(true);
    }
    @Test
    public void setState() throws Exception {
        State newState=new Considering(grant);

        grant.setState(newState);

        State state= (State) stateField.get(grant);

        assertEquals(state,newState);
    }

    @Test
    public void consider() throws Exception {
        grant.consider();

        State state= (State) stateField.get(grant);
        assert(state instanceof Considering);
    }

    @Test
    public void postpone() throws Exception {
        grant.consider();

        State state= (State) stateField.get(grant);
        assert(state instanceof Considering);
    }

    @Test
    public void deny() throws Exception {
        Grant grant=new Grant();
        grant.consider();
        grant.deny();

        State state= (State) stateField.get(grant);
        assert(state instanceof Denyed);
    }

    @Test
    public void accept() throws Exception {
        Grant grant=new Grant();
        grant.consider();
        grant.accept();

        State state= (State) stateField.get(grant);
        assert(state instanceof Accepted);
    }

    @Test
    public void withdraw() throws Exception {
        grant.withdraw();

        State state= (State) stateField.get(grant);
        assert(state instanceof Withdraw);
    }

}