import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Roman on 08/04/2017.
 */
public class Map
{
    Map(int x, int y)
    {
        point = new Point();
        point.x = x;
        point.y = y;
        content = new int[x][y];
        rand = new Random();
        islands = new ArrayList<>();
        populate();
    }

    private void populate()
    {
        for (int i = 0; i != point.x; i++)
        {
            for (int j = 0; j != point.y; j++)
            {
                content[i][j] = rand.nextInt(2);
            }
        }
    }

    void display()
    {
        for (int i = 0; i != point.y; i++)
        {
            for (int j = 0; j != point.x; j++)
            {
                System.out.print(content[j][i]);
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
            islands.get(island).add(new Point(x - 1, y));
            exploreIsland(x - 1, y, island);
        }
        if (x + 1 < point.x && content[x + 1][y] == 1 && !isAlreadyRegistered(x + 1, y))
        {
            islands.get(island).add(new Point(x + 1, y));
            exploreIsland(x + 1, y, island);
        }
        if (y - 1 > 0 && content[x][y - 1] == 1 && !isAlreadyRegistered(x, y - 1))
        {
            islands.get(island).add(new Point(x, y - 1));
            exploreIsland(x, y - 1, island);
        }
        if (y + 1 < point.y && content[x][y + 1] == 1 && !isAlreadyRegistered(x, y + 1))
        {
            islands.get(island).add(new Point(x, y + 1));
            exploreIsland(x, y + 1, island);
        }
    }

    void count()
    {
        for (int i = 0; i != point.x; i++)
        {
            for (int j = 0; j != point.y; j++)
            {
                if (content[i][j] == 1 && !isAlreadyRegistered(i, j))
                {
                    islands.add(new ArrayList<>());
                    islands.get(islands.size() - 1).add(new Point(i, j));
                    exploreIsland(i, j, islands.size() - 1);
                }
            }
        }
        System.out.println("SIZE " + islands.size());

    }

    ArrayList<ArrayList<Point>> islands;
    Random rand;
    int [][] content;
    Point point;

}
