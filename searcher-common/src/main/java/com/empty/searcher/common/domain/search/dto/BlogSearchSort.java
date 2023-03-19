package com.empty.searcher.common.domain.search.dto;

public enum BlogSearchSort {
    ACCURACY,
    RECENCY;

    public static BlogSearchSort valueOfSort(String sort) {
        for (BlogSearchSort value : BlogSearchSort.values()) {
            if (value.name().equals(sort)) {
                return value;
            }
        }

        return null;
    }
}
