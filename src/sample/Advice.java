package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.Serializable;

public class Advice implements Serializable {
    protected ImageView imageView = new ImageView();
    private final String img_url = "src/images/extraImages/scroll.png";
    String getName() {
        return this.img_url;
    }
    public ImageView getImageView() {
        String img = null;
        Image image = null;
        img = img_url;
        try {
            File file = new File(img);
            img = file.toURI().toURL().toExternalForm();
            image = new Image(img);
        }
        catch(Exception e) {
            //do nothing
        }
        imageView.setImage(image);
        imageView.setFitHeight(66);
        imageView.setFitWidth(40);
        return imageView;
    }
}
