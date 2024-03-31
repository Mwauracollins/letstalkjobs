package org.letstalkjobs.letstalkjobs.services;

import org.letstalkjobs.letstalkjobs.entities.jobentities.Position;
import org.letstalkjobs.letstalkjobs.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }
    public List<Position> getAllPositions(){
        return positionRepository.findAll();
    }
    public Position addPosition(Position position){
        //TODO: Additional business logic like if the position is already there
//              it should not add.
        return positionRepository.save(position);
    }
}
