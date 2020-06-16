
class Application {

    private List<Image> images = new ArrayList<Image>();

    public Application(List<Image> images) {
        this.images = images;
    }

    public void draw(){
        for (Image image : images) {
            image.draw();
        }
    }

}


class Image {

    protected String url;

    public Image() {
    }

    public Image(String url) {
        System.out.println("Loading image");
        this.url = url;
    }

    public void draw(){
        System.out.println("Draw image from url "+url);
    }

}


// the proxy
class ImageProxy extends Image{

    private Image image;

    public ImageProxy(String url) {
        super();
        this.url = url;
    }

    @Override
    public void draw() {
        if(image ==null){
            image = new Image(this.url);
        }
        image.draw();
    }
}





class Client {

    public static void main(String[] args) {

        ImageProxy image = new ImageProxy("test image");
        ImageProxy image2 = new ImageProxy("second image");

        List<Image> images = new ArrayList<Image>();
        images.add(image);
        images.add(image2);

        Application application = new Application(images);


        System.out.println("Application setup");

        application.draw();

    }

}
