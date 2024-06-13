package com.example.demo.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Operation(security = {@SecurityRequirement(name = "DemoSecurityScheme")})
    @GetMapping 
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    } 

    @Operation(security = {@SecurityRequirement(name = "DemoSecurityScheme")})
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer id) {
        PostDto post = postService.getPostById(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    @Operation(security = {@SecurityRequirement(name = "DemoSecurityScheme")})
    @PostMapping
    public PostDto createPost(@RequestBody /* @Valid */ PostDto postDto) {
        return postService.savePost(postDto);
    }

    @Operation(security = {@SecurityRequirement(name = "DemoSecurityScheme")})
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Integer id, @RequestBody PostDto postDto) {
        PostDto existingPost = postService.getPostById(id);
        if (existingPost == null) {
            return ResponseEntity.notFound().build();
        }
        postDto.setUserId(postDto.getUserId());
        return ResponseEntity.ok(postService.savePost(postDto));
    }

    @Operation(security = {@SecurityRequirement(name = "DemoSecurityScheme")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

}
