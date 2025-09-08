import java.util.*;

class Room {
    String roomNumber;
    String roomType;
    double pricePerNight;
    boolean isAvailable;
    int maxOccupancy;

    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
        this.maxOccupancy = maxOccupancy;
    }
}

class Guest {
    String guestId;
    String guestName;
    String phoneNumber;
    String email;
    String[] bookingHistory;
    int historyCount;

    public Guest(String guestId, String guestName, String phoneNumber, String email) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new String[20];
        this.historyCount = 0;
    }

    public void addBookingHistory(String bookingId) {
        if (historyCount < bookingHistory.length) {
            bookingHistory[historyCount++] = bookingId;
        }
    }
}

class Booking {
    String bookingId;
    Guest guest;
    Room room;
    String checkInDate;
    String checkOutDate;
    double totalAmount;

    // Static variables
    static int totalBookings = 0;
    static double hotelRevenue = 0.0;
    static String hotelName = "Grand SRM Hotel";

    public Booking(String bookingId, Guest guest, Room room, String checkInDate, String checkOutDate, double totalAmount) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;

        totalBookings++;
        hotelRevenue += totalAmount;
    }

    // Reservation Management
    public static Booking makeReservation(String bookingId, Guest guest, Room room, String checkInDate, String checkOutDate, int nights) {
        if (room.isAvailable) {
            double bill = calculateBill(room.pricePerNight, nights);
            Booking booking = new Booking(bookingId, guest, room, checkInDate, checkOutDate, bill);
            room.isAvailable = false;
            guest.addBookingHistory(bookingId);
            System.out.println("Reservation successful! Booking ID: " + bookingId + " | Amount: ₹" + bill);
            return booking;
        } else {
            System.out.println("Room " + room.roomNumber + " is not available.");
            return null;
        }
    }

    public static void cancelReservation(Booking booking) {
        if (booking != null) {
            booking.room.isAvailable = true;
            hotelRevenue -= booking.totalAmount;
            totalBookings--;
            System.out.println("Booking " + booking.bookingId + " cancelled. Refund: ₹" + booking.totalAmount);
        }
    }

    public static boolean checkAvailability(Room room) {
        return room.isAvailable;
    }

    public static double calculateBill(double pricePerNight, int nights) {
        return pricePerNight * nights;
    }

    // Reporting Methods
    public static double getOccupancyRate(Room[] rooms) {
        int totalRooms = rooms.length;
        int occupied = 0;
        for (Room r : rooms) {
            if (!r.isAvailable) occupied++;
        }
        return ((double) occupied / totalRooms) * 100;
    }

    public static double getTotalRevenue() {
        return hotelRevenue;
    }

    public static String getMostPopularRoomType(List<Booking> bookings) {
        Map<String, Integer> countMap = new HashMap<>();
        for (Booking b : bookings) {
            countMap.put(b.room.roomType, countMap.getOrDefault(b.room.roomType, 0) + 1);
        }
        String popular = "N/A";
        int max = 0;
        for (String type : countMap.keySet()) {
            if (countMap.get(type) > max) {
                max = countMap.get(type);
                popular = type;
            }
        }
        return popular;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize Rooms
        Room[] rooms = {
            new Room("101", "Single", 2000, 1),
            new Room("102", "Double", 3500, 2),
            new Room("103", "Suite", 6000, 4),
            new Room("104", "Single", 2000, 1),
            new Room("105", "Double", 3500, 2)
        };

        // Guests
        Guest g1 = new Guest("G001", "Alice", "9876543210", "alice@mail.com");
        Guest g2 = new Guest("G002", "Bob", "9123456789", "bob@mail.com");

        List<Booking> allBookings = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n--- " + Booking.hotelName + " Reservation Menu ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reports");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- Available Rooms ---");
                    for (Room r : rooms) {
                        if (r.isAvailable) {
                            System.out.println(r.roomNumber + " | " + r.roomType + " | ₹" + r.pricePerNight + " | Max Occupancy: " + r.maxOccupancy);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Guest ID (G001/G002): ");
                    String gid = sc.nextLine();
                    Guest guest = gid.equals("G001") ? g1 : g2;

                    System.out.print("Enter Room Number: ");
                    String rnum = sc.nextLine();
                    Room selectedRoom = null;
                    for (Room r : rooms) {
                        if (r.roomNumber.equals(rnum)) {
                            selectedRoom = r;
                            break;
                        }
                    }

                    if (selectedRoom != null && Booking.checkAvailability(selectedRoom)) {
                        System.out.print("Enter Check-in Date: ");
                        String in = sc.nextLine();
                        System.out.print("Enter Check-out Date: ");
                        String out = sc.nextLine();
                        System.out.print("Enter Nights: ");
                        int nights = sc.nextInt();
                        sc.nextLine();

                        String bid = "B" + (Booking.totalBookings + 1);
                        Booking booking = Booking.makeReservation(bid, guest, selectedRoom, in, out, nights);
                        if (booking != null) allBookings.add(booking);
                    } else {
                        System.out.println("Room not available.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Booking ID to cancel: ");
                    String bid = sc.nextLine();
                    Booking cancelBooking = null;
                    for (Booking b : allBookings) {
                        if (b.bookingId.equals(bid)) {
                            cancelBooking = b;
                            break;
                        }
                    }
                    if (cancelBooking != null) {
                        Booking.cancelReservation(cancelBooking);
                        allBookings.remove(cancelBooking);
                    } else {
                        System.out.println("Booking not found.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Hotel Reports ---");
                    System.out.println("Total Bookings: " + Booking.totalBookings);
                    System.out.println("Total Revenue: ₹" + Booking.getTotalRevenue());
                    System.out.println("Occupancy Rate: " + Booking.getOccupancyRate(rooms) + "%");
                    System.out.println("Most Popular Room Type: " + Booking.getMostPopularRoomType(allBookings));
                    break;

                case 0:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
