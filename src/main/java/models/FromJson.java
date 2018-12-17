package models;

import processing.data.JSONObject;

public interface FromJson<T> {
    T fromJson(JSONObject json);
}
