package com.fileutiliy.dto;

public class Compare {

	private String line1;
	private String line2;
	private String colour;
	
	
	public Compare(String line1, String line2, String colour) {
		this.line1 = line1;
		this.line2 = line2;
		this.colour = colour;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	@Override
	public String toString() {
		return "Compare [line1=" + line1 + ", line2=" + line2 + ", colour=" + colour + "]";
	}
}
