package kechen.hw10springbootredbook.service.impl;

import kechen.hw10springbootredbook.dao.PostJPQLRepository;
import kechen.hw10springbootredbook.dao.PostRepository;
import kechen.hw10springbootredbook.entity.Post;
import kechen.hw10springbootredbook.exception.ResourceNotFoundException;
import kechen.hw10springbootredbook.payload.PostDto;
import kechen.hw10springbootredbook.payload.PostResponse;
import kechen.hw10springbootredbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    PostJPQLRepository postJPQLRepository;

    @Override
    public PostDto createPost(PostDto postDto) {
        /*
        // 把payload转换成entity，这样dao才能把该数据存到数据库中。
        Post post = new Post();
        if (postDto.getTitle() != null) {
            post.setTitle(postDto.getTitle());
        } else {
            post.setTitle("");
        }

        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        // 此时已成功把request body的信息传递给entity(body里面包含了title，description，content(payload)，获取之后换成entity)
         */

        // covert DTO to Entity
        Post post = mapToEntity(postDto);

        // 调用Dao的save 方法，将entity的数据存储到数据库MySQL
        // save()会返回存储在数据库中的数据
        Post savedPost = postRepository.save(post);

        /*
        // 将save() 返回的数据转换成controller/前端 需要的数据，然后return给controller
        PostDto postResponse = new PostDto();
        postResponse.setId(savedPost.getId());
        postResponse.setTitle(savedPost.getTitle());
        postResponse.setDescription(savedPost.getDescription());
        postResponse.setContent(savedPost.getContent());
         */

        PostDto postResponse = mapToDTO(savedPost);

        return postResponse;
    }

    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;
    }

    private PostDto mapToDTO(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;
    }


    /*
    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts
                .stream()
                .map(post -> mapToDTO(post))
                .collect(Collectors.toList());
        return postDtos;
    }
     */

    @Override
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir) {
        // Sort 对象根据传入的 sortDir 参数判断排序方式是升序还是降序，并且根据 sortBy 参数指定的字段进行排序。
        // 假设现在 sortDir 是 "DESC"，sortBy 是 "createDateTime"，那么上面的代码将创建一个 Sort 对象，按照创建日期字段降序排序。
        // 相反，如果 sortDir 是 "ASC"，则会按照升序排序。
        // 如果 sortBy 是 "title"，则将根据标题字段进行排序。
        // variable = (condition) ? expressionTrue : expressionFalse;

        // 如果 sortDir 的值（排序方向）是 ASC（升序），则 sort 对象使用 Sort.by(sortBy).ascending() 来创建一个按指定字段升序排序的 Sort 对象；
        // 否则，使用 Sort.by(sortBy).descending() 来创建一个按指定字段降序排序的 Sort 对象
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();

        //create pageable instance
        // PageRequest是Spring Data中的一个类，用于创建分页请求对象
        // 用于根据传入的页数 (pageNo)、页面大小 (pageSize) 和排序规则 (sort) 来构建PageRequest分页请求对象
        PageRequest pageRequest = PageRequest.of(pageNo,pageSize,sort);
        // PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        // PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        //根据分页后查找的数据
        //Page是Spring Data中表示分页查询结果的接口。它是一个包含有关分页信息和实际数据内容的对象。
        Page<Post> pagePosts = postRepository.findAll(pageRequest);

        //get content for page object
        List<Post> posts = pagePosts.getContent();
        List<PostDto> postDtos = posts
                .stream()
                .map(post -> mapToDTO(post))
                .collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(pagePosts.getNumber());
        postResponse.setPageSize(pagePosts.getSize());
        postResponse.setTotalElements(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLast(pagePosts.isLast());
        return postResponse;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatePost = postRepository.save(post);
        return mapToDTO(updatePost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getAllPostWithJPQL() {
        return postJPQLRepository.getAllPostWithJPQL()
                .stream()
                .map(post -> mapToDTO(post))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostByIdJPQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLIndexParameters(id, title);
        return mapToDTO(post);
    }

    @Override
    public PostDto getPostByIdJPQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithJPQLNamedParameters(id, title);
        return mapToDTO(post);
    }

    @Override
    public PostDto getPostByIdSQLIndexParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLIndexParameters(id, title);
        return mapToDTO(post);
    }

    @Override
    public PostDto getPostByIdSQLNamedParameter(Long id, String title) {
        Post post = postRepository.getPostByIDOrTitleWithSQLNamedParameters(id, title);
        return mapToDTO(post);
    }
}
