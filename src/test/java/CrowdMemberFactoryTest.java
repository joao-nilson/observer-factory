import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrowdMemberFactoryTest {

    @Test
    void shouldCreateEnthusiasticCrowdMember() {
        CrowdMember member = CrowdMemberFactory.create(CrowdMemberType.ENTHUSIASTIC, "Ana");
        assertTrue(member instanceof EnthusiasticCrowdMember);
        assertEquals("CLAP CLAP CLAP!!!", member.clap());
    }

    @Test
    void shouldCreateCalmCrowdMember() {
        CrowdMember member = CrowdMemberFactory.create(CrowdMemberType.CALM, "Bob");
        assertTrue(member instanceof CalmCrowdMember);
        assertEquals("clap clap", member.clap());
    }

    @Test
    void shouldThrowExceptionForNullType() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> CrowdMemberFactory.create(null, "Ana"));
        assertEquals("Crowd member type is required", e.getMessage());
    }
}
