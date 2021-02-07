
## Double pointer to find nth element from the end

![image](https://user-images.githubusercontent.com/51791113/99157299-9a22ab00-26ed-11eb-84c3-5739d1435871.png)

## Double pointer to find the middle element

![image](https://user-images.githubusercontent.com/51791113/99157849-b8d77080-26f2-11eb-8370-def21724be1d.png)

## Reverse a linked list

![image](https://user-images.githubusercontent.com/51791113/99307531-a25d2080-287c-11eb-88f0-84633c764862.png)

## Pairwise Swap Element in the Linked List by Changing Links (Important)

![image](https://i0.wp.com/algorithms.tutorialhorizon.com/files/2016/03/Swap-Nodes-in-pairs-in-a-Linked-List-by-changing-links.png)

Approach:

Iterative Method:

    1. Take the 4 pointers ptrOne, ptrOne_prev, newhead and ptrTwo.
    2. Make ptrOne = head and ptrTwo = head.next.
    3. Store the reference of next node of ptrTwo, call it ptrTwoNext.
    4. Make the ptrOne.next = ptrTwoNext. (we have just swap the ptrOne).
    5. Make ptrOne_prev.next = ptrTwo; if ptrOne_prev is not null (swapped the ptrTwo).
    6. Make the ptrTwo as newHead (this step will happen only once).
    7. Move 2 nodes ahead for next pair wise swap.
Recursive Method:

    1. This approach is easy compare to iterative approach.
    2. Change the links for first two nodes.
    3. Make the recursive call to rest of the list.

## Intersection of Two Linked List

https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

Method (By node count and difference)

Slight change in main method

![image](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20190626143630/IntersectionYtwoLinkedList1.png)

Method ( 2-pointer technique ):

Using Two pointers :

    - Initialize two pointers ptr1 and ptr2  at the head1 and  head2.
    - Traverse through the lists,one node at a time.
    - When ptr1 reaches the end of a list, then redirect it to the head2.
    - similarly when ptr2 reaches the end of a list, redirect it the head1.
    - Once both of them go through reassigning,hey will be equidistant from
    the collision point
    - If at any node ptr1 meets ptr2, then it is the intersection node.
    - After second iteration if there is no intersection node it returns NULL.

![image](https://miro.medium.com/max/568/0*LBVyr7FkKnfq8nCb.png)

After reaching null, 

![image](https://miro.medium.com/max/540/0*OHV0taSxYlhEXALB.png)

If two linked lists have intersection pointer, the two pointers will both move forward to length(A)+length(B) positions!

![image](https://miro.medium.com/max/875/0*Wq-RdRb1u86uT-2Z.png)

Time complexity: 𝑂(𝑀+𝑁), 
space complexity: 𝑂(1).

## Detect and remove loop

https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/

