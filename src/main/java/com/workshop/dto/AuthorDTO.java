package com.workshop.dto;

import com.workshop.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class AuthorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7662381501090821364L;

    private String id;
    private String name;

    public AuthorDTO(User user) {
        id = user.getId();
        name = user.getName();
    }
}
