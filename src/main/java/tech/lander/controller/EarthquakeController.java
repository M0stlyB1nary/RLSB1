package tech.lander.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.lander.constants.CommonConstant;
import tech.lander.domain.Qgroup;
import tech.lander.domain.Quake;
import tech.lander.repository.EqGroupRepository;
import tech.lander.repository.EqLoadRepository;
import tech.lander.repository.EqRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by rory on 2/16/17.
 */
@CrossOrigin(origins = {"http://localhost:63342", "http://192.168.0.17"})
@RestController
@RequestMapping(CommonConstant.URL_EQ_API)
@Api(value="quakeapi", description = "Operations pertaining to the Earthquake API.")
public class EarthquakeController {

    @Autowired
    private EqLoadRepository eqLoadRepository;

    @Autowired
    private EqGroupRepository eqGroupRepository;

    @Autowired
    private EqRepository eqRepository;

    @RequestMapping(value = CommonConstant.URL_FETCH, method = RequestMethod.POST)
    public String fetchNewEQGroup(@RequestBody Qgroup qgroup) {
        qgroup.setCreatedDate(new Date());

        String groupObjId = eqLoadRepository.addQuakeGroup(qgroup);

        List<Quake> quakeList = eqLoadRepository.fetchLatestEq(qgroup.getStartDate(),
                qgroup.getEndDate(), qgroup.getMinMagnatude(), groupObjId);
        if (quakeList.size() > 0) {
            //Save the quakes for the given date range and minimum magnatude.
            eqLoadRepository.addQuakesToGroup(quakeList);
        }
        return "Earthquakes saved: " + quakeList.size();
    }

    @ApiOperation(value = "Fetch all Earth Quake Groups", notes = "Groups of earthquakes are based on a date range and minimum magnatude.")
    @RequestMapping(value = "quakegroup", method = RequestMethod.GET)
    public List<Qgroup> getAllQuakeGroups() {
        return eqGroupRepository.findAll();
    }

    @ApiOperation(value = "Fetch Earth Quake Group by ID", notes = "Returns an Earthquake group for the given ID.")
    @RequestMapping(value = "quakegroup{id}", method = RequestMethod.GET)
    public Qgroup getQuakeGroupById(@PathVariable  String id) {
        Optional<Qgroup> foundQGroup = eqGroupRepository.findById(id);
        return foundQGroup.get();
    }

    @ApiOperation(value = "Fetch all Earth Quakes by Group", notes = "Returns all Earthquakes for the given Group ID")
    @RequestMapping(value = "quake/{groupObjectId}", method = RequestMethod.GET)
    public List<Quake> getQuakesByGroupId(@PathVariable String groupObjectId) {
        return eqRepository.findByGroupObjectId(groupObjectId);
    }
}
