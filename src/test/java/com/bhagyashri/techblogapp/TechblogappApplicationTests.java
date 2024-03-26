package com.bhagyashri.techblogapp;

import com.bhagyashri.techblogapp.dto.RegistrationDto;
import com.bhagyashri.techblogapp.entity.Comment;
import com.bhagyashri.techblogapp.entity.Post;
import com.bhagyashri.techblogapp.entity.User;
import com.bhagyashri.techblogapp.mapper.PostMapper;
import com.bhagyashri.techblogapp.repository.CommentRepository;
import com.bhagyashri.techblogapp.repository.PostRepository;
import com.bhagyashri.techblogapp.repository.UserRepository;
import com.bhagyashri.techblogapp.service.UserService;
import com.bhagyashri.techblogapp.util.SecurityUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class TechblogappApplicationTests {
    @Autowired
    protected UserService userService;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
     protected PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @BeforeEach
    void init(){
        userService.saveUser(new RegistrationDto(null,"Peter", "Parker", "peter@marvels.com", "pass" ));

        User user = userRepository.findByEmail("peter@marvels.com");
        Post post1 = new Post(null, "post-title", "post-url", "some-content", "descr",
                LocalDateTime.now(), LocalDateTime.now(), user, null);
        postRepository.save(post1);

        Post post2 = new Post(null, "demo-post", "demo-post-url", "some-content", "descr",
                LocalDateTime.now(), LocalDateTime.now(), user, null);
        postRepository.save(post2);

        Post post3 = new Post(null, "some-post", "some-post-url", "some-content", "demo post",
                LocalDateTime.now(), LocalDateTime.now(), user, null);
        postRepository.save(post3);

        commentRepository.save(new Comment(null,"abc", "abc@z.com", "Good Post",null,null, post1));
        commentRepository.save(new Comment(null,"xyz", "xyz@z.com", "Great Info",null,null, post1));
    }


}
