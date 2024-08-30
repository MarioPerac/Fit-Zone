package org.unibl.etf.ip.fitzone.services;

import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.unibl.etf.ip.fitzone.base.CrudJpaService;
import org.unibl.etf.ip.fitzone.exceptions.NotFoundException;
import org.unibl.etf.ip.fitzone.models.dto.Comment;
import org.unibl.etf.ip.fitzone.models.entites.CommentEntity;
import org.unibl.etf.ip.fitzone.repositories.CommentRepository;

@Service
public class CommentService  extends CrudJpaService<CommentEntity, Integer> {

    private CommentRepository commentRepository;
    public CommentService(CommentRepository jpaRepository, ModelMapper modelMapper) {
        super(jpaRepository, CommentEntity.class, modelMapper);

        this.commentRepository = jpaRepository;
    }

    public Comment addAnswer(Integer id, String answer) throws NotFoundException {

        if(!commentRepository.existsById(id))
            throw new NotFoundException();

        CommentEntity commentEntity = commentRepository.findById(id).get();

        commentEntity.setAnswer(answer);
        commentEntity = commentRepository.saveAndFlush(commentEntity);
        entityManager.refresh(commentEntity);

        return modelMapper.map(commentEntity, Comment.class);
    }
}
