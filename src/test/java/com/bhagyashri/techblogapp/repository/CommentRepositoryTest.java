package com.bhagyashri.techblogapp.repository;

import com.bhagyashri.techblogapp.TechblogappApplicationTests;
import com.bhagyashri.techblogapp.dto.RegistrationDto;
import com.bhagyashri.techblogapp.entity.Comment;
import com.bhagyashri.techblogapp.entity.User;
import com.bhagyashri.techblogapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommentRepositoryTest extends TechblogappApplicationTests {

@Autowired
CommentRepository commentRepository;

@Autowired
    UserService userService;

@Autowired
UserRepository userRepository;

    @Test
    void findCommentByPost() {
        User user = userRepository.findByEmail("peter@marvels.com");
        List<Comment> comments  = commentRepository.findCommentByPost(user.getId());
        assertEquals(comments.get(0).getContent(), "Good Post");
    }
}