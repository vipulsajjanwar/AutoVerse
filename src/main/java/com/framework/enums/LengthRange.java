package com.framework.enums;

public enum LengthRange {
	
	GROUP_NAME(2, 255),
	GROUP_DESCRIPTION(1, 255),
    NONE(0, Integer.MAX_VALUE);

    private final int min;
    private final int max;

    LengthRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
