package by.bsuir.trianglequalifier.entity;

import org.apache.camel.util.Pair;

import java.util.Objects;

public class Triangle {

    /* Вершины треугольника определенные координатами X и Y как Pair<X,Y> */
    private final Pair<Double> a;
    private final Pair<Double> b;
    private final Pair<Double> c;

    /* Стороны треугольника */
    private final double ab;
    private final double bc;
    private final double ac;

    /* Углы треугольника, где alpha - угол при a, beta - угол при b, gamma - угол при c  */
    private final double alpha;
    private final double beta;
    private final double gamma;

    public Triangle(Pair<Double> a, Pair<Double> b, Pair<Double> c) {
        this.a = a;
        this.b = b;
        this.c = c;
        ab = getSide(a, b);
        bc = getSide(b, c);
        ac = getSide(a, c);
        alpha = getAngle(bc, ab, ac);
        beta = getAngle(ac, ab, bc);
        gamma = getAngle(ab, ac, bc);
    }

    public Pair<Double> getA() {
        return a;
    }
    public Pair<Double> getB() {
        return b;
    }
    public Pair<Double> getC() {
        return c;
    }
    public double getAlpha() {
        return alpha;
    }
    public double getBeta() {
        return beta;
    }
    public double getGamma() {
        return gamma;
    }
    public double getAb() {
        return ab;
    }
    public double getBc() {
        return bc;
    }
    public double getAc() {
        return ac;
    }

    private double getSide(Pair<Double> firstPoint, Pair<Double> secondPoint){
        return Math.sqrt((firstPoint.getLeft()-secondPoint.getLeft())*(firstPoint.getLeft()-secondPoint.getLeft()) + (firstPoint.getRight()-secondPoint.getRight())*(firstPoint.getRight()-secondPoint.getRight()));
    }
    private double getAngle(double oppositeSide, double... adjacentSides){
        return Math.toDegrees(Math.acos((adjacentSides[0] * adjacentSides[0] + adjacentSides[1] * adjacentSides[1] - oppositeSide * oppositeSide) /
                (2 * adjacentSides[0] * adjacentSides[1])));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.ab, ab) == 0 &&
                Double.compare(triangle.bc, bc) == 0 &&
                Double.compare(triangle.ac, ac) == 0 &&
                Double.compare(triangle.alpha, alpha) == 0 &&
                Double.compare(triangle.beta, beta) == 0 &&
                Double.compare(triangle.gamma, gamma) == 0 &&
                Objects.equals(a, triangle.a) &&
                Objects.equals(b, triangle.b) &&
                Objects.equals(c, triangle.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, ab, bc, ac, alpha, beta, gamma);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", ab=" + ab +
                ", bc=" + bc +
                ", ac=" + ac +
                ", alpha=" + alpha +
                ", beta=" + beta +
                ", gamma=" + gamma +
                '}';
    }
}
