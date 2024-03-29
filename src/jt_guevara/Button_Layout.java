/* FILE: Button_Layout.java
 * CLASS DESCRIPTION: Class for generating a button layout. A Button_Layout consists of a button bar and buttons.  
 */
package jt_guevara;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;


public class Button_Layout {
	public Button_Layout() {}//constructor
	private Button left_scroll = new Button();//left-scroll, right-scroll and zoom buttons
	private Button right_scroll = new Button();
	private Button zoom = new Button();
	private GridPane buttonBar = new GridPane();//button bar that contains the above buttons
	public Button getLeftScroll() {return left_scroll;}//get functions for buttons
	public Button getRightScroll() {return right_scroll;}
	public Button getZoom() {return zoom;}
	
	public GridPane getButtonBar() {return buttonBar;}//get function for button bar
	
/*
public void set_scroll_buttons();
    DESCRIPTION: Sets the shape of the left-scroll(<|) and right-scroll(|>) buttons along with their 
                 layout and style properties. 
*/
	public void set_scroll_buttons()
	{
		//local array of doubles used to define a button shape using points(in the form(x,y))(in this case, a triangle (<|))
		final double[] POINTS = {					
				0.0, 0.0,
				-30.0, 30.0,
				0.0, 60.0,
				0.0, 0.0
			    };
		//Polyline object used to set the shape of the zoom button using the points
		Polyline shape = new Polyline(POINTS);
		left_scroll.setShape(shape);
		left_scroll.setScaleX(1.4);
		left_scroll.setScaleY(1.5);
		left_scroll.setStyle("-fx-background-color: lightblue");
		//do the same for the right-scroll button
		right_scroll.setShape(shape);
		right_scroll.setScaleX(1.4);
		right_scroll.setScaleY(1.5);
		right_scroll.setRotate(180);//rotate button so it points right
		right_scroll.setStyle("-fx-background-color: lightblue");
	}
/*
public void set_zoom_button();
    DESCRIPTION: Sets the shape of the zoom button(+) along with its layout and style properties. 
*/
	public void set_zoom_button()
	{	
		//local array of doubles used to define a shape using points(in the form (x,y))(in this case a (+) sign)	
		final double[] POINTS = {			
			0.0, 0.0,
			20.0, 0.0,
			20.0, 20.0,
			40.0, 20.0,
			40.0, 40.0,
			20.0, 40.0,
			20.0, 60.0,
			0.0, 60.0,
			0.0, 40.0,
			-20.0, 40.0,
			-20.0, 20.0, 
			0.0, 20.0,
			0.0, 0.0
		};
		//Polyline object used to set the shape of the zoom button using the points
		Polyline shape = new Polyline(POINTS);	
		zoom.setShape(shape);
		zoom.setScaleX(2);
		zoom.setScaleY(2);
		zoom.setStyle("-fx-background-color: lightblue");
	}
/*
public void set_button_bar();
     DESCRIPTION: Sets the button bar's layout and style properties. 
*/
	public void set_button_bar()
	{
		buttonBar.setAlignment(Pos.CENTER);
		buttonBar.setHgap(20);
		buttonBar.setStyle("-fx-border-color: royalblue;-fx-border-radius: 10px;-fx-background-radius: 10px;"
				+ "-fx-border-width: 5px;-fx-background-color: darkblue;");
		buttonBar.setOpacity(.9);
		buttonBar.setMinHeight(80);
		buttonBar.setMaxHeight(100);
		buttonBar.setLayoutX(10);
		buttonBar.setLayoutY(500);
		buttonBar.setHgap(100);
		buttonBar.setPadding(new Insets(15,15,15,15));
		
	}
/*
public void add_buttons();
    DESCRIPTION: Adds the left-scroll, right-scroll and zoom buttons to the button bar
*/
	public void add_buttons() {
		buttonBar.add(left_scroll, 0, 0);
		buttonBar.add(zoom, 1, 0);
		buttonBar.add(right_scroll, 2, 0);
	}
	
/*
public void bind_button_layout(Stage window);
     PARAMETER: Stage window - application window used to apply property binding 
     DESCRIPTION: This function binds the width and height properties of the button bar to the width and height properties   
                   of the application window so that the button bar is automatically resized along with the window when the 
                   window changes.
*/
	public void bind_button_layout(Stage window) {
		buttonBar.prefWidthProperty().bind(window.widthProperty());
		buttonBar.prefHeightProperty().bind(window.heightProperty());
	}
}
