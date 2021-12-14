# Book_Inventory

CS341 Software Engineering

Homework 8

Write the application described below in Java.  Commit the source code (with documentation) to GitHub. 
Submit the Git repository URL to Moodle.
Submit the following Word documents to Moodle
•	Testing summary. 
•	Completed final summary for your Personal Software Process: PSP Form







Program Requirements, Class Diagrams, Testing, Personal Software Process





 


Build an application tool for a Campus Textbook Store


Write a Java application that will allow a user to manage the inventory of a store that sells textbooks.

The inventory for the video store will contain the following information for each textbook
(each title) in the inventory:

SKU 	(stock-keeping unit, an integer, must be unique)
title 	(may contain spaces in it)
price 	(dollars and cents, greater than 0)
quantity 	(number of copies in inventory, greater than or equal to 0)


Software Requirements:
•	The program should offer the user a menu (do this however you wish) with the following options:
1.	Add a textbook to the inventory (prompt user for input values in this order: sku, title, price, quantity).
2.	Remove a textbook from the inventory (by sku).
3.	Display the information for a textbook (given the sku).
4.	Display the inventory in a table (in any order).

The program should perform the menu operation selected. If the operation fails (i.e. attempt to remove a textbook not in the inventory) your program should display an error message.


•	Your program should store the inventory in a file between executions of the program, so that when the program is run again it will start up with the same inventory contents as when it last terminated (use serialization!). 

•	Draw a basic class diagram for this system.  Include relationships between classes (generalization and associational).

•	Construct a set of test cases to ensure that the code is correct. For example, your program must run even if the file is not present (initial inventory will be empty). Test for valid input and invalid input. Produce a test summary. You are responsible for resolving all issues. Document all your assumptions and decisions wherever requirements are unclear.


•	Produce a final summary of your Personal Software Process. See the PSP HW Form. This document requires you to record the size (number of lines of code) for your entire program, the time spent on design, coding, testing (in minutes), and a list of all defects your encountered and fixed (indicate the type/root cause). The final program should have all defects corrected. Retain this data for future use.
