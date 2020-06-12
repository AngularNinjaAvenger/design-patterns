class Window {

      public void draw(){
          System.out.println("Drawing window");
      }

  }

  // the only class that extends the widnow
  class WindowDecorator extends Window{

  protected Window window;

  public WindowDecorator(Window window) {
      this.window = window;
  }

  @Override
  public void draw() {
      window.draw();
  }

  // now when you want to create sub functionality  that need the window object you can just extend the window decorator and
  class ScrollbarWindowDecorator extends WindowDecorator{

    public ScrollbarWindowDecorator(Window window) {
      super(window);
    }

    @Override
    public void draw() {
      System.out.println("Draw a scrollbar");

      window.draw();
    }
  }
}

    // the window class here here extending the window decorator instead of the window object
    class ScrollbarWindowDecorator extends WindowDecorator{

    public ScrollbarWindowDecorator(Window window) {
    super(window);
    }

    @Override
    public void draw() {
    System.out.println("Draw a scrollbar");

    window.draw();
    }

    }

    class Client {

public static void main(String[] args) {
     Window window = new Window();
    ScrollbarWindowDecorator scrollBarWindow = new ScrollbarWindowDecorator(window);
    scrollBarWindow.draw();
    }
}