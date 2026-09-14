# Problem Statement

**Project Title:** Smart Campus Complaint & Maintenance Management System

## Problem Statement
University campuses rely on a wide range of physical infrastructure (classrooms, plumbing, electrical fixtures, network hardware) that regularly require maintenance. Currently, reporting broken infrastructure is often handled via scattered emails, verbal complaints, or paper registers. This leads to slow response times, lack of accountability, and an inability for students to track whether their reported issues are being addressed. A centralized system is required to bring order to this process.

## Scope of the Project
This project provides a focused, console-based digital solution for reporting and managing campus infrastructure complaints. The scope includes:
- Secure, role-based login workflows.
- A centralized list for complaint creation, assignment, and resolution.
- Persistent file-based data storage for tracking historical complaints.
The scope is strictly limited to issue tracking and does not extend to broader facilities management features like payroll, inventory purchasing, or vendor contracting.

## Target Users
- **Students / Staff:** The primary reporters who experience the infrastructure issues firsthand.
- **Administrators:** The coordinators who monitor incoming complaints and assign them to appropriate personnel.
- **Maintenance Workers:** The ground staff responsible for viewing their assigned tasks and resolving them physically.

## High-Level Features
- **Issue Reporting:** Quick generation of complaint tickets containing descriptions and auto-incrementing IDs.
- **Assignment System:** Ability for administrators to direct specific tickets to targeted maintenance usernames.
- **Lifecycle Management:** Strict status transitions (OPEN -> ASSIGNED -> RESOLVED).
- **Data Persistence:** Automatic binary file serialization (`complaints.dat`) to ensure all tickets survive application restarts.
