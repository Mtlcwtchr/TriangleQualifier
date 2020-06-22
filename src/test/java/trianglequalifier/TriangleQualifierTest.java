package trianglequalifier;

import by.bsuir.trianglequalifier.util.OfAngleType;
import by.bsuir.trianglequalifier.util.OfSideType;
import by.bsuir.trianglequalifier.entity.Triangle;
import by.bsuir.trianglequalifier.util.TriangleQualifier;
import org.apache.camel.util.Pair;
import org.junit.Assert;
import org.junit.Test;

public class TriangleQualifierTest {

    @Test
    public void TriangleQualifierTest_Qualify_Rectangular(){
        Triangle triangle = new Triangle(new Pair<>(0D, 0D), new Pair<>(0D, 5.0D), new Pair<>(5.0D, 0D));
        OfAngleType expectedType = OfAngleType.RECTANGULAR;

        Assert.assertEquals(expectedType, new TriangleQualifier(triangle).qualifyOfAngleType());
    }

    @Test
    public void TriangleQualifierTest_Qualify_Acute_angled(){
        Triangle triangle = new Triangle(new Pair<>(0D, 0D), new Pair<>(2.0D, 7.0D), new Pair<>(4.0D, 0D));
        OfAngleType expectedType = OfAngleType.ACUTE_ANGLED;

        Assert.assertEquals(expectedType, new TriangleQualifier(triangle).qualifyOfAngleType());
    }

    @Test
    public void TriangleQualifierTest_Qualify_Obtuse(){
        Triangle triangle = new Triangle(new Pair<>(0D, 0D), new Pair<>(7.0D, 7.0D), new Pair<>(14.0D, 2.0D));
        OfAngleType expectedType = OfAngleType.OBTUSE;

        Assert.assertEquals(expectedType, new TriangleQualifier(triangle).qualifyOfAngleType());
    }

    @Test
    public void TriangleQualifierTest_Qualify_Simple(){
        Triangle triangle = new Triangle(new Pair<>(0D, 0D), new Pair<>(7.0D, 7.0D), new Pair<>(14.0D, 2.0D));
        OfSideType expectedType = OfSideType.SIMPLE;

        Assert.assertEquals(expectedType, new TriangleQualifier(triangle).qualifyOfSideType());
    }

    @Test
    public void TriangleQualifierTest_Qualify_Isosceles(){
        Triangle triangle = new Triangle(new Pair<>(0D, 0D), new Pair<>(0D, 5.0D), new Pair<>(5.0D, 0D));
        OfSideType expectedType = OfSideType.ISOSCELES;

        Assert.assertEquals(expectedType, new TriangleQualifier(triangle).qualifyOfSideType());
    }

    @Test
    public void TriangleQualifierTest_Qualify_Equilateral(){
        Triangle triangle = new Triangle(new Pair<>(0D, 0D), new Pair<>(2.5D, 4.330127D), new Pair<>(5.0D, 0D));
        OfSideType expectedType = OfSideType.EQUILATERAL;

        Assert.assertEquals(expectedType, new TriangleQualifier(triangle).qualifyOfSideType());
    }

}
