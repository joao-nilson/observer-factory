import org.example.CrowdMember;
import org.example.CrowdMemberFactory;
import org.example.CrowdMemberType;
import org.example.Show;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShowTest {

    @Test
    void shouldClapWhenShowEnds() {
        Show show = new Show("Rock Night");
        CrowdMember member = CrowdMemberFactory.create(CrowdMemberType.ENTHUSIASTIC, "Ana");
        member.watch(show);
        show.end();
        assertEquals("Ana: CLAP CLAP CLAP!!!", member.getLastClap());
    }

    @Test
    void shouldMakeWholeCrowdClap() {
        Show show = new Show("Rock Night");
        CrowdMember ana = CrowdMemberFactory.create(CrowdMemberType.ENTHUSIASTIC, "Ana");
        CrowdMember bob = CrowdMemberFactory.create(CrowdMemberType.CALM, "Bob");
        ana.watch(show);
        bob.watch(show);
        show.end();
        assertEquals("Ana: CLAP CLAP CLAP!!!", ana.getLastClap());
        assertEquals("Bob: clap clap", bob.getLastClap());
    }

    @Test
    void shouldNotClapBeforeShowEnds() {
        Show show = new Show("Rock Night");
        CrowdMember member = CrowdMemberFactory.create(CrowdMemberType.CALM, "Bob");
        member.watch(show);
        assertNull(member.getLastClap());
    }

    @Test
    void shouldNotClapIfNotWatchingTheShow() {
        Show show = new Show("Rock Night");
        CrowdMember member = CrowdMemberFactory.create(CrowdMemberType.CALM, "Bob");
        show.end();
        assertNull(member.getLastClap());
    }

    @Test
    void shouldOnlyClapForTheShowItWatched() {
        Show showA = new Show("Show A");
        Show showB = new Show("Show B");
        CrowdMember ana = CrowdMemberFactory.create(CrowdMemberType.ENTHUSIASTIC, "Ana");
        CrowdMember bob = CrowdMemberFactory.create(CrowdMemberType.CALM, "Bob");
        ana.watch(showA);
        bob.watch(showB);
        showA.end();
        assertEquals("Ana: CLAP CLAP CLAP!!!", ana.getLastClap());
        assertNull(bob.getLastClap());
    }
}
