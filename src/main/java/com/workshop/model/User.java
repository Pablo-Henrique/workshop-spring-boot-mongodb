package com.workshop.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@Document(collection = "user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 7189149854250575515L;

    @Id
    private String id;
    private String name;
    private String email;
}
