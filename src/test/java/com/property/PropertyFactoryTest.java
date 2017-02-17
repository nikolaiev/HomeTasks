package com.property;


import com.flower.Flower;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by vlad on 17.02.17.
 */
public class PropertyFactoryTest {
    PropertyFactory propertyFactory=new PropertyFactory();

    @Test
    public void createPropertyNormal() throws Exception {
        Property property=propertyFactory.createProperty(PropertyType.HERB);
        assertEquals(Herb.class,property.getClass());
    }

    /*illegal price*/
    @Test(expected = IllegalArgumentException.class)
    public void createPropertyException() throws Exception {
        Property property=propertyFactory.createProperty(PropertyType.HERB,-10);
    }

    /*null price exception*/
    @Test(expected = IllegalArgumentException.class)
    public void createPropertyNullException() throws Exception {
        Property property=propertyFactory.createProperty(null);
    }

    /*Specific prices constructor test*/
    @Test
    public void constructorTestSpecific(){
        /*Herb - grace*/
        final double price=223.1;
        PropertyFactory propertyFactory=new PropertyFactory(new HashMap<PropertyType, Double>(){{
            put(PropertyType.HERB,price);
        }});

        Property property=propertyFactory.createProperty(PropertyType.HERB);
        assertEquals(price,property.getPrice(),0.001);
    }
}