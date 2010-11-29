Given a live cell
When it has 0 live neighbours
Then the cell dies
When it has 1 live neighbour
Then the cell dies
When it has 2 live neighbours
Then the cell lives on to the next generation
When it has 3 live neighbours
Then the cell lives on to the next generation
When it has 4 live neighbours
Then the cell dies
When it has 5 live neighbours
Then the cell dies
When it has 6 live neighbours
Then the cell dies
When it has 7 live neighbours
Then the cell dies
When it has 8 live neighbours
Then the cell dies

Given a dead cell
When it has 0 live neighbours
Then the cell stays dead
When it has 1 live neighbour
Then the cell stays dead
When it has 2 live neighbours
Then the cell stays dead
When it has 3 live neighbours
Then the cell becomes live
When it has 4 live neighbours
Then the cell stays dead
When it has 5 live neighbours
Then the cell stays dead
When it has 6 live neighbours
Then the cell stays dead
When it has 7 live neighbours
Then the cell stays dead
When it has 8 live neighbours
Then the cell stays dead
