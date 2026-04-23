# CRC Cards Explanation

TaskManager collaborates with Task because its responsibilities are 
storing, adding, finding, and filtering tasks,all require it to directly 
create, access, and manipulate Task objects. Task, on the other hand, only 
manages its own internal data and does not 
need to know about TaskManager or any other class to fulfill its 
responsibilities. This one-way dependency keeps Task simple and reusable, 
while TaskManager takes on the role of organizing and coordinating Task objects.