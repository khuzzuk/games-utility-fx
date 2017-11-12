package pl.khuzzuk.games.utility.fx;

import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

/**
 * Points are measured ordinal where 3 is the top point, 0 is the bottom and it is counted counter clockwise: <br/>
 * __3 <br/>
 * 4___2 <br/>
 * 5___1 <br/>
 * __0 <br/>
 */
public class HexFactory {
    public static LineTo[] drawLines(int x, int y, int r, int[] points) {
        LineTo[] drawing = new LineTo[points.length];
        for (int i = 0; i < points.length; i++) {
            double rad = Math.toRadians((double) 60 * points[i]);
            drawing[i] = new LineTo(getX(x, r, rad), getY(y, r, rad));
        }

        return drawing;
    }

    public static MoveTo getStartingPoint(int x, int y, int r, int point) {
        double rad = Math.toRadians((double) 60 * point);
        return new MoveTo(getX(x, r, rad), getY(y, r, rad));
    }

    public static double getX(double x, double r, double radians) {
        return Math.sin(radians) * r + x;
    }

    public static double getY(double y, double r, double radians) {
        return Math.cos(radians) * r + y;
    }

    /**
     * creates full hex represented by {@link Path}.
     * @param x starting x, it may be determined with {@link HexFactory#getX(double, double, double)}.
     * @param y As above, but for y's.
     * @param r size of hex, which usually is the same size as for getX/getY methods.
     * @return {@link Path} with a shape of hex.
     */
    public static Path getHex(int x, int y, int r) {
        Path icon = new Path(getStartingPoint(x, y, r, 0));
        icon.getElements().addAll(drawLines(x, y, r, new int[]{1, 2, 3, 4, 5}));
        icon.getElements().addAll(new ClosePath());
        return icon;
    }
}
