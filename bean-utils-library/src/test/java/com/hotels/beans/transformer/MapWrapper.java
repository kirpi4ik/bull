package com.hotels.beans.transformer;

import java.util.Map;

/**
 *
 */
public class MapWrapper {
    public Map<String, Object> map;

    public MapWrapper setMap(Map<String, Object> map) {
        this.map = map;
        return this;
    }
}
