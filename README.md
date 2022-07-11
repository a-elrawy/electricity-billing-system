# Electricity Billing System

> a desktop application built with java, javaFX, and File-based storage system.
## Components

#### 1 -  Old Customer Module

- Enables customer to pay a bill with meter code
- Enables customer to enter monthly reading of meter
- Enables customer to complain about bill with meter code.
- System will send email automatically if customer didn’t pay within 3 months.

#### 2 - New Customer Module
- Enables customer to fill all information
- Enables customer to attach copy of contract (apartment, …)
- System will send email automatically to notify customer when meter is ready.

#### 3 - Operator Module
- Enables operator to collect payments from customer
- Enables operator to print bill with meter code
- Enables operator to view bills of specific region.
- Enables operator to validate reading with real consumption.
- Enables operator to define tariff for customer.
- Enables operator to stop meter and cancel subscription for customer.

#### 4 - Admin Module

- Enables admin to view all bills of specific regions.
- Enables admin to view total collected.
- Enables admin to make consumption statistics for specific region.
- Enables admin to add / update / delete users with different roles.



## Requirements
* Java11+
* Maven

## Installation
1. Download the repository (project) from the download section or clone it using the following command:
   ```shell
   git clone https://github.com/a-elrawy/electricity-system
   ```
2. Run the app by running the maven command inside the project folder:
   ```shell
   mvn clean javafx:run
   ```
