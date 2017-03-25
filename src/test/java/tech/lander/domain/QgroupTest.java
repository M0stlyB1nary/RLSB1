package tech.lander.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rory on 2/28/17.
 */
public class QgroupTest {

    @Test
    public void Qgroup() {
        Qgroup qg = new Qgroup();
        qg.setDesc("This is a Test.");
        qg.setMinMagnatude("5");
        assertEquals("Description was not set", "This is a Test.", qg.getDesc());
        assertEquals("Min Magnatude was not set", "5", qg.getMinMagnatude());
    }
}
