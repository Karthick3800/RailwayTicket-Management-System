# Railway Ticket Management System

This project is a console-based Railway Ticket Management System developed in Java. It allows users to book and cancel railway tickets, check available tickets, and view booked tickets. The system handles different types of berths (lower, middle, upper), RAC (Reservation Against Cancellation), and waiting lists.

## Features

- **Book Ticket**: Allows users to book a ticket with berth preferences.
- **Cancel Ticket**: Allows users to cancel a booked ticket.
- **Check Availability**: Displays the number of available lower, middle, upper berths, RAC, and waiting list positions.
- **View Booked Tickets**: Displays the details of all booked passengers.

You will be presented with a menu to choose different actions:
- Book Ticket
- Cancel Ticket
- Available Tickets
- Booked Tickets
- Exit

------------


**Classes and Methods**
RailwayTicketManagementSys
**bookticket(passenger p):** Handles the logic for booking a ticket based on berth preferences and availability.
**cancelTicket(int id):** Cancels a booked ticket and updates the available berths, RAC, and waiting list.
**main(String[] args):** Main method to run the application and present the menu to the user.
ticketbooking
**Attributes:** Tracks available lower, middle, and upper berths, RAC, and waiting list positions.
**bookticket(passenger p, int seatnum, String allotedbirth):** Books a ticket and updates the passenger details.
**addToRAC(passenger p, int racInfo, String allotedRAC):** Adds a passenger to the RAC list.
**addToWaitingList(passenger p, int waitingListInfo, String allotedWL): **Adds a passenger to the waiting list.
**cancelTicket(int passengerId):** Cancels a booked ticket and handles the RAC and waiting list adjustments.
**printAvailable(): **Prints the number of available lower, middle, upper berths, RAC, and waiting list positions.
**printPassengers():** Prints the details of all booked passengers.
passenger
**Attributes: **Stores passenger details such as name, age, berth preference, passenger ID, allotted berth type, and seat number.
**Constructor:** Initializes a new passenger with the provided name, age, and berth preference.


