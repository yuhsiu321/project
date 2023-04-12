package at.fhtw.swen2.tutorial.persistence;

import at.fhtw.swen2.tutorial.persistence.entities.TourEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.TourRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseInitializer implements InitializingBean {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<TourEntity> tourList = new ArrayList<>();
        tourList.add(TourEntity.builder().id(5L).name("First").tourDescription("1").from("here").to("there").build());
        tourList.add(TourEntity.builder().id(7L).name("Second").tourDescription("2").from("here").to("there").build());
        tourList.add(TourEntity.builder().id(11L).name("Third").tourDescription("3").from("here").to("there").build());
        tourRepository.saveAll(tourList);
    }
}
