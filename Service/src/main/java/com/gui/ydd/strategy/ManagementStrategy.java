package com.gui.ydd.strategy;

import java.util.Map;

public interface ManagementStrategy<T> {
    Object execute(String operation, Map<String, Object> params);
}
