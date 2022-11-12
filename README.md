# big-xyt-task
### Description:
This is the very simple version of exchange. \
You can get total sum of orders and find out better price to BUY or SELL operations. \

In the summary we have a list of records. We have two types of operations: \
ADD and REMOVE Logically, if we have REMOVE operation in record list, \
it means we already added ADD record before, respectively, \
we have to filter out all our records and delete all REMOVE operations \
and their copies in the form of ADD operations (we have to find them by id).\

After that we will have a clean list with which we can actually work.

We iterate through all records and display in the console the actual data: \
the best price of all time for buying the order \
and the best price for selling the order + print the sum of transaction

### Technologies:
> - Java 11
> - Maven
> - Logger

### Functionality:
> - Initialize list of orders
> - Delete redundant orders
> - Get total sum and better price to BUY or SELL

### To run the project - follow steps below:
1. Fork this repository
2. git clone <your link>
3. Run project
