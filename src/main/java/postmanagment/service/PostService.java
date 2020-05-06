package postmanagment.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postmanagment.dto.PostDto;
import postmanagment.model.Post;
import postmanagment.repository.PostRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRespository;
    
    @Autowired
    private ModelMapper modelMapper;

    public PostService(PostRepository postRepository) {
        this.postRespository = postRepository;
    }

    public Iterable<PostDto> findAll() {
        return postRespository.findAll().stream().map(post -> convertToDto(post)).collect(Collectors.toList());
    }

    public Optional<PostDto> findById(Long id) {
        return Optional.of(convertToDto(postRespository.findById(id).orElse(null)));
    }

    private PostDto convertToDto(Post post) {
        return modelMapper.map(post, PostDto.class);
    }
}
