abstract class Graphic {

	
	/**
	 * Create a clone of this graphic object.
	 */
	public abstract Graphic clone();


    public abstract String getUrl();
	
}

class GraphicTool {

	private Graphic prototype;
	
	/**
	 * Crates a graphictool by using a prototype
	 * @param prototype
	 */
	public GraphicTool(Graphic prototype){
		this.prototype = prototype;
	}
	
	
	/**
	 * Method internal to the framework
	 * @return
	 */
	protected Graphic createGraphic(){
		return prototype.clone();
	}

    public void setPrototype(Graphic prototype) {
        this.prototype = prototype;
    }
}

class Video extends Graphic{

	private String url;
	
	@Override
	public Graphic clone() {
		Video clone = new Video();
		clone.setUrl(this.url);
		return clone;
	}

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
		this.url = url;
	}
	
}


class Image extends Graphic{

	private String url;
	
	@Override
	public Graphic clone() {
		// create new clone
		Image clone = new Image();
		clone.setUrl(this.url);
		return clone;
	}

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
		this.url = url;
	}
	
}


class main {

	public static void main(String [] args){
		
        Image image = new Image();
        image.setUrl("http://test.com");

        GraphicTool tool = new GraphicTool(image);

        Graphic graphic = tool.createGraphic();

        System.out.println("Graphic instance "+graphic.getClass());
        System.out.println("Graphic url "+graphic.getUrl());

        image.setUrl("test");

        graphic = tool.createGraphic();
        System.out.println("Graphic url "+graphic.getUrl());

        Video video = new Video();
        video.setUrl("http://test.video.com");

        tool.setPrototype(video);

        graphic = tool.createGraphic();

        System.out.println("Graphic instance "+graphic.getClass());
        System.out.println("Graphic url "+graphic.getUrl());

		
	}
	
}