import java.beans.Transient;
import java.util.Arrays;
import com.example.NumFinder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumFinderTest{
    private com.example.NumFinder nf;

    @BeforeEach
    void setUp(){
        nf = new NumFinder();
    }

    @Test 
    void testeMenorQualquerOrdem(){
        //Arrange
        var array = new int[] {10,8,2,14,7};
        //Act
        nf.find(array);
        var menor = nf.getSmallest();
        //Assert
        assertEquals(2,menor);
    }

    @Test 
    void testeMenorOrdemCrescente(){
        //Arrange
        var array = new int[] {1,2,3,4,5};
        //Act
        nf.find(array);
        var menor = nf.getSmallest();
        //Assert
        assertEquals(1,menor);
    }

}