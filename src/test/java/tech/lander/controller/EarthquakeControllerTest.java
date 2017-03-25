package tech.lander.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import tech.lander.domain.Qgroup;
import tech.lander.repository.EarthQuakeRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by rory on 2/28/17.
 */
public class EarthquakeControllerTest {

    private EarthQuakeRepository earthQuakeRepository;
    @Before
    public void Setup() {
        System.out.println("Before Check");
        EarthQuakeRepository earthQuakeRepository = new EarthQuakeRepository();
    }
    @Ignore
    @Test
    public void EQTestMain(){
        EarthquakeController eqc = new EarthquakeController();
        Qgroup qg = new Qgroup();
        qg.setDesc("Test desc");
        qg.setMinMagnatude("5");
        qg.setCreatedDate(new Date());
        qg.setStartDate("2017-02-1");
        qg.setEndDate("2017-02-5");
        assertEquals("Earthquakes group was not created.", "Earthquakes saved:",eqc.fetchNewEQGroup(qg));

    }

}
