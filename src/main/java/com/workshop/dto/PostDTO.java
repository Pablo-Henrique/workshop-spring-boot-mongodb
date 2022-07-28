package com.workshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class PostDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7662381501090821364L;

    private String id;
    private String name;

}
