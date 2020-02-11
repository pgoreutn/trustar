```$xslt
5- Reflecting on our solution, can you think of any issues we might run into
if we want to use these functions in production, where we expect thousands of 
extractions to be requested per second? Please describe an architecture 
you believe will support that volume of calls.
```

In order to run in production where we expected  thousands of extractions , 
the main idea should be executed an  Spark's job , in a cluster where several 
workers help to process the whole documents.
Another approach to working with the black list , is create a broadcast 
variable and share it the  list in each workers of the cluster.