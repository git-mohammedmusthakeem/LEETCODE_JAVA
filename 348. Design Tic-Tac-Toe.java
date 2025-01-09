class TicTacToe {
		private int[][] rows;
		private int[][] cols;
		private int[][] digs;
		private int n;
		/** Initialize your data structure here. */
		public TicTacToe(int n) {
			this.rows = new int[n][2];
			this.cols = new int[n][2];
			this.digs = new int[2][2];
			this.n = n;
		}
		
		/** Player {player} makes a move at ({row}, {col}).
			@param row The row of the board.
			@param col The column of the board.
			@param player The player, can be either 1 or 2.
			@return The current winning condition, can be either:
					0: No one wins.
					1: Player 1 wins.
					2: Player 2 wins. */
		public int move(int row, int col, int player) {
			if(++rows[row][player - 1] == n) return player;
			if(++cols[col][player - 1] == n) return player;
			if(row == col && ++digs[0][player - 1] == n) return player;
			if(row + col == n - 1 && ++digs[1][player - 1] == n) return player;
			return 0;
		}
	}