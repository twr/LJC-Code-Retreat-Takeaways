package code.retreat;

public enum Cell {

	LIVE {
		@Override
		public Cell mutate(int liveNeighbours) {
			return liveNeighbours == 2 || liveNeighbours == 3 ? LIVE : DEAD;
		}
	},
	DEAD {
		@Override
		public Cell mutate(int liveNeighbours) {
			return liveNeighbours == 3 ? LIVE : DEAD;
		}
	};

	public abstract Cell mutate(int liveNeighbours);

}
