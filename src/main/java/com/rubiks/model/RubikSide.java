package com.rubiks.model;

import java.util.stream.IntStream;

public class RubikSide implements Cloneable {
	private final int size;
	private int[][] values;

	public RubikSide(int size, int value) {
		this.size = size;
		int[] dimension = IntStream.generate(() -> value).limit(size).toArray();
		values = IntStream.range(0, size).boxed().map(i -> dimension.clone()).toArray(int[][]::new);
	}

	public int[] getRow(int row) {
		return values[row];
	}

	public int[] getCol(int col) {
		return IntStream.range(0, size).map(i -> values[i][col]).toArray();
	}

	public void setRow(int row, int[] newValues) {
		values[row] = newValues;
	}

	public void setCol(int col, int[] newValues) {
		IntStream.range(0, size).forEach(i -> values[i][col] = newValues[i]);
		
	}
}
