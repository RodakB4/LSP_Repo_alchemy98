Heuristic 1:
Name:
H2.1: All data should be hidden within its class.

Explanation:
This heuristic states that all data attributes in a class should be private so that external code cannot access or modify them directly. In lecture, this was presented as one of the foundational rules of object-oriented design and the basis of many real-world coding standards, specifically the rule that all data attributes should be declared private. The improvement in readability and maintainability comes from the fact that callers depend only on the public interface of the class, not on how the data is stored internally. This means the internal representation can change without breaking any code that uses the class.

Heuristic 2:
Name:
H3.2: Do not create god classes/objects in your system.

Explanation:
This heuristic states that no single class should control everything or know too much about the rest of the system. In lecture, this was illustrated with Arthur Riel's home heating system example. The original design had a HeatFlowRegulator class that acted as an omnipotent controller, pulling DesiredTemp, ActualTemp, and Occupancy directly from the Room class and then deciding whether to turn on the Furnace. Prof. Woolfolk explained that this made HeatFlowRegulator a god class because it reached into Room to gather data and performed computations that Room itself should be doing. The improved design moved the decision logic into Room through a do_I_need_heat?() method, so HeatFlowRegulator only had to ask Room one question instead of accessing multiple data fields. This improved maintainability because changes to Room's internal data no longer required changes to HeatFlowRegulator.

Heuristic 3:
Name:
H5.1: Inheritance should be used only to model a specialization hierarchy.

Explanation:
This heuristic states that inheritance is only appropriate when a subclass truly represents a special kind of the parent class, not when it represents a role that an object plays. In lecture, this was illustrated with the Person, Passenger, and Agent example. The initial design made Passenger and Agent subclasses of Person using inheritance, but this failed because a person's role can change over time, for example a person could be a Passenger, then become an Agent, or be both at once. Prof. Woolfolk explained that this violated H5.1 because Passenger and Agent are roles a person plays, not special kinds of Person. The corrected design used composition instead, where Person contained optional references to a Passenger role and an Agent role, allowing roles to change without requiring an object to switch classes.
