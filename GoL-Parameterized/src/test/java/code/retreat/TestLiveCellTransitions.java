package code.retreat;

import static code.retreat.Cell.DEAD;
import static code.retreat.Cell.LIVE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestLiveCellTransitions {

	private final int liveNeighbours;

	private final Cell expected;

	@Parameters(name = "{index}: a live cell with {0} neighbours is {1} after transition")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { //
				{ 0, DEAD }, //
						{ 1, DEAD }, //
						{ 2, LIVE }, // live
						{ 3, LIVE }, // live
						{ 4, DEAD }, //
						{ 5, DEAD }, //
						{ 6, DEAD }, //
						{ 7, DEAD }, //
						{ 8, DEAD }, //
				});
	}

	public TestLiveCellTransitions(int liveNeighbours, Cell expected) {
		this.liveNeighbours = liveNeighbours;
		this.expected = expected;
	}

	@Test
	public void assertExpectedResult() {
		// when
		Cell result = LIVE.mutate(liveNeighbours);

		// then
		assertThat(result, equalTo(expected));
	}

}
