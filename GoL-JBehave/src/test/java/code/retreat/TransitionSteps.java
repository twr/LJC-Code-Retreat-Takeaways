package code.retreat;

import static code.retreat.Cell.DEAD;
import static code.retreat.Cell.LIVE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TransitionSteps {

	private Cell cell;
	private Cell nextGeneration;

	@Given("a live cell")
	public void aLiveCell() {
		cell = LIVE;
	}

	@Given("a dead cell")
	public void aDeadCell() {
		cell = DEAD;
	}

	@When("it has $neighbours live neighbours")
	@Alias("it has $neighbours live neighbour")
	public void transition(int liveNeighbours) {
		nextGeneration = cell.mutate(liveNeighbours);
	}

	@Then("the cell lives on to the next generation")
	@Alias("the cell becomes live")
	public void theCellSurvives() {
		assertThat(nextGeneration, is(LIVE));
	}

	@Then("the cell dies")
	@Alias("the cell stays dead")
	public void theCellDies() {
		assertThat(nextGeneration, is(DEAD));
	}

}