package io.loop.test.day9;

import io.loop.pages.LoopPracticeDragDropPage;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/*
Loop Practice Drag and Drop Test
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. validate expected default text appears on big circle
Expected = "Drag the small circle here."

Loop Practice Drag and Drop Test
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. validate "Drop here." text appears on big circle

1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Move it on top of the big circle
5. validate “Now drop…” text appears on big circ

1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Dropped anywhere outside of big circle
5. validate “Try again!” text appears on big circle
*/
public class T4_drag_and_drop_POM {

    LoopPracticeDragDropPage loopPracticeDragDropPage;
    Actions actions;

    @BeforeMethod
    public void setUpMethod() {
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        loopPracticeDragDropPage = new LoopPracticeDragDropPage();
        actions = new Actions(Driver.getDriver());
    }

    @Test
    public void drag_small_here_test () {
        String expected = "Drag the small circle here.";
        String  actual = loopPracticeDragDropPage.bigCircle.getText();
        assertEquals(actual, expected, "Actual does not match the expected");

    }

}
