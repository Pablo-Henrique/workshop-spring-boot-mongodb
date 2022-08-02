package com.workshop.mapper;

import com.workshop.dto.AuthorDTO;
import com.workshop.model.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostMapper {

    @Autowired
    private ModelMapper mapper;

    public AuthorDTO converterEntityToDTO(Post entity) {
        return mapper.map(entity, AuthorDTO.class);
    }

    public Post converterDtoToEntity(AuthorDTO dto) {
        return mapper.map(dto, Post.class);
    }
}
