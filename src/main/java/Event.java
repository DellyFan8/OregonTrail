public class Event {

    public enum EventType{RIVERCROSSING,ENDOFPROTYPE,  XYZ}
    public EventType eventType;
    public Double riverStage;
    public int riverwidth;
    public boolean hasFerry;
    public Event(EventType eventtype) {
        this.eventType= eventtype;
    }

    public Event(EventType eventType, double riverStage,boolean hasFerry) {
        this.eventType = eventType;
        this.riverStage = riverStage;
        this.hasFerry= hasFerry;
    }
    public boolean isHasFerry(){return this.hasFerry;}
    public double riverheight(double watertableincrease){
        double riverheight= watertableincrease+riverStage;
        return riverheight/25.4;

    }
    //Probably, pass an event to this class to see which type of event it is and do the event handling here. if location has event, pass location to "eventHandler"
    // check what event and/or location() are here.

    //Started on this but wanted to check with aaron to see if he agrees event is the best location to deal with this stuff


    public EventType getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventType=" + eventType +
                '}';
    }

}
