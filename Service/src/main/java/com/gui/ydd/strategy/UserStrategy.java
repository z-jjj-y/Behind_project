package com.gui.ydd.strategy;

import java.util.Map;

public interface UserStrategy {
    Object execute(String key, Map<String, String> params);
}
