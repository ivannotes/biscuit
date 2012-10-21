biscuit
=======

biscuit is a set of toolkits. it contains a async task excutor and a local event module.
* the async task excutor have timeout & listeners which you can easily hack in , it also has a simple duplicate task sweep mechanism which is useful for me
* the event module can dispatch events and subscrib a handler to handle that event,  i used it to do decoupling things. events can not be presistent & it not import cluster also, why? because i want to keep it simple and useful. 
