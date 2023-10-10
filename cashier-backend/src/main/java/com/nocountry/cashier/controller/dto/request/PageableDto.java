package com.nocountry.cashier.controller.dto.request;

import lombok.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ROMULO
 * @package com.nocountry.cashier.controller.dto.request
 * @license Lrpa, zephyr cygnus
 * @since 10/10/2023
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageableDto implements Pageable, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer page;
    private Integer size;
    private Integer order;
    private String field;

    @Override
    public boolean isPaged() {
        return Pageable.super.isPaged();
    }

    @Override
    public int getPageNumber() {
        return 0;
    }

    @Override
    public int getPageSize() {
        return 0;
    }

    @Override
    public long getOffset() {
        return 0;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
