package com.ubs.opsit.interviews.enums;

public enum Color {
	
	 RED("R"), YELLOW("Y") ,OFF("O");
	
	private String colorCode;

	Color(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return colorCode;
	}


}
