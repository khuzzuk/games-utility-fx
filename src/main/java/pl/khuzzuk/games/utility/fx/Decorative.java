package pl.khuzzuk.games.utility.fx;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Shape;

/**
 * adds shadow effects for decoration. It should be added as trait for your custom {@link Shape}.
 */
public interface Decorative<T extends Shape> extends Element<T> {
    default void setBackground(Image background) {
        getElement().setFill(new ImagePattern(background, 0, 0, 1, 1, true));
        getElement().setStrokeWidth(0);
    }

    default void addDropShadow() {
        getElement().setEffect(new DropShadow(10, 0, 0, Color.BLACK));
    }

    default void addInner(int x, int y, int distance) {
        InnerShadow shadow = new InnerShadow(10, 0, 0, Color.BLACK);
        Light.Point light = new Light.Point(x, y, distance, Color.WHITE);
        Lighting lighting = new Lighting(light);
        shadow.setInput(lighting);
        getElement().setEffect(shadow);
    }

    default void addInnerShadow() {
        getElement().setEffect(new InnerShadow(10, 0, 0, Color.BLACK));
    }

    default void clearEffects() {
        getElement().setEffect(null);
    }
}
