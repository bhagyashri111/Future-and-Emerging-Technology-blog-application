package com.bhagyashri.techblogapp.repository;

import com.bhagyashri.techblogapp.TechblogappApplicationTests;
import com.bhagyashri.techblogapp.entity.Post;
import com.bhagyashri.techblogapp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest extends TechblogappApplicationTests {

    @Test
    void
    findByUrl() {
        Optional<Post> post = postRepository.findByUrl("post-url");
        assertEquals(post.get().getTitle(), "post-title");
    }

    @Test
    void searchPosts() {
       List<Post> posts = postRepository.searchPosts("demo");
       assertEquals(2, posts.size());
       assertEquals(posts.get(0).getTitle(), "demo-post");
       assertEquals(posts.get(1).getTitle(), "some-post");
    }

    @Test
    void findPostsByUser() {
        User user = userRepository.findByEmail("peter@marvels.com");
        List<Post> post = postRepository.findPostsByUser(user.getId());
        assertEquals(post.get(0).getTitle(), "title");

    }
}