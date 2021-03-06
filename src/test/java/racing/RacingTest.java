package racing;

import org.junit.Test;
import racing.rule.Forward;

import java.util.Comparator;
import java.util.Optional;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class RacingTest {

    private static final Random random = new Random();

    @Test
    public void 자동차_숫자_만큼_자동차_목록이_생성되는지_검사() {

        final String carRacerName = "Ryan";
        final int tryCount = random.nextInt(20);

        final Game racing = new Racing(carRacerName, tryCount, new Forward());
        assertThat(racing.getCars().size()).isEqualTo(1);
    }

    @Test
    public void 게임이_끝나면_종료되는지_검사() {

        final String carRacerName = "Ryan";
        final int tryCount = random.nextInt(20);

        final Game racing = new Racing(carRacerName, tryCount, new Forward());
        while (racing.hasTryCount()) {
            racing.start();
        }

        assertThat(racing.hasTryCount()).isEqualTo(false);
    }

}