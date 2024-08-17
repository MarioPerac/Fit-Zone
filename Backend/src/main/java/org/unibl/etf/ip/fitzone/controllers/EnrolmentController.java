package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.base.CrudService;
import org.unibl.etf.ip.fitzone.models.dto.Enrolment;
import org.unibl.etf.ip.fitzone.models.requests.EnrolmentRequest;
import org.unibl.etf.ip.fitzone.services.EnrolmentService;

@RestController
@RequestMapping("/api/enrolments")
public class EnrolmentController extends CrudController<Integer, EnrolmentRequest, Enrolment> {
    protected EnrolmentController(EnrolmentService crudService) {
        super(crudService, Enrolment.class);
    }
}
