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

    Random rand;
    int [][] content;
    Size size;

}
