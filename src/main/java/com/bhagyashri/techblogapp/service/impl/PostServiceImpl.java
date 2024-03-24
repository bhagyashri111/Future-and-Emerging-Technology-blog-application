package com.bhagyashri.techblogapp.service.impl;

import com.bhagyashri.techblogapp.dto.PostDto;
import com.bhagyashri.techblogapp.entity.Post;
import com.bhagyashri.techblogapp.entity.User;
import com.bhagyashri.techblogapp.mapper.PostMapper;
import com.bhagyashri.techblogapp.repository.PostRepository;
import com.bhagyashri.techblogapp.repository.UserRepository;
import com.bhagyashri.techblogapp.service.PostService;
import com.bhagyashri.techblogapp.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
@Component
public class PostServiceImpl implements PostService {



    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository,UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PostDto> findAllposts() {
        List<Post> posts=postRepository.findAll();
        return posts.stream().map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findPostsByUser() {
        String email = SecurityUtils.getCurrentUser().getUsername();
        userRepository.findByEmail(email);
        User createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Post>posts = postRepository.findPostsByUser(userId);
        return posts.stream()
                .map((post) -> PostMapper.mapToPostDto(post))
                .collect(Collectors.toList());

    }

    @Override
    public void createPost(PostDto postDto) {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User user = userRepository.findByEmail(email);
        Post post = PostMapper.mapToPost(postDto);
        post.setCreatedBy(user);
        postRepository.save(post);

    }

    @Override
    public PostDto findPostById(Long postId) {
        Post post= postRepository.findById(postId).get();
        return PostMapper.mapToPostDto(post);

    }

    @Override
    public void updatePost(PostDto postDto) {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User createdBy = userRepository.findByEmail(email);
        Post post = PostMapper.mapToPost(postDto);
        post.setCreatedBy(createdBy);
        postRepository.save(post);

    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public PostDto findPostByUrl(String postUrl) {
        Post post =postRepository.findByUrl(postUrl).get();
       return PostMapper.mapToPostDto(post);
    }


    @Override
    public List<PostDto> searchPosts(String query) {
        List<Post> posts = postRepository.searchPosts(query);
        return posts.stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

}
