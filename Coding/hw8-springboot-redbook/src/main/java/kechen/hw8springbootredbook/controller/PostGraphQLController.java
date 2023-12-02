package kechen.hw8springbootredbook.controller;

import kechen.hw8springbootredbook.payload.PostDto;
import kechen.hw8springbootredbook.service.PostService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * GraphQL是一种由Facebook开发的查询语言和运行时环境，用于API和数据层的交互。它允许客户端以更灵活、更高效的方式来获取所需的数据，相比于传统的RESTful API，GraphQL具有以下特点：
 *
 * 灵活性和精确性： 客户端可以精确地指定需要获取的数据，而不会收到不需要的数据。通过定义特定的查询，客户端能够精确获取所需数据。
 * 单一端点： 与RESTful API不同，GraphQL通常只有一个端点（通常是/graphql），客户端可以发送查询来获取所需的数据。这消除了对多个端点的依赖，提高了API的一致性和可维护性。
 * 类型系统： GraphQL拥有强大的类型系统，定义了数据模型和查询结构。这使得开发人员能够清晰地了解API所提供的数据类型和结构。
 * 即时文档： GraphQL具有自描述的能力，客户端可以查看可用的数据类型和操作，并根据文档指南编写查询。
 * 批量查询： 客户端可以在一个请求中获取多个资源，减少了网络通信的开销。
 * 总的来说，GraphQL旨在提供更灵活、更高效、更精确的数据查询和交互方式，使得客户端能够按需获取所需数据。
 */

@Controller
public class PostGraphQLController {
    private final PostService postService;

    public PostGraphQLController(PostService postService) {
        this.postService = postService;
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
     */
    @QueryMapping
    public PostDto getPostById(@Argument Long id){
        return postService.getPostById(id);
    }

    /*
    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto postResponse = postService.createPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
     */
    @MutationMapping
    public PostDto createPost(@Argument String title, @Argument String description, @Argument String content){
        PostDto postDto = new PostDto();

        postDto.setTitle(title);
        postDto.setDescription(description);
        postDto.setContent(content);

        return postService.createPost(postDto);
    }
}
