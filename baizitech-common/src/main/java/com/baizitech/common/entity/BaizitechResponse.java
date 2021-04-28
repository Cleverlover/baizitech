package com.baizitech.common.entity;

import java.util.HashMap;

public class BaizitechResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public BaizitechResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public BaizitechResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public BaizitechResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }
}
