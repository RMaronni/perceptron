import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;
import java.util.ArrayList;



public class PerceptronTest {

    private Perceptron andNetwork;
    private Perceptron orNetwork;
    private List<Double> input1;
    private List<Double> input2;
    private List<Double> input3;
    private List<Double> input4;


    @Before
    public void setUp() {
        this.andNetwork = new Perceptron(2, 0.5);
        this.orNetwork  = new Perceptron(2, 0.5);  

        this.input1 = new ArrayList<Double>();
        input1.add(0.0); 
        input1.add(0.0); 

        this.input2 = new ArrayList<Double>();
        input2.add(1.0); 
        input2.add(0.0); 

        this.input3 = new ArrayList<Double>();
        input3.add(0.0); 
        input3.add(1.0); 

        this.input4 = new ArrayList<Double>();
        input4.add(1.0); 
        input4.add(1.0); 
    }


    @Test
    public void testGetInputNumber() {
        assertEquals(this.andNetwork.getInputNumber(), 2);
        assertEquals(this.orNetwork.getInputNumber(), 2);
    }


    @Test
    public void testGetActivationThreshold() {
        assertEquals(this.andNetwork.getActivationThreshold(), 0.5, 0.001);
        assertEquals(this.orNetwork.getActivationThreshold(),  0.5, 0.001);
    }


    @Test
    public void testGetWeightArray() {
        assertThat(this.andNetwork.getWeightArray(), is(input1));
        assertThat(this.orNetwork.getWeightArray(),  is(input1));
    }


    @Test
    public void testAndNetwork() {
        for (int i = 0; i < 100; i++) {
            this.andNetwork.train(input1, 0);
            this.andNetwork.train(input2, 0);
            this.andNetwork.train(input3, 0);
            this.andNetwork.train(input4, 1);
        }

        assertEquals(this.andNetwork.run(input1), 0);
        assertEquals(this.andNetwork.run(input2), 0);
        assertEquals(this.andNetwork.run(input3), 0);
        assertEquals(this.andNetwork.run(input4), 1);
    }

    
    @Test
    public void testOrNetwork() {
        for (int i = 0; i < 100; i++) {
            this.orNetwork.train(input1, 0);
            this.orNetwork.train(input2, 1);
            this.orNetwork.train(input3, 1);
            this.orNetwork.train(input4, 1);
        }

        assertEquals(this.orNetwork.run(input1), 0);
        assertEquals(this.orNetwork.run(input2), 1);
        assertEquals(this.orNetwork.run(input3), 1);
        assertEquals(this.orNetwork.run(input4), 1);
    }




    
}