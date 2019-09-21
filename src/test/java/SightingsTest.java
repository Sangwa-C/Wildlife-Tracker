import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class SightingsTest {
    @Test
    public void Sightings_instantiatesCorrectly_true() {
        Sightings testSightings = new Sightings(1, "zoneA", "range2");
        assertEquals(true, testSightings instanceof Animals);
    }

}
