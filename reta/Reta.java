import java.lang.Math;

public class Reta{
	private Ponto p1;
	private Ponto p2;

	public Reta(Ponto p1, Ponto p2){
		this.p1 = p1;
		this.p2 = p2;
	}

	public double size() {
		float deltaX = this.p2.getX() - this.p1.getX();
		float deltaY = this.p2.getY() - this.p1.getY();

		double d = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

		return d;
	}

	public void setP1(Ponto value) {this.p1 = value;}

	public Ponto getP1() {return this.p1;}


	public void setP2(Ponto value) {this.p2 = value;}

	public Ponto getP2() {return this.p2;}

}
