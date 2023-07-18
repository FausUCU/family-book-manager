package com.mycompany.bibliotecafamiliar;

public import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONFileManager {
    private List<JSONObject> jsonFiles;

    public JSONFileManage
impor() {
        jsonFiles = new ArrayList<>();
    }

    public List<JSONObject> getJsonFiles() {
        return jsonFiles;
    }

    public void readJsonFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".json")) {
                    try {
                        JSONParser parser = new JSONParser();
                        Object obj = parser.parse(new FileReader(file));
                        JSONObject json = (JSONObject) obj;
                        jsonFiles.add(json);
                    } catch (IOException | ParseException e) {
                        System.out.println("Error reading JSON file: " + file.getName());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void addJsonFile(JSONObject json, String filePath) {
        jsonFiles.add(json);

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(json.toJSONString());
            System.out.println("JSON file added: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + filePath);
            e.printStackTrace();
        }
    }
}
t java.text.ParseException;
    
}
