# ProjectAlpha (Official workflow began Oct 4, 2018)
Project Alpha is the first of  phases in developing an online multiplayer fighting game that supports both p2p, community servers, and local hosting.

## Phase 1 -Burst Engine Setup (To be exported)
### Part A (Complete):
Mathematical setup such that vector maths are easy to prepare and complete
* Vector2f class
* Vector3f class
* Matrix class
### Part B:
Game Engine Development: Custom Collision detection,Custom Collision analysis
* General Polygons and GeoPolygons
* Collision Detection to test whether certain vertices lie within a Convex PolWygon.
* AABB object references for each polygon.
* Utilise SAT and AABB to test for inter polygon collision.
* Setup a Dynamic AABB trees, Octrees/Quadtrees
* (optional) Non-Convex Polygons to be created and have a setup for pre-processed triangulation into a set of Convex Polygons.

### Part C:
Renderable Game objects: Animation Objects, Sprite Objects, 2D "Layering" System, OpenGL properties linked to Polygonal objects "AABB outputs"
* Animation Objects
* abstract Sprite Objects
* Shadows on certain objects and no shadows on others
* 2D drawing "Layering"
* Drawing Engine
* Animation freezing, cancelling, deletion , reversion (akin to abilities in past project)
### Part D:
Graphical user interfaces: Custom buttons, panels, and selection interfaces. 
* Allow for a general abstract object for each such that custom buttons and panels may be created.
* Allow for panels to access other panels and a "SceneManager"
* Allow for an "Input" class that allows for two types of inputs, (Dynamic/Continuous,static/Discrete).
### Part E:
* Game Objects
* Main engine
* Abstractable Scene Manager
* Scene Object
* Player Object
* Object "trees"
* Gamestate linkedLists
## Phase 2 - Gameplay progamming and planning!
### Part A
Object Creation Tool:
* Nodes, Location, Waypoints , Parents system
* Effect creation and animation addition/testing tool.
* Utilise past GUI and custom graphics rendering properties.
* Capable of saving preprocessed (static) references of each object on the map to be duplicated and referenced instead of reprocessed each frame
* Allows for "Live" map testing.
* Play/pause button with map adding and drag and droppable entities.
### Part B
Single player movement and small-scale, used to test different game playstyles by adding custom global force vectors, and special character and engine effects.
* Used for testing logic up until current state.
* Entity creation and saving.
* Gameplay engine and testing.
* Use stick figures and "programmers art"
* Gameplay effects and planning(TBD)
### Part C
* Multiplayer (1v1) utilizing local programming, splitscreen rendering, and different control/input methods.
* Hitbox setup
## Phase 3 - (Create a publishable game utilising the tools and elements created)
###TBD
