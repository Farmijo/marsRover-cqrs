# MY SOLUTION

My solution ended to be inspired in DDD, CQRS and Ports & Adapters concepts.

**Domain Layer**

The MarsRover will be the main Aggregate on the project (assuming that only will be one Rover on Mars and that the Mars surface won't change)
and will handle the whole domain logic of the project.

Mars Rover will need a CoordinateSystem that will control its position and movement and a OrientationSystem.

The CoordinateSystem requires to know the field (dimensions, obstacles,...) and the initial position to start the navigation. 

The CoordinateSystem is responsible of handling of calculate the position of the marsRover (or another entity) after each move, but does not control the rotation of the MarsRover,

The OrientationSystem requires to know the initial orientation of the MarsRover (or another entity) and is responsible of handling the orientation of the mars rover after a rotation.

The MarsRover class itself can't handle the movement or rotations, delegates on the systems to do that actions, but exposes the move and rotation methods on its own API to maintain a single entrypoint on the Rover possible actions.

With this system, the Rover logic (movements, boundaries, obstacle detection) is easily testable.

**Application layer.**

 CQRS inspired approach. To start a navigation session there's a bit of application logic to handle (a Field should be defined, the obstacles of the field should be defined to, the initial position of the Rover should be defined).
 
  For that, the CreateMarsRoverSessionCommand and the CreateMarsRoverSessionCommand will expose the data needed depending on the type of session desired. The CreateSessionCommandHandler will be responsible of translating that data to objects of the domain (mainly, the Coordinate System and the OrientationSystem that will be needed by the Mars Rover).

The CreateSessionCommandHandler will invoke the MarsRoverService's method createMarsRoverNavigationSession, that will create a single Mars Rover using the provided Coordinate and Orientation Systems and will store it (on the provided example, in memory, but the service is not aware of that).

The ActionCommands are a lot simpler. They just specify the action desired (rotate, move forward,...) and the handler invokes the desired method of the MarsRoverService, that stores the new status of the Mars Rover.

_**Disclaimer**_: This approach will imply move the CreateSession Handler logic to the service if more Rovers would be placed in mars, since the Field should be updated at every move and this will require store the Field status to pass it to the CoordinateSystem to avoid collisions.

**Infrastructure Layer.**

Just a simple InMemoryRepository that will store the current status of the Mars rover (just one Mars Rover.)

**Application Interface:**
  The code is a bit messy on the Command Line app, but the Mars Rover project is totally unaware of who's calling him. The CLI app is dependent of the domain, not viceversa.

**Testing approach:**
The domain logic is covered through the domain tests without caring of storages, services or other stuff.
The application logic is tested in a sort of integration tests. Commands are launched to the handlers and the side effects are checked on the inMemoryRepository.

**Random Facts**
- The obstacle detection has being implemented. The obstacle position is hardcoded, though.
- The whole projects has been refactored inside-out through TDD. After a bit of cleanup, a MarsRover Class that contained almost all the logic of the initial status was created, allowing it to write tests. Once the domain was created, the services and commands were added.
- Builder pattern used on complex or with optional fields objects (field, that could have obstacles or not, sessionCreation Data)
- Tried to add several rovers with obstacles at the same time, but the complexity increased. The Field should be stored apart and updated with the obstacles and each Rover move to allow that.
- No IoC container provided, i'm not experienced with them outside the Spring Boot one. The dependency tree is resolved on the app init. 
- Commands and Services are not abstracted at 100%, but could be 
