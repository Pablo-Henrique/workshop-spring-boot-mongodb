package com.workshop.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 7189149854250575515L;

    @Id
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true)
    @Setter(value = AccessLevel.NONE)
    private List<Post> posts = new ArrayList<>();
}
