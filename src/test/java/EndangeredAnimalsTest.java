import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;

public class EndangeredAnimalsTest {
    @Test
    public void fireMonster_instantiatesCorrectly_true() {
        EndangeredAnimals testEndangeredAnimals = new EndangeredAnimals(1, "dog", "healthy","newborn");
        assertEquals(true, testEndangeredAnimals instanceof Animals);
    }

}
