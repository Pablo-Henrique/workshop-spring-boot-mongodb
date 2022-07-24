package com.workshop.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6415235214704777746L;

    @Id
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String email;

}
