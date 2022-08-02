package com.workshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class CommentDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6474590900115955740L;

    private Date date;
    private String text;
    private AuthorDTO author;

    public CommentDTO(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

}
