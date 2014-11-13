package com.jacksonf.domain;

public class ThreeAVL {
	private int rotateLeftCount, rotateRightCount, rotateInsertCount;

	public ThreeAVL() {
		this.rotateLeftCount = 0;
		this.rotateRightCount = 0;
	}

	public Node insertNode(Node node, Client value) {

		Node newNode;
		
		rotateInsertCount = 0;

		if (node == null) {
			newNode = new Node();
			newNode.setValue(value);
			newNode.setHeigthLeft(0);
			newNode.setHeigthRight(0);

			newNode.setLeft(null);
			newNode.setRight(null);

			node = newNode;

		} else if (value.precedesTo(node.getValue())) {
			node.setLeft(insertNode(node.getLeft(), value));

			if (node.getLeft().getHeigthRight() > node.getLeft()
					.getHeigthLeft()) {
				node.setHeigthLeft(node.getLeft().getHeigthRight() + 1);
			} else {
				node.setHeigthLeft(node.getLeft().getHeigthLeft() + 1);
			}

			node = balanceNode(node);
		} else {
			node.setRight(insertNode(node.getRight(), value));

			if (node.getRight().getHeigthRight() > node.getRight()
					.getHeigthLeft()) {
				node.setHeigthRight(node.getRight().getHeigthRight() + 1);
			} else {
				node.setHeigthRight(node.getRight().getHeigthLeft() + 1);
			}
			node = balanceNode(node);
		}
		return node;
	}

	private Node balanceNode(Node node) {
		// TODO Auto-generated method stub
		int fator1, fator2;

		fator1 = node.getHeigthRight() - node.getHeigthLeft();

		if (fator1 == 2) {
			fator2 = node.getRight().getHeigthRight()
					- node.getRight().getHeigthLeft();

			if (fator2 >= 0) {
				node = rotateLeft(node);
			} else {
				node.setRight(rotateRight(node.getRight()));
				node = rotateLeft(node);
			}
		} else if (fator1 == -2) {

			fator2 = node.getLeft().getHeigthRight()
					- node.getLeft().getHeigthLeft();

			if (fator2 <= 0) {
				node = rotateRight(node);
			} else {
				node.setLeft(rotateLeft(node.getLeft()));
				node = rotateRight(node);
			}

		}

		return node;

	}

	private Node rotateRight(Node node) {
		Node aux1, aux2;

		aux1 = node.getLeft();
		aux2 = aux1.getRight();

		node.setLeft(aux2);
		aux1.setRight(node);

		if (node.getLeft() == null) {
			node.setHeigthLeft(0);
		} else if (node.getLeft().getHeigthLeft() > node.getLeft()
				.getHeigthRight()) {
			node.setHeigthLeft(node.getLeft().getHeigthLeft() + 1);
		} else {
			node.setHeigthLeft(node.getLeft().getHeigthRight() + 1);
		}

		if (aux1.getRight().getHeigthLeft() > aux1.getRight().getHeigthRight()) {
			aux1.setHeigthRight(aux1.getRight().getHeigthLeft() + 1);
		} else {
			aux1.setHeigthRight(aux1.getRight().getHeigthRight() + 1);
		}
		rotateRightCount++;
		rotateInsertCount++;
		return aux1;
	}

	private Node rotateLeft(Node node) {
		Node aux1, aux2;

		aux1 = node.getRight();
		aux2 = aux1.getLeft();

		node.setRight(aux2);
		aux1.setLeft(node);

		if (node.getRight() == null) {
			node.setHeigthRight(0);
		} else if (node.getRight().getHeigthLeft() > node.getRight()
				.getHeigthRight()) {
			node.setHeigthRight(node.getRight().getHeigthLeft() + 1);
		} else {
			node.setHeigthRight(node.getRight().getHeigthRight() + 1);
		}

		if (aux1.getLeft().getHeigthLeft() > aux1.getLeft().getHeigthRight()) {
			aux1.setHeigthLeft(aux1.getLeft().getHeigthLeft() + 1);
		} else {
			aux1.setHeigthLeft(aux1.getLeft().getHeigthRight() + 1);
		}
		
		rotateLeftCount++;
		rotateInsertCount++;
		return aux1;
	}

	public void printOrder(Node node) {
		if (node != null) {
			
			printOrder(node.getLeft());
			System.out.print(node.getValue().getNome() + " ");
			printOrder(node.getRight());
			
		}
	}

	public void printPreOrder(Node node) {
		if (node != null) {
			System.out.print(node.getValue().getNome() + " ");
			printPreOrder(node.getLeft());
			printPreOrder(node.getRight());
		}
	}

	public void printPosOrder(Node node) {
		if (node != null) {
			printPosOrder(node.getLeft());
			printPosOrder(node.getRight());
			System.out.print(node.getValue().getNome() + " ");
		}
	}
	
	public int getRotateLeftCount()
	{
		return rotateLeftCount;	
	}
	
	public int getRotateRightCount()
	{
		return rotateRightCount;	
	}
	
	public int getRotateTotalCount()
	{
		return rotateLeftCount + rotateRightCount;	
	}
		
	public int getRotateInsertCount(){
		return rotateInsertCount;
	}
	
}
