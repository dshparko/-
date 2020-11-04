/*`18. помен€ть местами первый и последний элементы очереди*/

#ifndef CRT_SECURE_NO_WARNINGS
#define CRT_SECURE_NO_WARNINGS
#endif // !CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include <stdlib.h>
#include <Windows.h>


//элемент очереди
typedef struct queueNode {
	int data;
	struct queueNode* next;

}queueNode;

typedef struct queueNode* QUEUENODE;

void instructions() {
	printf("\n"
		"1 - добавить значение в очередь\n"
		"2 - очистить очередь\n"
		"3 - помен€ть местами 1 и последний элементы очереди\n"
		"4 - поиск элемента и его номер в очереди\n"
		"5 - завершить программу\n");
}

//добавление нового элемента
void enqueue(QUEUENODE* head, QUEUENODE* tail, int value) {
	QUEUENODE new = malloc(sizeof(queueNode));
	if (new != NULL) {
		new->data = value;
		new->next = NULL;
		if (isEmpty(*head))
			*head = new;
		else
			(*tail)->next = new;
		*tail = new;
	}
}

//удаление элемента
int dequeue(QUEUENODE* head, QUEUENODE* tail) {
	int value;
	QUEUENODE temp;
	value = (*head)->data;
	temp = *head;
	*head = (*head)->next;
	if (*head == NULL) {
		*tail = NULL;
	}
	free(temp);
	return value;
}


int isEmpty(QUEUENODE headPtr) {
	return headPtr == NULL;
}


void printQueue(QUEUENODE current) {
	if (current == NULL)
		printf("ќчередь пуста\n\n");
	else {
		printf("ќчередь представл€ет из себ€:\n");
		while (current != NULL) {
			printf("%d ", current->data);
			if (current->next != NULL)
				printf("--> ");
			current = current->next;
		}
		printf("\n");
	}
}


int checkInputElements() {
	int buffer, element;
	do {
		buffer = scanf_s("%d", &element);
		while (element < -50 || element > 50) {
			printf("%s", "ќшибка! Ќеобходимо ввести число из диапазона  [-50;50].\n");
			scanf_s("%*[^\n]%*c");
			buffer = scanf_s("%d", &element);
		}
		scanf_s("%*[^\n]%*c");
	} while (buffer != 1);
	return element;
}


void makeTask(QUEUENODE current) {
	if (!current == NULL) {
		int buffer = current->data;
		QUEUENODE bufferLink = current;
		while (current != NULL) {
			if (current->next == NULL) {
				bufferLink->data = current->data;
				current->data = buffer;
			}
			current = current->next;
		}
	}
}

void searchElement(QUEUENODE current, int digit) {
	if (!current == NULL) {
		int buffer = 0;
		int flag = 0;
		while (current != NULL) {
			buffer++;
			if (current->data == digit) {
				int flag = 1;
				printf("Ёлемент %d найден в очереди под номером %d.", digit, buffer);
			}
			current = current->next;
		}
		if (flag == 0) {
			printf("Ёлемент %d не найден в очереди.", digit);
		}
	}
	else {
		printf("ќчередь пуста. ¬веденный элемент не найден.");
	}
}


main() {
	system("color F0");
	SetConsoleCP(1251);// установка кодовой страницы win-cp 1251 в поток ввода
	SetConsoleOutputCP(1251); // установка кодовой страницы win-cp 1251 в поток вывода
	QUEUENODE head = NULL, tail = NULL;
	int choice;
	int buffer;
	instructions();
	printf("\n¬ведите необходимую операцию: ");
	choice = checkInputElements();
	while (choice != 5) {
		switch (choice) {
		case 1:
			printf("\n¬ведите элемент очереди: ");
			buffer = checkInputElements();
			enqueue(&head, &tail, buffer);
			printQueue(head);
			break;
		case 2:
			while (!isEmpty(head)) {
				buffer = dequeue(&head, &tail);
				printf("Ёлемент %d был удален.\n", buffer);
			}
			printQueue(head);
			break;
		case 3:
			makeTask(head);
			printQueue(head);
			break;
		case 4:
			printf("\n¬ведите число, которое необходимо найти. ");
			buffer = checkInputElements();
			searchElement(head, buffer);
			break;
		}
		instructions();
		printf("\n¬ведите необходимую операцию: ");
		choice = checkInputElements();
	}
}