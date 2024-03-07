import java.util.ArrayList;
import java.util.Scanner;

public class Event {
    private String eventID;
    private String eventName;
    private String eventVenue;
    private String eventDate;
    private ArrayList<String> eventAttendees;

    public Event(String eventID, String eventName, String eventVenue, String eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.eventAttendees = new ArrayList<>();
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<String> getEventAttendees() {
        return eventAttendees;
    }

    public void addAttendee(String attendee) {
        eventAttendees.add(attendee);
    }

    public void removeAttendee(String attendee) {
        eventAttendees.remove(attendee);
    }

    public void updateAttendee(String oldName, String newName) {
        int index = eventAttendees.indexOf(oldName);
        if (index != -1) {
            eventAttendees.set(index, newName);
        }
    }

    public boolean findAttendee(String attendee) {
        return eventAttendees.contains(attendee);
    }

    public int totalAttendees() {
        return eventAttendees.size();
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID='" + eventID + '\'' +
                ", eventName='" + eventName + '\'' +
                ", eventVenue='" + eventVenue + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventAttendees=" + eventAttendees +
                '}';
    }

    public static Event organizeEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter event ID:");
        String eventID = scanner.nextLine();
        System.out.println("Enter event name:");
        String eventName = scanner.nextLine();
        System.out.println("Enter event venue:");
        String eventVenue = scanner.nextLine();
        System.out.println("Enter event date:");
        String eventDate = scanner.nextLine();

        Event event = new Event(eventID, eventName, eventVenue, eventDate);

        System.out.println("Enter the number of attendees:");
        int numAttendees = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < numAttendees; i++) {
            System.out.println("Enter attendee name:");
            String attendee = scanner.nextLine();
            event.addAttendee(attendee);
        }

        return event;
    }

    public static void main(String[] args) {
        Event event = Event.organizeEvent();
        System.out.println("Event details:");
        System.out.println(event);
        System.out.println("Total number of attendees: " + event.totalAttendees());
    }
}
