#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct node* treePointer;
typedef struct node {
	char data;
	treePointer leftChild;
	treePointer rightChild;
};

treePointer root = NULL;
void insert(char parent, char lchild, char rchild);
treePointer makeNode(char data);
void searchAndInsert(treePointer node, char parent, char left, char right);


void insert(char parent, char lchild, char rchild) {
	if (root == NULL) {
		treePointer newNode = makeNode(parent);
		if (lchild != '.') newNode->leftChild = makeNode(lchild);
		if (rchild != '.') newNode->rightChild = makeNode(rchild);
		root = newNode;
	}
	else {
		searchAndInsert(root, parent, lchild, rchild);
	}
}

treePointer makeNode(char data) {
	treePointer newNode = (treePointer)malloc(sizeof(struct node));
	newNode->data = data;
	newNode->leftChild = NULL;
	newNode->rightChild = NULL;
	return newNode;
}

void searchAndInsert(treePointer node, char parent, char left, char right) {
	if (node == NULL) return;
	if (node->data == parent) {
		if (left == '.') left = NULL;
		else node->leftChild = makeNode(left);

		if (right == '.') right = NULL;
		else node->rightChild = makeNode(right);
		return;
	}
	searchAndInsert(node->leftChild, parent, left, right);
	searchAndInsert(node->rightChild, parent, left, right);
}

void preorder(treePointer node) {
	if (node) {
		printf("%c", node->data);
		preorder(node->leftChild);
		preorder(node->rightChild);
	}
}

void inorder(treePointer node) {
	if (node) {
		inorder(node->leftChild);
		printf("%c", node->data);
		inorder(node->rightChild);
	}
}

void postorder(treePointer node) {
	if (node) {
		postorder(node->leftChild);
		postorder(node->rightChild);
		printf("%c", node->data);
	}
}

int main() {
	int n;
	scanf("%d", &n);
	char parent, lchild, rchild;
	for (int i = 0; i < n; i++) {
		scanf(" %c %c %c", &parent, &lchild, &rchild);
		insert(parent, lchild, rchild);
	}

	preorder(root);
	printf("\n");
	inorder(root);
	printf("\n");
	postorder(root);
}