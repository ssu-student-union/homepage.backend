package ussum.homepage.application.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ussum.homepage.global.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class PostController {

    @GetMapping("/{boardcodeid}/posts/{postid}")
    public ApiResponse<?> getBoardPost() {

        return null;
    }

    @GetMapping("/{boardcode}/posts/")
    public ApiResponse<?> getBoardPostsList() {

        return null;
    }

    @PostMapping("/{boardcode}/posts")
    public ApiResponse<?> createBoardPost() {

        return null;
    }

    @PatchMapping("/{boardcode}/posts/{postid}")
    public ApiResponse<?> editBoardPost() {

        return null;
    }

    @DeleteMapping("/{boardcodeid}/posts/{postid}")
    public ApiResponse<?> deleteBoardPost() {

        return null;
    }

    @GetMapping("/{boardcodeid}/posts/search")
    public ApiResponse<?> searchBoardPost() {

        return null;
    }


}
