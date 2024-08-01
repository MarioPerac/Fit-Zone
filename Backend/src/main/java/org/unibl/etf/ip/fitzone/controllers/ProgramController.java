package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.models.dto.Program;
import org.unibl.etf.ip.fitzone.models.requests.ProgramRequest;
import org.unibl.etf.ip.fitzone.services.ProgramService;

@RestController
@RequestMapping("/api/programs")
public class ProgramController extends CrudController<Integer, ProgramRequest, Program> {

    public ProgramController(ProgramService programService){
        super(programService, Program.class);
    }
}
