package com.realworld.dto;

import com.realworld.dto.CursorPager;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CursorPageParameter<T> {
    private static final int MAX_LIMIT = 1000;
    private int limit = 20;
    private T cursor;
    private CursorPager.Direction direction;

    public CursorPageParameter(T cursor, int limit, CursorPager.Direction direction) {
        setLimit(limit);
        setCursor(cursor);
        setDirection(direction);
    }

    public boolean isNext() {
        return direction == CursorPager.Direction.NEXT;
    }

    public int getQueryLimit() {
        return limit + 1;
    }

    private void setCursor(T cursor) {
        this.cursor = cursor;
    }

    private void setLimit(int limit) {
        if (limit > MAX_LIMIT) {
            this.limit = MAX_LIMIT;
        } else if (limit > 0) {
            this.limit = limit;
        }
    }
}

