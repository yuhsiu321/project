package at.fhtw.swen2.tutorial.service.impl;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.entities.TourLogEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourLogRepository;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import at.fhtw.swen2.tutorial.service.TourLogService;
import at.fhtw.swen2.tutorial.service.dto.TourLog;
import at.fhtw.swen2.tutorial.service.mapper.TourLogMapper;
import at.fhtw.swen2.tutorial.service.mapper.TourMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TourLogServiceImpl implements TourLogService {

    @Autowired
    private TourLogRepository tourLogRepository;
    @Autowired
    private TourLogMapper tourLogMapper;


    @Override
    public List<TourLog> getTourLogList() {
        return tourLogMapper.fromEntity(tourLogRepository.findAll());
    }

    @Override
    public TourLog addnew(TourLog tourLog) {
        if (tourLog == null){
            return null;
        }
        TourLogEntity entity = tourLogRepository.save(tourLogMapper.toEntity(tourLog));
        return tourLogMapper.fromEntity(entity);
    }

    /*@Override
    public void delete(Long id) {
        tourLogRepository.delete(tourLogRepository.findById(id));
    }*/
}
