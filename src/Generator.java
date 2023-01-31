import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generator
{
    /**
     * This class will be used to generate rooms and exits
     * by reading the appropriate text files (Rooms & Exits)
     */

    private List<Room> rooms;

    public Generator(){ rooms = new ArrayList<>(); }

    // Generates the rooms in the rooms list
    public void GenerateRooms()
    {
        try
        {
            File roomFile = new File("Rooms.txt");
            Scanner scanner = new Scanner(roomFile);

            // Create local instances of the needed values

            int tempID = 0;
            String tempName = "";
            List<String> tempDescription = new ArrayList<>();

            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String tempLine = line;

                // Clear the list at the start of each loop

                tempDescription = new ArrayList<>();

                // Determine if the current line is an integer --> for roomID

                if(IsStringInt(tempLine))
                {
                    tempID = Integer.parseInt(tempLine);
                }

                // If the amount of words in the line is more than 3 then it's a description
                // If it's not, and it's also not an integer, then it's the name of the room

                if(line.split(" ").length > 3)
                {
                    tempDescription.add(tempLine);
                }
                else
                {
                    if(!IsStringInt(tempLine))
                    {
                        tempName = tempLine;
                    }
                }

                // If all the local variables have been set to their new values then we create a new room
                // and add that room to the global list of rooms (rooms).

                if(tempID != 0 && tempName != "" && tempDescription.size() > 0)
                {
                    Room temp = new Room(tempID, tempName, tempDescription);
                    rooms.add(temp);
                }
            }

            scanner.close();

            GenerateExits();
        }
        catch(FileNotFoundException fne)
        {
            fne.printStackTrace();
        }
    }

    // Creates the appropriate exits for each room in the rooms list
    public void GenerateExits()
    {
        try
        {
            File exitFile = new File("Exits.txt");
            Scanner scanner = new Scanner(exitFile);

            int tempDestination = 0;
            String tempDirection = "";

            while(scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String tempLine = line;
                String[] lineData = tempLine.split(",");

                for(int i = 1; i < lineData.length; i++)
                {
                    String[] data = lineData[i].split(" ");

                    tempDirection = data[0];
                    tempDestination = Integer.parseInt(data[1]);

                    if(tempDestination != 0 && tempDirection != "")
                    {
                        for(Room room : rooms)
                        {
                            if(room.GetRoomID() == Integer.parseInt(lineData[0]))
                            {
                                room.AddExit(new Exit(tempDestination, tempDirection));
                            }
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException fne)
        {
            fne.printStackTrace();
        }

        /*for(Room room : rooms)
        {
            for(Exit exit : room.GetExits())
            {
                System.out.println(room.GetRoomID() + ", " + exit.toString());
            }
        }*/
    }

    // This is the method that checks whether a string is an integer or not
    private boolean IsStringInt(String string)
    {
        if(string == null)
            return false;

        try
        {
            int i = Integer.parseInt(string);
            return true;
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
    }

    public List<Room> GetRooms(){ return rooms; }
}
