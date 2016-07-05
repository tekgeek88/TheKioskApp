package com.thekioskapp.util;

import java.util.Properties;

/**
 * This class extends the java.util.Properties class to allow cleaner String conversion.
 * 
 * @author Joshua Neighbarger
 */
public final class XMLProperties extends Properties {
    /** Automatically generated serial version. */
    private static final long serialVersionUID = -8530210109827260735L;

    /**
     * Tries to return an int value of the given property.
     * 
     * @param theKey the property to find.
     * @return the int value of the property.
     */
    public int getAsInt(final String theKey) {
        return Integer.valueOf(getProperty(theKey));
    }
    
    /**
     * Tries to return an double value of the given property.
     * 
     * @param theKey the property to find.
     * @return the double value of the property.
     */
    public double getAsDouble(final String theKey) {
        return Double.valueOf(getProperty(theKey));
    }
    
}