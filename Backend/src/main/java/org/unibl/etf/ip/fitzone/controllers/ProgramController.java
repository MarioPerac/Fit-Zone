package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.models.dto.Program;
import org.unibl.etf.ip.fitzone.models.dto.UserHasProgram;
import org.unibl.etf.ip.fitzone.models.requests.ProgramRequest;
import org.unibl.etf.ip.fitzone.services.ProgramService;

@RestController
@RequestMapping("/api/programs")
public class ProgramController extends CrudController<Integer, ProgramRequest, Program> {

    private ProgramService programService;
    public ProgramController(ProgramService programService){
        super(programService, Program.class);
        this.programService = programService;
    }

    @GetMapping("/to/{username}")
    public Page<UserHasProgram> getProgramsToUser(
            @PathVariable String username,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){

        Pageable pageable = PageRequest.of(page, size);
        return programService.getProgramsToUser(username, pageable);
    }

    @PostMapping("/new")
    public void CreateProgram(@RequestBody ProgramRequest programRequest){
        programService.createProgram(programRequest);
    }
}
