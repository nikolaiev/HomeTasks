package com.property;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vlad on 17.02.17.
 */
public class PropertyTest {
    PropertyFactory propertyFactory=new PropertyFactory();

    @Test
    public void getPrice() throws Exception {
        double price=20;
        Property property=propertyFactory.createProperty(PropertyType.HERB,price);
        assertEquals(price,property.getPrice(),0.001);
    }

    @Test
    public void getMaxCount() throws Exception {
        double price=20;
        Property property=propertyFactory.createProperty(PropertyType.HERB,price);
        assertEquals(price,property.getMaxCount(),20);
    }

}