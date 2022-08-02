package com.workshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6474590900115955740L;

    private String id;
    private Date date;
    private AuthorDTO author;

}
