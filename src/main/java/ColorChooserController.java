import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;

public class ColorChooserController {
   @FXML private Slider redSlider;
   @FXML private Slider greenSlider;
   @FXML private Slider blueSlider;
   @FXML private Slider alphaSlider;
   @FXML private TextField redTextField;  
   @FXML private TextField greenTextField;
   @FXML private TextField blueTextField; 
   @FXML private TextField alphaTextField;
   @FXML private Rectangle colorRectangle;

   private int red = 0;
   private int green = 0;
   private int blue = 0;
   private double alpha = 1.0;
   
   public void initialize() {
       NumberFormat nf = NumberFormat.getNumberInstance();
       NumberFormat alphanf = NumberFormat.getNumberInstance();
       nf.setMaximumFractionDigits(0);
       nf.setRoundingMode(RoundingMode.HALF_UP);
       alphanf.setMaximumFractionDigits(2);

       redTextField.textProperty().bindBidirectional(redSlider.valueProperty(), nf);
       greenTextField.textProperty().bindBidirectional(greenSlider.valueProperty(), nf);
       blueTextField.textProperty().bindBidirectional(blueSlider.valueProperty(), nf);
       alphaTextField.textProperty().bindBidirectional(alphaSlider.valueProperty(), alphanf);

       redTextField.setOnMouseClicked(e -> redTextField.selectAll());
       greenTextField.setOnMouseClicked(e -> greenTextField.selectAll());
       blueTextField.setOnMouseClicked(e -> blueTextField.selectAll());
       alphaTextField.setOnMouseClicked(e -> alphaTextField.selectAll());

       redSlider.valueProperty().addListener(
         new ChangeListener<Number>() {                                   
            @Override                                                     
            public void changed(ObservableValue<? extends Number> ov,     
               Number oldValue, Number newValue) {                        
               red = newValue.intValue();                                 
               colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
         }
      );                                                                  
      greenSlider.valueProperty().addListener(
         new ChangeListener<Number>() {                                   
            @Override                                                     
            public void changed(ObservableValue<? extends Number> ov,     
               Number oldValue, Number newValue) {                        
               green = newValue.intValue();
               colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
         }
      );                                                                  
      blueSlider.valueProperty().addListener(
         new ChangeListener<Number>() {                                   
            @Override                                                     
            public void changed(ObservableValue<? extends Number> ov,     
               Number oldValue, Number newValue) {                        
               blue = newValue.intValue();
               colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
         }
      );                                                                  
      alphaSlider.valueProperty().addListener(
         new ChangeListener<Number>() {                                   
            @Override                                                     
            public void changed(ObservableValue<? extends Number> ov,     
               Number oldValue, Number newValue) {                        
               alpha = newValue.doubleValue();
               colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
         }
      );                                                                  
   }     
}
