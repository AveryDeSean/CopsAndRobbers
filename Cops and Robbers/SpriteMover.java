
public class SpriteMover implements Runnable
{
    View view;
    Model model;

    public SpriteMover(View view,Model model)
    {
        this.model=model;
        this.view=view;
    }



    public void run() {
        while (true) 
        {
            model.updateScene(view.getWidth(), view.getWidth());
            view.repaint();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {}
        }

    }
}