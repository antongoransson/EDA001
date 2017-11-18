package mountain;

import fractal.Fractal;
import fractal.TurtleGraphics;

public class Mountain extends Fractal{
	private Point p3, p1, p2;

	public Mountain(Point p1, Point p2, Point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	public void draw(TurtleGraphics turtle) {
		turtle.moveTo(p1.getX(), p1.getY());
		fractalTriangle(turtle,p1,p2,p3, order);
	}
	private void fractalTriangle(TurtleGraphics turtle, Point p1, Point p2, Point p3, int order){
		if(order == 0){
			turtle.moveTo(p1.getX(), p1.getY());
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
		} else{
			Point side12= new Point((p1.getX()+p2.getX())/2,(p1.getY() + p2.getY())/2);
			Point side23= new Point((p2.getX()+p3.getX())/2,(p2.getY() + p3.getY())/2);
			Point side31= new Point((p3.getX()+p1.getX())/2,(p3.getY() + p1.getY())/2);
		 	fractalTriangle(turtle,side12,side23,side31,order -1);
			fractalTriangle(turtle,p2,side23,side12,order -1);
			fractalTriangle(turtle,p3,side23,side31,order -1);
			fractalTriangle(turtle,p1,side12,side31,order -1);
		}
	}
	@Override
	public String getTitle() {
		return "Mountain";
	}
}
