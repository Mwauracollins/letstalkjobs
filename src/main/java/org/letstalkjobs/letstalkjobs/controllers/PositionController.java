package org.letstalkjobs.letstalkjobs.controllers;

import org.letstalkjobs.letstalkjobs.entities.jobentities.Position;
import org.letstalkjobs.letstalkjobs.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }
    @PostMapping
    public Position addPosition(@RequestBody Position position){
        return positionService.addPosition(position);
    }
}
