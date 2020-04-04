package ds.list;
/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
 */

/** Singly linked list node */
class Link {
	private String element;        // Value for this node
	private Link next;     // Pointer to next node in list

	// Constructors
	Link(String it, Link nextval)
	{ element = it;  next = nextval; }
	Link(Link nextval) { next = nextval; }

	Link next() { return next; }  // Return next field
	Link setNext(Link nextval) // Set next field
	{ return next = nextval; }     // Return element field
	String element() { return element; }  // Set element field
	String setElement(String it) { return element = it; }
}