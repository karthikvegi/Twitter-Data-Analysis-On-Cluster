/*
#
# Copyright 2014 The Trustees of Indiana University
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# -----------------------------------------------------------------
#
# Project: InstantKarma
# File:  PropertyReader.java
# Description:  Utility class for reading properties file
#
# -----------------------------------------------------------------
# 
*/

package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Yuan Luo (yuanluo@indiana.edu)
 *
 */
public class PropertyReader {
	//public static final Logger log = Logger.getLogger(PropertyReader.class);
	private static PropertyReader instance = null;
    private static Properties properties;
    
    private PropertyReader(String propertiesPath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(propertiesPath);
            properties = new Properties();
            properties.load(fileInputStream);
		} catch (IOException e) {
        	//log.error("[ERROR]",e);
            System.exit(-1);
        }
    }
    
    public static PropertyReader getInstance(String propertiesPath) {
        instance = new PropertyReader(propertiesPath);
        return instance;
    }
    
    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

}

