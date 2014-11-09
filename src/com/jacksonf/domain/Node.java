package com.jacksonf.domain;

public class Node {

	private Client value;
	
	private int heigthLeft, heigthRight;
	private Node left, right;
	public Client getValue() {
		return value;
	}
	public void setValue(Client value) {
		this.value = value;
	}
	public int getHeigthLeft() {
		return heigthLeft;
	}
	public void setHeigthLeft(int heigthLeft) {
		this.heigthLeft = heigthLeft;
	}
	public int getHeigthRight() {
		return heigthRight;
	}
	public void setHeigthRight(int heigthRight) {
		this.heigthRight = heigthRight;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}

	

}
