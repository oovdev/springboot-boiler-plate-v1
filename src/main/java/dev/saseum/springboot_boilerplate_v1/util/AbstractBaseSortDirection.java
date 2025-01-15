package dev.saseum.springboot_boilerplate_v1.util;

import org.springframework.data.domain.Sort;

public abstract class AbstractBaseSortDirection {
    /**
     * @param sort String
     * @return Sort.Direction
     */
    protected static Sort.Direction getDirection(final String sort) {
        if ("desc".equalsIgnoreCase(sort)) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }
}
