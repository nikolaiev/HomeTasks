package com.task17;

import com.task17.components.Component;
import com.task17.components.Number;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * Created by vlad on 06.03.17.
 */
public class CompositeTest {
    Composite composite;
    String expression;
    Method makeComponentFromStack;

    @Before
    public void init() throws NoSuchMethodException {
        expression="(9+2^2)*2-3*(3-3+4*17)";
        composite=new Composite(expression);
        makeComponentFromStack=Composite.class.getDeclaredMethod("makeComponentFromStack",char.class,LinkedList.class);
        makeComponentFromStack.setAccessible(true);

    }

    @Test
    public void makeComponentFromStackPlus() throws Exception {

        LinkedList<Component> components=new LinkedList<Component>(){{
            add(new Number(10));
            add(new Number(20));
        }};
        makeComponentFromStack.invoke(new Composite(""),'+',components);
        assertEquals(30,components.getFirst().calculate());
    }

    @Test
    public void makeComponentFromStackSub() throws Exception {
      LinkedList<Component> components=new LinkedList<Component>(){{
            add(new Number(15));
            add(new Number(23));
        }};
        makeComponentFromStack.invoke(new Composite(""),'-',components);
        assertEquals(-8,components.getFirst().calculate());
    }

    @Test
    public void makeComponentFromStackMul() throws Exception {

        LinkedList<Component> components=new LinkedList<Component>(){{
            add(new Number(15));
            add(new Number(15));
        }};

        makeComponentFromStack.invoke(new Composite(""),'*',components);
        assertEquals(225,components.getFirst().calculate());
    }

    @Test
    public void makeComponentFromStackPow() throws Exception {

        LinkedList<Component> components=new LinkedList<Component>(){{
            add(new Number(3));
            add(new Number(3));
        }};

        makeComponentFromStack.invoke(new Composite(""),'^',components);
        assertEquals(27,components.getFirst().calculate());
    }

    /*test tree calculation*/
    @Test
    public void calculate() throws Exception {
        assertEquals(composite.calculate(),-178);
    }
}