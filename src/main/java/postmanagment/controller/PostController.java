package postmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import postmanagment.dto.PostDto;
import postmanagment.service.PostService;

import java.util.Optional;

@RestController

public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public Iterable<PostDto> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/posts/{postId}")
    private ResponseEntity<PostDto> gePost(@PathVariable("postId") Long postId)
    {
        Optional<PostDto> post = postService.findById(postId);
        if (!post.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(post.get());
    }
}