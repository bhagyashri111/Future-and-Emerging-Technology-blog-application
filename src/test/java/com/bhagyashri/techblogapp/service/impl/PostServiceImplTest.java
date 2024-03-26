package com.bhagyashri.techblogapp.service.impl;

import com.bhagyashri.techblogapp.TechblogappApplicationTests;
import com.bhagyashri.techblogapp.dto.PostDto;
import com.bhagyashri.techblogapp.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest extends TechblogappApplicationTests {

    @Autowired
    PostServiceImpl postService;
    @Test
    void findPostByUrl() {
        PostDto post = postService.findPostByUrl("some-post-url");
        assertEquals("some-post", post.getTitle());
        assertEquals("demo post", post.getShortDescription());
    }

}