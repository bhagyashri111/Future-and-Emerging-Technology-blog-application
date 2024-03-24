package com.bhagyashri.techblogapp.service.impl;

import com.bhagyashri.techblogapp.dto.CommentDto;
import com.bhagyashri.techblogapp.entity.Comment;
import com.bhagyashri.techblogapp.entity.Post;
import com.bhagyashri.techblogapp.entity.User;
import com.bhagyashri.techblogapp.mapper.CommentMapper;
import com.bhagyashri.techblogapp.repository.CommentRepository;
import com.bhagyashri.techblogapp.repository.PostRepository;
import com.bhagyashri.techblogapp.repository.UserRepository;
import com.bhagyashri.techblogapp.service.CommentService;
import com.bhagyashri.techblogapp.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository,
                              UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {

        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto);
        comment.setPost(post);
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDto> findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentMapper::mapToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDto> findCommentsByPost() {
        String email = SecurityUtils.getCurrentUser().getUsername();
        User createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Comment> comments= commentRepository.findCommentByPost(userId);
        return comments.stream()
                .map((comment) -> CommentMapper.mapToCommentDto(comment))
                .collect(Collectors.toList());
    }


}
