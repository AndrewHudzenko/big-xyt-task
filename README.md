### big-xyt-task
In the summary we have a list of records.
We have two types of operations: ADD and REMOVE
Logically, if we have REMOVE operation in record list, 
it means we already added ADD record before, respectively, 
we have to filter out all our records and delete all REMOVE operations 
and their copies in the form of ADD operations (we have to find them by id).

After that we will have a clean list with which we can actually work.

We iterate through all records and display in the console the actual data: 
the best price of all time for buying the order 
and the best price for selling the order + print the sum of transaction
