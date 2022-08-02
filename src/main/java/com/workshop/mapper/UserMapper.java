package com.workshop.mapper;

import com.workshop.dto.UserDTO;
import com.workshop.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    @Autowired
    private ModelMapper mapper;

    public <D> D map(Object source, Class<D> destinationType) {
        Assert.notNull(source, "source");
        Assert.notNull(destinationType, "destinationType");
        return mapper.map(source, destinationType);
    }

    public UserDTO converterEntityToDTO(User entity) {
        return mapper.map(entity, UserDTO.class);
    }

    public User converterDtoToEntity(UserDTO dto) {
        return mapper.map(dto, User.class);
    }

    public List<UserDTO> converterListEntityToDTO(List<User> entity) {
        return entity.stream().map(this::converterEntityToDTO).collect(Collectors.toList());
    }
}
