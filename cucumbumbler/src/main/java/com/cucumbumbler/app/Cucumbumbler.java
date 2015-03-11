package com.cucumbumbler.app;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cucumbumbler
{    
    public Boolean thereAreFeatureFilesPresent(String feature_folder) {
    	Path feature_path = Paths.get(feature_folder);
        return Files.exists(feature_path);
    }

}