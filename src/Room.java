import java.util.ArrayList;
import java.util.List;

public class Room
{
    private int roomID;
    private String name;
    private List<String> description;
    private boolean hasVisited;
    private List<Exit> exits;

    public Room(int roomID, String name, List<String> description)
    {
        this.roomID = roomID;
        this.name = name;
        this.description = description;
        hasVisited = false;
        exits = new ArrayList<>();
    }

    public void AddExit(Exit exit){ exits.add(exit); }

    public void SetVisitation(boolean hasVisited){ this.hasVisited = hasVisited; }

    public int GetRoomID(){ return roomID; }
    public String GetName(){ return name; }
    public List<String> GetDescription(){ return description; }
    public boolean HasVisited(){ return hasVisited; }
    public List<Exit> GetExits(){ return exits; }

    @Override
    public String toString()
    {
        return "ID = " + roomID + ", Name = " + name + ", Description = " + description.toString();
    }
}
