package tech.lander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.lander.constants.CommonConstant;
import tech.lander.domain.Qgroup;
import tech.lander.domain.Quake;
import tech.lander.repository.EarthQuakeRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by rory on 2/16/17.
 */
@CrossOrigin(origins = {"http://localhost:63342", "http://192.168.0.17"})
@RestController
@RequestMapping(CommonConstant.URL_EQ_API)
public class EarthquakeController {

    @Autowired
    private EarthQuakeRepository earthQuakeRepository;

    @RequestMapping(value = CommonConstant.URL_FETCH, method = RequestMethod.POST)
    public String fetchNewEQGroup(@RequestBody Qgroup qgroup) {
        qgroup.setCreatedDate(new Date());

        String groupObjId = earthQuakeRepository.addQuakeGroup(qgroup);

        List<Quake> quakeList = earthQuakeRepository.fetchLatestEq(qgroup.getStartDate(),
                qgroup.getEndDate(), qgroup.getMinMagnatude(), groupObjId);
        if (quakeList.size() > 0) {
            //Save the quakes.
            earthQuakeRepository.addQuakesToGroup(quakeList);
        }
        return "Earthquakes saved: " + quakeList.size();
    }
}
