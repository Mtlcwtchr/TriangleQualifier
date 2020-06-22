package by.bsuir.trianglequalifier.util;

import by.bsuir.trianglequalifier.entity.Triangle;

public class TriangleQualifier {

    private final Triangle qualifyingTriangle;
    private final static double RESIDUAL = 0.001;

    public TriangleQualifier(Triangle qualifyingTriangle){
        this.qualifyingTriangle = qualifyingTriangle;
    }

    public Triangle getQualifyingTriangle() {
        return qualifyingTriangle;
    }

    public OfAngleType qualifyOfAngleType(){
        if(qualifyingTriangle.getAlpha()>Math.toDegrees(Math.PI/2)+RESIDUAL ||
                qualifyingTriangle.getBeta()>Math.toDegrees(Math.PI/2)+RESIDUAL ||
                qualifyingTriangle.getGamma()>Math.toDegrees(Math.PI/2)+RESIDUAL) {
            return OfAngleType.OBTUSE;
        } else if(Math.abs(qualifyingTriangle.getAlpha()-Math.toDegrees(Math.PI/2))<=RESIDUAL ||
                Math.abs(qualifyingTriangle.getBeta()-Math.toDegrees(Math.PI/2))<=RESIDUAL ||
                Math.abs(qualifyingTriangle.getGamma()-Math.toDegrees(Math.PI/2))<=RESIDUAL) {
            return OfAngleType.RECTANGULAR;
        } else {
            return OfAngleType.ACUTE_ANGLED;
        }
    }

    public OfSideType qualifyOfSideType(){
        if(Math.abs((qualifyingTriangle.getAb()-qualifyingTriangle.getAc()))<=RESIDUAL &&
                Math.abs(qualifyingTriangle.getAb()-qualifyingTriangle.getBc())<=RESIDUAL){
            return OfSideType.EQUILATERAL;
        } else if(Math.abs(qualifyingTriangle.getAb()-qualifyingTriangle.getAc())<=RESIDUAL ||
                Math.abs(qualifyingTriangle.getAb()-qualifyingTriangle.getBc())<=RESIDUAL ||
                Math.abs(qualifyingTriangle.getAc()-qualifyingTriangle.getBc())<=RESIDUAL) {
            return OfSideType.ISOSCELES;
        } else {
            return OfSideType.SIMPLE;
        }
    }

}
