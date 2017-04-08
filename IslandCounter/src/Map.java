import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Roman on 08/04/2017.
 */
public class Map
{
    Map(int x, int y)
    {
        size = new Size();
        size.x = x;
        size.y = y;
        content = new int[x][y];
        rand = new Random();
        islands = new ArrayList<>();
        populate();
    }

    private void populate()
    {
        for (int i = 0; i != size.x; i++)
        {
            for (int j = 0; j != size.y; j++)
            {
                content[i][j] = rand.nextInt(2);
            }
        }
    }

    void display()
    {
        for (int i = 0; i != size.x; i++)
        {
            for (int j = 0; j != size.y; j++)
            {
                System.out.print(content[i][j]);
            }
            System.out.println("");
        }
    }

    private boolean isAlreadyRegistered(int x, int y)
    {
        for (int i = 0; i != islands.size(); i++)
        {
            for (int j = 0; j != islands.get(i).size(); j++)
            {
                if (islands.get(i).get(j).x == x && islands.get(i).get(j).y == y)
                    return true;
            }
        }
        return false;
    }

    private void exploreIsland(int x, int y, int island)
    {
        if (x - 1 > 0 && content[x - 1][y] == 1 && !isAlreadyRegistered(x - 1, y))
        {
            islands.get(island).add(new Size(x - 1, y));
            exploreIsland(x - 1, y, island);
        }
        if (x + 1 < size.x && content[x + 1][y] == 1 && !isAlreadyRegistered(x + 1, y))
        {
            islands.get(island).add(new Size(x + 1, y));
            exploreIsland(x + 1, y, island);
        }
        if (y - 1 > 0 && content[x][y - 1] == 1 && !isAlreadyRegistered(x, y - 1))
        {
            islands.get(island).add(new Size(x, y - 1));
            exploreIsland(x, y - 1, island);
        }
        if (y + 1 < size.y && content[x][y + 1] == 1 && !isAlreadyRegistered(x, y + 1))
        {
            islands.get(island).add(new Size(x, y + 1));
            exploreIsland(x, y + 1, island);
        }
    }

    void count()
    {
        for (int i = 0; i != size.x; i++)
        {
            for (int j = 0; j != size.y; j++)
            {
                if (content[i][j] == 1 && !isAlreadyRegistered(i, j))
                {
                    islands.add(new ArrayList<Size>());
                    islands.get(islands.size() - 1).add(new Size(i, j));
                    exploreIsland(i, j, islands.size() - 1);
                    //new island
                }
            }
        }
        System.out.println("SIZE " + islands.size());

    }

    ArrayList<ArrayList<Size>> islands;
    Random rand;
    int [][] content;
    Size size;

}
