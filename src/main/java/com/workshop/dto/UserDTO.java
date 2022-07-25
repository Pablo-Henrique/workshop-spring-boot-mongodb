package com.workshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -6415235214704777746L;

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String email;

}
