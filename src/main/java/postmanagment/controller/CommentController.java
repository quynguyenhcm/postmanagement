package postmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import postmanagment.dto.CommentDto;
import postmanagment.dto.PostDto;
import postmanagment.service.CommentService;
import postmanagment.service.PostService;

import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<Iterable<CommentDto>> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        Optional<PostDto> post = postService.findById(postId);
        if (!post.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(commentService.findByPostId(postId));
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    private Optional<CommentDto> getCommentByPostIdAndCommentId( @PathVariable("commentId") Long commentId, @PathVariable("postId") Long postId)
    {
        return commentService.findByIdAndPostId(commentId, postId);
    }
}