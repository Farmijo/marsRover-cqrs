# MY SOLUTION

My solution ended to be inspired in DDD, CQRS and Ports & Adapters concepts. 
The MarsRover will be the main Aggregate on the project (assuming that only will be one Rover on Mars and that the Mars surface won't change)
and will handle the whole domain logic of the project.

Mars Rover will need a Coordinate System that will control its position and movement. This Coordinate System requires to know 
the field (dimensions, obstacles,...) 