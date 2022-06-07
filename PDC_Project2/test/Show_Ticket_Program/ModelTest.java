/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JL Lopez
 */
public class ModelTest {

    private Model model;

    public ModelTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        model = new Model();
        model.getDb().dbsetup();
        model.displayData();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getShowID method, of class Model.
     */
    @Test
    public void testGetShowID() {
        System.out.println("getShowID");

        model.setInputData(new ShowData());

        String expResult = "";
        String result = model.getShowID();
        assertEquals(expResult, result);
    }

    /**
     * Test of displayData method, of class Model.
     */
    @Test
    public void testDisplayData() {
        System.out.println("displayData case 0");
        assertEquals(model.getShowAData().display, true);
        assertEquals(model.getShowBData().display, true);
        assertEquals(model.getShowCData().display, true);
    }

    /**
     * Test of updateBoxes method for case A, of class Model.
     */
    @Test
    public void testUpdateBoxesA() {
        System.out.println("updateBoxes case A");
        model.updateBoxes("A");
        boolean expResult = true;
        boolean result = model.getShowAData().chosen;
        assertEquals(result, expResult);
    }

    /**
     * Test of updateBoxes method for case B, of class Model.
     */
    @Test
    public void testUpdateBoxesB() {
        System.out.println("updateBoxes case B");
        model.updateBoxes("B");
        boolean expResult = true;
        boolean result = model.getShowBData().chosen;
        assertEquals(result, expResult);
    }

    /**
     * Test of updateBoxes method for case C, of class Model.
     */
    @Test
    public void testUpdateBoxesC() {
        System.out.println("updateBoxes case C");
        model.updateBoxes("C");
        boolean expResult = true;
        boolean result = model.getShowCData().chosen;
        assertEquals(result, expResult);
    }

    /**
     * Test of updateTotalCost method for case G, of class Model.
     */
    @Test
    public void testUpdateTotalCostGold() {
        System.out.println("updateTotalCost case G");

        model.updateTotalCost("G", 5);
        double expResult = 30.0;
        double result = model.getInputData().goldTicks.price;

        assertEquals(expResult, result, 0);
    }

    /**
     * Test of updateTotalCost method for case S, of class Model.
     */
    @Test
    public void testUpdateTotalCostSilver() {
        System.out.println("updateTotalCost case S");

        model.updateTotalCost("S", 5);
        double expResult = 21.0;
        double result = model.getInputData().silverTicks.price;

        assertEquals(result, expResult, 0);
    }

    /**
     * Test of updateTotalCost method for case B, of class Model.
     */
    @Test
    public void testUpdateTotalCostBronze() {
        System.out.println("updateTotalCost case B");

        model.updateTotalCost("B", 5);
        double expResult = 12.0;
        double result = model.getInputData().bronzeTicks.price;

        assertEquals(result, expResult, 0);
    }

    /**
     * Test of cancelBooking method for case B, of class Model.
     */
    @Test
    public void testCancelBooking() {
        System.out.println("cancelBooking");
        boolean cancelExpResult = true;
        boolean updateExpResult = false;
        
        model.cancelBooking();
        boolean cancelResult = model.getInputData().cancel;
        boolean updateResult = model.getInputData().update;
        
        assertEquals(cancelResult, cancelExpResult);
        assertEquals(updateResult, updateExpResult);
    }

    /**
     * Test of confirmBooking method, of class Model.
     */
    @Test
    public void testConfirmBooking() {
        System.out.println("confirmBooking");
        
        boolean confirmExpResult = true;
        boolean updateExpResult = false;
        String nameExpResult = "JL";
        String phNumExpResult = "1234";
        ShowData showExpResult = model.getInputData();
        
        model.confirmBooking("JL", "1234");
        boolean confirmResult = model.getInputData().confirm;
        boolean updateResult = model.getInputData().update;
        String nameResult = model.getUserData().name;
        String phNumResult = model.getUserData().phNum;
        ShowData showResult = model.getUserData().show;
        System.out.println(nameResult + " " + nameExpResult);
        
        assertEquals(confirmResult, confirmExpResult);
        assertEquals(updateResult, updateExpResult);
        assertTrue(nameResult.equals(nameExpResult));
        assertTrue(phNumResult.equals(phNumExpResult));
        assertEquals(showResult, showExpResult);
    }

}
