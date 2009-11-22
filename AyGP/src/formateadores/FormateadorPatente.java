package formateadores;

import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class FormateadorPatente extends JFormattedTextField.AbstractFormatter
{
	private static final long serialVersionUID = 1L;

    public Object stringToValue(String text) throws ParseException
    {
        return new TPatente(text,this.getFormattedTextField().getValue().toString());
    }

    public String valueToString(Object value) throws ParseException
    {    	
        if (value==null)
            return ("");
        return value.toString();
    }
}