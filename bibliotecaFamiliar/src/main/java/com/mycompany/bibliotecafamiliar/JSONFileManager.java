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

    public void addJsonFile(JSONObject json, String filePath) throws IOException, ParseException {
        List<JSONObject> existingJsonList = readListOfJsonsFromFile(filePath);
        existingJsonList.add(json);

        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(existingJsonList);

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            System.out.println("JSON file updated with the new JSON object.");
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + filePath);
            throw e;
        }
    }

    public List<JSONObject> getJsonObjectsWithKey(String key, Object value, String filePath) throws ParseException, IOException {
        List<JSONObject> matchingJsonObjects = new ArrayList<>();

        List<JSONObject> existingJsonList = readListOfJsonsFromFile(filePath);
        for (JSONObject json : existingJsonList) {
            if (json.containsKey(key)) {
                Object jsonValue = json.get(key);
                if (jsonValue instanceof Number && value instanceof Number) {
                    Number jsonNumber = (Number) jsonValue;
                    Number searchNumber = (Number) value;
                    if (jsonNumber.doubleValue() == searchNumber.doubleValue()) {
                        matchingJsonObjects.add(json);
                    }
                } else if (jsonValue != null && jsonValue.equals(value)) {
                    matchingJsonObjects.add(json);
                }
            }
        }

        return matchingJsonObjects;
    }

    private void updateJsonValue(JSONObject json, String key, Object newValue) {
        json.put(key, newValue);
    }
       
    public boolean findAndEditJsonObject(String key, Object valueToFind, String keyToEdit, Object newValue, String filePath) {
        try {
            List<JSONObject> existingJsonList = readListOfJsonsFromFile(filePath);
            for (JSONObject json : existingJsonList) {
                if (json.containsKey(key)) {
                    Object jsonValue = json.get(key);
                    if (jsonValue instanceof Number && valueToFind instanceof Number) {
                        Number jsonNumber = (Number) jsonValue;
                        Number searchNumber = (Number) valueToFind;
                        if (jsonNumber.doubleValue() == searchNumber.doubleValue()) {
                            updateJsonValue(json, keyToEdit, newValue);
                            saveJsonListToFile(existingJsonList, filePath);
                            return true; 
                        }
                    } else if (jsonValue != null && jsonValue.equals(valueToFind)) {
                        updateJsonValue(json, keyToEdit, newValue);
                        saveJsonListToFile(existingJsonList, filePath);
                        return true; 
                    }
                }
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error reading/writing JSON file: " + filePath);
            e.printStackTrace();
        }

        return false; 
    }

    private void saveJsonListToFile(List<JSONObject> jsonList, String filePath) throws ParseException, IOException {
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(jsonList);

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            System.out.println("JSON file updated with the edited JSON object.");
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + filePath);
            throw e;
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

    
    private Object parseNumericValue(String value) {
        try {
            if (value.contains(".")) {
                return Double.parseDouble(value);
            } else {
                return Long.parseLong(value);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numeric value: " + value);
            e.printStackTrace();
        }
        return value; 
    }
}