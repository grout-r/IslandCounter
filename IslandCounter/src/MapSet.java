import java.util.ArrayList;

/**
 * Created by Roman on 08/04/2017.
 */
public class MapSet
{
    MapSet()
    {

    }

    ArrayList<Map> generateMaps(CommandFull command)
    {
        maps = new ArrayList<>();
        for (int i = 0; i != command.setSize; i++)
        {
            maps.add(new Map(command.size.x, command.size.y));
        }
        return maps;
    }

    void displaySet()
    {
        for (int i = 0; i != maps.size(); i++)
        {
            System.out.printf("\n\nMap #" + i + "\n");
            maps.get(i).display();
        }
    }

    public void countIsland(int id)
    {
        maps.get(id).count();
    }

    ArrayList<Map> maps;

}
