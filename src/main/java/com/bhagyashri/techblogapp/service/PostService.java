package com.bhagyashri.techblogapp.service;

import com.bhagyashri.techblogapp.dto.PostDto;

import java.util.List;

public interface PostService {


    List<PostDto> findAllposts();
    List<PostDto> findPostsByUser();
    void createPost(PostDto postDto);
    PostDto findPostById(Long postId);
    void updatePost(PostDto postDto);
    void deletePost(Long postId);

    PostDto findPostByUrl(String postUrl);

    List<PostDto>searchPosts(String query);
}
