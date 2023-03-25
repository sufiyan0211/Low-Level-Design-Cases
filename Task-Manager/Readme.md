# TASK MANAGER
(This Use case is taken from [Spring boot crash course](https://www.scaler.com/topics/course/java-spring-boot-blogging-app/))

## Content
* [Problem Statement](#problem-statement)
* [Requirements](#requirements)
* [Basic Flow](#basic-flow)
* [Good to haves](#good-to-haves)

## Problem Statement
Design and develop an in memory (*NO DATABASE*) web application for managing personal tasks and notes within a given task.


## Requirements
- CRUD capabilities for tasks and for **NOTES** within a **TASK**. - *Notes can be considered as descriptors to that task*
- A **TASK** should be able to have multiple **NOTES** linked to it. Initially, a not can only be linked to one task. - *i.e. a TASK has many NOTES*
- A simple UI for the user to be able to view and interact with **TASKS** and **NOTES**


## Basic Flow
*Subject to changes basis of how you want the overall UX to be*
1. Initial page where user can view current tasks and also a form to create a new one along with notes inside it
2. Capability to click on Edit/Delete buttons against each task for one to be able to Modify/Delete a task
3. Capability to be able to see notes within a task after clicking on it
4. Capability to remove or add notes in existing tasks


## Good to haves 
(Optional Requirements)
*Try to work on these features once all the required features are complete*
- Adding functionality to have some priority order for tasks and be able to update task priorites
- Adding various tasks to task buckets for easy management
- Support to have email reminders when tasks approach deadlines
