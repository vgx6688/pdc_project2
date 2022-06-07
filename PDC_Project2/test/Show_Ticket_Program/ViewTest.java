/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Show_Ticket_Program;

import java.awt.event.ActionListener;
import java.util.Observable;
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
public class ViewTest {

    View view;
    Model model;

    public ViewTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        view = new View();
        model = new Model();
        model.getDb().dbsetup();
        model.displayData();
        model.addObserver(view);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of update method for display for Show A, of class View.
     */
    @Test
    public void testUpdateDisplayA() {
        System.out.println("update case display for Show A");

        model.getShowAData().display = false;
        view.update(model, model.getShowAData());

        String expResult = "Show A   2022-05-27";
        String result = view.getShowATitle().getText();

        assertEquals(result, expResult);

    }

    /**
     * Test of update method for display for Show B, of class View.
     */
    @Test
    public void testUpdateDisplayB() {
        System.out.println("update case display for Show B");

        model.getShowBData().display = false;
        view.update(model, model.getShowBData());

        String expResult = "Show B   2022-05-29";
        String result = view.getShowBTitle().getText();

        assertEquals(result, expResult);

    }

    /**
     * Test of update method for display for Show C, of class View.
     */
    @Test
    public void testUpdateDisplayC() {
        System.out.println("update case display for Show C");

        model.getShowCData().display = false;
        view.update(model, model.getShowCData());

        String expResult = "Show C   2022-05-31";
        String result = view.getShowCTitle().getText();

        assertEquals(result, expResult);

    }

    /**
     * Test of update method for display for Costs, of class View.
     */
    @Test
    public void testUpdateDisplayCost() {
        System.out.println("update case display for Costs");

        model.getShowCData().display = false;
        view.update(model, model.getShowCData());

        String expResult = "$30.00";
        String result = view.getGoldCost().getText();

        assertEquals(result, expResult);

    }

    /**
     * Test of update method for chosen, of class View.
     */
    @Test
    public void testUpdateChosen() {
        System.out.println("update case chosen");

        model.getShowCData().chosen = true;
        view.update(model, model.getShowCData());

        int goldExpResult = 32;
        int goldResult = view.getGoldQuant().getItemCount();

        int silverExpResult = 33;
        int silverResult = view.getSilverQuant().getItemCount();

        int bronzeExpResult = 34;
        int bronzeResult = view.getBronzeQuant().getItemCount();

        assertEquals(goldResult, goldExpResult);
        assertEquals(silverResult, silverExpResult);
        assertEquals(bronzeResult, bronzeExpResult);
    }

    /**
     * Test of update method for display for update, of class View.
     */
    @Test
    public void testUpdateUpdate() {
        System.out.println("update case update");

        model.updateTotalCost("G", 1);
        model.updateTotalCost("S", 1);
        model.updateTotalCost("B", 1);

        model.getShowCData().update = true;
        view.update(model, model.getInputData());

        String expResult = "$63.00";
        String result = view.getFinalCost().getText();

        assertEquals(result, expResult);

    }

    /**
     * Test of update method for display for Cancel, of class View.
     * 
     * Need to comment out this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
     * To avoid errors
     */
    @Test
    public void testUpdateCancel() {
        System.out.println("update case cancel");

        model.getShowCData().cancel = true;
        view.update(model, model.getShowCData());
        
        String expResult = "";
        String result = view.getPhNumField().getText();

        assertEquals(result, expResult);

    }

}
