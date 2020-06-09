interface WidgetFactory {
	ScrollBar createScrollBar();
	Window createWindow();
}

interface ScrollBar {}
interface Window {}


class PinkThemeWindow implements Window {}
class PinkThemeScrollBar implements ScrollBar{}
class PinkThemeWidgetFactory implements WidgetFactory {

	@Override
	public ScrollBar createScrollBar() {
		return new PinkThemeScrollBar();
	}

	@Override
	public Window createWindow() {
		return new PinkThemeWindow();
	}

}

class YellowThemeWindow implements Window {}
class YellowThemeScrollBar implements ScrollBar{}
class YellowThemeWidgetFactory implements WidgetFactory {

	@Override
	public ScrollBar createScrollBar() {
		return new YellowThemeScrollBar();
	}

	@Override
	public Window createWindow() {
		return new YellowThemeWindow();
	}

}


class Client {

	
	public static void initializeGUI(WidgetFactory factory){
		initializeGUI(factory.createScrollBar(), factory.createWindow());
	}
		
	public static void initializeGUI(ScrollBar bar, Window window){
		System.out.println("Do initazation logic here with "+bar.getClass().getName()+" and "+window.getClass().getName());
	}
	
	public static void main(String [] args){

        // here we are creating the pink and blue factory

        WidgetFactory factory = new PinkThemeWidgetFactory();
        initializeGUI(factory);

        factory = new  YellowThemeWidgetFactory();
        initializeGUI(factory);

		
	}
		
}