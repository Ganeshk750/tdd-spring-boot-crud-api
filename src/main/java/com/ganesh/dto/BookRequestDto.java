package com.ganesh.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @created: 29/09/2021 - 11:19 AM
 * @author: Ganesh
 */

@Data
public class BookRequestDto {

    @NotEmpty
    private String title;

    @NotEmpty
    @Size(max = 20)
    private String isbn;

    @NotEmpty
    private String author;
}
