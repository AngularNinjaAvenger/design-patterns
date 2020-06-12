// interface || abstrac class
abstract class WindowImpl {

    public abstract void draw(int x, int y, int width, int height, String colour);

}

class Window {

    private WindowImpl window;

    public void draw(int x, int y, int width, int height, String colour){
        window.draw(x,y,width,height,colour);
    }


    public void setWindow(WindowImpl window) {
        this.window = window;
    }
}


class LinuxWindowImpl extends WindowImpl{

    @Override
    public void draw(int x, int y, int width, int height, String colour) {
        System.out.println("Drawing on linux x: "+x+" y: "+y+"  width: "+width+ " height "+height);
    }

}

class DirectXWindowImpl extends WindowImpl {

    @Override
    public void draw(int x, int y, int width, int height, String colour) {
        System.out.println("Drawing on direct x: "+x+" y: "+y+"  width: "+width+ " height "+height);
    }

}
