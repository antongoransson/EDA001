package fractal;

import koch.Koch;
import mountain.Point;
import mountain.Mountain;
import mountain.FixedMountain;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[3];
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(new Point(150,400),new Point(500,500),new Point(350,200));
		fractals[2] = new FixedMountain(new Point(10,550),new Point(600,500),new Point(350,200),50);
	    new FractalView(fractals, "Fraktaler");
	}
}
