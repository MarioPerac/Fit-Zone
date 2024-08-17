package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.models.dto.Program;
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


    @PostMapping("/new")
    public void CreateProgram(@RequestBody ProgramRequest programRequest){
        programService.createProgram(programRequest);
    }

}
