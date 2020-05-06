package postmanagment.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postmanagment.dto.CommentDto;
import postmanagment.model.Comment;
import postmanagment.repository.CommentRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Iterable<CommentDto> findByPostId(Long postId){
        return commentRepository.findByPostId(postId).stream().map(
                comment -> convertToDto(comment)
        ).
        collect(Collectors.toList());
    }

    public Optional<CommentDto> findByIdAndPostId(Long id, Long postId){
        Optional<CommentDto> commentDto = Optional.of(
                convertToDto(commentRepository.findByIdAndPostId(id, postId).orElse(null)));
        return commentDto;
    }


    private CommentDto convertToDto(Comment comment) {
        CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
        return commentDto;
    }
}
