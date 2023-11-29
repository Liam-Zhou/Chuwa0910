package kechen.hw9springbootredbook.controller;

import kechen.hw9springbootredbook.payload.PostDto;
import kechen.hw9springbootredbook.payload.PostResponse;
import kechen.hw9springbootredbook.service.PostService;
import kechen.hw9springbootredbook.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto postResponse = postService.createPost(postDto);
        // 将创建的帖子的 PostDto 对象封装在 ResponseEntity 中并返回。
        // 同时，使用 HTTP 状态码 HttpStatus.CREATED 表示请求成功创建了一个资源。
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    /*
    @GetMapping
    public List<PostDto> getAllPosts(){
        return postService.getAllPost();
    }
     */

    @GetMapping
    public PostResponse getAllPosts(
            // 将 HTTP 请求中的查询参数（Query Parameters）与控制器方法的参数进行绑定。
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ){
                return postService.getAllPost(pageNo,pageSize,sortBy,sortDir);
    }

    @GetMapping("/{id}")
    // 告诉 Spring MVC 将 URL 中名为 id 的部分提取出来，并将其赋值给方法参数 id。
    // name = "id" 这个属性是可选的，如果路径变量的名字与方法参数的名字相同，你可以省略 name 属性
    // = public ResponseEntity<PostDto> getPostById(@PathVariable long id){
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        // ResponseEntity.ok() 是一个静态方法，用于创建一个 HTTP 状态码为 200（OK）的响应
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") long id){
        PostDto postResponse = postService.updatePost(postDto,id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
}
