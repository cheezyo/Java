package pojo;

public class TableDataChanged {
	private String nameOfColumn;
	private int row,column;
	public TableDataChanged(int row, int column, String nameOfColumn){
		setColumn(column);
		setNameOfColumn(nameOfColumn);
		setRow(row);
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public String getNameOfColumn() {
		return nameOfColumn;
	}
	public void setNameOfColumn(String nameOfColumn) {
		this.nameOfColumn = nameOfColumn;
	}

}
