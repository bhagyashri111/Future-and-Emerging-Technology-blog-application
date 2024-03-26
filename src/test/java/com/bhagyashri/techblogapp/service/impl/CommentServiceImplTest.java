package com.bhagyashri.techblogapp.service.impl;

import com.bhagyashri.techblogapp.TechblogappApplicationTests;
import com.bhagyashri.techblogapp.dto.CommentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceImplTest extends TechblogappApplicationTests {

    @Autowired
    CommentServiceImpl commentService;

    @Test
    void findAllComments() {
        List<CommentDto> comments = commentService.findAllComments();
        assertEquals(2, comments.size());
        assertEquals(comments.get(0).getName(),"abc");
        assertEquals(comments.get(1).getName(),"xyz");

    }
}