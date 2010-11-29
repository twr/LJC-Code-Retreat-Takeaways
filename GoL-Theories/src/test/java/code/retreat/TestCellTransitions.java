package code.retreat;

import static code.retreat.Cell.DEAD;
import static code.retreat.Cell.LIVE;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TestCellTransitions {

	@DataPoints
	public static int[] input = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

	@Theory
	public void liveCellWithFewerThanTwoLiveNeighboursDies(int liveNeighbours) {
		assumeThat(liveNeighbours, lessThan(2));
		assertThat(LIVE.mutate(liveNeighbours), is(DEAD));
	}

	@Theory
	public void liveCellWithTwoOrThreeLiveNeighboursLivesOnToTheNextGeneration(
			int liveNeighbours) {
		assumeThat(liveNeighbours, anyOf(is(2), is(3)));
		assertThat(LIVE.mutate(liveNeighbours), is(LIVE));
	}

	@Theory
	public void liveCellWithMoreThanThreeLiveNeighboursDies(int liveNeighbours) {
		assumeThat(liveNeighbours, greaterThan(3));
		assertThat(LIVE.mutate(liveNeighbours), is(DEAD));
	}

	@Theory
	public void deadCellWithExactlyThreeLiveNeighboursBecomesALiveCell(
			int liveNeighbours) {
		assumeThat(liveNeighbours, is(3));
		assertThat(DEAD.mutate(liveNeighbours), is(LIVE));
	}

	@Theory
	public void deadCellWithAnyNumberOfLiveNeighboursButThreeStaysDead(
			int liveNeighbours) {
		assumeThat(liveNeighbours, not(is(3)));
		assertThat(DEAD.mutate(liveNeighbours), is(DEAD));
	}

}
