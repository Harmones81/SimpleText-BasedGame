public class Player
{


    private Room currentRoom;

    public Player(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }

    public void SetCurrentRoom(Room room){ this.currentRoom = room; }

    public Room GetCurrentRoom(){ return this.currentRoom; }
}
