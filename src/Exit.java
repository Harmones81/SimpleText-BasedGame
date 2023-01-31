public class Exit
{
    private int destination;
    private String direction;

    public Exit()
    {
        // For an empty exit
    }

    public Exit(int destination, String direction)
    {
        this.destination = destination;
        this.direction = direction;
    }

    public void SetDestination(int destination){ this.destination = destination; }
    public void SetDirection(String direction){ this.direction = direction; }

    public int GetDestination(){ return destination; }
    public String GetDirection(){ return direction; }

    @Override
    public String toString()
    {
        return "Destination = " + destination + ", Direction = " + direction;
    }
}
