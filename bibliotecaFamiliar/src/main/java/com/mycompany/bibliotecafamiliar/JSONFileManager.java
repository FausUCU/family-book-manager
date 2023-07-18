package com.mycompany.bibliotecafamiliar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONFileManager {
    private List<JSONObject> jsonFiles;

    public JSONFileManager() {
        jsonFiles = new ArrayList<>();
    }

    public List<JSONObject> getJsonFiles() {
        return jsonFiles;
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

    public List<JSONObject> readListOfJsonsFromFile(String filePath) {
        List<JSONObject> jsonList = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));

            if (obj instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) obj;
                for (Object item : jsonArray) {
                    if (item instanceof JSONObject) {
                        jsonList.add((JSONObject) item);
                    }
                }
            } else if (obj instanceof JSONObject) {
                jsonList.add((JSONObject) obj);
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading JSON file: " + filePath);
            e.printStackTrace();
        }

        return jsonList;
    }
}
