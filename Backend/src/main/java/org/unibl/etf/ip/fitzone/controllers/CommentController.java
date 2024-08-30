package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.base.CrudService;
import org.unibl.etf.ip.fitzone.exceptions.NotFoundException;
import org.unibl.etf.ip.fitzone.models.dto.Comment;
import org.unibl.etf.ip.fitzone.models.requests.CommentRequest;
import org.unibl.etf.ip.fitzone.services.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController extends CrudController<Integer, CommentRequest, Comment> {
    CommentService commentService;
    protected CommentController(CommentService crudService) {
        super(crudService, Comment.class);
        this.commentService = crudService;
    }

    @PutMapping("/{id}/answer")
    public Comment addAnswer(@PathVariable Integer id, @RequestBody String answer) throws NotFoundException {
        return commentService.addAnswer(id, answer);
    }
}
