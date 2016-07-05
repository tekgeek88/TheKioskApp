package com.thekioskapp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * This class loads all Properties so that the classes which use them only need
 * to load them once. Each property will be used application-wide, and only one
 * copy of each will exist if this class is used properly. This class will also
 * read from and save to various XML Properties files. This class is also
 * observable to allow other classes to be notified of changes to these
 * Properties.
 * 
 * @author Joshua Neighbarger
 */
public final class PropertiesManager {
    /** The only instance of this. */
    private static final PropertiesManager INSTANCE = new PropertiesManager();
    /** String path to the directory that contains each of the configurable properties. */
    private static final String PATH = "./config";
    /** The HashMap, which contains all configurable XMLProperties for this application. */
    private final HashMap<String, XMLProperties> propMap;
    
    /**
     * Private constructor to prevent external instantiation.
     */
    private PropertiesManager() {
    	propMap = new HashMap<>();
    	loadAllFromDirectory();
    }
    
    /**
     * Tries to load all XMLProperties files from a single directory.
     */
    private void loadAllFromDirectory() {
    	for (final File f : new File(PATH).listFiles()) {
    		if (f.isFile()) {
    			try {
					propMap.put(f.getAbsolutePath(), loadFromXML(f.getAbsolutePath()));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    }
    
    /**
     * Tries to generate and returns an XMLProperties object from the given path. 
     * 
     * @param thePath the String path which references the XMLProperties File.
     * @return the XMLProperties Object.
     */
    public static XMLProperties loadFromXML(final String thePath) throws FileNotFoundException, IOException {
    	if (INSTANCE.propMap.containsKey(thePath)) {
    		return INSTANCE.propMap.get(thePath);
    	} else {
    		final XMLProperties prop = new XMLProperties();
            prop.loadFromXML(new FileInputStream(new File(thePath)));
            INSTANCE.propMap.put(thePath, prop);
            return prop;
        }
    }
    
    /**
     * Tries to save the given Properties table to the given XML File. If the File
     * does not exist, it will be created.
     * 
     * @param theProperties the XMLProperties Object to save.
     * @param thePath the String path to the File to save to.
     * @param theComment the comment to leave.
     */
    public static void saveToXML(final XMLProperties theProperties, final String thePath, 
                                 final String theComment) {
        try {
            theProperties.storeToXML(new FileOutputStream(new File(thePath)), theComment);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
    
}
