package org.unibl.etf.ip.fitzone.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.fitzone.base.CrudController;
import org.unibl.etf.ip.fitzone.base.CrudService;
import org.unibl.etf.ip.fitzone.models.dto.MessageToAdvisors;
import org.unibl.etf.ip.fitzone.models.entites.MessageToAdvisorsEntity;
import org.unibl.etf.ip.fitzone.models.requests.MessageToAdvisorsRequest;
import org.unibl.etf.ip.fitzone.services.MessageToAdvisorsService;

@RestController
@RequestMapping("/api/message-to-advisors")
public class MessageToAdvisorsController extends CrudController<Integer, MessageToAdvisorsRequest, MessageToAdvisors> {
    protected MessageToAdvisorsController(MessageToAdvisorsService crudService) {
        super(crudService, MessageToAdvisors.class);
    }
}
