package tech.lander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.lander.constants.CommonConstant;
import tech.lander.domain.Qgroup;
import tech.lander.domain.Quake;
import tech.lander.repository.EarthQuakeRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by rory on 2/16/17.
 */
@RestController
@RequestMapping(CommonConstant.URL_EQ_API)
public class EarthquakeController {

    @Autowired
    private EarthQuakeRepository earthQuakeRepository;

    @RequestMapping(value = CommonConstant.URL_FETCH, method = RequestMethod.POST)
    public String home() {

        String groupDesc = "My test";
        String groupStartDate = "2017-01-01";
        String groupEndDate = "2017-01-02";
        String groupMinMag = "5";


        //Save the Group
        Qgroup qgroup = new Qgroup();
        qgroup.setDesc(groupDesc);
        qgroup.setCreatedDate(new Date());
        qgroup.setMinMagnatude(groupMinMag);
        qgroup.setStartDate(groupStartDate);
        qgroup.setEndDate(groupEndDate);

        String groupObjId = earthQuakeRepository.addQuakeGroup(qgroup);

        List<Quake> quakeList = earthQuakeRepository.fetchLatestEq(groupStartDate,
                groupEndDate, groupMinMag, groupObjId);
        if (quakeList.size() > 0) {
            //Save the quakes.
            earthQuakeRepository.addQuakesToGroup(quakeList);
        }

        return "Earthquakes saved: " + quakeList.size();
    }
}
