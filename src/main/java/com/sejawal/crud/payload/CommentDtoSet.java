package com.sejawal.crud.payload;

import com.sejawal.crud.entity.Comment;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CommentDtoSet {
    private long postId;
    private Set<CommentDto> commentDtoSet = new HashSet<>();

}
