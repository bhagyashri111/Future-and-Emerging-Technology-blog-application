package com.bhagyashri.techblogapp.controller;

import com.bhagyashri.techblogapp.dto.CommentDto;
import com.bhagyashri.techblogapp.dto.PostDto;
import com.bhagyashri.techblogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class BlogController {

    private PostService postService;

    // @Autowired
    public BlogController(PostService postService) {
        this.postService = postService;
    }
    private static final Logger logger = Logger.getLogger(BlogController.class.getName());


    // handler method to handle http://localhost:8080/
    @GetMapping("/")
    public String viewBlogPosts(Model model){
        List<PostDto> postsResponse = postService.findAllposts();
        logger.info("Get blogs response " + postsResponse);
        model.addAttribute("postsResponse", postsResponse);
        return "blog/view_posts";
    }


    // handler method to handle view post request
    @GetMapping("/post/{postUrl}")
    private String showPost(@PathVariable("postUrl") String postUrl,
                            Model model){
        PostDto post = postService.findPostByUrl(postUrl);

        CommentDto commentDto = new CommentDto();
        model.addAttribute("post", post);
        logger.info("Comments " + commentDto);
        model.addAttribute("comment", commentDto);
        return "blog/blog_post";
    }
    // handler method to handle blog post search request
    // http://localhost:8080/page/search?query=java
    @GetMapping("/page/search")
    public String searchPosts(@RequestParam(value = "query") String query,
                              Model model){
        List<PostDto> postsResponse = postService.searchPosts(query);
        logger.info("Search blogs response " + postsResponse);
        model.addAttribute("postsResponse", postsResponse);
        return "blog/view_posts";
    }
}

