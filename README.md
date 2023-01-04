# Learning Workflow by Square
This repo is just a scratchpad/notebook for understanding how Workflow by Square works.
Compared to what I'm used to, some general concepts are very familiar, but how it is implemented is
trickier to grasp. By making a silly app, silly mistakes, and summarizing my learnings, I can develop
a deeper understanding of this library.

## Table of Contents
 - Summary of how Kotlin Workflow works
 - Comparison to a reactive VM approach
 - General takeaways

### Summary of how Kotlin Workflow works

When building a UI application, it's important to maintain the principle of separation of concerns.
We want our layers (business, data, and view), to remain decoupled, for ease of debugging and testing.

This can be done by following a Clean Architecture approach, where we have dependency inversion and
building classes using the single responsibility principle, among others. However, Workflow
helps to implement this way of thinking.

Workflow is a unidirectional data flow library, where an immutable public state is used to determine
the how the view looks. Data flows from the data source to the UI, and events are sent from UI to the
business logic. The state cannot be mutated from the view layer itself.

When a workflow is created, it is intended to be responsible for a single view, output a single screen,
and may or may not accept in data (props), generate output, and have a state. When tied in with multiple screen
and more business logic, workflows can have children. These child workflows may feed data back up to the parent workflow.

A workflow can be either be stateful or stateless

Stateful Workflow 

A stateful workflow, as the name describes, maintains a state. In Kotlin, this state is generally a data
class with properties that represent the state of the screen. For example, you can have a state
that maintains a list of objects in a single property. This property can have an empty list or a non-empty list of objects.
This state can change through actions performed by the user. For example, if the user removes or adds
objects to the list, or if the user triggers a network call that updates the list.

A stateful workflow can be seen as an engine that is constantly running, increasing or decreasing in RPM
as the driver presses down or eases up on the throttle, but still always providing output as it runs.

Stateless Workflow

A stateless workflow is a workflow that does NOT maintain a state. This is seen for workflows where they
does not need to maintain actions by users, and just display data passed down to it from it's parent workflow.
These workflows are generally more simple as it is just given data, and then renders that data onto the screen.

A stateless workflow can be seen as a manual machine, that when given something, can provide an output, but otherwise
remains idle until given another piece of input.

### Comparison to a reactive VM approach

